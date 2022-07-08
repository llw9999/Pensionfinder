/**
 *  예약 버튼 클릭
 */
$(function(){
	const pemail = $('#pension').val();
	const sessionEmail = $('#sessionEmail').text().trim();
	if(sessionEmail == pemail){
		$('#preserve').hide();
	}else{
		$('#preserve').show();
	}
});