<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Task</title>
</head>
<body>

	<h1>Create a new task</h1>
	<form:form method="POST" action="/tasks/new" modelAttribute="task">
	<form:input path="creator" type="hidden" value="${ currentUserId} " ></form:input>
		<table>
			<tr>
				<td><form:label path="taskName">Task:</form:label></td>
				<td><form:input path="taskName" class="input" /></td>
				<%-- <td><form:errors path="taskName" /></td> --%>
			</tr>
			
			<tr>
				<td><form:label path="assignee">Assignee:</form:label></td>
				<td><form:select path="assignee" class="select is-one-third">
						<c:forEach items="${users}" var="user">
							<c:if test="${user.name != currentUser.name}">
								<form:option value="${user}">
									<c:out value="${user.name}" />
								</form:option>
							</c:if>
						</c:forEach>
					</form:select>
				</td>
				<%-- <td><form:errors path="assignee" /></td> --%>
			</tr>
			
			<tr>
				<td><form:label path="priority">Priority:</form:label></td>
				<td><form:select path="priority" class="select is-one-third">
					<form:option value=""></form:option>
					<form:option value="1">Low</form:option>
					<form:option value="2">Medium</form:option>
					<form:option value="3">High</form:option>
					</form:select></td>
			</tr>
		</table>
		<input type="submit" value="Create" class="button" />
	</form:form>
	<p><c:out value="${errors }"/></p>

</body>
</html>