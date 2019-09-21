<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Customer</title>
<link rel="stylesheet" type="text/css" href="css/generalStyles.css">
</head>
<body>

<h1>Add New Customer</h1>
<form:form modelAttribute="customer">
  <table>
    <tr>
      <td class="labeld">Customer Name:</td>
      <td><form:input path="cName"></form:input></td>
      <td><form:errors path="cName" class="error"></form:errors></td>
    </tr>
    <tr>
      <td class="labeld">Loan Period (days):</td>
      <td><form:input path="loanPeriod"></form:input></td>
      <td><form:errors path="loanPeriod" class="error"></form:errors></td>
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
	<a href="/addBook">Add Book</a>
	<a href="/newLoan">New Loans</a>
</p>

</body>
</html>