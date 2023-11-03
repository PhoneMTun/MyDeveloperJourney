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
		<a href="/">Home</a>
		
	</div>
	<hr>
	<form:form action="/addcategory" method="post" modelAttribute="category">
	<div class="container-errors">
		<form:errors class="errors" path="name"/><br>
	</div>
	<table>
		<tbody>
			<tr>
				<td><form:label path="name">Name:</form:label></td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td colspan="2"><input class="submit" type="submit" value="Submit"/></td>
			</tr>
		</tbody>
	</table>
	
	</form:form>
</body>
</html>