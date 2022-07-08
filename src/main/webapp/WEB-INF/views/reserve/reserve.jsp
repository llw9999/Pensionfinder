<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>    
<%@ include file="../include/sessionCheck.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script>
  $( function() {
    $( "#startdate" ).datepicker({dateFormat: 'yy-mm-dd', language:'kr', autoclode:true});
    
    $( "#enddate" ).datepicker({dateFormat: 'yy-mm-dd', language:'kr', autoclode:true});

  } );
  
  </script>
</head>
<body>
	<div class="container">
		<%@ include file="../header.jsp" %>
		<div class = "wrapper">
		<h2>예 약</h2>
		<form id="frmreserve" action="${path}/reserve/reserve" method="post">
			<table class="table table-condensed">
				<tr>
					<td><input type="hidden" name="pnum" value="${param.pnum}"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="memail" value="${sessionScope.memail}" readonly></td>
				</tr>
				<tr>
					<th>입실</th>
					<td><input type="text" name="startdate" id="startdate" ></td>
				</tr>
				<tr>
					<th>퇴실</th>
					<td><input type="text" name="enddate" id="enddate" ></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button class="btn btn-primary">예약하기</button>
						<button type="reset" onclick="location.href='${path}/board/detail?pnum=${param.pnum}'" class="btn">취소</button>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<%@include file="../footer.jsp" %>	
</body>
</html>