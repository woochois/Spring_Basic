<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title></head><body>
<c:if test="${result > 0 }">
	<script type="text/javascript">
		alert("탈퇴했으니 꺼져");
		location.href="loginForm.html";
	</script>	
</c:if>
<c:if test="${result == 0 }">
	<script type="text/javascript">
		alert("탈퇴 실패 !! 평생 노예해야지");
		history.go(-1);
	</script>	
</c:if>
</body>
</html>