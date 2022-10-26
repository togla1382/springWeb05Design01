package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.nowon.domain.dto.faq.faqDTO;
import com.green.nowon.service.CustomerService;
import com.green.nowon.service.impl.CustomerServiceProcess;

@Controller
public class CustomerController {
	
	@Autowired//container에서 등록된 bean 중 일치하는 객체를 자동연결
	private CustomerService service;
	
	@GetMapping("/customers/home")
	public String home() {
		return "customer/front";
	}
	
	@GetMapping("/customers/faq/write")
	public String FaqWrite() {
		return "admin/customer/faq-write";
	}
	
	@GetMapping("/admin/customers/faq")
	public String faq() { //관리자모드의 list페이지
		return "/admin/customer/faq-list";
	}
	
	
	@PostMapping("/admin/customers/faq")
	public String faq(faqDTO dto) {
		return service.save(dto);
	}
}
