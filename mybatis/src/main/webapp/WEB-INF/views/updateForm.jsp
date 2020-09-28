<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function chk() {
		if (frm.password.value != frm.password2.value) {
			alert("암호와 암호 확인이 다릅니다");
			frm.password.focus();
			frm.password.value = "";
			return false;
		}
	}
</script></head><body><div class="container">
<form action="update.html" method="post" enctype="multipart/form-data"
	name="frm" onsubmit="return chk()">
	<input type="hidden" name="id" value="${member.id}">
<table class="table table-bordered">
	<caption class="text-primary">회원정보 수정</caption>
	<tr><td>아이디 <span class="glyphicon glyphicon-user"></span></td>
		<td>${member.id}</td></tr>
	<tr><td>암호 <span class="glyphicon glyphicon-lock"></span></td>
		<td><input type="password" name="password" 
			required="required" autofocus="autofocus"></td></tr>
	<tr><td>암호 확인<span class="glyphicon glyphicon-lock"></span></td>
		<td><input type="password" name="password2" 
			required="required"></td></tr>
	<tr><td>이름</td><td><input type="text" name="name" 
			required="required" value="${member.name}"></td></tr>
	<tr><td>이메일 <span class="glyphicon glyphicon-envelope"></span></td>
		<td><input type="email" name="email" required="required"
			value="${member.email}"></td></tr>
	<tr><td>사진 <span class="glyphicon glyphicon-picture"></span></td>
		<td><input type="file" name="file"></td></tr>
	<tr><td colspan="2"><img width="200" src="${path}/upload/${member.fileName}">
		</td></tr>
	<tr><th colspan="2"><input type="submit"></th></tr>
</table></form>
</div>
</body>
</html>