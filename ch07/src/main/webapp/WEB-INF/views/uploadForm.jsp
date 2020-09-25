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
		<!-- <form action="upload.do" method="post" enctype="multipart/form-data"> -->
		<form action="upload2.do" method="post" enctype="multipart/form-data">
			<table class="table table-bordered">
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="id" required="required" autofocus="autofocus">
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="name" required="required">
					</td>
				</tr>
				<tr>
					<td>
						파일
						<span class="glyphicon glyphicon-folder-open"></span>
					</td>
					<td>
						<input type="file" name="file" required="required">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>