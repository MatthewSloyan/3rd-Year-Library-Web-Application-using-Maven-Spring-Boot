package com.sales.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sales.models.Book;
import com.sales.repositories.BookRepository;

/**
* Book service which handles all database functionality
*
* @author Matthew Sloyan G00348036
*/
@Service
public class BookService {
	
	// Create an instance of repository which implements database methods such as save, find etc.
	@Autowired
	BookRepository bookRepo;
	
	/**
	* Gets all books from the database.
	* 
	* @return Iterable list of books returned from database
	*/
	public Iterable<Book> getBooks() {
		return bookRepo.findAll();
	}
	
	/**
	* Finds a specific book from the database.
	* 
	* @return Book object found in database
	*/
	public Book getBook(Long id) {
		return bookRepo.findOne(id);
	}
	
	/**
	* Adds a new book to database.
	* If bId is supplied then updates book in database.
	*/
	public void addBook(Book book) {
    	bookRepo.save(book);
  	}

}
