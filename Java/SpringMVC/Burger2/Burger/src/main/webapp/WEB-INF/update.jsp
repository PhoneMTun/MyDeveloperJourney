<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Burger Tracker</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<h1>Edit Burger</h1>
	<form:form action="/burgers/${burger.id}" method="post" modelAttribute="burger">
	<input type="hidden" name="_method" value="put" /> 
	<div class="errors">
		<form:errors path="burgername"/><br>
		<form:errors path="resname"/><br>
		<form:errors path="rating"/><br>
		<form:errors path="notes"/>
	</div>
	<p>
	<form:label path="burgername">Burger Name</form:label>
	<form:input path="burgername"/>
	</p>
	<p>
	<form:label path="resname">Reastaurant Name</form:label>
	<form:input path="resname"/>
	</p>
	<p>
	<form:label path="rating">Rating</form:label>
	<form:input path="rating"/>
	</p>
	<p>
	<form:label path="notes">Notes</form:label>
	<form:textarea path="notes"/>

	</p>
	 <input type="submit" value="Submit"/>
</form:form>

</body>
</html>