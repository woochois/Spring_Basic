<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container" align="center">
	<h2 class="text-primary">사칙 연산 결과</h2>
	<table class="table table=bordered table-hover">
		<tr>
			<td>덧셈</td>
			<td>${plus }</td>
		</tr>
		<tr>
			<td>뺼셈</td>
			<td>${minus }</td>
		</tr>
		<tr>
			<td>곱셈</td>
			<td>${multiply }</td>
		</tr>
		<tr>
			<td>나눗셈</td>
			<td>${divide }</td>
		</tr>
	</table>
</div>
</body>
</html>