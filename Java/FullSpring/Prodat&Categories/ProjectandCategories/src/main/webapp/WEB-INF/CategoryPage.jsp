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
	<h1><c:out value="${category.name}"></c:out></h1>
	<div class="newcategory">
		<a href="/">Home</a>
	</div>
	<hr>
	<h2>Products:</h2>
	<ul>
		<c:forEach var="product" items="${belongs}">
	    <li><c:out value="${product.name}"></c:out></li>
	    </c:forEach>
	</ul>
	<hr>
	<h2>Add Categories:</h2>
	<form action="/categories/${category.id}/update" method="post">
		<select name="productId" id="productId" class="input">
			<c:forEach var="product" items="${notbelongs}">
				<option value="${product.id}">${product.name}</option>
			</c:forEach>
		</select>
			<input class="submit" type="submit" value="Submit"/>
	</form>
</body>
</html>