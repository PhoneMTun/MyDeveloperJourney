<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Dojo</title>
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<h1>New Dojo</h1>
	<a href="/dojos/new">Add Dojo</a><br>
<a href="/ninjas/new">Add Ninja</a><br>
<h3>Display <c:forEach var="dojo" items="${dojos}"><a href="/dojos/${dojo.id}"><c:out value="${dojo.name}"></c:out> , </a></c:forEach> Location</h3>
	<form:form action="/dojos" method="post" modelAttribute="dojo">
		<form:label path="name">Title:</form:label>
		<form:errors path="name"/>
		<form:input path="name"/>
	<input type="submit" value="Submit">
	</form:form>
</body>
</html>

