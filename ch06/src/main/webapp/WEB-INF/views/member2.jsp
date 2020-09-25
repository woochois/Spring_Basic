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
	<h2 class="text-primary">회원정보</h2>
	<table class="table table-stripde">
		<tr>
			<td>이름</td>
			<td>${member.name }</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${member.tel }</td>
		</tr>
		<tr>
			<td>나이</td>
			<td>${member.age }</td>
		</tr>
	</table>
</div>
</body>
</html>