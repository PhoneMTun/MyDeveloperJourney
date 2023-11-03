<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Read Share</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container1">
		<div class="title">
			<h1>Welcome, ${user.userNameString }</h1>
			<h4>Books for everyone's shelves</h4>
		</div>
		<div class="nav-right">
			<h3>Logout</h3>
			<h3><a href="/books/new">+Add to my shelves</a></h3>
	</div>
	</div>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Posted By</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="book" items="${books}">

			<tr>
				<td><c:out value="${book.id}"></c:out></td>
				<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
				<td><c:out value="${book.author }"></c:out></td>
				<td><c:out value="${book.user.userNameString }"></c:out></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

</body>
</html>