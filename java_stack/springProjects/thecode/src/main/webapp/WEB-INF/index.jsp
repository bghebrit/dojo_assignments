<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Code !</title>
</head>
<body>
	<p><c:out value="${error}"/></p>
	<h1>You must train harder!</h1>
	<p>What is the Code?</p><br>
	<br>
	<form method = "POST" action="/login">
		<input type="text" name="code"><br>
		<br>
		<button>Try Code</button>
	</form>
</body>
</html>