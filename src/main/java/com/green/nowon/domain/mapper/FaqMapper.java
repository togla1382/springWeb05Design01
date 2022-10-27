package com.green.nowon.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.green.nowon.domain.dto.faq.FaqDTO;

@Mapper
public interface FaqMapper {

	@Insert("insert into faq(faq_no,division,question,answer)"
			+ " values(seq_faq.nextval, #{division}, #{question}, #{answer})")
	void save(FaqDTO dto);

	@Select("select * from (select rownum rnum,f.* from "
			+ " (select * from faq order by faq_no) f)"
			+ "where rnum between 1 and 10")
	List<FaqDTO> faqAll();

	

}
