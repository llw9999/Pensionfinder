<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>    
<%@ include file="../include/sessionCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<%@ include file="../header.jsp" %>
		<div class = "wrapper">
		<h2>회원정보</h2>
		
		<table class="table table-striped">
			<tr>
				<th>이메일</th>
				<td>${joinpension.pemail}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${joinpension.pname}</td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td>${joinpension.zipcode}</td>
			</tr>
			<tr>
				<th>도로명주소</th>
				<td>${joinpension.addrload}</td>
			</tr>
			<tr>
				<th>상세주소</th>
				<td>${joinpension.addrdetail}</td>
			</tr>
		</table>
	</div>
 </div>
 <%@include file="../footer.jsp" %>
</body>
</html>