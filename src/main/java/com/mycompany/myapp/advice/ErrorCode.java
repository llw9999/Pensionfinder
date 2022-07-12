package com.mycompany.myapp.advice;

//열거형
//코드와 메시지 관리
public enum ErrorCode {
	SUCCESS_ADD(0, "추가 성공"),
	SUCCESS_MODIFY(0, "수정 성공"),
	SUCCESS_REMOVE(0, "삭제 성공"),
	ERROR_LOGIN_EMAIL(1, "등록된 이메일이 없습니다."),
	ERROR_LOGIN_PASSWD(2, "비밀번호 불일치."),
	ERROR_LOGIN_EMAILAUTH(3, "이메일 미인증"),
	SUCCESS_LOGIN(0, "환영합니다."),
	ERROR_JOIN_ID_EXIST(1,"이미 등록된 아이디" ),
	SUCCESS_JOIN(0,"이메일 인증 진행해 주세요" ),
	SUCCESS_EMAILAUTH(0,"이메일 인증이 완료 되었습니다." ),
	ERROR_EMAILAUTH(1,"인증코드가 일치 하지 않습니다." ),
	SUCCESS_RESERVE(0, "예약이 완료되었습니다."),
	SUCCESS_REMOVE_RESERVE(0, "예약이 취소되었습니다."),
	ERROR_RESERVE(1,"이미 예약된 날짜입니다."),
	SUCCESS_REMOVE_MEMBER(0, "탈퇴가 완료되었습니다.");

	
	private int code;
	private String msg;
	//생성자
	private ErrorCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	//게터
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
}
