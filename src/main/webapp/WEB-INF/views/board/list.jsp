<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %> 
<%@ include file="../include/sessionCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펜션 목록</title>
<script type="text/javascript" src="${path}/resources/js/pensionadd.js"></script>
</head>
<body>
<div class="container">
	<%@ include file="../header.jsp" %>
	<div class = "wrapper">
		<h2>펜션 목록</h2>
		<form action="${path}/board/list">
			<select name="findkey">
				<option value="pemail" <c:out value="${page.findkey=='pemail'?'selected':''}"/>>이메일</option>
				<option value="region" <c:out value="${page.findkey=='region'?'selected':''}"/>>지역</option>
				<option value="subject" <c:out value="${page.findkey=='subject'?'selected':''}"/>>펜션 이름</option>
			</select>
			<input type="text" name="findvalue" value="${page.findvalue}">
			<button class="btn">조회</button>
			<button type="button" onclick="location.href='${path}/board/add'" id="pAdd" class="btn btn-primary">펜션 등록</button>
		</form>
		
		<table class="table table-condensed">
			<tr>
				<th>번호</th>
				<th>이메일</th>
				<th>펜션 이름</th>
				<th>지역</th>
				<th>가격</th>
				<th>옵션</th>						
			</tr>
			<c:forEach var="pList" items="${plist}">
				<tr>
					<td>${pList.pnum}</td>
					<td>${pList.pemail}</td>
					<td><a href="${path}/board/detail?pnum=${pList.pnum}">${pList.subject}</a></td>
					<td>${pList.region}</td>
					<td>${pList.pprice}</td>
					<td>${pList.poption}</td>				
				</tr>
			</c:forEach>
		</table>
		<hr>
		<div>
			<c:if test="${page.startPage != 1}">
				<a href="${path}/board/list?curPage=${page.startPage-1}">이전</a>
			</c:if>
			
			<c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
				<a href="${path}/board/list?curPage=${i}">${i}</a> 
			</c:forEach>
		
			<c:if test="${page.endPage<page.totPage}">
				<a href="${path}/board/list?curPage=${page.endPage+1}">다음</a>
			</c:if>
		</div>
		<hr>
	</div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>