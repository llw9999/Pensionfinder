<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="../include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<script type="text/javascript" src="${path}/resources/js/memberinfo.js"></script>
</head>
<body>
	<div>
		<%@include file="../header.jsp" %>
		<div class="wrapper">
			<h2>회원 정보 수정</h2>
			<form name="frmModify" id="frmModify" action="${path}/joinpension/modify" method="post" enctype="multipart/form-data"> 
				<table class="table table-striped">
					<tr>
						<th>이메일</th>
						<td><input type="email" name="pemail" id="pemail" value="${joinpension.pemail}" readonly></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" name="pname" id="pname" value="${joinpension.pname}" readonly></td>
					</tr>
					<tr>
						<th>기존 비밀번호</th>
						<td><input type="password" name="ppasswd" id="ppasswd"></td>
					</tr>
					<tr>
						<th>신규 비밀번호</th>
						<td><input type="password" name="npasswd" id="npasswd"></td>
					</tr>
					<tr>
						<th>신규 비밀번호 확인</th>
						<td><input type="password" id="npasswdConfirm"></td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td><input type="text" name="zipcode" size="5" value="${joinpension.zipcode}" readonly></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" name="addrload" size="35" value="${joinpension.addrload}" readonly> </td>
					</tr>
					<tr>
						<th>상세주소</th>
						<td> <input type="text" name="addrdetail" size="35" value="${joinpension.addrdetail}" readonly> </td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<button onclick="pmodifyCheck(event)" class="btn btn-primary">수정</button>
							<button type="reset" onclick="location.href='${path}/joinpension/info'" class="btn">취소</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>