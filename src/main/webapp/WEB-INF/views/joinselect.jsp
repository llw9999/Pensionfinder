<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<%@ include file="./header.jsp" %>
	<div class = "wrapper">
	<h2>회원 가입</h2>
	<form id="frmjoinselect" action="${path}/joinselect" method="post">
		<table>
			<tr>
				<td>
					<button type="button" onclick="location.href='./joinmember/join'" class="btn-default">일반회원</button>
					<button type="button" onclick="location.href='./joinpension/join'" class="btn-default">펜션사업자</button>
				</td>
			</tr>
		</table>
	</form>	
	</div>
</div>
<%@include file="footer.jsp" %>	
</body>
</html>