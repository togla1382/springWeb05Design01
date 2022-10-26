package com.green.nowon.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class GoodsController {

	@PostMapping("/goods")
	public String save(MultipartFile img) throws IOException {
		String filePath="/images/temp/";
		ClassPathResource cpr=new ClassPathResource("static"+filePath);
		//   "static/images/temp/"
		File location=cpr.getFile();//폴더
		
		String fileOrgName=img.getOriginalFilename();
		
		File dest=new File(location, fileOrgName);
		
		img.transferTo(dest);
		System.out.println("파일업로드완료!");
		
		
		return "goods/list";
	}
	
	@ResponseBody //return "" 페이지정보가 아니고  응답data String 입니다.
	//->성공시 result로 전달되는 문자열입니다.
	@PostMapping("/goods/upload")
	public  String fileUpload(MultipartFile img) throws IOException {
		String filePath="/images/temp/";
		ClassPathResource cpr=new ClassPathResource("static"+filePath);
		//   "static/images/temp/"
		File location=cpr.getFile();//폴더
		
		String fileOrgName=img.getOriginalFilename();
		
		File dest=new File(location, fileOrgName);
		
		img.transferTo(dest);
		System.out.println("파일업로드완료!");
		return filePath+fileOrgName; //"/images/temp/파일이름.확장자"
	}
}
