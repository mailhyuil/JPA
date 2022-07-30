<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post">
	<input name="username" placeholder="username"/>
	<input name="password" placeholder="password"/>
	<input name="name" placeholder="name"/>
	<input name="role" placeholder="role"/>
	<input name="email" placeholder="email"/>
	<button>저장</button>
</form>
<table>
	<tr>
		<th>username</th>
		<th>password</th>
		<th>name</th>
		<th>email</th>
		<th>role</th>
	</tr>
	<c:forEach items="${LIST }" var="list">
		<tr>
			<td><a href="/school/delete?username=${list.username}">${list.username }</a></td>
			<td>${list.password }</td>
			<td>${list.name }</td>
			<td>${list.email }</td>
			<td>${list.role }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>