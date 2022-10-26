package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
	
	@GetMapping("/customers/home")
	public String home() {
		return "customer/front";
	}
	
	@GetMapping("/customers/faq/write")
	public String FaqWrite() {
		return "admin/customer/faq-write";
	}
}
