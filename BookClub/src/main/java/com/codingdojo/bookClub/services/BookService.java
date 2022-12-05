package com.codingdojo.bookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookClub.models.Book;
import com.codingdojo.bookClub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
	public Book createBook(Book newBook) {
		return bookRepo.save(newBook);
	}
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	public Book getBookById(Long id) {
		Optional<Book> book = bookRepo.findById(id);
		return book.orElseGet(() -> null);
	}
	public Book updateBook(Book updatedBook) {
		return bookRepo.save(updatedBook);
	}
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
}
