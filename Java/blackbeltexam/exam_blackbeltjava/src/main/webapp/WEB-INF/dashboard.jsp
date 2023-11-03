<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Kickball League Dashboard</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css"> <!-- custom styles -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
</head>

<body class="bg-light">
    
        <div class="row">
            <div class="col-md-8">
                <h1 class="display-4">Welcome, <span class="text-primary">${user.userNameString}</span></h1>
            </div>
            <div class="col-md-4 text-right">
                <a href="/logout" class="btn btn-danger">Logout</a>
            </div>
        </div>

        <div class="mt-4">
            <table class="table table-bordered table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th>Team Name</th>
                        <th>Skill Level(1-5)</th>
                        <th>Players</th>
                        <th>Game Day</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="team" items="${ teams}">
                        <tr>
                            <td><a href="/teams/${team.id}"><c:out value="${team.name}"/></a></td>
                            <td><c:out value="${team.skilllvl}"></c:out></td>
                            <td><c:out value="${fn:length(team.players)}"></c:out>/9</td>
                            <td><fmt:formatDate value="${team.gameday}" pattern="EEEE"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="teams/new" class="btn btn-success">Create New Team</a>
        </div>

</body>

</html>
