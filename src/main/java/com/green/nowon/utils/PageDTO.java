package com.green.nowon.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class PageDTO {
	private int pageTotal;
	private int start;
	private int end;
	
	/**
	 * 페이지 개수 : defaut 5 
	 * @param page 페이지번호
	 * @param pageTotal 총 페이지수
	 */
	public PageDTO(int page, int pageTotal) {
		//page=1: pGroup=1 pFrom=1;  pTo=5;
		//page=2: pGroup=1 pFrom=1;  pTo=5;
		//page=3: pGroup=1 pFrom=1;  pTo=5;
		//page=4: pGroup=1 pFrom=1;  pTo=5;
		//page=5: pGroup=1 pFrom=1;  pTo=5;
		//page=6: pGroup=2 pFrom=6;  pTo=10;
		//page=7: pGroup=2 pFrom=6;  pTo=10;
		//page=8: pGroup=2 pFrom=6;  pTo=10;
		//page=9: pGroup=2 pFrom=6;  pTo=10;
		//page=10: pGroup=2 pFrom=6;  pTo=10;
		int pLength=5;//페이지 그룹에 표현한 개수
		
		this.pageTotal=pageTotal;
		int pGroup=page/pLength; 
		// 1/5,2/5,3/5,4/5,5/5 == 1
		//  0 , 0 , 0 , 0 , 1  == pGroup가 1이되도록
		if(page%pLength !=0) pGroup++;
		end=pGroup*pLength;
		start=end-pLength+1;
		
		//혹시 마지막페이지번호는? 총 페이지수 보다 클수는 없어요
		if(end > pageTotal) 
			end=pageTotal;
	}
	
	/**
	 * 
	 * @param page 페이지번호
	 * @param pageTotal 총 페이지수
	 * @param pLength 보여지는 페이지 번호 개수 숫자로 입력
	 */
	public PageDTO(int page, int pageTotal, int pLength) {
		this.pageTotal=pageTotal;
		int pGroup=page/pLength; 
		// 1/5,2/5,3/5,4/5,5/5 == 1
		//  0 , 0 , 0 , 0 , 1  == pGroup가 1이되도록
		if(page%pLength !=0) pGroup++;
		end=pGroup*pLength;
		start=end-pLength+1;
		
		//혹시 마지막페이지번호는? 총 페이지수 보다 클수는 없어요
		if(end > pageTotal) 
			end=pageTotal;
	}
}
