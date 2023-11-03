<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dorms</title>
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
	<h1>Dorms</h1>
	<a href="/newdorm">Add a new dorm</a><br>
	<a href="/newstudent">Add a new student</a>
	<table>
		<thead>
			<tr>
				<th>Dorm</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dorm" items="${dorms}">
			<tr>
				<td><c:out value="${dorm.name}"></c:out></td>
				<td><a href="dorms/${dorm.id}">See Students</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>