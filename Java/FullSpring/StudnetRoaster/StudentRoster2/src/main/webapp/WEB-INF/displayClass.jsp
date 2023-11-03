<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><c:out value="${student.name}"></c:out></title>
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<h1><c:out value="${student.name}"></c:out>'s classes</h1>
	<a href="/dorms">Dashboard</a><br>
		<form:form action="/editstudentincourse/${student.id}" method="post" modelAttribute="course">
	<table>
		<tbody>
			<tr>
				<td>
					Classes:
						<select name="courseId" id="courseId" class="input">
		                    <c:forEach var="course" items="${coursesexcept}">
		                    	<option value="${course.id}">${course.name}</option>
		                    </c:forEach>
		                </select>
				</td>
					<td><input type="submit" value="Add"></td>
			</tr>
		

		</tbody>
	</table>
		</form:form>
	<table>
		<thead>
			<tr>
				<th>Class Name</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="selectcourse" items="${student.courses}">
			<tr>
				<td><c:out value="${selectcourse.name}"/></td>
				<td><a href="/course/${student.id}/drop/${selectcourse.id}">Drop</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>