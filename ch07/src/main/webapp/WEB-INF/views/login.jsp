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
	<c:if test="${result > 0 }">
		<script type="text/javascript">
			alert("로그인 성공");
		</script>
		<a class="btn btn-info" href="uploadForm.do">업로드</a><br>
		<a class="btn btn-danger" href="logout.do">로그아웃</a><br>
	</c:if>
	<c:if test="${result == 0 }">
		<script type="text/javascript">
			alert("로그인 실패");
			history.go(-1);
		</script>
	</c:if>
</body>
</html>