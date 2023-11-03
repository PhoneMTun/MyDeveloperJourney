<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold Game</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="script/Date.js"></script>
</head>
<body>
	<div class="conatiner">
		<div class="yourgold">
			<h2>Your Gold: </h2>
			<div class="goldcontainer">
				<h2 class="points"><c:out value="${count}"></c:out></h2>
			</div>
		</div>
		<div class="box">
			<div class="innerbox">
				<h3>Farm</h3>
				<h3>(earns 10-20 gold)</h3>
				<form action="/" method="post">
					<input type="hidden" name="farm" value="farm">
					<button>Find Gold!</button>
				</form>
			</div>
			<div class="innerbox">
				<h3>Cave</h3>
				<h3>(earns 5-10 gold)</h3>
				<form action="/" method="post">
					<input type="hidden" name="cave" value="cave">
					<button>Find Gold!</button>
				</form>
			</div>
			<div class="innerbox">
				<h3>House</h3>
				<h3>(earns 2-5 gold)</h3>
				<form action="/" method="post">
					<input type="hidden" name="house" value="house">
					<button>Find Gold!</button>
				</form>
			</div>
			<div class="innerbox">
				<h3>Quest</h3>
				<h3>(earns/takes 0-50 gold)</h3>
				<form action="/" method="post">
					<input type="hidden" name="quest" value="quest">
					<button>Find Gold!</button>
				</form>
			</div>
			<div class="innerbox">
				<h3>Spa</h3>
				<h3>(earns/takes 5-20 gold)</h3>
				<form action="/" method="post">
					<input type="hidden" name="spa" value="spa">
					<button>Find Gold!</button>
				</form>
			</div>
		</div>
			<form action="/" method="post">
				<input type="hidden" name="reset" value="reset">
				<button>Reset</button>
			</form>
		<h3>Activities:</h3>
		<iframe src="/activities" title="Activities Iframe"></iframe>

	</div>
</body>
</html>