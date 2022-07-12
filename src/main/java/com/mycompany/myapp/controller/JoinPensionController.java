package com.mycompany.myapp.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.myapp.advice.ErrorCode;
import com.mycompany.myapp.dto.JoinMember;
import com.mycompany.myapp.dto.JoinPension;
import com.mycompany.myapp.service.JoinMemberService;
import com.mycompany.myapp.service.JoinPensionService;

@Controller
@RequestMapping("joinpension")
public class JoinPensionController {
	private static final Logger LOGGER = LoggerFactory.getLogger(JoinPensionController.class);
	
	@Autowired
	private JoinPensionService joinpensionservice;
	
	@GetMapping("join")
	public void join() {
		
	}
	
	//가입버튼
	@PostMapping("join")
	public String join(@ModelAttribute JoinPension joinpension, Model model,
			RedirectAttributes rattr, HttpSession session, HttpServletRequest request) throws Exception{
		
		ErrorCode errorCode = joinpensionservice.insert(joinpension, session, request.getContextPath());
		rattr.addFlashAttribute("msg", errorCode.getMsg());
		
		return "redirect:/";
	}
	//이메일 인증
	@GetMapping("emailConfirm")
	public String emailConfirm(@RequestParam String authCode, @RequestParam String pemail,
			HttpSession session, RedirectAttributes rattr) {
		
		String authCodes=(String)session.getAttribute("authCode");
		System.out.println("세션의 인증코드"+authCodes);
		
		if(authCode.equals(authCodes)) {
			joinpensionservice.update_emailauth(pemail);
			System.out.println("테스트");
			
			rattr.addFlashAttribute("msg", ErrorCode.SUCCESS_EMAILAUTH.getMsg());
		}else {
			rattr.addFlashAttribute("msg", ErrorCode.ERROR_EMAILAUTH.getMsg());
		}
		
		return "redirect:/";
	}
	@GetMapping("list")
	public void list() {
		
	}
	
	//주소를 호출
		@GetMapping("jusoPopup") 
		public void jusoPopup() {
			//member/jusoPopup.jsp호출
		}
		
		//주소검색후 callback
		@PostMapping("jusoPopup") 
		public void jusoPopup(@RequestParam Map<String, String> jusomap, Model model) {
			model.addAttribute("jusomap", jusomap);
		}
	
	//가입정보
	@GetMapping("info")
	public String info(HttpSession session, Model model) {
		String pemail = (String)session.getAttribute("pemail");
		//한건조회
		JoinPension joinpension = joinpensionservice.selectOne(pemail);
		
		model.addAttribute("joinpension", joinpension);
		
		return "joinpension/info";
	}
	@GetMapping("remove")
	public String remove(@RequestParam String pemail,HttpSession session ,RedirectAttributes rattr) {
		ErrorCode errorCode = joinpensionservice.delete(pemail);
		
		rattr.addFlashAttribute("msg", errorCode.getMsg());
		session.invalidate();
		return "redirect:/";
	}
	
		//회원 정보 수정
		@GetMapping("modify")
		public void modify(HttpSession session, Model model) {
			String pemail = (String)session.getAttribute("pemail");
			
			model.addAttribute("joinpension", joinpensionservice.selectOne(pemail));
		}
		
		@PostMapping("modify")
		public String modify(JoinPension joinpension, String npasswd, RedirectAttributes rattr) throws Exception{
			ErrorCode errorCode = joinpensionservice.update(joinpension, npasswd);
			if (errorCode.getCode() !=0) {
				rattr.addFlashAttribute("msg", errorCode.getMsg());
				
				return "redirect:modify";
			}else {
				rattr.addFlashAttribute("msg", errorCode.getMsg());
				return "redirect:info";
			}
			
		}
	
}
