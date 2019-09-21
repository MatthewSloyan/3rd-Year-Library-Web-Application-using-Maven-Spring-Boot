package com.sales;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.sales.models.Loan;
import com.sales.services.LoanService;

public class LoanServiceTest {

	LoanService test = new LoanService();
	Loan loan;
	
	// Set up before every test
	@Before
	public void setUp() throws Exception {
		loan = new Loan();
		loan.setDueDate(LocalDate.now().plusDays(5).toString());
	}
	
	@Test
	public void testGetDueDate() {
		String actual = test.getDueDate(5);
		
		assertEquals("Calculate Due Date", loan.getDueDate(), actual);
	}

}
