<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add to <c:out value="${song.name}"></c:out></title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css"> 
    <script type="text/javascript" src="/js/app.js" defer></script>
</head>
<body>
    <h1>Add to <c:out value="${song.name}"></c:out></h1>
    <table>
        <form:form action="/edit/${song.id}" method="post" modelAttribute="song">
            <form:errors class="errors" path="name"/><br>
            <form:errors class="errors" path="lyric"/><br>
            <form:errors class="errors" path="genre"/><br>
            <form:errors class="errors" path="additionalLyric"/><br>
            <tbody>
                <tr>
                    <td><form:label path="name">Song Title</form:label></td>
                    <td><form:input class="label1" path="name" readonly="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="genre">Genre:</form:label></td>
                    <td><form:input class="label1" path="genre"/></td>
                </tr>
                <tr>
                    <td><form:label path="lyric">Add to the lyrics:</form:label></td>
					<td>
						<form:input type="hidden" class="label1" path="lyric"/>
					    <c:out value="${song.lyric}" /><br>
					    <form:input  class="label1" path="additionalLyric"/>
					</td>
                </tr>
                <tr>
                     <td colspan="2"><input class="submit" type="submit" value="Submit"/></td>
                </tr>
                <form:errors path="creator" class="error"/>
                <form:input type="hidden" path="creator" value="${userId}"/>
            </tbody>
        </form:form>
    </table>
    <br>
    <a href="/home" class="btn btn-warning">Cancel</a>
    <c:if test="${userId==song.creator.id}">
        <a href="/songs/delete/${song.id}" class="btn btn-danger">Delete</a>
    </c:if>
</body>
</html>
