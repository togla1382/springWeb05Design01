package com.green.nowon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.dto.faq.FaqDTO;
import com.green.nowon.domain.mapper.FaqMapper;
import com.green.nowon.service.CustomerService;
import com.green.nowon.utils.PageDTO;

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
	public void faqAll(Model model, int page, String division) {
		//if page=1 int from=1, int to=10;
		//if page=2 int from=11, int to=20;
		int length=10;//페이지당 보여줄 개수		
		int to=page*length;
		int from=to-length+1;
		
		//페이지계산
		//총 게시글수
		int tot=mapper.countAllByDivision(division);
		System.out.println("faq의 총 개수 : "+tot);
		
		int pageTotal=tot/length; //총페이지 수
		if(tot%length != 0) {
			pageTotal++;
		}
		
		//PageDTO pageDTO=new PageDTO(page, pageTotal, 8);
		
		
		System.out.println("총페이지수 : "+pageTotal);// 2001
		model.addAttribute("list", mapper.faqAllByDivision(from, to, division));
		model.addAttribute("pData", PageDTO.getInstance(page, pageTotal, 8) );
		
		
	}



}
