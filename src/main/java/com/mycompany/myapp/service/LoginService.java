package com.mycompany.myapp.service;

import com.mycompany.myapp.advice.ErrorCode;

public interface LoginService {
	ErrorCode mloginCheck(String memail, String mpasswd);
	ErrorCode ploginCheck(String pemail, String ppasswd);
}
