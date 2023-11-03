<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Increment by 2</title>
</head>
<body>
	<h3>You have visited<a href="/">http://localhost:8080/</a> <c:out value="${ count}"/> <a href="/counter">http://localhost:8080/counter</a></h3>
	<form action="/reset" method="Post">
		<input type="submit" value="Click here to Reset">
	</form>
</body>
</html>