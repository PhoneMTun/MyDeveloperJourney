<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Team</title>
    <link rel="stylesheet" href="/css/style.css"> 
    <script type="text/javascript" src="/js/app.js" defer></script>
</head>
<body>
<h1> Edit Team</h1>
<a href="/home">dashboard</a>
	<table>
<form:form action="/edit/${team.id}" method="post" modelAttribute="team">
	<form:errors class="errors" path="name"/><br>
		<form:errors class="errors" path="skilllvl"/><br>
		<form:errors class="errors" path="gameday"/><br>
	<tbody>
		<tr>
			<td><form:label path="name">Team Name</form:label></td>
			<td><form:input class="label1" path="name"/></td>
		</tr>
		<tr>
			<td><form:label path="skilllvl">Skill Level(1-5)</form:label></td>
			<td><form:input type="number" class="label1" path="skilllvl"/></td>
		</tr>
		<tr>
			<td><form:label path="gameday">Game Day:</form:label></td>
			<td><form:input class="label1" type="date" path="gameday"/></td>
		</tr>
		<tr>
			 <td colspan="2"><input class="submit" type="submit" value="Submit"/></td>
		</tr>
		<form:errors path="creator" class="error"/>
		<form:input type="hidden" path="creator" value="${userId}"/>
	</tbody>
	</form:form>
</table>
<a href="/teams/delete/${team.id}">delete</a>

</body>
</html>