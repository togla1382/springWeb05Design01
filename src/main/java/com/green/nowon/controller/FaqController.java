package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.green.nowon.service.FaqService;
import com.green.nowon.service.impl.FaqServiceProcess;

import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
@Controller
public class FaqController {
	
	//interface-class
	//private final FaqService service;
	
	@Autowired
	private FaqService service;
	
	@GetMapping("/customers")
	public String customers() {
		return "customer/faq/page";
	}
	
	//HTML응답을 하기위해 ModelAndView 이용
	//ajax요청시 실행되는 GetMapping 메서드
	@ResponseBody //ModelAndView의 ViewName에설정된 HTML 응답객체로 사용
	@GetMapping("/customers/{division}/{page}")
	public ModelAndView customers(
			@PathVariable String division,
			@PathVariable int page,
			ModelAndView mv) {
		
		service.listFoAjax(mv, division, page);
		
		mv.setViewName("customer/faq/list");
		//@ResponseBody 없을때 리턴형이 String 이면 ViewResolver처리대상인 templates
		return mv;
	}

}
