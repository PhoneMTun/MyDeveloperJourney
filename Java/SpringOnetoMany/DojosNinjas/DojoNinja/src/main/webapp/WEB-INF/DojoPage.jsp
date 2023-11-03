<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dojo Page</title>
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<h1> <c:out value="${ dojo.name}"/> Ninjas</h1>
<table>
	<thead>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="ninja" items="${dojo.ninjas }">
		<tr>
			<td><c:out value="${ ninja.firstName}"/></td>
			<td><c:out value="${ ninja.lastName}"/></td>
			<td><c:out value="${ ninja.age}"/></td>
			
		</tr>
	</c:forEach>
	</tbody>
</table>
   
</body>
</html>

