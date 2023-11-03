<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<h1> Save Travels</h1>
	<table>
	<thead>
		<tr>
			<th>Expense</th>
			<th>Vendor</th>
			<th>Amount</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="saveTravel" items="${saveTravels}">
	<tr>
		<td><a href="/expenses/${saveTravel.id}"><c:out value="${saveTravel.expensename}"/></a></td>
		<td><c:out value="${saveTravel.vendor}"/></td>
		<td>$<c:out value="${saveTravel.amount}"/></td>
		<td class="action">
			<a href="/expenses/${saveTravel.id}/edit">edit</a>
			<form action="/saveTravel/delete/${saveTravel.id}" method="post">
				<input type="hidden" name="_method" value="delete">
                <input type="submit" value="Delete">
            </form>
		</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
<h1>Add an expense:</h1>
<form:form action="/add" method="post" modelAttribute="saveTravel">
	<div class="errors">
		<form:errors path="expensename"/><br>
		<form:errors path="vendor"/><br>
		<form:errors path="amount"/><br>
		<form:errors path="description"/>
	</div>
	<p>
	<form:label path="expensename">Expense Name:</form:label>
	<form:input path="expensename"/>
	</p>
	<p>
	<form:label path="vendor">Vendor:</form:label>
	<form:input path="vendor"/>
	</p>
	<p>
	<form:label path="amount">Amount:</form:label>
	<form:input path="amount"/>
	</p>
	<p>
	<form:label path="description">Description:</form:label>
	<form:textarea path="description"/>

	</p>
	 <input type="submit" value="Submit"/>
</form:form>
</body>
</html>