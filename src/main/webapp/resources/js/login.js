$(function(){
	//로그인 버튼 클릭
	$('#btnLogin').click(e=>{
		e.preventDefault();
		const memail = $('#memail');
		const mpasswd = $('#mpasswd');
		if(memail.val()==""){
			memail.focus();
			alert('이메일을 입력해 주세요!');
			return;
		}
		
		if(mpasswd.val()==""){
			mpasswd.focus();
			alert('비밀번호를 입력해 주세요!');
			return;
		}
		
		$('#frmLogin').submit();
	});
});