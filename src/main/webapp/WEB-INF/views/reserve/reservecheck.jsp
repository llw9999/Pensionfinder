<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>    
<%@ include file="../include/sessionCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 확인</title>
<script type="text/javascript" src="${path}/resources/js/reservecheck.js"></script>
</head>
<body>
<div class="container">
	<%@ include file="../header.jsp" %>
	<div class = "wrapper">
	<h2>예약 확인</h2>
	<table class="table table-condensed">
		<tr>
			<th>펜션번호</th>
			<th>예약번호</th>
			<th>입실</th>
			<th>퇴실</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="reserve" items="${reservecheck}">
			<tr>
				<td>${reserve.pnum}</td>
				<td>${reserve.rnum}</td>
				<td>${reserve.startdate}</td>
				<td>${reserve.enddate}</td>
				<td><button onclick="removeCheck('${path}', '${reserve.rnum}','${reserve.pnum}')" class="btn">삭제</button></td>
			</tr>
		</c:forEach>
		</table>
		<table>
			<tr>
				<td>
					<button onclick="location.href='${path}/joinmember/info'" class="btn btn-primary">확인</button>
				</td>
			</tr>
		</table>
	</div>
</div>
	<%@include file="../footer.jsp" %>	
</body>
</html>