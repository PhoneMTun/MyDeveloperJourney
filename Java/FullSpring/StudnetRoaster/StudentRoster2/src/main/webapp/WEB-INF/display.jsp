<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><c:out value="${dorm.name}"></c:out></title>
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
	<h1><c:out value="${dorm.name}"></c:out> Students</h1>
	<a href="/dorms">Dashboard</a><br>
	<table>
		<tbody>
		<form:form action="/editstudentindorm/${dorm.id}" method="post" modelAttribute="student">
			<tr>
				<td>
					Students:
						<select name="studentId" id="studentId" class="input">
		                    <c:forEach var="student" items="${studentsexcept}">
		                    	<option value="${student.id}">${student.name}</option>
		                    </c:forEach>
		                </select>
				</td>
					<td><input type="submit" value="Submit"></td>
			</tr>
		
		</form:form>

		</tbody>
	</table>
	<table>
		<thead>
			<tr>
				<th>Student</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${dorm.students}">
			<tr>
				<td><a href="/students/${student.id}"><c:out value="${student.name}"/></a></td>
				<td><a href="/dorms/${student.id}/delete">Remove</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>