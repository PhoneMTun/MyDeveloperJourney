<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome!</title>
    <link rel="stylesheet" href="/css/style.css"> 
    <script type="text/javascript" src="/js/app.js" defer></script>
</head>
<body>
	<h1 class="welcome"> Welcome!</h1>
	<c:if test="${not empty successMessage}">
		<div class="success">
			${successMessage}
		</div>
	</c:if>
	<div class="container">
		<div class="register">
			<form:form action="/register" method="post" modelAttribute="newUser">
				<h1> Register</h1>
				
				<div class="inputs">
					<form:errors class="errors" path="userNameString"/><br>
					<form:label path="userNameString">User Name:</form:label><br>
					<form:input path="userNameString"/><br>
				</div>
				
				<div class="inputs">
					<form:errors class="errors" path="email"/><br>
					<form:label path="email">Email:</form:label><br>
					<form:input path="email"/><br>
				</div>
				<div class="inputs">
					<form:errors class="errors" path="password"/><br>
					<form:label path="password">Password:</form:label><br>
					<form:password  path="password"/><br>
				</div>
				<div class="inputs">
					<form:errors class="errors" path="confirm"/><br>
					<form:label path="confirm">Confirm PW:</form:label><br>
					<form:password  path="confirm"/><br>
				</div>
				<input class="button-64" type="submit" value="Register"/>
			</form:form> 
		</div>
		<div class="login">
		<h1> Login</h1>
			<form:form action="/login" method="post" modelAttribute="newLogin">
				<div class="errors">
					<form:errors class="errors" path="emailString"/><br>
					<form:errors class="errors" path="passwordString"/><br>
				</div>
				<br>
				
				<form:label path="emailString">Email:</form:label><br>
				<form:input path="emailString"/><br>
				
				
				<form:label path="passwordString">Password:</form:label><br>
				<form:password  path="passwordString"/><br>
				<input class="button-64" type="submit" value="Log in"/>
			</form:form> 
		</div>
	</div>

</body>
</html>