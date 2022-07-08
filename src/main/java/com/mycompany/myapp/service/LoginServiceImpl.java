package com.mycompany.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.advice.ErrorCode;
import com.mycompany.myapp.dto.JoinMember;
import com.mycompany.myapp.dto.JoinPension;
import com.mycompany.myapp.repository.JoinMemberRepository;
import com.mycompany.myapp.repository.JoinPensionRepository;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private JoinMemberRepository joinmemberRepository;
	
	@Autowired
	private JoinPensionRepository joinpensionrepository;
	
	//암호화 
	@Autowired
		private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public ErrorCode mloginCheck(String memail, String mpasswd) {
		//한건조회
		JoinMember joinmember = joinmemberRepository.selectOne(memail);
		
		//이메일 없을 경우
		if(joinmember == null) {
			return ErrorCode.ERROR_LOGIN_EMAIL;
		}
		//비밀번호
		//평문, 암호문 비교
		boolean match = bCryptPasswordEncoder.matches(mpasswd, joinmember.getMpasswd());
		if(!match) {
			return ErrorCode.ERROR_LOGIN_PASSWD;
		}
		//이메일 인증
		if(!joinmember.getMemailauth().equals("1")) {
			return ErrorCode.ERROR_LOGIN_EMAILAUTH;
		}
		//성공
		
		return ErrorCode.SUCCESS_LOGIN;
	}

	@Override
	public ErrorCode ploginCheck(String pemail, String ppasswd) {
		//한건조회
				JoinPension joinpension = joinpensionrepository.selectOne(pemail);
				
				//이메일 없을 경우
				if(joinpension == null) {
					return ErrorCode.ERROR_LOGIN_EMAIL;
				}
				//비밀번호
				//평문, 암호문 비교
				boolean match = bCryptPasswordEncoder.matches(ppasswd, joinpension.getPpasswd());
				if(!match) {
					return ErrorCode.ERROR_LOGIN_PASSWD;
				}
				//이메일 인증
				if(!joinpension.getPemailauth().equals("1")) {
					return ErrorCode.ERROR_LOGIN_EMAILAUTH;
				}
				//성공
				
				return ErrorCode.SUCCESS_LOGIN;
	}

}
