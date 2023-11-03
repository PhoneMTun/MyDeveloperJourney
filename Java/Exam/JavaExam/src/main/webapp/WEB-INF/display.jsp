<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a Task</title>
</head>
<head>
    <meta charset="ISO-8859-1">
    <title>Create a Task</title>
    <link rel="stylesheet" href="/css/style.css"> 
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body >
        <h1 class="display-4"><c:out value="${baby.name}"></c:out></h1>
        <h4 class="welcome">(added by Added By: <c:out value="${baby.creator.userName}"></c:out>)</h4>
        <h4>Gender: <c:out value="${baby.gender}"></c:out></h4>
        <h4>Origin: <c:out value="${baby.origin}"></c:out></h4>
        
        <c:if test="${userId==vote.user.id}">
            <h4 class ="the_one">You voted for this name</h4>
        </c:if>
        
        <p class="success">Meaning: <c:out value="${baby.meaning}"></c:out></p>
        <hr>
        <br>
        <c:if test="${userId==baby.creator.id}">
            <a class="button-64" href="/names/${baby.id}/edit">edit</a>
        </c:if>

</body>
</html>