<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Expense</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<h1>Edit Expense</h1>
	<form:form action="/saveTravel/${saveTravel.id}" method="post" modelAttribute="saveTravel">
	<input type="hidden" name="_method" value="put" /> 
	<div class="errors">
		<form:errors path="expensename"/><br>
		<form:errors path="vendor"/><br>
		<form:errors path="amount"/><br>
		<form:errors path="description"/>
	</div>
	<input type="hidden" name="id" value="${saveTravel.id}" />
	
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