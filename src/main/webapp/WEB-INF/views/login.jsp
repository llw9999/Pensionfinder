<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/login.js"></script>
</head>
<body>
<div class="container">
	<%@ include file="header.jsp" %>
	<div class="wrapper">
		<h2>로그인</h2>
		<form id="frmLogin" action="${path}/login" method="post">
			<input type="radio" name="usertype" id="user" value="user" checked>
			<label for="user">일반 사용자</label>
			<input type="radio" name="usertype" id="pension" value="pension">
			<label for="pension">펜션 사업자</label>
			<table class="table table-condensed">
				<tr>
					<th>이메일</th>
					<td><input type="email" name="memail" id="memail"> </td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="mpasswd" id="mpasswd"> </td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="button" id="btnLogin" class="btn btn-primary">로그인</button>
						<button type="reset" class="btn">취소</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>