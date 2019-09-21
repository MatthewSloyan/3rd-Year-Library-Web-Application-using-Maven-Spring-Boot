<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Customers</title>
	<link rel="stylesheet" type="text/css" href="css/tableStyles.css">
</head>
<body>
	<h1>List of Customers</h1>
	<c:forEach items="${customers}" var="customer">
		<h2>${customer.cId} ${customer.cName} - <a href="/editCustomer/${customer.cId}">Edit</a></h2>
		<p>Loan Period = ${customer.loanPeriod}</p>
		<p>${customer.cName}'s Loans</p>
		<table>
		  <tr>
		   <th>Loan ID</th>
		   <th>Book ID</th>
		   <th>Title</th>
		   <th>Author</th>
		  </tr>
		  <tr>
		    <c:forEach items="${customer.loans}" var="loan">
		      <tr> 
		        <td>${loan.lid}</td>
		        <td>${loan.book.bid}</td>
		        <td>${loan.book.title}</td>
		        <td>${loan.book.author}</td>
		      </tr>
		    </c:forEach>
		  </tr>
		</table>
    </c:forEach>
	
	<p>
		<a href="/">Home</a>
		<a href="/showBooks">List Books</a>
		<a href="/showLoans">List Loans</a>
		<a href="/logout">Logout</a>
	</p>
</body>
</html>