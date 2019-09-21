<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/generalStyles.css">
</head>
<body>

<h1>Delete Loan</h1>
<form:form modelAttribute="loan">
  <table>
    <tr>
      <td class="labeld">Loan ID:</td>
      <td><form:input path="lid"></form:input></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Delete" class="button"/>
      </td>
    </tr>
  </table>
</form:form>

<p>
	<a href="/">Home</a>
	<a href="/showBooks">List Books</a>
	<a href="/showCustomers">List Customers</a>
	<a href="/showLoans">List Loans</a>
	<a href="/newLoan">New Loan</a>
</p>

</body>
</html>