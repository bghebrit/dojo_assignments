<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Submitted Info</h1>
	<label>Name: <c:out value="${username}"/> </label><br>
	<br>
	<label>location: <c:out value="${location}"/> </label><br>
	<br>
	<label>language: <c:out value="${language}"/> </label><br>
	<br>
	<label>comment: <c:out value="${comment}"/> </label><br>
	<br>
	<a href="/">Go Back</a>

</body>
</html>