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
	<h1> Create a Project</h1>
	<form:form action="/edit/${project.id}" method="post" modelAttribute="project">
	
		<form:errors class="errors" path="title"/><br>
		<form:errors class="errors" path="description"/><br>
		<form:errors class="errors" path="dueDate"/><br>
		<form:label path="title">Title</form:label>
		<form:input class="label1" path="title"/>
		<form:label path="description"> Project Description:</form:label>
		<form:textarea  class="label2" path="description"/>
		<form:label path="dueDate">Due Date</form:label>
		<form:input class="label1" type="date" path="dueDate"/>
		
		<form:errors path="lead" class="error"/>
			<form:input type="hidden" path="lead" value="${userId}"/>
		
		<input class="submit" type="submit" value="Submit"/>
	</form:form>
	
</html>