<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>    
<%@ include file="../include/sessionCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/fileAdd.js"></script>
</head>
<body>
<div class="container">
	<%@ include file="../header.jsp" %>
	<div class = "wrapper">
	<h2>펜션 정보 수정</h2>
	<form action="${path}/board/modify" method="post" enctype="multipart/form-data">
		<table class="table table-condensed">
			<tr>
				<th>번호</th>
				<td> <input type="text" name="pnum" readonly="readonly" value="${pList.pnum}" > </td>
			</tr>
			<tr>
				<th>작성자</th>
				<td> <input type="text" name="pemail" readonly="readonly" value="${pList.pemail}" > </td>
			</tr>
			<tr>
				<th>펜션 이름</th>
				<td> <input type="text" name="subject" value="${pList.subject}"> </td>
			</tr>
			<tr>
				<th>펜션 전화번호</th>
				<td> <input type="text" name="pphone" value="${pList.pphone}"> </td>
			</tr>
			<tr>
				<th>지역</th>
				<td> <input type="text" name="region" value="${pList.region}" readonly> </td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td> <input type="text" name="zipcode" value="${pList.zipcode}" readonly> </td>
			</tr>
			<tr>
				<th>주소</th>
				<td> <input type="text" name="addrload" size="35" value="${pList.addrload}" readonly> </td>
			</tr>
			<tr>
				<th>상세주소</th>
				<td> <input type="text" name="addrdetail" size="35" value="${pList.addrdetail}" readonly> </td>
			</tr>
			<tr>
				<th>펜션 소개</th>
				<td> <textarea  name="pcontent" rows="10" cols="50">${pList.pcontent}</textarea> </td>
			</tr>
			<tr>
				<th>옵션</th>
				<td> <textarea name="poption" rows="10" cols="50">${pList.poption}</textarea> </td>
			</tr>
			<tr>
				<th>비용</th>
				<td> <input type="text" name="pprice" value="${pList.pprice}"> </td>
			</tr>
			<tr>
				<th>펜션 사진<br> <button type="button" onclick="fileAdd(event)">+</button> </th>
				<td>
					<c:forEach var="pensionFile" items="${pflist}">
						${pensionFile.filename} <input type="checkbox" name="removeFiles" value="${pensionFile.pfnum}">
					</c:forEach>
					<hr>
					<div id="divFiles">
						<input type="file" name="files"> <br>
					</div>
				</td>
			</tr>
			
			
			<tr>
				<td colspan="2" align="center">
					<button class="btn btn-primary">수정 완료</button>
					<button type="reset" onclick="location.href='${path}/board/detail?pnum=${pList.pnum}'" class="btn btn-warning">취소</button>
				</td>
			</tr>
			
		</table>
	</form>
	</div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>