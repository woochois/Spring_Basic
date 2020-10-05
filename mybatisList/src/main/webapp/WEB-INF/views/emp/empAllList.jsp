<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" align="center">
		<h2 class="text-primary">전 직원 목록</h2>
		<table class="table table-hover table-striped">
			<tr>
				<td>사번</td>
				<td>이름</td>
				<td>업무</td>
				<td>입사일</td>
				<td>부서명</td>
				<td>근무지</td>
			</tr>
			<c:forEach var="emp" items="${empList }">
				<tr>
					<td>${emp.empno }</td>
					<td>${emp.ename }</td>
					<td>${emp.job }</td>
					<td>${emp.hiredate }</td>
					<td>${emp.dept.dname }</td>
					<td>${emp.dept.loc }</td>
				</tr>
			</c:forEach>
		</table>
		<a href="deptList.html" class="btn btn-info">부서 목록</a>
	</div>
</body>
</html>