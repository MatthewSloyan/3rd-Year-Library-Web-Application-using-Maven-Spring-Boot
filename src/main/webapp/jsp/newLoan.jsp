<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Loan</title>
<link rel="stylesheet" type="text/css" href="css/generalStyles.css">
</head>
<body>
	<h1>Add New Loan</h1>
	<form:form modelAttribute="loan">
	  <table>
	    <tr>
	      <td class="labeld">Customer ID:</td>
	      <td><form:input path="cust.cId"></form:input></td>
	    </tr>
	    <tr>
	      <td class="labeld">Book ID:</td>
	      <td><form:input path="book.bid"></form:input></td>
	    </tr>
	    <tr>
	      <td colspan="2">
	        <input type="submit" value="Add" class="button"/>
	      </td>
	    </tr>
	  </table>
	</form:form>
	
	<p>
		<a href="/">Home</a>
		<a href="/showBooks">List Books</a>
		<a href="/showCustomers">List Customers</a>
		<a href="/showLoans">List Loans</a>
	</p>
</body>
</html>