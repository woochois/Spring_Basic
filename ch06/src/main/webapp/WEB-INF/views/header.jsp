
<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- Spring tag -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Responsive Web -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap, JQuery -->
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<link rel="stylesheet" href="${path }/resources/css/bootstrap.min.css">
<script type="text/javascript" src="${path }/resources/js/jquery.js"></script>
<script type="text/javascript" src="${path }/resources/js/bootstrap.min.js"></script>

<!-- CSS -->
<style>
	caption 
	{
		font-size: 30px;
		caption-side: top;
	}
	.err 
	{
		color:red; font-weight: bold; 
	}
</style>

