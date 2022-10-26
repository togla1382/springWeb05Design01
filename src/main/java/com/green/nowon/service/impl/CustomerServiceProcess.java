package com.green.nowon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.nowon.domain.dto.faq.faqDTO;
import com.green.nowon.domain.mapper.FaqMapper;
import com.green.nowon.service.CustomerService;

@Service
public class CustomerServiceProcess implements CustomerService {
	
	
	@Autowired
	private FaqMapper mapper;
	
	
	
	@Override
	public String save(faqDTO dto) {
		mapper.save(dto);
		return "redirect:/admin/customers/faq"; //관리자모드 list페이지요청
	}

}
