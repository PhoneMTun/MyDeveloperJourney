<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
    <title>Create a Task</title>
    <link rel="stylesheet" href="/css/style.css"> 
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
<body >

<c:out value="${team}"></c:out>
<c:out value="${team.creator}"></c:out>


        <h1 class="display-4"><c:out value="${song.name}"></c:out></h1>
        <h4 class="welcome">(Started By: <c:out value="${song.creator.userName}"></c:out>)</h4>
        <h4>Genre: <c:out value="${song.genre}"></c:out></h4>
        <h4>Lyrics: <br><c:out value="${song.lyric}"></c:out></h4>
        
        <a class="button-64" href="/songs/${song.id}/edit">Contribute</a>
        <br>
        <br>
        <hr>
        <br>
        <h4> Collaborators:</h4>
        <ul>
		    <c:forEach var="collaborator" items="${collaborators}">
		        <li><c:out value="${collaborator.user.userName}"></c:out></li>
		    </c:forEach>
		</ul>


</body>
</html>