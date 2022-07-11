package com.mycompany.myapp.service;

import javax.servlet.http.HttpSession;

import com.mycompany.myapp.advice.ErrorCode;
import com.mycompany.myapp.dto.JoinPension;

public interface JoinPensionService {

	ErrorCode insert(JoinPension joinpension, HttpSession session, String path) throws Exception;
	
	ErrorCode update(JoinPension joinpension, String npasswd) throws Exception;
	
	ErrorCode delete(String pemail);
	
	void update_emailauth(String pemail);
	
	JoinPension selectOne(String pemail);

}
