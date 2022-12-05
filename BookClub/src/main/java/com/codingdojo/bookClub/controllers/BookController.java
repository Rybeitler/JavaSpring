package com.codingdojo.bookClub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.bookClub.models.Book;
import com.codingdojo.bookClub.services.BookService;
import com.codingdojo.bookClub.services.UserService;

@Controller
public class BookController {
	@Autowired
	private BookService bookServ;
	@Autowired UserService userServ;
	
	@GetMapping("/allBooks")
	public String allBooks(Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		model.addAttribute("user", userServ.getUserById((Long)session.getAttribute("userId")));
		model.addAttribute("books", bookServ.getAllBooks());
		return "/allBooks.jsp";
	}
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("newBook") Book book, HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		model.addAttribute("user", userServ.getUserById((Long)session.getAttribute("userId")));
		return "addBook.jsp";
	}
	@GetMapping("/books/{id}")
	public String showBook(@PathVariable Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		model.addAttribute("user", userServ.getUserById((Long)session.getAttribute("userId")));
		model.addAttribute("book", bookServ.getBookById(id));
		return "showBook.jsp";
	}
	@GetMapping("/books/{id}/edit")
	public String editBookPage(@PathVariable Long id, HttpSession session, Model model, @ModelAttribute("editBook") Book book) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		model.addAttribute("user", userServ.getUserById((Long)session.getAttribute("userId")));	
		model.addAttribute("book", bookServ.getBookById(id));
		return "editBook.jsp";
	}
	
	@PostMapping("/books/new")
	public String addBook(@Valid @ModelAttribute("newBook")Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "addBook.jsp";
		}
		bookServ.createBook(book);
		return "redirect:/allBooks";
	}
	@PutMapping("/books/{id}/edit")
	public String editBook(@PathVariable Long id, @Valid @ModelAttribute("editBook") Book book, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("book", bookServ.getBookById(id));
			model.addAttribute("user", userServ.getUserById((Long)session.getAttribute("userId")));	
			return "editBook.jsp";
		}
		bookServ.updateBook(book);
		return "redirect:/allBooks";
	}
	@RequestMapping(value="/books/{id}/delete", method={RequestMethod.GET, RequestMethod.DELETE})
	public String deleteBook(@PathVariable Long id) {
		bookServ.deleteBook(id);
		return "redirect:/allBooks";
	}
}
