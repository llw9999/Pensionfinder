package com.mycompany.myapp.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.mycompany.myapp.advice.ErrorCode;
import com.mycompany.myapp.dto.JoinMember;

public interface JoinMemberService {
	
	ErrorCode insert(JoinMember joinmember, HttpSession session, String path) throws Exception;
	
	ErrorCode update(JoinMember joinmember, String npasswd) throws Exception;
		
	ErrorCode delete(String memail);
	
	void update_emailauth(String memail);
	
	JoinMember selectOne(String memail);
	
}
