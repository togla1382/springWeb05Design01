package com.green.nowon;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.green.nowon.domain.dto.faq.FaqDTO;
import com.green.nowon.domain.mapper.FaqMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
class SpringWeb05Design01ApplicationTests {
	
	@Autowired
	FaqMapper faqMapper;
	
	@Test
	void contextLoads() {
	}
	//@Test
	void faq더미테스트() {
		log.debug(">>>faqMapper:"+faqMapper);
		log.info(">>>faqMapper:"+faqMapper);
		log.error(">>>faqMapper:"+faqMapper);
		
		//FaqDTO dto=new FaqDTO(null, null, null);
		//FaqDTO dto=FaqDTO.builder().build();//null로 초기화
		/*
		for(int i=1; i<=10000; i++) {
			FaqDTO dto=FaqDTO.builder() //빌더클래스 생성
					.division("use").question("질문-쇼핑몰이용-"+i).answer("답변-쇼핑몰이용-"+i)
					.build(); //FaqDTO객체생성
			faqMapper.save(dto);
		}
		*/
		
		//java @since 1.8
		IntStream.rangeClosed(1, 10000).forEach(i->{
			FaqDTO dto=FaqDTO.builder() //빌더클래스 생성
					.division("delivery").question("질문-배송관련-"+i).answer("답변-배송관련-"+i)
					.build(); //FaqDTO객체생성
			faqMapper.save(dto);
		});
		
	}

}
