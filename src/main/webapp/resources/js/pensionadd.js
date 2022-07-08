/**
 *  펜션 리스트 추가 버튼 클릭
 */

$(function(){
	const pemail = $('#pension').val();
	const sessionEmail = $('#sessionEmail').text().trim();
	if(sessionEmail == pemail){
		$('#pAdd').show();
	}else{
		$('#pAdd').hide();
	}
});