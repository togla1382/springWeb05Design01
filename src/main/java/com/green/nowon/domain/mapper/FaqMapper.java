package com.green.nowon.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import com.green.nowon.domain.dto.faq.FaqDTO;

@Mapper
public interface FaqMapper {

	@Insert("insert into faq(faq_no,division,question,answer)"
			+ " values(seq_faq.nextval, #{division}, #{question}, #{answer})")
	void save(FaqDTO dto);

	@Select("select * from (select rownum rnum,f.* from "
			+ " (select * from faq order by faq_no) f) "
			+ "where rnum between #{from} and #{to}")
	List<FaqDTO> faqAll(
			@Param("from") int from,
			@Param("to") int to);
	
	@Select("select * from (select rownum rnum,f.* from "
			+ " (select * from faq where division=#{division} order by faq_no) f) "
			+ "where rnum between #{from} and #{to}")
	List<FaqDTO> faqAllByDivision(
			@Param("from") int from,
			@Param("to") int to, 
			@Param("division") String division);

	@Select("select count(*) from faq")
	int countAll();

	@Select("select count(*) from faq where division=#{division}")
	int countAllByDivision(@Param("division") String division);

	@Select("select * from faq")
	List<FaqDTO> findAll(RowBounds rowBounds);

	//서브쿼리를 사용하지않고 기본쿼리적용하고 RowBounds객체만 파라미터로 삽입
	@Select("select * from faq faq where division=#{division}")
	List<FaqDTO> findAllByDivisionAndRowBounds(@Param("division") String division, RowBounds rowBounds);


	

}
