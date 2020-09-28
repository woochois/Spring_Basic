<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title></head><body>
<div class="container">
<table class="table table-striped table-bordered">
	<caption>회원정보 상세</caption>
	<tr><td>아이디</td><td>${member.id}</td></tr>
	<tr><td>이름</td><td>${member.name}</td></tr>
	<tr><td>이메일</td><td>${member.email}</td></tr>
	<tr><td>등록일</td><td>${member.regdate}</td></tr>
	<tr><td colspan="2">사진</td></tr>
	<tr><td colspan="2">
<c:forEach var="ph" items="${list }">
	<img alt="" src="${path}/upload/${ph.fileName }" 
			width="200">
</c:forEach>		
</table>
<a href="main.html" class="btn btn-default">메인</a>
</div>
</body>
</html>