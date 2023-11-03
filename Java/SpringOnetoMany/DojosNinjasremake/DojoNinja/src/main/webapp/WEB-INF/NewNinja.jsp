<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Ninja</title>
    <link rel="stylesheet" href="/css/style1.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<h1>New Ninja</h1>
	<a href="/dojos/new">Add Dojo</a><br>
	<a href="/ninjas/new">Add Ninja</a><br>
	
	<h3>Display <c:forEach var="dojo" items="${dojos}"><a href="/dojos/${dojo.id}"><c:out value="${dojo.name}"></c:out> , </a></c:forEach> Location</h3>
	
   <form:form action="/ninjas" method="post" modelAttribute="ninja">
		<h4>
			<form:label path="dojo">Dojo:</form:label>
				<form:select path="dojo">
					<c:forEach var="eachDojo" items="${dojos}">
						<form:option value="${eachDojo.id }" path="dojo">
							<c:out value="${eachDojo.name }"></c:out>
						</form:option>
					</c:forEach>
				</form:select>
		</h4>
		<h4>
			<form:label path="firstName">First Name:</form:label>
			<form:errors path="firstName"/>
			<form:input path="firstName"/>
		</h4>
		<h4>
			<form:label path="lastName">Last Name:</form:label>
			<form:errors path="lastName"/>
			<form:input path="lastName"/>
		</h4>
		<h4>
			<form:label path="age">Age:</form:label>
			<form:errors path="age"/>
			<form:input path="age"/>
		</h4>
	<input type="submit" value="Submit">
	</form:form>
</body>
</html>

