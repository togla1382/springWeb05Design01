package com.green.nowon;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageControlelr {
	
	@GetMapping("/signin")
	public String login() {
		return "sign/signin";
	}
	
	@GetMapping("/page1.nhn")
	public String page1() {
		return "page1"; // classpath:/templates/page1.html
	}
	
	@GetMapping("/page1")// classpath:/templates/page1.html
	public void page1Other() {
	}
	
	@GetMapping("/test")// classpath:/templates/test.html
	public void test() {
	}
	@GetMapping("/test2")// classpath:/templates/test2.html
	public void test2() {
	}
	
	@GetMapping("/goods/sale/{kind}")
	public ModelAndView goodsSale(@PathVariable int kind, ModelAndView modelAndView) {
		System.out.println("tab메뉴를 누르면 실행됩니다.");
		modelAndView.setViewName("goods/sale/list");
		if(kind==1) {
			modelAndView.addObject("list", "타임특가 상품");
		}else if(kind==2) {
			modelAndView.addObject("list", "한정특가 상품");
		}else if(kind==3) {
			modelAndView.addObject("list", "브랜드특가 상품");
		}
		
		return modelAndView;
		
	}
}
