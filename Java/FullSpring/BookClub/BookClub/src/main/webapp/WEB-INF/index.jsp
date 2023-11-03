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
	<h1>Book Club</h1>
	<h4>A place for friends to share thoughts on books.</h4>
	<div class="container">
		<div class="register">
			<form:form action="/register" method="post" modelAttribute="newUser">
				<h1> Register</h1>
				<form:errors class="errors" path="userNameString"/><br>
				<form:errors class="errors" path="email"/><br>
				<form:errors class="errors" path="password"/><br>
				<form:errors class="errors" path="confirm"/>
				<form:label path="userNameString">User Name:</form:label>
				<form:input path="userNameString"/>
				<form:label path="email">Email:</form:label>
				<form:input path="email"/>
				<form:label path="password">Password:</form:label>
				<form:password  path="password"/>
				<form:label path="confirm">Confirm PW:</form:label>
				<form:password  path="confirm"/>
				<input class="submit" type="submit" value="Submit"/>
			</form:form> 
		</div>
		<div class="login">
		<h1> Login</h1>
			<form:form action="/login" method="post" modelAttribute="newLogin">
				<form:errors class="errors" path="emailString"/><br>
				<form:errors class="errors" path="passwordString"/><br>
				<br>
				<form:label path="emailString">Email:</form:label>
				<form:input path="emailString"/>
				<form:label path="passwordString">Password:</form:label>
				<form:password  path="passwordString"/>
				<input class="submit" type="submit" value="Submit"/>
			</form:form> 
		</div>
	</div>
</body>
</html>