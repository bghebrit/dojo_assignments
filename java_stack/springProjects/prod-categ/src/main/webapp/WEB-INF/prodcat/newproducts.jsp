<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1> <c:out value="${product.name }"/> </h1>
	<h2>Categories:</h2>
	<c:forEach items="${product.categories }" var="cat">
		<h3><c:out value="${cat.name }"/></h3>
	</c:forEach>
	
	<form:form action="/attachcategory" method="post" modelAttribute="product">
		<h2>
			<form:label path="category">Add Category:</form:label>
			<form:select path="category">
				<c:forEach items="${categories }" var="cat">
					<form:option value="${cat.id }"><c:out value = "${cat.name }"/></form:option>
				</c:forEach>
			</form:select>
		</h2>
		<form:hidden path="product" value="${product.id }"/>
		<input type="submit" value="create"/>
	</form:form>
	

</body>
</html>