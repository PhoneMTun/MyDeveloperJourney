<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Expense</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<h1>Expense</h1>
	<h3>Expense Name:                             <c:out value="${ saveTravel.expensename}"/></h3>
	<h3>Expense Description:                             <c:out value="${ saveTravel.description}"/></h3>
	<h3>Vendor:                             <c:out value="${ saveTravel.vendor}"/></h3>
	<h3>Amount Spend:                             <c:out value="${ saveTravel.amount}"/></h3>
</body>
</html>