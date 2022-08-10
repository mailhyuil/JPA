<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<link rel="stylesheet" href="static/css/style.css?sfsfdfsssdssfdf" />
		</head>

		<body>
			<h1 class="text-red-500 text-6xl font-bold bg-red-100 p-4">안녕하세요</h1>
			<form class="flex flex-col" method="post">
				<input name="username" placeholder="username" />
				<input name="password" placeholder="password" />
				<input name="name" placeholder="name" />
				<input name="role" placeholder="role" />
				<input name="email" placeholder="email" />
				<button class="bg-red-100">저장</button>
			</form>
			<table class="w-full text-center">
				<tr>
					<th>username</th>
					<th>password</th>
					<th>name</th>
					<th>email</th>
					<th>role</th>
					<th>삭제</th>
				</tr>
				<c:forEach items="${LIST }" var="list">
					<tr class="border-red-100 border">
						<td><a href="/school/delete?username=${list.username}">${list.username }</a></td>
						<td>${list.password }</td>
						<td>${list.name }</td>
						<td>${list.email }</td>
						<td>${list.role }</td>
						<td><a href="/school/delete?username=${list.username}">삭제</a></td>
					</tr>
				</c:forEach>
			</table>
		</body>

		</html>