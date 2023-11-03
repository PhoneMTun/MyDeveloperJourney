<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="script/Date.js"></script>
</head>
<body>
	<h1>Send an Omikuji</h1>
	<div class="container">
		<form action="/send" method="post">
			<label>Pick any number from 5 to 25</label>
    		<input type="number" name='num'>
    		<label>Enter the name of any city.</label>
    		<input type="text" name='cityname'>
    		<label>Enter the name of real person.</label>
    		<input type="text" name='personname'>
    		<label>Enter professional endeavor or hobby</label>
    		<input type="text" name='hobby'>
    		<label>Enter any type of living thing.</label>
    		<input type="text" name='livingthing' >
    		<label>Say something nice to someone:</label>
    		<input type="text" name='nicething' class="saysomething">
    		<label>Send and show a friend</label>
    		<input type="submit" name='Send' class="submit">
    		
		</form>
	</div>
	

</body>
</html>