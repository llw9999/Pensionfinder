<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>    
<%@ include file="../include/sessionCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/javascript" src="${path}/resources/js/replyListDetail.js"></script>
<script type="text/x-handlebars-template" id="template_source"></script>
</head>
<body>
<div class="container">
	<%@ include file="../header.jsp" %>
	<div class = "wrapper">
	<h2>방명록 상세 보기</h2>
	<table class="table table-striped">
		<tr>
			<th>펜션 번호</th>
			<td id="pnum">${rList.pnum}</td>
		</tr>
		<tr>
			<th>댓글 번호</th>
			<td id="rnum">${rList.rnum}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td id="memail">${rList.memail}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td id="rsubject">${rList.rsubject}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td id="rcontent">${rList.rcontent}</td>
		</tr>
		<tr>
			<th><i class="fas fa-thumbs-up" id="helpcnt"></i>좋아요</th>
			<td id="help">${rList.help}</td>
		</tr>
		<tr>
			<th><i class="fas fa-thumbs-down" id="uselesscnt"></i>싫어요</th>
			<td id="useless">${rList.useless}</td>
		</tr>
		<tr>
		<th>등록일자</th>
			<td><fmt:formatDate value="${rList.regidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
		</tr>
		<tr>
			<th>수정일자</th>
			<td><fmt:formatDate value="${rList.modidate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<c:if test="${sessionScope.memail eq rList.memail}">
				<button onclick="location.href='${path}/reply/replyModify?rnum=${rList.rnum}'" class="btn btn-primary">수정</button>
				<button onclick="removeCheck('${path}', ${rList.rnum}, ${rList.pnum})" class="btn btn-warning">삭제</button>
			</c:if>
				<button onclick="location.href='${path}/reply/replyList?pnum=${rList.pnum}'" class="btn">리스트</button>
			</td>
		</tr>
	</table>
	</div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>