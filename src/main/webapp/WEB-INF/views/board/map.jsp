<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<title>찾아오시는길</title>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=ckoeuzl93b"></script>
	<script>
		$(function () { 
			const pnum = $('#pnum').val();
			
			if(pnum == 1){
			//map id에 맵생성
			var map = new naver.maps.Map('map', {
			    center: new naver.maps.LatLng(37.78154583397379, 127.36845920014854),//경도,위도 
			    zoom: 17
			});
			//마커생성
			var marker = new naver.maps.Marker({
			    position: new naver.maps.LatLng(37.78154583397379, 127.36845920014854),
			    map: map
			});
		}else {
			var map = new naver.maps.Map('map', {
			    center: new naver.maps.LatLng(37.8353319107295, 127.49950712651592),//경도,위도 
			    zoom: 17
			});
			//마커생성
			var marker = new naver.maps.Marker({
			    position: new naver.maps.LatLng(37.8353319107295, 127.49950712651592),
			    map: map
			});
		}
		
		});
			
	</script>  
</head>
<body>
<div class="container">
	<%@ include file="../header.jsp" %>
	<div class = "wrapper">
	<input type="hidden" name="pnum" value="${param.pnum}" id="pnum">
	<div id="map" style="width:100%;height:400px;"></div>
	<table>
		<tr>
			<td colspan="2" align="center">
				<button type="button" onclick="location.href='${path}/board/detail?pnum=${param.pnum}'" class="btn btn-primary">확인</button>
			</td>
		</tr>
	</table>
	</div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>