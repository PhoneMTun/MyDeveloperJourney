<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Read Share</title>
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<meta charset="ISO-8859-1">
<title>Question Dashboard</title>
</head>
<body>
<h1> Question Dashboard</h1>
<table>
	<thead>
		<tr>
			<th>Question</th>
			<th>Tags</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="question" items="${questions }">
		<tr>
			<td><a href="/questions/${question.id}"><c:out value="${question.text}"></c:out></a></td>
			<td>
	           
	            <c:forEach var="tag" items="${question.tags}" varStatus="loop">
	                    <c:out value="${tag.subject}"/>
	            </c:forEach>
			</td>
		</tr>
	</c:forEach>
	
	</tbody>
</table>
<a href="/questions/new">New Questions</a>

</body>
</html>