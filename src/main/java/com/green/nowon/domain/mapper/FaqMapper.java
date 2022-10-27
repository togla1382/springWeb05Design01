package com.green.nowon.domain.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.domain.dto.faq.FaqDTO;

@Mapper
public interface FaqMapper {

	@Insert("insert into faq(faq_no,division,question,answer)"
			+ " values(seq_faq.nextval, #{division}, #{question}, #{answer})")
	void save(FaqDTO dto);

}
