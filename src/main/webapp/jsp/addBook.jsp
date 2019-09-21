<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
	<link rel="stylesheet" type="text/css" href="css/generalStyles.css">
</head>
<body>

<h1>Add New Book</h1>
<form:form modelAttribute="book">
  <table>
    <tr>
      <td class="labeld">Title:</td>
      <td><form:input path="title"></form:input></td>
      <td><form:errors path="title" class="error"></form:errors></td>
    </tr>
    <tr>
      <td class="labeld">Author:</td>
      <td><form:input path="author"></form:input></td>
      <td><form:errors path="author" class="error"></form:errors></td>
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
	<a href="/addCustomer">Add Customer</a>
	<a href="/newLoan">New Loans</a>
</p>

</body>
</html>