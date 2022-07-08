package com.mycompany.myapp.service;

import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.advice.ErrorCode;
import com.mycompany.myapp.dto.JoinPension;
import com.mycompany.myapp.repository.JoinPensionRepository;

@Service
public class JoinPensionServiceImpl implements JoinPensionService {

	@Autowired
	private JoinPensionRepository joinpensionRepository;
	
	//비밀번호 암호화
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//이메일 전송
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public ErrorCode insert(JoinPension joinpension, HttpSession session, String path) throws Exception {
		
		//중복이메일 체크
		JoinPension dbpension = joinpensionRepository.selectOne(joinpension.getPemail());
		if(dbpension !=null) {
			return ErrorCode.ERROR_JOIN_ID_EXIST;
		}
		//비밀번호 암호화
		String cryptPasswd = bCryptPasswordEncoder.encode(joinpension.getPpasswd());
		joinpension.setPpasswd(cryptPasswd);
		
		//저장
		int cnt = joinpensionRepository.insert(joinpension);
				
		//이메일전송
		String authCode = sendAuthMail(joinpension.getPemail(), path);
				
		//성공시 세션 저장
		session.setMaxInactiveInterval(60*60*2);
		session.setAttribute("authCode", authCode);
				
		return ErrorCode.SUCCESS_JOIN;
	}

	//인증번호 랜덤으로 생성
	private String getAuthCode() {
		StringBuffer authCode = new StringBuffer();
		Random random = new Random();
		for(int i=0; i<6; i++)
			authCode.append(random.nextInt(10));
		return authCode.toString();
	}

	private String sendAuthMail(String pemail, String path) throws MessagingException{
		
		String authCode = getAuthCode();
		StringBuffer content = new StringBuffer();
		content.append(pemail + "님 반갑습니다. 아래 링크를 클릭해 주세요<br>");
		content.append("<a href='http://localhost:8081"+path+"/joinpension/emailConfirm?authCode="+authCode+"&pemail="+pemail+"'>이메일인증확인</a>");
		
		MimeMessage message = mailSender.createMimeMessage();
		
		message.setSubject("회원가입 이메일 인증", "utf-8");
		message.setText(content.toString(), "utf-8", "html");
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(pemail));
		
		//메일보내기
		mailSender.send(message);
		
		return authCode;
	}

	@Override
	public void update_emailauth(String pemail) {
		int cnt = joinpensionRepository.update_emailauth(pemail);
		
	}

	@Override
	public JoinPension selectOne(String pemail) {
		return joinpensionRepository.selectOne(pemail);
	}

}
