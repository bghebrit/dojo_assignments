<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<p>Edit a task</p>
	
	<form:form method="POST" action="/tasks/${id}/edit"	modelAttribute="edittask">
	<form:input type="hidden" path="creator"></form:input> 
		<table>
			<tr>
				<td><form:label path="taskName">Task:</form:label></td>
				<td><form:input path="taskName"/></td>
				<td><form:errors path="taskName"/></td>
			</tr>
			<tr>
				<td><form:label path="assignee">Assignee:</form:label></td>

					<form:select path="assignee" class="select">
						<c:forEach items="${users}" var="user">
							<form:option value="${user.id}">${user.name}</form:option>					
						 </c:forEach>
					</form:select>		
			<tr>
				<td><form:label path="priority">Priority:</form:label></td>
				<td><form:select path="priority" class="select">
						<form:option value="1">Low</form:option>
						<form:option value="2">Medium</form:option>
						<form:option value="3">High</form:option>
					</form:select>
				</td>
					
		</table>
			<input type="submit" value="Edit" class="button" />
	</form:form>


</body>
</html>