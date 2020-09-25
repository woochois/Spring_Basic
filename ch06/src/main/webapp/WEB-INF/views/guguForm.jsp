<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="gugu2">
		<table>
			<caption>구구단 번호 선택</caption>
			<tr>
				<td>
					<select name="num">
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>
					<input type="submit" value="확인">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>