<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Project Details</title>
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<h1> Project details</h1> 
	<a href="/dashboard"> Back To Dashboard</a>
	<h4>Project: <c:out value="${project.title}"></c:out></h4>
	<h4>Description: <c:out value="${project.description}"></c:out></h4>
	<h4>Due Date: <fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></h4>
	
	<a href="/projects/${project.id}/tasks">See tasks!</a>
	<a href="/projects/delete/${project.id}">Delete</a>
</body>
</html>