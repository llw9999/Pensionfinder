package com.mycompany.myapp.service;

import java.util.Map;
import java.util.Random;

import javax.annotation.processing.Messager;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.myapp.advice.ErrorCode;
import com.mycompany.myapp.dto.JoinMember;
import com.mycompany.myapp.repository.JoinMemberRepository;

@Service
public class JoinMemberServiceImpl implements JoinMemberService{
	private static final Logger logger = LoggerFactory.getLogger(JoinMemberService.class);
	
	@Autowired
	private JoinMemberRepository joinmemberrepository;
	
	//비밀번호 암호화
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//이메일 전송
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	@Transactional
	public ErrorCode insert(JoinMember joinmember, HttpSession session, String path) throws Exception {
		
		//중복이메일 체크
		JoinMember dbmember = joinmemberrepository.selectOne(joinmember.getMemail());
		if(dbmember != null) {
			return ErrorCode.ERROR_JOIN_ID_EXIST;
		}
		//비밀번호 암호화
		String cryptPasswd = bCryptPasswordEncoder.encode(joinmember.getMpasswd());
		joinmember.setMpasswd(cryptPasswd);
		
		//저장
		int cnt = joinmemberrepository.insert(joinmember);
		
		//이메일전송
		String authCode = sendAuthMail(joinmember.getMemail(), path);
		
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

	private String sendAuthMail(String memail, String path) throws MessagingException{
		
		String authCode = getAuthCode();
		StringBuffer content = new StringBuffer();
		content.append(memail + "님 반갑습니다. 아래 링크를 클릭해 주세요<br>");
		content.append("<a href='http://localhost:8081"+path+"/joinmember/emailConfirm?authCode="+authCode+"&memail="+memail+"'>이메일인증확인</a>");
		
		MimeMessage message = mailSender.createMimeMessage();
		
		message.setSubject("회원가입 이메일 인증", "utf-8");
		message.setText(content.toString(), "utf-8", "html");
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(memail));
		
		//메일보내기
		mailSender.send(message);
		
		return authCode;
	}

	@Override
	public void update_emailauth(String memail) {
		// 이메일 인증
		int cnt = joinmemberrepository.update_emailauth(memail);
		
	}

	@Override
	public JoinMember selectOne(String memail) {
		
		return joinmemberrepository.selectOne(memail);
	}

}
