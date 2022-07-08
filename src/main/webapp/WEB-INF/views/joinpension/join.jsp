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
		<form name="frmJoinp" id="frmJoinp" action="${path}/joinpension/join" method="post" >
			<table class="table table-condensed">
				<tr>
					<th>이메일</th>
					<td><input type="email" name="pemail" id="pemail" value="${joinpension.pemail}"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="pname" value="${joinpension.pname}"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="ppasswd" id="ppasswd"></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" id="ppasswdConfirm"></td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td>
						<input type="text" name="zipcode" size="5" value="${joinpension.zipcode}">
						<button type="button" onclick="goPopup('${path}')" class="btn">조회</button> 
					</td>
				</tr>
				<tr>
					<th>도로명주소</th>
					<td><input type="text" name="addrload" size="35" value="${joinpension.addrload}"> </td>
				</tr>
				<tr>
					<th>상세주소</th>
					<td><input type="text" name="addrdetail" size="35" value="${joinpension.addrdetail}"> </td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button onclick="pjoinCheck(event)" class="btn btn-primary">가입</button>
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