package com.green.nowon.domain.dto.faq;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//@Builder// args 존재하는 생성자와 함께쓸수 있어요 : 빌터패턴을 통해서 객체 생성을 지원합니다.
//@AllArgsConstructor
@Getter
@Setter
public class FaqDTO {
	private String division;
	private String question;
	private String answer;
	
	public FaqDTO(String division, String question, String answer) {
		this.division = division;
		this.question = question;
		this.answer = answer;
	}
	
	//내부클래스 객체를 생성시켜주는 메서드
	public static FaqDTOBuilder builder() {
		return new FaqDTOBuilder();
	}
	//inner class
	public static class FaqDTOBuilder{
		private String division;
		private String question;
		private String answer;
		
		public FaqDTOBuilder division(String division) {
			this.division=division;
			return this;
		}
		public FaqDTOBuilder question(String question) {
			this.question=question;
			return this;
		}
		public FaqDTOBuilder answer(String answer) {
			this.answer=answer;
			return this;
		}
		
		public FaqDTO build() {
			return new FaqDTO(division, question, answer);
		}
		
		//FaqDTO dto=new FaqDTO(division, question, answer);
	}
	

}
