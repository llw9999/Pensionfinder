package com.mycompany.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.myapp.advice.ErrorCode;
import com.mycompany.myapp.dto.JoinPension;
import com.mycompany.myapp.dto.Page;
import com.mycompany.myapp.dto.PensionList;
import com.mycompany.myapp.service.JoinPensionService;
import com.mycompany.myapp.service.PensionFileService;
import com.mycompany.myapp.service.PensionListService;

@Controller
@RequestMapping("board")
@SessionAttributes("page") //세션에 담을 변수명 : Page page; (초기 null);
public class PensionListController {
	@Autowired
	private JoinPensionService joinPensionService;
	@Autowired
	private PensionListService pensionListService;
	@Autowired
	private PensionFileService pensionFileService;
	
	JoinPension joinpension;
	
	@GetMapping("/")
	public String listhome(Page page, Model model) {
		model.addAttribute("page", page);
		return "redirect:list";
	}
	
	@GetMapping("list")
	public void list(@ModelAttribute("page") Page page, Model model) {
		model.addAttribute("plist", pensionListService.selectList(page));
	}
	
	@GetMapping("detail")
	public void detail(@RequestParam int pnum, Model model) {
		//게시물 조회
		model.addAttribute("pList", pensionListService.selectOne(pnum));
		//게시물 파일들 조회
		model.addAttribute("pflist", pensionFileService.selectList(pnum));
	}
	
	@GetMapping("add")
	public void add(HttpSession session, Model model) {
		//추가 페이지로 이동
		
		String pemail = (String)session.getAttribute("pemail");
		
		JoinPension joinpension = joinPensionService.selectOne(pemail);
		model.addAttribute("joinpension", joinpension);
	}
	
	@PostMapping("add")
	public String add(PensionList pList, RedirectAttributes rattr) throws Exception {
		
		ErrorCode errorCode = pensionListService.insert(pList);
		
		rattr.addFlashAttribute("msg", errorCode.getMsg());
		
		return "redirect:/board/";
	}
	
	@GetMapping("modify")
	public void modify(@RequestParam int pnum, Model model) {
		//게시물 조회
		model.addAttribute("pList", pensionListService.selectOne(pnum));
		//게시물 파일들 조회
		model.addAttribute("pflist", pensionFileService.selectList(pnum));
	}
	
	@PostMapping("modify")
	public String modify(PensionList pList, 
			@RequestParam(required = false) List<Integer> removeFiles, RedirectAttributes rattr) throws Exception {		
		ErrorCode errorCode = pensionListService.update(pList, removeFiles);
		
		rattr.addFlashAttribute("msg", errorCode.getMsg()); //한번만 실행되는 파라메터
		rattr.addAttribute("pnum", pList.getPnum()); //url에 포함
		
		return "redirect:detail";
	}
	
	@GetMapping("remove")
	public String remove(@RequestParam int pnum, RedirectAttributes rattr) {
		ErrorCode errorCode = pensionListService.updateRemoveyn(pnum);
		
		//redirect, list로 이동
		rattr.addFlashAttribute("msg", errorCode.getMsg());
		return "redirect:list";
	}
	
	@GetMapping("sessionClear")
	public String sessionClear(SessionStatus sessionStatus) {
		sessionStatus.setComplete(); //세션에서 지우기
		return "/board/list";
	}
	
	@ResponseBody
	@PutMapping("likes/{pnum}")
	public String likescnt(@PathVariable int pnum) {
		pensionListService.updateLikes(pnum);
		PensionList pList = pensionListService.selectOne(pnum);
		//좋아요를 문자로 변경 후 리턴
		return String.valueOf(pList.getLikes());
	}
	
	@ResponseBody
	@PutMapping("dislikes/{pnum}")
	public String dislikecnt(@PathVariable int pnum) {
		pensionListService.updateDislikes(pnum);
		PensionList pList = pensionListService.selectOne(pnum);
		return String.valueOf(pList.getDislikes());
	}
	@GetMapping("map")
	public void map(@RequestParam int pnum, RedirectAttributes rattr) {
		//찾아오시는길
		rattr.addAttribute("pnum", pnum);
	}
}
