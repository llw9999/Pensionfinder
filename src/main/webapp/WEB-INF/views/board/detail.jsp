<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>    
<%@ include file="../include/sessionCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펜션 소개</title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/javascript" src="${path}/resources/js/pensionListDetail.js"></script>
<script type="text/javascript" src="${path}/resources/js/home.js"></script>
<script type="text/javascript" src="${path}/resources/js/reserve.js"></script>
<script type="text/x-handlebars-template" id="template_source"></script>
</head>
<body>
<div class="container">
		<%@ include file="../header.jsp" %>
		<div class = "wrapper">
		<h2>펜션 소개</h2>
			<div class="bxslider">	
				<c:forEach var="pensionFile" items="${pflist}">
					<div><img src="${path}/savedir/${pensionFile.filename}"></div>
				</c:forEach>
			</div>
			<hr>
			<input type="hidden" value="${param.pnum}" id="pnum">
			<table class="table table-striped">
				<tr>
					<th>주소</th>
					<td>${pList.addrload}</td>
				</tr>
				<tr>
					<th>상세주소</th>
					<td>${pList.addrdetail}</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>${pList.pphone}</td>
				</tr>
				<tr>
					<th>비용</th>
					<td>${pList.pprice}</td>
				</tr>
				<tr>
					<th>옵션</th>
					<td>${pList.poption}</td>
				</tr>
				<tr>
					<th>펜션 소개글</th>
					<td>${pList.pcontent}</td>
				</tr>
			</table>		
			<hr>	
			<table >
				<!-- 좋아요 -->
			<tr>
				<th><i class="fas fa-thumbs-up" id="likescnt"></i>좋아요 &ensp;</th>
				<td id="likes">${pList.likes}</td> 
				<th><i class="fas fa-thumbs-down" id="dislikescnt"></i>싫어요 &ensp;</th>
				<td id="dislikes">${pList.dislikes}</td>
			</tr>
			</table>
			
			<table>
				<tr>
					<td colspan="2">
						<c:if test="${sessionScope.pemail eq pList.pemail}">
							<button onclick="location.href='${path}/board/modify?pnum=${pList.pnum}'" class="btn btn-primary">수정</button>
							<button onclick="removeCheck('${path}','${pList.pnum}')" class="btn btn-warning" id="btnRemove">삭제</button>
							<button onclick="location.href='${path}/reserve/reservelist?pnum=${pList.pnum}'" id="listcheck" class="btn btn-success">예약현황</button>
						</c:if>
						<button onclick="location.href='${path}/reserve/reserve?pnum=${pList.pnum}'" id="preserve" class="btn btn-success">예약하기</button>
						<button onclick="location.href='${path}/reply/?pnum=${pList.pnum}'" class="btn btn-info">방명록</button>
						<button onclick="location.href='${path}/board/map?pnum=${pList.pnum}'" class="btn btn-info">찾아오시는길</button>
						<button onclick="location.href='${path}/board/list'" class="btn">리스트</button>
					</td>
				</tr>
			</table>
			<hr>
		</div>
	</div>
	<%@include file="../footer.jsp" %>
</body>
</html>