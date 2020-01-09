<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Page</title>
</head>
<body>

	<h1>New Category</h1>
		<form:form action="/categories" method="post" modelAttribute="category">
		<p>
			<form:label path="name">Name</form:label>
			<form:input path="name"/>
		</p>
			<input type="submit" value="Create"/>
		</form:form>
		<form:errors path="category.*"/>

</body>
</html>