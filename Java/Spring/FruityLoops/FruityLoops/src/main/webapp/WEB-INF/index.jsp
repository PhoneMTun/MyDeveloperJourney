<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fruit Store</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="script/Date.js"></script>
</head>
<body>
	<h1>Fruit Store	</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Price</th>
		</tr>
		<c:forEach var="onefruit" items="${fruits}">
		<tr>
			<td><c:out value="${onefruit.name}"></c:out></td>
			<td><c:out value="${onefruit.price}"></c:out></td>
		</tr>
		</c:forEach>
			
	</table>
	

</body>
</html>