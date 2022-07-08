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
	<h2>방명록 수정</h2>
	<form action="${path}/reply/replyModify" method="post">
		<table class="table table-condensed">
			<tr>
				<th>게시물 번호</th>
				<td> <input type="text" name="pnum" readonly="readonly" value="${rList.pnum}"> </td>
			</tr>
			<tr>
				<th>댓글 번호</th>
				<td> <input type="text" name="rnum" readonly="readonly" value="${rList.rnum}"> </td>
			</tr>
			<tr>
				<th>작성자</th>
				<td> <input type="text" name="memail" readonly="readonly" value="${rList.memail}" > </td>
			</tr>
			<tr>
				<th>제목</th>
				<td> <input type="text" name="rsubject" value="${rList.rsubject}"> </td>
			</tr>
			<tr>
				<th>내용</th>
				<td> <textarea name="rcontent" rows="10" cols="50">${rList.rcontent}</textarea> </td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button class="btn btn-primary">수정 완료</button>
					<button type="reset" onclick="location.href='${path}/reply/replyDetail?rnum=${param.rnum}'" class="btn btn-warning">취소</button>
				</td>
			</tr>
		</table>
	</form>
	</div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>