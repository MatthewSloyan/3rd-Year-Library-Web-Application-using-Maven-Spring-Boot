<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Books</title>
	<link rel="stylesheet" type="text/css" href="css/tableStyles.css">
</head>
<body>
	<h1>List of Books</h1>
	<table>
	  <tr>
	   <th>Book ID</th>
	   <th>Title</th>
	   <th>Author</th>
	   <th>Edit</th>
	  </tr>
	  <tr>
	    <c:forEach items="${books}" var="book">
	      <tr> 
	        <td>${book.bid}</td>
	        <td>${book.title}</td>
	        <td>${book.author}</td>
	        <td><a href="/editBook/${book.bid}">Edit</a></td>
	      </tr>
	    </c:forEach>
	  </tr>
	</table>
	<p>
		<a href="/">Home</a>
		<a href="/addBook">Add Book</a>
		<a href="/showCustomers">List Customers</a>
		<a href="/showLoans">List Loans</a>
		<a href="/logOut">Logout</a>
	</p>
</body>
</html>