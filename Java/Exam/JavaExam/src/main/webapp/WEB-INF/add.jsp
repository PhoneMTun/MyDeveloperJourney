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
<h1>Add a name!</h1>
	<table>
<form:form action="/add/baby" method="post" modelAttribute="baby">
		<form:errors class="errors" path="name"/><br>
		<form:errors class="errors" path="gender"/><br>
		<form:errors class="errors" path="origin"/><br>
		<form:errors class="errors" path="meaning"/><br>
	<tbody>
		<tr>
			<td><form:label path="name">New Name</form:label></td>
			<td><form:input class="label1" path="name"/></td>
		</tr>
		<tr>
		    <td><form:label path="gender">Typical Gender</form:label></td>
		    <td>
		        <form:select path="gender" class="gender">
		            <form:option value="Male" label="Male"/>
		            <form:option value="Female" label="Female"/>
		            <form:option value="Neutral" label="Neutral"/>
		        </form:select>
		    </td>
		</tr>
		<tr>
			<td><form:label path="origin">Origin:</form:label></td>
			<td><form:input class="label1" path="origin"/></td>
		</tr>
		<tr>
			<td><form:label path="meaning">Meaning</form:label></td>
			<td><form:textarea class="label2" path="meaning" cols="50"/></td>

		</tr>
		<tr>
		
			 <td colspan="2"><input class="submit" type="submit" value="Submit"/></td>
		</tr>
		<form:errors path="creator" class="error"/>
		<form:input type="hidden" path="creator" value="${userId}"/>
	</form:form>
	</tbody>
</table>
<br>
		<a href="/home" class="btn btn-warning">Cancel</a>
		
	

</body>
</html>