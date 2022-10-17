package com.green.nowon;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageControlelr {
	
	@GetMapping("/page1.nhn")
	public String page1() {
		return "page1"; // classpath:/templates/page1.html
	}
	
	@GetMapping("/page1")// classpath:/templates/page1.html
	public void page1Other() {
	}
}
