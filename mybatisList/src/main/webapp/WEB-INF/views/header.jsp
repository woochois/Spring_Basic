<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style> 
	caption { font-size: 30px; }
	.err { color: red; font-weight: bold; }	
</style>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<link href="${path}/resources/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${path}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${path}/resources/js/bootstrap.min.js"></script>