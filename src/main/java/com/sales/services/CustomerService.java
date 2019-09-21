package com.sales.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.repositories.CustomerRepository;

/**
* Customer service which handles all database functionality
*
* @author Matthew Sloyan G00348036
*/
@Service
public class CustomerService {

	// Create an instance of repository which implements database methods such as save, find etc.
	@Autowired
	CustomerRepository customerRepo;
	
	/**
	* Gets all customers from the database.
	* 
	* @return Iterable list of customers returned from database
	*/
	public Iterable<Customer> getCustomer() {
		return customerRepo.findAll();
	}
	
	/**
	* Finds a specific customer from the database.
	* 
	* @return Customer object found in database
	*/
	public Customer getCustomer(Long id) {
		return customerRepo.findOne(id);
	}
	
	/**
	* Adds a new customer to database.
	* If cId is supplied then updates customer in database.
	*/
	public void addCustomer(Customer cust) {
		customerRepo.save(cust);
  	}
}
