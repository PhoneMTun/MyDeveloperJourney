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
			<h4>Hello, ${user.userNameString }, Welcome to..</h4>
			<h1>The Book Broker!</h1>
		</div>
		<div class="nav-right">
			<h3><a href="/books">Back to the shelves</a></h3>
		</div>
		<h4>Available Books to Borrow</h4>
	</div>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Owner</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="book" items="${books}">
			<c:if test="${user.id!=book.borrower.id}">

			<tr>
				<td><c:out value="${book.id}"></c:out></td>
				<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
				<td><c:out value="${book.author }"></c:out></td>
				<td><c:out value="${book.user.userNameString }"></c:out></td>
				<c:if test="${user==book.user}">
					<td><a href="/books/${book.id}/edit">edit</a> | <a href="/books/${book.id}/delete">delete</a>
				</c:if>
				<c:if test="${user!=book.user}">
					<td><a href="/books/${book.id}/borrow">borrow</a> </td>
				</c:if>
			</tr>
			</c:if>
		</c:forEach>
		</tbody>
	</table>
	<h2> Books I am Borrowing</h2>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Owner</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="book" items="${books}">
			<c:if test="${user.id==book.borrower.id}">

			<tr>
				<td><c:out value="${book.id}"></c:out></td>
				<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
				<td><c:out value="${book.author }"></c:out></td>
				<td><c:out value="${book.user.userNameString }"></c:out></td>
				<td><a href="/books/${book.id}/return">return</a> 
			</tr>
			</c:if>
		</c:forEach>
		</tbody>
	</table>
	

</body>
</html>