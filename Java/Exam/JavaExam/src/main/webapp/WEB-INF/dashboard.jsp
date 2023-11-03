<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Project Manager Dashboard</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css"> 
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	 <div class="row">
     	<div class="col-md-8">
            <h1 class="display-4">Hello, <span class="text-primary">${user.userName}</span>. Here are some name suggestions..</h1>
        </div>
        <div class="col-md-4 text-right">
        	<a href="/logout" class="btn btn-danger">Logout</a>
        </div>
     </div>
    
   
     <p>${voteMessage}</p>
     <div class="mt-4">
            <table class="table table-bordered table-striped">
    			<thead>
					<tr>
						<th>Project</th>
						<th> </th>
						<th> </th>
						<th> </th>
						<th>Votes</th>
					</tr>
		</thead>
                <tbody>
                    <c:forEach var="baby" items="${babies}">
                        <tr>
                        	<td><a href="/count/${baby.id }">upvote!</a></td>
                            <td><a href="/names/${baby.id}"><c:out value="${baby.name}"/></a></td>
                            <td><c:out value="${baby.gender}"></c:out></td>
                            <td>Origin:  <c:out value="${baby.origin}"></c:out></td>
                            <td><c:out value="${fn:length(baby.votes)}"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="/names/new" class="btn btn-success"> new name </a>
        
        </div>




</body>
</html>