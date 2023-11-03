<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>West Wing</title>
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
	<h1>New Student</h1>
	<a href="/dorms">Dashbaord</a><br>
	<table>
		<tbody>
		<form:form action="/newstudentadd" method="post" modelAttribute="student">
			<form:errors path="name"></form:errors>
			<tr>
				<td><form:label path="name">Name:</form:label></td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td><form:label path="dorm">Select Dorm:</form:label></td>
						<td><form:select path="dorm">
							<c:forEach var="dorm" items="${dorms}">
								<form:option value="${dorm.id}">
									<c:out value="${dorm.name }"></c:out>
								</form:option>
							</c:forEach>
						</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit"></td>
			</tr>
		</form:form>

		</tbody>
	</table>
</body>
</html>