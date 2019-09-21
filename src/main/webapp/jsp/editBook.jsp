<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit book</title>
	<link rel="stylesheet" type="text/css" href="css/generalStyles.css">
</head>
<body>

<h1>Editing Book ID: ${oldBook.bid}</h1>
<form:form modelAttribute="book">
  <table>
    <tr>
      <td class="labeld">Title:</td>
      <td><form:input path="title" value="${oldBook.title}"></form:input></td>
    </tr>
    <tr>
      <td class="labeld">Author:</td>
      <td><form:input path="author" value="${oldBook.author}"></form:input></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Update" class="button"/>
      </td>
    </tr>
  </table>
</form:form>

<p>
	<a href="/">Home</a>
	<a href="/showBooks">List Books</a>
</p>

</body>
</html>