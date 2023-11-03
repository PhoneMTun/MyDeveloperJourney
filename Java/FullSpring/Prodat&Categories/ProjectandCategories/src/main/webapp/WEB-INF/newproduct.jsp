<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Read Share</title>
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<h1>Home Page</h1>
	<div class="newcategory">
		<a href="###">Home</a>
		
	</div>
	<hr>
	<form:form action="/add" method="post" modelAttribute="product">
	<div class="container-errors">
		<form:errors class="errors" path="name"/><br>
		<form:errors class="errors" path="description"/><br>
		<form:errors class="errors" path="price"/><br>
	</div>
	<table>
		<tbody>
			<tr>
				<td><form:label path="name">Name:</form:label></td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td><form:label path="description">Description:</form:label></td>
				<td><form:input path="description"/></td>
			</tr>
			<tr>
				<td><form:label path="price">Price:</form:label></td>
				<td><form:input path="price"/></td>
			</tr>
			<tr>
				<td colspan="2"><input class="submit" type="submit" value="Submit"/></td>
			</tr>
		</tbody>
	</table>
	
	</form:form>
</body>
</html>