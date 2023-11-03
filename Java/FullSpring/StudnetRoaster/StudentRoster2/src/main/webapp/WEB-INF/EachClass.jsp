<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><c:out value="${course.name }"></c:out></title>
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
	<h1>Students taking <c:out value="${course.name }"></c:out></h1>
	<a href="/dorms">Dashboard</a><br>
	<table>
		<thead>
			<tr>
				<th>Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${students}">
			<tr>
				<td><a href="/classes/%${student.id}"><c:out value="${student.name}"></c:out></a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>