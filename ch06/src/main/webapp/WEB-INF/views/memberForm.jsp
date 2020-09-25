<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form action="member2">
			<table class="table table-bordered">
				<caption class="text-primary">회원정보</caption>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" required="required"
						autofocus="autofocus"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="tel" name="tel" required="required"
						placeholder="010-1111-1111" pattern="\d{3}-\d{3,4}-\d{4}">
					</td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type="number" name="age" required="required">
					</td>
				</tr>
				<tr>
					<th colspan="2"><input type="submit" name="확인"></th>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>