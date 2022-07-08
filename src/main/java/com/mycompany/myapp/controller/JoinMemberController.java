package com.mycompany.myapp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.myapp.advice.ErrorCode;
import com.mycompany.myapp.dto.JoinMember;
import com.mycompany.myapp.service.JoinMemberService;

@Controller
@RequestMapping("joinmember")
public class JoinMemberController {
	private static final Logger LOGGER = LoggerFactory.getLogger(JoinMemberController.class);
	
	@Autowired
	private JoinMemberService joinmemberservice;
	
	@GetMapping("join")
	public void join() {
		
	}
	
	//가입버튼
	@PostMapping("join")
	public String join(@ModelAttribute JoinMember joinmember, Model model,
			RedirectAttributes rattr, HttpSession session, HttpServletRequest request) throws Exception{
		
		ErrorCode errorCode = joinmemberservice.insert(joinmember, session, request.getContextPath());
		rattr.addFlashAttribute("msg", errorCode.getMsg());
		
		return "redirect:/";
	}
	//이메일 인증
	@GetMapping("emailConfirm")
	public String emailConfirm(@RequestParam String authCode, @RequestParam String memail,
			HttpSession session, RedirectAttributes rattr) {
		
		String authCodes=(String)session.getAttribute("authCode");
		System.out.println("세션의 인증코드"+authCodes);
		
		if(authCode.equals(authCodes)) {
			joinmemberservice.update_emailauth(memail);
			
			rattr.addFlashAttribute("msg", ErrorCode.SUCCESS_EMAILAUTH.getMsg());
		}else {
			rattr.addFlashAttribute("msg", ErrorCode.ERROR_EMAILAUTH.getMsg());
		}
		
		return "redirect:/";
	}
	
	@GetMapping("list")
	public void list() {
		
	}
	
	//가입정보
	@GetMapping("info")
	public String info(HttpSession session, Model model) {
		String memail = (String)session.getAttribute("memail");
		//한건조회
		JoinMember joinmember = joinmemberservice.selectOne(memail);
		
		model.addAttribute("joinmember", joinmember);
		
		return "joinmember/info";
	}

	
}
