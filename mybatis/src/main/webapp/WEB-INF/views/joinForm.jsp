<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function idChk() {
		if (!frm.id.value) { alert("아이디 입력하고 중복체크하시오");
			frm.id.focus(); return false;			
		}
		$.post('idChk.html','id='+frm.id.value, function(data) {
			// alert(data);
			$('#disp').html(data);
		});
	}
	function chk() {
		if (frm.password.value != frm.password2.value) {
			alert("암호와 암호 확인이 다릅니다");
			frm.password.focus(); frm.password.value="";
			return false;
		}
	}
</script></head><body>
<div class="container" align="center">
<form action="join.html" method="post" name="frm" 
	onsubmit="return chk()" enctype="multipart/form-data">
<table class="table table-bordered">
	<caption class="text-primary">회원 가입</caption>
	<tr><td>아이디 <span class="glyphicon glyphicon-user"></span></td>
		<td><input type="text" name="id" required="required" 
		autofocus="autofocus"><input type="button" onclick="idChk()"
		class="btn btn-info btn-sm" value="중복체크"><span id="disp" class="err"></span></td></tr>
	<tr><td>암호 <span class="glyphicon glyphicon-lock"></span></td>
		<td><input type="password" name="password" 
			required="required"></td></tr>
	<tr><td>암호 확인<span class="glyphicon glyphicon-lock"></span></td>
		<td><input type="password" name="password2" 
			required="required"></td></tr>
	<tr><td>이름</td><td><input type="text" name="name" 
			required="required"></td></tr>
	<tr><td>이메일 <span class="glyphicon glyphicon-envelope"></span></td>
		<td><input type="email" name="email" required="required"></td></tr>
	<tr><td>사진 <span class="glyphicon glyphicon-picture"></span></td>
		<td><input type="file" name="file" required="required"></td></tr>
	<tr><th colspan="2"><input type="submit"></th></tr>
</table></form>
<a href="loginForm.html" class="btn btn-default">로그인</a>
</div>
</body>
</html>