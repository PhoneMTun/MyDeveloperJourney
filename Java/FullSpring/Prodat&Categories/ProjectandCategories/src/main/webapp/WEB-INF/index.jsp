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
	<h1>Home Page</h1>
	<div class="newcategory">
		<a href="/products/new">New Product</a>
		<a href="/categories/new">New Category</a>
	</div>
	<hr>
	<table>
		<thead>
			<tr>
				<th>Products</th>
				<th>Category</th>
			</tr>
		</thead>
		<tbody>
		
			<tr>
				<td>
					<ul class="vertical-list">
						<c:forEach var="product" items="${products}">
							<li><a href="/products/${product.id}"><c:out value="${product.name }"/></a></li>
						</c:forEach>
					</ul>
				</td>
				<td>
					<ul class="vertical-list">
						<c:forEach var="category" items="${categories}">
							<li><a href="/categories/${category.id}"><c:out value="${category.name }"/></a></li>
						</c:forEach>
					</ul>
			</tr>
		
		
		</tbody>
	</table>
</body>
</html>