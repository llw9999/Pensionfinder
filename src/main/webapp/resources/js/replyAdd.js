/**
 *  댓글 리스트 추가 버튼 클릭
 */

$(function(){
	const memail = $('#member').val();
	const sessionEmail = $('#sessionEmail').text().trim();
	if(sessionEmail == memail){
		$('#mAdd').show();
	}else{
		$('#mAdd').hide();
	}
});
