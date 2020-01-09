<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/login" method="POST">
	<label>Your Name: <input type="text" name="username"></label><br>
	<br>
	<label>Dojo Location:<select>
		<option value="location">San Jose</option>
		<option value="location">Oakland</option>
		<option value="location">San Francisco</option>
	</select> 
	<label>Favourite Language: <select>
		<option value="language">Python</option>
		<option value="language">Java</option>
		<option value="language">JavaScript</option>
	</select>
	</label><br>
	<br>
	<label>Comment (optional:)<input type ="text" name="comment"></label><br>
		<br><textarea rows="4" cols="50"></textarea>
	</label>
	<br>
	<button type="submit">Button</button>
	</form>

</body>
</html>