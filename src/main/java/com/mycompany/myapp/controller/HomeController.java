package com.mycompany.myapp.controller;

import com.mycompany.myapp.advice.ErrorCode;
import com.mycompany.myapp.controller.HomeController;
import com.mycompany.myapp.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private LoginService loginService;
	
	
	//홈으로 이동
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	//로그인 폼으로 이동
	@GetMapping("login")
	public void login(HttpSession session, HttpServletRequest request, Model model) throws Exception{
	
	}
	
	//로그인 버튼을 눌렀을떄
	@PostMapping("login")
	public String login(@RequestParam String memail, @RequestParam String mpasswd,
						@RequestParam String usertype,
			RedirectAttributes rattr, HttpSession session) {
		
		ErrorCode errorCode;
		if(usertype.equals("user")) {
			errorCode = loginService.mloginCheck(memail, mpasswd);
		}else {
			errorCode = loginService.ploginCheck(memail, mpasswd);
		}
		
		int code = errorCode.getCode();
		
		rattr.addFlashAttribute("msg", errorCode.getMsg());
		
		if (code==0) {//성공
			if(usertype.equals("user")) {
				session.setAttribute("memail", memail);
			}else {
				session.setAttribute("pemail", memail);
			}
			session.setAttribute("usertype", usertype);
			return "redirect:/";
		}
		return "redirect:login";
	}
	
	//로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session) {
		//세션 지우기
		session.invalidate();
		
		return "redirect:/";
	}
	
	//가입으로 이동
		@GetMapping("joinselect")
		public void join() {
			
		}
	
}
