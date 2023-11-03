<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Team Details</title>
    <link rel="stylesheet" href="/css/style.css"> 
    <script type="text/javascript" src="/js/app.js" defer></script>
</head>
<body>
	<h1><c:out value="${team.name}"></c:out></h1>
	<a href="/home">dashboard</a>
	<h4>Team Name: <c:out value="${team.name}"></c:out></h4>
	<h4>Added By: <c:out value="${team.creator.userNameString}"></c:out></h4>
	<h4>Skill Level: <c:out value="${team.skilllvl}"></c:out></h4>
	<h4>Game Day: <fmt:formatDate value="${team.gameday}" pattern="EEEE"/></h4>
	<h4>Players:</h4>
	<c:forEach var="player" items="${ players}">
		<ul>
		  <li><c:out value="${player.name}"></c:out></li>
		</ul>
	</c:forEach>
	<hr>
	<form:form action="/add/player/${team.id}" method="post" modelAttribute="player">
	<form:errors path="team" class="errors" />
	<table>
	<form:errors class="errors" path="name"/>
		<tbody>
			<tr>
				<td><form:label path="name">Player Name:</form:label></td>
				<td><form:input class="label1"  path="name"/></td>
				
			</tr>

			<tr>
			 	<td colspan="2"><input class="submit" type="submit" value="Submit"/></td>
			</tr>

	</tbody>
	</table>
	</form:form>
	<c:if test="${userId==team.creator.id}">
		<a href="/teams/${team.id}/edit">edit</a>
		<a href="/teams/delete/${team.id}">delete</a>
	</c:if>
	
</body>

	
</html>