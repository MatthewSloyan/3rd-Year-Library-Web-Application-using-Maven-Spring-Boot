package com.sales.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Customer;
import com.sales.services.CustomerService;

/**
* Customer controller which handles all customer functionality
*
* @author Matthew Sloyan G00348036
*/

@Controller
public class CustomerController {
	
	// == Customers ==
	// Create a instances of the CustomerService, and set up mapping
	@Autowired
	CustomerService customerService;
	
	/**
	* Gets ArrayList of Customers from service, and adds to model to be displayed in view when /showCustomers page is loaded
	*
	* @see CustomerService
	* 
	* @param m Model which is used to add list of customers to jsp view
	* @return string of .jsp page to be loaded 
	*/
	@RequestMapping(value = "/showCustomers")
	public String showCustomers(Model m) {
		ArrayList<Customer> customers = (ArrayList<Customer>) customerService.getCustomer();
		
		m.addAttribute("customers", customers);
		return "showCustomers";
	}
	
	/**
	* Get and display addCustomer when navigated to, this page allows the user to add a customer
	* 
	* @param cust Customer model which is the object bound to the form, and is used to get data from the form
	* @return string of .jsp page to be loaded 
	*/
	@RequestMapping(value = "/addCustomer", method=RequestMethod.GET)
	public String addNewCustomer(@ModelAttribute ("customer") Customer cust) {
	    return "addCustomer";
	}

	/**
	* Post request which is called on submit of form.
	* @see CustomerService
	* 
	* @param cust Customer model which is the object bound to the form, and is used to get data from the form
	* @param result Used in validation of form inputs, e.g displays error message if fields are empty.
	* @return string of .jsp page to be loaded using redirect so if page is refreshed it won't call add method again. 
	*/
	@RequestMapping(value = "/addCustomer", method=RequestMethod.POST)
	public String newCustomerAdded(@Valid @ModelAttribute ("customer") Customer cust, BindingResult result) {

		// Display error if encountered
		if (result.hasErrors()) {
			return "addCustomer";
		}
		
		// Add customer to database
		customerService.addCustomer(cust);
			
		return "redirect:showCustomers.html";
	}
	
	/**
	* Get and display editCustomer when navigated to, this page allows the user to edit a customers details
	* which are pre-loaded and added to the form using the cId passed in the url
	* @see CustomerService
	* 
	* @param cust Customer model which is the object bound to the form, and is used to get data from the form
	* @param cId gets the string from the url
	* @param m Model which is used to add old customer data to jsp view
	* @return string of .jsp page to be loaded.
	*/
	@RequestMapping(value="/editCustomer/{cId}", method = RequestMethod.GET)
	public String editBook(@ModelAttribute ("customer") Customer cust, @PathVariable("cId") String cId, Model model) {
		
		 Customer oldCustomer = customerService.getCustomer(Long.parseLong(cId));
		 model.addAttribute("oldCustomer", oldCustomer);
		 return "editCustomer";
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
	@RequestMapping(value="/editCustomer/{cId}", method=RequestMethod.POST)
	public String editedBook(@ModelAttribute ("customer") Customer cust, @PathVariable("cId") String cId, 
			BindingResult result) {
	
		// Display error if encountered
		// Doesn't seem to work however with editing, could be due to the object
		if (result.hasErrors()) {
			return "editCustomer";
		}
		
		// set the customer ID as it's not input in form, this allows use of the same add method 
		// as if given an id it will work as an update function.
		cust.setcId(Long.parseLong(cId));
		customerService.addCustomer(cust);
			
		return "redirect:/showCustomers.html";
	}

}
