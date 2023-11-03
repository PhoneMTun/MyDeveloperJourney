<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<h1 class="welcome"> Welcome!, ${user.userNameString}</h1>
	<h3> All Projects.</h3>
	<h5><a href="/logout">logout</a></h5>
	<h2> All Projects</h2>
	<a href="/projects/new"><button >+ new Project</button></a>
	<table>
		<thead>
			<tr>
				<th>Project</th>
				<th>Team Lead</th>
				<th>Due Date</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="project" items="${unassignedProjects}">
			<c:if test="${project.lead.id!=user.id}">

			<tr>
				<td><a href="/projects/${project.id}"><c:out value="${project.title}"/></a></td>
				<td><c:out value="${project.lead.userNameString}"></c:out></td>
				<td><fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></td>
				<td><a href="/dashboard/join/${project.id}">Join team</a> </td>

			</tr>
			</c:if>
		</c:forEach>
		</tbody>
	</table>
	<h2> Your Projects</h2>
	<table>
		<thead>
			<tr>
				<th>Project</th>
				<th>Team Lead</th>
				<th>Due Date</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach var="project" items="${assignedprojects}">
			

			<tr>
				<td><a href="/projects/${project.id}"><c:out value="${project.title}"/></a></td>
				<td><c:out value="${project.lead.userNameString }"></c:out></td>
				<td><c:out value="${project.dueDate }"></c:out></td>
				<c:if test="${user.id==project.lead.id}">
					<td><a href="/projects/edit/${project.id}">Edit</a>
				</c:if>
				<c:if test="${user.id!=project.lead.id}">
					<td><a href="/dashboard/leave/${project.id}">Leave</a> </td>
				</c:if>
			</tr>
		
		</c:forEach>
		</tbody>
	</table>
	
	
	

</body>
</html> 