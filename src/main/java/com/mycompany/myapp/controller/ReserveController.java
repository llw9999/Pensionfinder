package com.mycompany.myapp.controller;

import java.util.List;

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
import com.mycompany.myapp.dto.Reserve;
import com.mycompany.myapp.service.ReserveService;

@Controller
@RequestMapping("reserve")
public class ReserveController {
	private static final Logger logger = LoggerFactory.getLogger(ReserveController.class);
	
	@Autowired
	private ReserveService reserveService;
	
	@GetMapping("reserve")
	public void reserve() {
		
	}
	
	@PostMapping("reserve")
	public String reserve(Reserve reserve, RedirectAttributes rattr) throws Exception {
		ErrorCode errorCode = reserveService.insert(reserve);
		
		rattr.addFlashAttribute("msg", errorCode.getMsg());
		rattr.addAttribute("pnum", reserve.getPnum());
		return "redirect:/board/detail";
	}
	
	@GetMapping("reserveRemove")
	public String reserveRemove(@RequestParam int rnum, int pnum, RedirectAttributes rattr) throws Exception {
		ErrorCode errorCode = reserveService.updateRremoveyn(rnum);
		
		rattr.addFlashAttribute("msg", errorCode.getMsg());
		rattr.addAttribute("pnum", pnum);
		return "redirect:/reserve/reservecheck";
	}
	
	@GetMapping("reservelist")
	public void reservelist(@RequestParam int pnum, Model model) {
		List<Reserve> ReserveData = reserveService.selectList(pnum);
		
		model.addAttribute("reserve", ReserveData);		
	}
	
	@GetMapping("reservecheck")
	public void reservecheck(@RequestParam(required = false) String memail, Model model) {
		model.addAttribute("reservecheck", reserveService.mselectList(memail));
	}

}