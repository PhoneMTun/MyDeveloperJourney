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
</body>
	<h1>Add a Book to Your Shelf!</h1>
	<h3><a>Look to your shelves</a></h3>
	<form:form action="/add" method="post" modelAttribute="book">
		<h1> Register</h1>
		<form:errors class="errors" path="title"/><br>
		<form:errors class="errors" path="author"/><br>
		<form:errors class="errors" path="thoughts"/><br>
		<form:label path="title">Title</form:label>
		<form:input class="label1" path="title"/>
		<form:label path="author">Author</form:label>
		<form:input class="label1" path="author"/>
		<form:label path="thoughts">My thoughts</form:label>
		<form:textarea  class="label2" path="thoughts"/>
		<form:label path="user"></form:label>
		<form:input type="hidden" value="${user.id}" path="user"/>
		
		<input class="submit" type="submit" value="Submit"/>
	</form:form>
	
</html>