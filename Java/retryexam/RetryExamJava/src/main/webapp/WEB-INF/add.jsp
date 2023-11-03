<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create a course</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css"> 
    <script type="text/javascript" src="/js/app.js" defer></script>
</head>
<body>
	<h1>Start a new Song!</h1>
	<table>
	<form:form action="/add/song" method="post" modelAttribute="song">
		<form:errors class="errors" path="name"/><br>
		<form:errors class="errors" path="genre"/><br>
		<form:errors class="errors" path="lyric"/><br>
		<form:errors class="errors" path="additionalLyric"/><br>
	<tbody>
		<tr>
			<td><form:label path="name">Song Title:</form:label></td>
			<td><form:input class="label1" path="name"/></td>
		</tr>
		<tr>
			<td><form:label path="genre">Genre:</form:label></td>
			<td><form:input class="label1" path="genre"/></td>
		</tr>
		<tr>
			<td><form:label path="lyric">Add your lyrics:</form:label></td>
			<td><form:textarea class="label2" path="lyric" cols="50"/></td>
			<form:input type="hidden" class="label1" path="additionalLyric"/>

		</tr>
		<tr>
		
			 <td colspan="2"><input class="submit" type="submit" value="Submit"/></td>
		</tr>
		<form:errors path="creator" class="error"/>
		<form:input type="hidden" path="creator" value="${userId}"/>
	</tbody>
	</form:form>
</table>
	
	<a href="/home" class="btn btn-warning">Cancel</a>

</body>
</html>