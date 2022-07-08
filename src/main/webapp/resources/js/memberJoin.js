//회원가입 js

// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
function goPopup(path){
	//컨트롤러에 jusoPopup.jsp호출 요청	
	var pop = window.open(path + "/joinpension/jusoPopup","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}

//주소팝업 호출후 실행할 함수
function jusoCallBack(zipNo,roadAddrPart1,addrDetail){
	// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
	document.frmJoinp.zipcode.value = zipNo;
	document.frmJoinp.addrload.value = roadAddrPart1;
	document.frmJoinp.addrdetail.value = addrDetail;
}

function mjoinCheck(e){
	e.preventDefault(); //기본
	const memail = document.getElementById('memail');
	const mpasswd = document.getElementById('mpasswd');
	const mpasswdConfirm = document.getElementById('mpasswdConfirm');
	console.log(memail.value);
	console.log(mpasswd.value);
	console.log(mpasswdConfirm.value);
	if (!memail.value){
		alert('이메일을 입력해주세요!');
		memail.focus();
		return ;
	}
	if (!mpasswd.value){
		alert('비밀번호를 입력해주세요!');
		mpasswd.focus();
		return ;
	}
	if (!mpasswdConfirm.value){
		alert('비밀번호 확인을 입력해주세요!');
		mpasswdConfirm.focus();
		return ;
	}
	if (mpasswd.value !== mpasswdConfirm.value){
		alert('비밀번호가 일치하지 않습니다!');
		mpasswdConfirm.focus();
		return ;
	}
	document.getElementById('frmJoin').submit();

}

function pjoinCheck(e){
	e.preventDefault(); //기본
	const pemail = document.getElementById('pemail');
	const ppasswd = document.getElementById('ppasswd');
	const ppasswdConfirm = document.getElementById('ppasswdConfirm');
	console.log(pemail.value);
	console.log(ppasswd.value);
	console.log(ppasswdConfirm.value);
	if (!pemail.value){
		alert('이메일을 입력해주세요!');
		pemail.focus();
		return ;
	}
	if (!ppasswd.value){
		alert('비밀번호를 입력해주세요!');
		ppasswd.focus();
		return ;
	}
	if (!ppasswdConfirm.value){
		alert('비밀번호 확인을 입력해주세요!');
		ppasswdConfirm.focus();
		return ;
	}
	if (ppasswd.value !== ppasswdConfirm.value){
		alert('비밀번호가 일치하지 않습니다!');
		ppasswdConfirm.focus();
		return ;
	}
	document.getElementById('frmJoinp').submit();

}