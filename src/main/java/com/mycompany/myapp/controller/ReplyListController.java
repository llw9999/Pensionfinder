package com.mycompany.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

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
import com.mycompany.myapp.dto.Page;
import com.mycompany.myapp.dto.ReplyList;

import com.mycompany.myapp.service.ReplyListService;

@Controller
@RequestMapping("reply")
//@SessionAttributes("page")
public class ReplyListController {
	@Autowired
	private ReplyListService replyListService;
	
	@GetMapping("/")
	public String replyListhome(@RequestParam(required = false) int pnum,  Page page, Model model,
			RedirectAttributes rattr) {
		
		model.addAttribute("page", page);
		rattr.addAttribute("pnum", pnum);
		return "redirect:replyList";
	}
	
	@GetMapping("replyList")
	public void replyList(@RequestParam int pnum,  @ModelAttribute("page") Page page, Model model) {
		model.addAttribute("rlist", replyListService.selectList(pnum, page));
	}
	
	@GetMapping("replyDetail")
	public void replyDetail(@RequestParam(required = false) int rnum, Model model) {
		model.addAttribute("rList", replyListService.selectOne(rnum));
	}
	
	@GetMapping("replyAdd")
	public void replyAdd() {
		
	}
	
	@PostMapping("replyAdd")
	public String replyAdd(ReplyList rList, RedirectAttributes rattr) throws Exception {
		ErrorCode errorCode = replyListService.insert(rList);
		
		rattr.addFlashAttribute("msg", errorCode.getMsg());
		rattr.addAttribute("pnum", rList.getPnum());

		return "redirect:/reply/";
	}
	
	@GetMapping("replyModify")
	public void replyModify(ReplyList rList,
			@RequestParam int rnum, Model model) {
		model.addAttribute("rList", replyListService.selectOne(rnum));
	}
	
	@PostMapping("replyModify")
	public String replyModify(ReplyList rList, RedirectAttributes rattr) throws Exception {
		ErrorCode errorCode = replyListService.update(rList);
		
		rattr.addFlashAttribute("msg", errorCode.getMsg());
		rattr.addAttribute("rnum", rList.getRnum());
		
		return "redirect:replyDetail";
	}
	
	@GetMapping("replyRemove")
	public String replyRemove(@RequestParam int rnum, int pnum, RedirectAttributes rattr) {
		ErrorCode errorCode = replyListService.updateRremoveyn(rnum);
		
		rattr.addFlashAttribute("msg", errorCode.getMsg());
		rattr.addAttribute("pnum", pnum);
		return "redirect:replyList";
	}
	
	@GetMapping("sessionClear")
	public String sessionClear(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "/reply/replyList";
	}
	
	@ResponseBody
	@PutMapping("help/{rnum}")
	public String help(@PathVariable int rnum) {
		replyListService.updateHelp(rnum);
		ReplyList rList = replyListService.selectOne(rnum);
		return String.valueOf(rList.getHelp());
	}
	
	@ResponseBody
	@PutMapping("useless/{rnum}")
	public String useless(@PathVariable int rnum) {
		replyListService.updateUseless(rnum);
		ReplyList rList = replyListService.selectOne(rnum);
		return String.valueOf(rList.getUseless());
	}
}
