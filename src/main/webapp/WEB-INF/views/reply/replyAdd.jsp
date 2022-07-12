<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ include file="../include/includeFile.jsp" %>   
<%@ include file="../include/sessionCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 추가</title>
</head>
<body>
<div class="container">
	<%@ include file="../header.jsp" %>
	<div class = "wrapper">
	<h2>방명록 추가</h2>
	<form action="${path}/reply/replyAdd" method="post">
		<table class="table table-condensed">	
			<tr>
				<th>펜션 번호</th>
				<td> <input type="number" name="pnum" value="${param.pnum}" readonly> </td>
			</tr>
			<tr>
				<th>작성자</th>
				<td> <input type="text" name="memail" value="${sessionScope.memail}" readonly> </td>
			</tr>
			<tr>
				<th>제목</th>
				<td> <input type="text" name="rsubject"> </td>
			</tr>
			<tr>
				<th>내용</th>
				<td> <textarea name="rcontent" rows="10" cols="50"></textarea> </td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button class="btn btn-primary">저장</button>
					<button type="reset" onclick="location.href='${path}/reply/replyList?pnum=${param.pnum}'" class="btn btn-warning">취소</button>
				</td>
			</tr>
		</table>
	</form>
	</div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>