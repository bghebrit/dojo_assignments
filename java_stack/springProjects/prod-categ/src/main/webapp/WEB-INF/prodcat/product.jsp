<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
</head>
<body>

	<h1>New Product</h1>
		<form:form action="/addproduct" method="post" modelAttribute="product">
		<p>
			<form:label path="name">Name</form:label>
			<form:input path="name"/>
		</p>
		<p>
			<form:label path="description">Description</form:label>
			<form:input path="description"/>
		</p>
		<p>
			<form:label path="price">Price</form:label>
			<form:input path="price"/>
		</p>
			<input type="submit" value="Create"/>
		</form:form>
		<form:errors path="product.*"/>
	

</body>
</html>