package com.sales.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Loan;
import com.sales.services.LoanService;

/**
* Loan controller which handles all loans functionality
*
* @author Matthew Sloyan G00348036
*/

@Controller
public class LoanController {
	// == Loans == 
	// Create a instances of the LoanService, and set up mapping
	@Autowired
	LoanService loanService;
	
	/**
	* Gets ArrayList of Loans from service, and adds to model to be displayed in view when /showLoans page is loaded
	* @see LoanService
	* 
	* @param m Model which is used to add list of loans to jsp view
	* @return string of .jsp page to be loaded 
	*/
	@RequestMapping(value = "/showLoans")
	public String showLoans(Model m) {
		ArrayList<Loan> loans = (ArrayList<Loan>) loanService.getLoans();
		
		m.addAttribute("loans", loans);
		return "showLoans";
	}
	
	/**
	* Get and display newLoan when navigated to, this page allows the user to add a new loan
	* 
	* @param loan Loan model which is the object bound to the form, and is used to get data from the form
	* @return string of .jsp page to be loaded 
	*/
	@RequestMapping(value = "/newLoan", method=RequestMethod.GET)
	public String addNewLoan(@ModelAttribute ("loan") Loan loan) {
	    return "newLoan";
	}

	/**
	* Post request which is called on submit of form, also errors are handled by displaying error pages if encountered.
	* @see LoanService
	* 
	* @param loan (Loan) model which is the object bound to the form, and is used to get data from the form
	* @param result Used in validation of form inputs, e.g displays error message if fields are empty.
	* @return string of .jsp page to be loaded using redirect so if page is refreshed it won't call add method again. 
	*/
	@RequestMapping(value = "/newLoan", method=RequestMethod.POST)
	public String newLoanAdded(@Valid @ModelAttribute ("loan") Loan loan, BindingResult result, Model model) {
		
		String error = loanService.addLoan(loan);
		
		if (error == "loanError") {
			model.addAttribute("loanEntry", loan);
			return "loanError";
		}
		if (error == "loanErrorTwo"){
			// Get the book information to populate error page
			Loan l = loanService.findByBookBid(loan.getBook().getBid());
			model.addAttribute("loanEntry", l);
			return "loanErrorTwo";
		}
			
		return "redirect:showLoans.html";
	}
	
	/**
	* Get and display deleteLoan when navigated to, this page allows the user to delete a loan using the loan id
	* @see LoanService
	* 
	* @param loan (Loan) model which is the object bound to the form, and is used to get data from the form
	* @return string of .jsp page to be loaded.
	*/
	@RequestMapping(value = "/deleteLoan", method=RequestMethod.GET)
	public String deleteLoan(@ModelAttribute ("loan") Loan loan) {
	    return "deleteLoan";
	}

	/**
	* Post request which is called on submit of form, also errors are handled by displaying error page if encountered.
	* Deletion of loan is handled here.
	* @see LoanService
	* 
	* @param loan (Loan) model which is the object bound to the form, and is used to get data from the form
	* @param m Model which is used to add old book data to jsp view
	* @return string of .jsp page to be loaded using redirect so if page is refreshed it won't call add method again. 
	*/
	@RequestMapping(value = "/deleteLoan", method=RequestMethod.POST)
	public String deletedLoan(@Valid @ModelAttribute ("loan") Loan loan, Model model) {
		
		String error = loanService.deleteLoan(loan);
		
		if (error == null) {
			model.addAttribute("loanEntry", loan);
			return "deleteLoanError";
		}
		
		return "redirect:showLoans.html";
	}
}
