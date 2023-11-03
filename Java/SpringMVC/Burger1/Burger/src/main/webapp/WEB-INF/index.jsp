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
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h1>Burger Tracker</h1>
<table>
	<thead>
		<tr>
			<th>Burger Name</th>
			<th>Restaurant Name</th>
			<th>Rating (out of 5)</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="burger" items="${burgers}">
	<tr>
		<td><c:out value="${burger.burgername}"/></td>
		<td><c:out value="${burger.resname}"/></td>
		<td><c:out value="${burger.rating}"/></td>
	</tr>
	</c:forEach>
	</tbody>
</table>
<h1>Add a Burger:</h1>
<form:form action="/add" method="post" modelAttribute="burger">
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