<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %> 
<%@ include file="../include/sessionCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/replyAdd.js"></script>
</head>
<body>
<div class="container">
	<%@ include file="../header.jsp" %>
	<div class = "wrapper">
	<h2> 방명록 </h2>
		<form action="${path}/reply/">
			<select name="findkey">
				<option value="memail" <c:out value="${page.findkey='memail'?'selected':''}" />>이메일</option>
				<option value="rsubject" <c:out value="${page.findkey='rsubject'?'selected':''}" />>제목</option>
				<option value="rcontent" <c:out value="${page.findkey='rcontent'?'selected':''}" />>내용</option>
				<option value="rsubcon" <c:out value="${page.findkey='rsubcon'?'selected':''}" />>제목+내용</option>
			</select>
			<input type="text" name="findvalue" value="${page.findvalue}">
			<button>조회</button>
		</form>
		<table class="table table-condensed">
			<tr>
				<th>게시물 번호</th>
				<th>댓글 번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>등록일자</th>
				<th>수정일자</th>
			</tr>
			<c:forEach var="rList" items="${rlist}">
				<tr>
					<td>${rList.pnum}</td>
					<td>${rList.rnum}</td>
					<td>${rList.memail}</td>
					<td><a href="${path}/reply/replyDetail?rnum=${rList.rnum}">${rList.rsubject}</a></td>
					<td><fmt:formatDate value="${rList.regidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					<td><fmt:formatDate value="${rList.modidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
				</tr>
			</c:forEach>
		</table>
		<hr>
		<c:if test="${page.startPage != 1}">
			<a href="${path}/reply/replyList?curPage=${page.startPage-1}">이전</a>
		</c:if>
		
		<c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
			<a href="${path}/reply/replyList?curPage=${i}">${i}</a> 
		</c:forEach>
	
		<c:if test="${page.endPage<page.totPage}">
			<a href="${path}/reply/replyList?curPage=${page.endPage+1}">다음</a>
		</c:if>
		<hr>
		<div>
			<a href="${path}/reply/replyAdd?pnum=${param.pnum}" id="mAdd" class="btn btn-primary" >댓글 추가</a>
		</div>
	</div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>