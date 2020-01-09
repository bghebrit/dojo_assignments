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

		<p>	Task:<c:out value="${task.taskName}" />
		</p>
		
		
		<table>
			<tr>
				<td >Creator:</td>
				<td >${task.creator.getName()}</td>
			</tr>
			<tr>
				<td >Assignee:</td>
				<td >${task.assignee.getName()}</td>
			</tr>
			<tr>
				<td >Priority:</td>
					<c:if test="${task.priority==1}">
						<td class="subtitle">Low</td>
					</c:if>
					<c:if test="${task.priority==2}">
					<td class="subtitle">Medium</td>
					</c:if>
					<c:if test="${task.priority==3}">
						<td class="subtitle">High</td>
					</c:if>
			</tr>
					
					<c:if test="${task.creator.getId()==currentUserId}">
					<tr>
					<td><a  href="/tasks/${task.id}/edit">Edit</a></td>
					<td><a  href="/tasks/${task.id}/delete">Delete</a></td>
					</tr>
					</c:if>
		</table>

</body>
</html>