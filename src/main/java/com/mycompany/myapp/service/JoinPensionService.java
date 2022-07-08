package com.mycompany.myapp.service;

import javax.servlet.http.HttpSession;

import com.mycompany.myapp.advice.ErrorCode;
import com.mycompany.myapp.dto.JoinPension;

public interface JoinPensionService {

	ErrorCode insert(JoinPension joinpension, HttpSession session, String path) throws Exception;
	
	void update_emailauth(String pemail);
	
	JoinPension selectOne(String pemail);

}
