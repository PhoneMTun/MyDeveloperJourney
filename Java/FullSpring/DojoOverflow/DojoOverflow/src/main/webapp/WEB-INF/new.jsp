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
<meta charset="ISO-8859-1">
<title>New Question</title>
</head>
<body>
<h1>What is your question?</h1>
<a href="/">Dashboard</a>
<form:form action="/questions/new/add" method="post" modelAttribute="question">
	<div class="container-errors">
		<form:errors class="errors" path="text"/><br>
		<p><c:out value="${error}"></c:out></p>
		
	</div>

			<div>
				<form:label path="text">Text:</form:label>
				<form:input path="text"/>
			</div>
			<div>
				<label for="listOfTags">Tags:</label>
        		<input class="input" name="listOfTags" id="listOfTags"/>

			</div>
			<div>
				<input class="submit" type="submit" value="Submit"/>
			</div>

	
	</form:form>
</body>
</html>