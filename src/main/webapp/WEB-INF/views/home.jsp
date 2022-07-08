<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/home.js"></script>
</head>
<body>
<div class="container">
	<%@include file="header.jsp"%>
	<div class = "wrapper">
	<div class="bxslider">
		<div><img src="${path}/resources/images/pension1.jpg"></div>
		<div><img src="${path}/resources/images/pension2.jpeg"></div>
		<div><img src="${path}/resources/images/pension3.jpg"></div>
		<div><img src="${path}/resources/images/pension4.jpg"></div>
		<div><img src="${path}/resources/images/pension5.jpg"></div>
	</div>
	</div>
</div>
	<%@include file="footer.jsp" %>
</body>
</html>