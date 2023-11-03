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
            <h1 class="display-4">Hello, <span class="text-primary">${user.userName}</span></h1>
        </div>
        <div class="col-md-4 text-right">
        	<a href="/logout" class="btn btn-danger">Logout</a>
        </div>
     </div>
     <div class="mt-4">
            <table class="table table-bordered table-striped">
    			<thead>
					<tr>
						<th>Song</th>
						<th># of Collaborations</th>
					</tr>
		</thead>
                <tbody>
                    <c:forEach var="song" items="${songs}">
                        <tr>
                            <td><a href="/songs/${song.id}"><c:out value="${song.name}"/></a></td>
                            <td><c:out value="${fn:length(song.collaborators)}"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="/songs/new" class="btn btn-success"> new song </a>
        
        </div>

</body>
</html>