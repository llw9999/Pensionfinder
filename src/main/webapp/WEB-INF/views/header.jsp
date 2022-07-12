<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더</title>
<script type="text/javascript" src="${path}/resources/js/header.js"></script>
</head>
<body>
	<header>
		<div>
		  <h1>펜션파인더</h1>
		</div>
	</header>
	<hr>
	<nav>
		<a href="${path}" class="btn btn-link" role="button">홈</a>
		<a href="${path}/board/" class="btn btn-link" role="button">펜션 목록</a>
		<!-- 컨택스트패스 -->
		<input type="hidden" value="${path}" id="contextpath"> 
		<input type="hidden" value="${sessionScope.pemail}" id="pension"> 
		<input type="hidden" value="${sessionScope.memail}" id="member">
		
		<span id="sessionEmail">
			<c:choose>
				<c:when test="${sessionScope.usertype eq 'user'}">
					<a href="${path}/joinmember/info" class="btn btn-link" role="button"> ${sessionScope.memail} </a>
				</c:when>
				<c:when test="${sessionScope.usertype eq 'pension'}">
					<a href="${path}/joinpension/info" class="btn btn-link" role="button"> ${sessionScope.pemail} </a>
				</c:when>
			</c:choose>
		</span>
		<a href="${path}/login" id="aLogin" class="btn btn-link" role="button">로그인</a>
		<a href="" id="aLogout" class="btn btn-link" role="button">로그아웃</a>
		<a href="${path}/joinselect" id ="aJoin" class="btn btn-link" role="button">회원가입</a>
	</nav>
	<hr>
	
</body>
</html>