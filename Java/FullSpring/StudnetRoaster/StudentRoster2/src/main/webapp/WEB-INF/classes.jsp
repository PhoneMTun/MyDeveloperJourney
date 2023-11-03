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
	<h1>All Classes</h1>
	<a href="/dorms">Dashbaord</a><br>
	<table>
		<thead>
			<tr>
				<th>Class</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="course" items="${courses}">
			<tr>
				<td><a href="/classes/${course.id}"><c:out value="${course.name}"></c:out></a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>