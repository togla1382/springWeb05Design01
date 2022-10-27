package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.nowon.domain.dto.faq.FaqDTO;
import com.green.nowon.service.CustomerService;
import com.green.nowon.service.impl.CustomerServiceProcess;

@Controller
public class CustomerController {
	
	@Autowired//container에서 등록된 bean 중 일치하는 객체를 자동연결
	private CustomerService service;
	
	@GetMapping("/customers/home")
	public String home(Model model) {
		service.faqAll(model);
		return  "customer/front";
	}
	
	@GetMapping("/customers/faq/write")
	public String FaqWrite() {
		return "admin/customer/faq-write";
	}
	
	//faq 리스트 읽어오기
	@GetMapping("/admin/customers/faq")
	public String faq() { //관리자모드의 list페이지
		return "/admin/customer/faq-list";
	}
	
	//faq저장하기위한 매핑
	@PostMapping("/admin/customers/faq")
	public String faq(FaqDTO dto) {
				
		return service.save(dto);
	}
}
