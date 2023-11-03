<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="script/Date.js"></script>
</head>
<body>
	<h1>Here's Your Omikuji!</h1>
	<div class="box">
		<h4><c:out value="${result}"/></h4>
	</div>


	<a href=/omikuji >Go Back</a>
</body>
</html>