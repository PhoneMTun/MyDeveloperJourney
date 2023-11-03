<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reading Books</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="script/Date.js"></script>
</head>
<body>
<h1><c:out value="${book.title}"/> </h1>
<H3>Description: <c:out value="${book.description}"/></H3>
<H3>Language: <c:out value="${book.language}"/></H3>
<H3>Number of Pages: <c:out value="${book.numberOfPages}"/></H3>
</body>
</html>