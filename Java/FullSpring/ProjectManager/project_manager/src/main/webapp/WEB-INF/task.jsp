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
    <title>Props Page</title>
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	
    <h1>Project: <c:out value="${thisproject.title}"></c:out></h1>
    <h3>Project: <c:out value="${thisproject.lead.userNameString }"></c:out></h3>
	<a href="/dashboard">Back to Dashboard</a>
	<form:form action="/add/task/${thisproject.id}" method="post" modelAttribute="task">
		<form:label path="tagdescription"> Add a task ticker for this team::</form:label>
		<form:textarea  class="label2" path="tagdescription"/>
		<form:input type="hidden" path="name" value="${username.userNameString}"/>
		
	<input class="submit" type="submit" value="Submit"/>
	</form:form>
	
	<c:forEach var="task" items="${projecttasks}">
		<p>Added by: <c:out value="${task.name}"/> at <c:out value="${task.createdAt}"/>.</p>
		<p><c:out value="${task.tagdescription}"/></p>
		</c:forEach>

</body>
</html>