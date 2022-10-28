package com.green.nowon.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	
	@Value("${mysetting.page.limit}")
	private int limit;
	
	@Override
	public String save(FaqDTO dto) {
		mapper.save(dto);
		return "redirect:/admin/customers/faq"; //관리자모드 list페이지요청
	}

	@Override
	public void faqAll(Model model, int page, String division) {
		//if page=1 int from=1, int to=10;
		//if page=2 int from=11, int to=20;
		//int limit=10;//페이지당 보여줄 개수: 필드에서적용		
		int to=page*limit;
		int from=to-limit+1;
		
		//페이지계산
		//총 게시글수
		int rowTotal=mapper.countAllByDivision(division);
		System.out.println("faq의 총 개수 : "+rowTotal);
		
		model.addAttribute("list", mapper.faqAllByDivision(from, to, division));
		//model.addAttribute("pData", PageDTO.getInstance(page, rowTotal, 8) );
		model.addAttribute("pData", PageDTO.getInstance(page, rowTotal, limit, 8) );
		
		
	}
	
	@Override
	public void faqList(Model model, int page, String division) {
		//int limit=10;// row 개수
		//시작위치에서 건너뛰는개수
		int offset=(page-1)*limit;
		model.addAttribute("list", mapper.findAllByDivisionAndRowBounds(division ,new RowBounds(offset, limit)));
		
		
		int rowTotal=mapper.countAllByDivision(division);
		model.addAttribute("pData", PageDTO.getInstance(page, rowTotal, limit, 8) );
		
		
	}



}
