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
	<h2>예약 현황</h2>
	<table class="table table-striped">
		<tr>
			<th>펜션번호</th>
			<th>예약번호</th>
			<th>작성자</th>
			<th>입실</th>
			<th>퇴실</th>
		</tr>
		<c:forEach var="reserve" items="${reserve}">
			<tr>
				<td>${reserve.pnum}</td>
				<td>${reserve.rnum}</td>
				<td>${reserve.memail}</td>
				<td>${reserve.startdate}</td>
				<td>${reserve.enddate}</td>
			</tr>
		</c:forEach>			
	</table>
	<table>
		<tr>
			<td colspan="2" align="center">
				<button onclick="location.href='${path}/board/detail?pnum=${param.pnum}'" class="btn btn-primary">확인</button>
			</td>
		</tr>
	</table>
	</div>
</div>
	<%@include file="../footer.jsp" %>	
</body>
</html>