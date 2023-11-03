<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Class</title>
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
	<h1>New Class</h1>
	<a href="/dorms">Dashbaord</a><br>
	<table>
		<tbody>
		<form:form action="/newclassadd" method="post" modelAttribute="course">
			<form:errors path="name"></form:errors>
			<tr>
				<td><form:label path="name">Name:</form:label></td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit"></td>
			</tr>
		</form:form>

		</tbody>
	</table>
</body>
</html>