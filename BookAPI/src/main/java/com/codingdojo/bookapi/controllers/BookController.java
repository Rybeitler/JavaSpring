package com.codingdojo.bookapi.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.bookapi.models.Book;
import com.codingdojo.bookapi.services.BookService;

@Controller
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    
    @GetMapping("/books")
    public String allBooks(Model model) {
    	List<Book> books = bookService.allBooks();
    	model.addAttribute("books",books);
    	return "index.jsp";
    }
    
	@GetMapping("/books/{id}")
	public String showBook(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "show.jsp";
	}
}
