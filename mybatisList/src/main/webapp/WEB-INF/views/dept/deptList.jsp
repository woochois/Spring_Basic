<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" align="center">
		<h2>부서 목록</h2>
		<table class="table table-striped">
			<tr>
				<td>부서 코드</td>
				<td>부서명</td>
				<td>근무지</td>
				<td>수정</td>
				<td>삭제</td>
			</tr>
			<c:if test="${empty deptList }">
				<tr>
					<td colspan="5">데이터가 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty deptList }">
				<c:forEach var="dept" items="${deptList }">
					<tr>
						<td>${dept.deptno }</td>
						<td>${dept.dname }</td>
						<td>${dept.loc }</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<a class="btn btn-info">부서 정보 입력</a>
		<a class="btn btn-default">전 직원 목록</a>
	</div>
</body>
</html>