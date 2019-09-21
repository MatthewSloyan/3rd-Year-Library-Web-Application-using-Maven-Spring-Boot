package com.sales.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Book;
import com.sales.services.BookService;
import com.sales.services.CustomerService;

/**
* Book controller which handles all books functionality
*
* @author Matthew Sloyan G00348036
*/

@Controller
public class BookController {
	
	// == BOOKS == 
	@Autowired
	BookService bookService; 
	
	/**
	* Gets ArrayList of Books from service, and adds to model to be displayed in view when /showBooks page is loaded
	* @see BookService
	* 
	* @param m Model which is used to add list of books to jsp view
	* @return string of .jsp page to be loaded 
	*/
	@RequestMapping(value = "/showBooks")
	public String showBooks(Model model) {
		ArrayList<Book> books = (ArrayList<Book>) bookService.getBooks();
		
		model.addAttribute("books", books);
		return "showBooks";
	}
	
	/**
	* Get and display addBook when navigated to, this page allows the user to add a book
	* 
	* @param book Book model which is the object bound to the form, and is used to get data from the form
	* @return string of .jsp page to be loaded 
	*/
	@RequestMapping(value = "/addBook", method=RequestMethod.GET)
	public String addNewBook(@ModelAttribute ("book") Book book) {
	    return "addBook";
	}

	/**
	* Post request which is called on submit of form.
	* @see BookService
	* 
	* @param book Book model which is the object bound to the form, and is used to get data from the form
	* @param result Used in validation of form inputs, e.g displays error message if fields are empty.
	* @return string of .jsp page to be loaded using redirect so if page is refreshed it won't call add method again. 
	*/
	@RequestMapping(value = "/addBook", method=RequestMethod.POST)
	public String newBookAdded(@Valid @ModelAttribute ("book") Book book, BindingResult result) {
		
		// Display error if encountered
		if (result.hasErrors()) {
			return "addBook";
		}
		
		bookService.addBook(book);
			
		return "redirect:showBooks.html";
	}
	
	/**
	* Get and display editBook when navigated to, this page allows the user to edit a books details
	* which are pre-loaded and added to the form using the bId passed in the url
	* @see BookService
	* 
	* @param book Book model which is the object bound to the form, and is used to get data from the form
	* @param bId gets the string from the url
	* @param m Model which is used to add old book data to jsp view
	* @return string of .jsp page to be loaded.
	*/
	@RequestMapping(value="/editBook/{bId}", method = RequestMethod.GET)
	public String editBook(@ModelAttribute ("book") Book book, @PathVariable("bId") String bId, Model model) {
		
		 Book oldBook = bookService.getBook(Long.parseLong(bId));
		 model.addAttribute("oldBook", oldBook);
		 return "editBook";
	}
	
	/**
	* Post request which is called on submit of form. This gets the values from the form and is
	* used to update the database using the new inputs.
	* @see CustomerService
	* 
	* @param cust Customer model which is the object bound to the form, and is used to get data from the form
	* @param cId gets the string from the url
	* @param result Used in validation of form inputs, however doesn't seem to work for updates
	* @return string of .jsp page to be loaded using redirect so if page is refreshed it won't call add method again.
	*/
	@RequestMapping(value = "/editBook/{bId}", method=RequestMethod.POST)
	public String editedBook(@Valid @ModelAttribute ("book") Book book, @PathVariable("bId") String bId, 
			BindingResult result, HttpServletRequest request) {
	
		// Display error if encountered
		// Doesn't seem to work however with editing, could be due to the 
		if (result.hasErrors()) {
			return "editBook";
		}
		
		// set the Book ID as it's not input in form, this allows use of the same add method 
		// as if given an id it will work as an update function.
		book.setBid(Long.parseLong(bId));
		bookService.addBook(book);
			
		return "redirect:/showBooks.html";
	}
	
	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource
	      = new ReloadableResourceBundleMessageSource();
	     
	    messageSource.setBasename("classpath:messages");
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}
//	
//	@Bean
//	public LocalValidatorFactoryBean getValidator() {
//	    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//	    bean.setValidationMessageSource(messageSource());
//	    return bean;
//	}
}
