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
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<h1><c:out value="${product.name}"></c:out></h1>
	<div class="newcategory">
		<a href="/">Home</a>
	</div>
	<hr>
	<h2>Categories:</h2>
	<ul>
		<c:forEach var="category" items="${belongs}">
	    <li><c:out value="${category.name}"></c:out></li>
	    </c:forEach>
	</ul>
	<hr>
	<h2>Add Categories:</h2>
	<form action="/products/${product.id}/update" method="post">
		<select name="categoryId" id="categoryId" class="input">
			<c:forEach var="category" items="${notbelongs}">
				<option value="${category.id}">${category.name}</option>
			</c:forEach>
		</select>
			<input class="submit" type="submit" value="Submit"/>
	</form>
</body>
</html>