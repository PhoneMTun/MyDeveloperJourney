<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Share</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="script/Date.js"></script>
</head>
<body>
	<h1> All Books</h1>
	<table>
		<thead>
			<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Language</th>
			<th>Number of Pages
			</tr>
		</thead>
		<tbody>
		<c:forEach var="book" items="${books}">
			<tr>
				<td><c:out value="${ book.id}"/></td>
				<td><a href="/books/<c:out value="${book.id}"/>"><c:out value="${book.title}"/></a></td>
				<td><c:out value="${ book.description}"/></td>
				<td><c:out value="${ book.numberOfPages}"/></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

</body>
</html>