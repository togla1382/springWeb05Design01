package com.green.nowon.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.green.nowon.domain.dto.faq.FaqDTO;
import com.green.nowon.domain.mapper.FaqMapper;
import com.green.nowon.service.FaqService;
import com.green.nowon.utils.PageDTO;

@Service
public class FaqServiceProcess implements FaqService {

	@Autowired
	private FaqMapper faqMapper;
	
	//faq리스트 얻어오는 작업처리
	@Override
	public void list(Model model, String division, int page) {
		
		int rowTotal=faqMapper.countAllByDivision(division);
		
		int limit=10;//한페이지에 표현 할 row 개수
		int offset= limit * (page-1);//첫번째결과부터 건너뛰는 개수
		RowBounds rowBounds=new RowBounds(offset, limit);
		//offset만큼 건너뛰고 limit개수를 읽어온다.
		
		//리스트정보
		List<FaqDTO> result=faqMapper.findAllByDivisionAndRowBounds(division, rowBounds);
		//페이지정보
		PageDTO pageInfo=PageDTO.getInstance(page, rowTotal, limit, 8);
		model.addAttribute("list", result);
		model.addAttribute("pi", pageInfo);
	}

	@Override
	public void listFoAjax(ModelAndView mv, String division, int page) {
		
		int rowTotal=faqMapper.countAllByDivision(division);
		
		int limit=10;//한페이지에 표현 할 row 개수
		int offset= limit * (page-1);//첫번째결과부터 건너뛰는 개수
		RowBounds rowBounds=new RowBounds(offset, limit);
		//offset만큼 건너뛰고 limit개수를 읽어온다.
		
		//리스트정보
		List<FaqDTO> result=faqMapper.findAllByDivisionAndRowBounds(division, rowBounds);
		//페이지정보
		PageDTO pageInfo=PageDTO.getInstance(page, rowTotal, limit, 5);
		mv.addObject("list", result);
		mv.addObject("pi", pageInfo);
		
	}

}
