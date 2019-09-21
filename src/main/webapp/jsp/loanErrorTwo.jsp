<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Could not create new loan </h1>
	<h3>Book: ${loanEntry.book.bid} (${loanEntry.book.title}) already on loan to Customer ${loanEntry.cust.cId} (${loanEntry.cust.cName})</h3>
	
	<p>
		<a href="/">Home</a>
		<a href="/showBooks">List Books</a>
		<a href="/showCustomers">List Customers</a>
		<a href="/showLoans">List Loans</a>
		<a href="/newLoan">New Loan</a>
	</p>
</body>
</html>