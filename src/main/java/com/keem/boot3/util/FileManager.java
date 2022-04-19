package com.keem.boot3.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	@Autowired
	private ServletContext servletContext;
	
	
	public String fileSave(MultipartFile mf,String path) throws Exception{
		// path는 프로젝트 상의 파일을 저장할 폴더의 경로
		// 파일을 HDD에 저장하고 
		// 저장된 파일명을 리턴(파일명은 중복X)
		
		// 어디에 저장할거냐 resources/upload/board
		// 파일 저장은 tomcat이 아니라 OS에서 저장
		String realPath=servletContext.getRealPath(path);
		System.out.println(realPath);
		
		File file= new File(realPath);
		// 파일 객체에 폴더 경로 정보를 담기
		
		if(!file.exists()) {
			file.mkdirs(); // 중간에 폴더가 없으면 중간 폴더를 생성해줌
			
		}
		
		// 1. 시간을 이용
		Calendar ca=Calendar.getInstance();
		long l = ca.getTimeInMillis(); // 현재 시간을 밀리세컨즈로 변환
		System.out.println("time: "+l);
		String oriName=mf.getOriginalFilename();
		
		String fileName=l+"_"+oriName;
		System.out.println("fileName: "+fileName);
		
		
		//2. UUID
		fileName= UUID.randomUUID().toString();	
		// static 클래스메서드임 리턴이 string이 아니라서 toString으로 변환
		fileName=fileName+"_"+oriName;
		System.out.println("UUID: "+fileName);
		
		file= new File(file,fileName);
		FileCopyUtils.copy(mf.getBytes(), file);
		
		return fileName;
	}
}
