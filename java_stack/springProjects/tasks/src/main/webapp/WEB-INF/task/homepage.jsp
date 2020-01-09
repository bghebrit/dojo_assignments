<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>

	<h1>Welcome, <c:out value="${user.name}"/></h1>
	<p>
		<a href>Priority High-Low</a> 
		<a href>Priority Low-High</a> 
		<a href="/logout">Logout</a>
	</p>
	
	<table >
			<thead>
				<tr>
					<td>Task</td><br>
					<td>Creator</td><br>
					<td>Assignee</td><br>
					<td>Priority</td><br>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tasks}" var="task" varStatus="loop">
					<tr>
						<td><a href="/tasks/${task.id}">${task.taskName }</a></td>
						<td>${task.creator.getName()}</td>
						<td>${task.assignee.getName()}</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
	
	<a href="/tasks/new" class="button">Create Task</a>
	
	
</body>
</html>