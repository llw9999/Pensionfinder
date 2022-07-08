<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/memberJoin.js"></script>
</head>
<body>
<div class="container">
	<%@ include file="../header.jsp" %>
		<div class = "wrapper">
		<h2>회원 가입</h2>
		<form name="frmJoin" id="frmJoin" action="${path}/joinmember/join" method="post" >
			<table class="table table-condensed">
				<tr>
					<th>이메일</th>
					<td><input type="email" name="memail" id="memail" value="${joinmember.memail}"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="mname" value="${joinmember.mname}"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="mpasswd" id="mpasswd"></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" id="mpasswdConfirm"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button onclick="mjoinCheck(event)" class="btn btn-primary">가입</button>
						<button type="reset" onclick="location.href='${path}/joinselect'" class="btn">취소</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>