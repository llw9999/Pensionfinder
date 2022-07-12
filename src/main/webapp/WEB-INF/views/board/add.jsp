<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>    
<%@ include file="../include/sessionCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펜션 등록</title>
<script type="text/javascript" src="${path}/resources/js/fileAdd.js"></script>
</head>
<body>
<div class="container">
	<%@ include file="../header.jsp" %>
	<div class = "wrapper">
		<h2>펜션 등록</h2>
		<form action="${path}/board/add" method="post" enctype="multipart/form-data">
			<table class="table table-condensed">
				<tr>
					<th>이메일</th>
					<td> <input type="email" name="pemail" value="${sessionScope.pemail}" readonly> </td>
				</tr>
				<tr>
					<th>펜션 이름</th>
					<td> <input type="text" name="subject"> </td>
				</tr>
				<tr>
					<th>펜션 전화번호</th>
					<td> <input type="text" name="pphone"> </td>
				</tr>
				<tr>
					<th>지역</th>
					<td> <input type="text" name="region"> </td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td><input type="text" name="zipcode" size="5" value="${joinpension.zipcode}" readonly></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="addrload" size="35" value="${joinpension.addrload}" readonly> </td>
				</tr>
				<tr>
					<th>상세주소</th>
					<td> <input type="text" name="addrdetail" size="35" value="${joinpension.addrdetail}" readonly> </td>
				</tr>
				<tr>
					<th>펜션 소개</th>
					<td> <textarea name="pcontent" rows="10" cols="50"></textarea> </td>
				</tr>
				<tr>
					<th>옵션</th>
					<td> <textarea name="poption" rows="10" cols="50"></textarea> </td>
				</tr>
				<tr>
					<th>비용</th>
					<td> <input type="number" name="pprice"> </td>
				</tr>
				<tr>
					<th>펜션 사진 <br><button onclick="fileAdd(event)">+</button></th>
					<td>
						<div id="divFiles">
							<input type="file" name="files"> <br>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button class="btn btn-primary">저장</button>
						<button type="reset" onclick="location.href='${path}/board/list'" class="btn btn-warning">취소</button>
					</td>
				</tr>
				
			</table>
		</form>
	</div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>