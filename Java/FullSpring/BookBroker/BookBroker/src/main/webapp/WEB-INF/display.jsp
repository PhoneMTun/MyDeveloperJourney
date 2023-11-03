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
	<h1><c:out value="${book.title }"/></h1>
	<h3><c:out value="${book.user.userNameString }"/> reads <c:out value="${book.title}"/> by <c:out value="${book.title }"/>.</h3>
	<h3>Here are <c:out value="${book.user.userNameString }"/> thoughts:</h3>
	<hr>
	<p><c:out value="${book.thoughts }"/></p>
	<hr>
	<div class="right_display">
		<form:form action="/books/${book.id}/edit" method="get">
			<input class="submit" type="submit" value="edit" />
		</form:form>

		<form:form action="/books/${book.id}/delete" method="post">
    		<input class="submit" type="submit" value="delete" />
		</form:form>

	</div>
	
	
</html>