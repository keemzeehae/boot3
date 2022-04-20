package com.keem.boot3.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.keem.boot3.util.FileManager;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private FileManager fileManager;
	
	public MemberVO login(MemberVO memberVO) throws Exception{
		
		return memberMapper.login(memberVO);
	}
	
	public int join(MemberVO memberVO,MultipartFile mf) throws Exception{
		int result=memberMapper.join(memberVO);
		
		String fileName=fileManager.fileSave(mf, "resources/upload/member");
		
		MemberFilesVO memberFilesVO= new MemberFilesVO();
		
		memberFilesVO.setId(memberVO.getId());
		memberFilesVO.setFileName(fileName);
		memberFilesVO.setOriName(mf.getOriginalFilename());
		memberMapper.addFile(memberFilesVO);
		
		return result;
	}
}
