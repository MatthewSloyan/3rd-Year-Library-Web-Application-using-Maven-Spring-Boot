package com.sales.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Book;
import com.sales.models.Customer;
import com.sales.models.Loan;
import com.sales.repositories.CustomerRepository;
import com.sales.repositories.LoanRepository;

@Service
public class LoanService {

	// Create an instance of repository which implements database methods such as save, find etc.
	@Autowired
	LoanRepository loanRepo;
	
	// User to get customer details to get loanPeriod in addLoan
	@Autowired
	CustomerRepository customerRepo;
	
	/**
	* Gets all loans from the database.
	* 
	* @return Iterable list of loans returned from database
	*/
	public Iterable<Loan> getLoans() {
		return loanRepo.findAll();
	}
	
	/**
	* Find loan by book Id using custom created query. Used in LoanController to 
	* get book information for error page.
	* 
	* @return Loan object
	*/
	public Loan findByBookBid(Long bid) {
		return loanRepo.findByBookBid(bid);
	}
	
	/**
	* Finds a specific loan from the database using the id.
	* 
	* @return Loan object found in database
	*/
	public Loan getLoan(Long cId) {
		return loanRepo.findOne(cId);
	}
	
	/**
	* Adds a new loan to database.
	* A customer is first found using the cId, then the loanPeriod is added and due date is set.
	* Errors are handled in the Controller depending on the stage they occur.
	* 
	* @return String error, which determines which error page to display in controller
	*/
	public String addLoan(Loan loan) {
		try {
			// Get customer using passed in ID to get loan period
			// Add loan period to current date and set value
			Customer c = customerRepo.findOne(loan.getCust().getcId());
			String dueDate = getDueDate(c.getLoanPeriod());
			loan.setDueDate(dueDate);
		} catch (Exception e) {
			// Error occurs here so customer id entered not valid.
			return "loanError";
		}
		
		try {
			loanRepo.save(loan);
		} catch (Exception e) {
			// Error occurs here so book is on loan
			return "loanErrorTwo";
		}
		return null;
  	}
	
	/**
	* Deletes loan from database.
	* A Loan is found, and if null then display error in controller, if not then delete from database (found).
	* 
	* @return String error, which determines wheter to display error in controller
	*/
	public String deleteLoan(Loan loan) {
		
		Loan findLoan = null;
		try {
			findLoan = loanRepo.findOne(loan.getLid());
		} catch (Exception e) {}
		
		if (findLoan != null) {
			loanRepo.delete(loan);
			return "foundLoan";
		}
		return null; 
  	}
	
	/**
	* Using the current date add the loan period and return as string.
	* 
	* @return String of new formatted date.
	*/
	public String getDueDate(int loanPeriod) {
		return LocalDate.now().plusDays(loanPeriod).toString(); 
  	}
}
