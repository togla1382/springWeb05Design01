package com.green.nowon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.dto.faq.FaqDTO;
import com.green.nowon.domain.mapper.FaqMapper;
import com.green.nowon.service.CustomerService;

@Service
public class CustomerServiceProcess implements CustomerService {
	
	
	@Autowired
	private FaqMapper mapper;
	
	
	
	@Override
	public String save(FaqDTO dto) {
		mapper.save(dto);
		return "redirect:/admin/customers/faq"; //관리자모드 list페이지요청
	}



	@Override
	public void faqAll(Model model) {
		//List<FaqDTO> result=mapper.faqAll();
		//model.addAttribute("list", result);
		model.addAttribute("list", mapper.faqAll());
	}



}
