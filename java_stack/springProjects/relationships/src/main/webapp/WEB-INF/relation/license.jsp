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
	
	<h1>New License</h1>
	<form:form action="/addlicense" method="post" modelAttribute="license" >
    	<p>
        	<form:label path="person">Person</form:label>
        	<form:select path="person">
				<c:forEach items="${personslist}" var="p">
					<form:option value="${p.id}"><c:out value="${p.firstName} ${p.lastName}"/></form:option>
				</c:forEach>
					</form:select>
    	</p>
    	<p>
        	<form:label path="state">State</form:label>
    			<form:select path="state">
					<c:forEach items="${states}" var="state">
						<form:option value="${state}"><c:out value="${state}"/></form:option>
					</c:forEach>
				</form:select>
    	</p>
    	<p>
    		<form:label path="expirationdate">Expiration Date:</form:label>
			<form:input path="expirationdate"/>
    	</p>
       		<input type="submit" value="Create"/>
	</form:form>			  


</body>
</html>