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
	<h1> What is the best programming language?</h1>
	<a href="/">Dashboard</a>
	<div>
	<h2>Tags:</h2>
	<c:forEach var="tag" items="${question.tags}" varStatus="loop">
		<button> <c:out value="${tag.subject}"/></button>
	</c:forEach>
	</div>
	<h4>Answers:</h4>
	<ul>
	<c:forEach var="answer" items="${question.answers}">
		<li><c:out value="${answer.text }"/></li>
	</c:forEach>
	</ul>
	<form:form action="/questions/addanswer/${question.id}" method="post" modelAttribute="answer">
			<form:errors class="errors" path="text"/><br>
			<div>
				<form:label path="text">Answer:</form:label>
				<form:input path="text"/>
			</div>
				<input class="submit" type="submit" value="Submit"/>		
	</form:form>
	
	
	

</body>
</html>