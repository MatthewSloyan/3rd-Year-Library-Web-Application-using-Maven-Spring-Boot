<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Loan Error</title>
</head>
<body>
	<h1>Could not delete Loan</h1>
	<h3>No such Loan: ${loanEntry.lid}</h3>
	
	<p>
		<a href="/">Home</a>
		<a href="/showBooks">List Books</a>
		<a href="/showCustomers">List Customers</a>
		<a href="/showLoans">List Loans</a>
		<a href="/newLoan">New Loan</a>
	</p>
</body>
</html>