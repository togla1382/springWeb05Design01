package com.green.nowon.service;

import org.springframework.ui.Model;

import com.green.nowon.domain.dto.faq.FaqDTO;

public interface CustomerService {

	String save(FaqDTO dto);

	void faqAll(Model model, int page, String division);

}
