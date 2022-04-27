package com.keem.boot3.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.keem.boot3.util.FileManager;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private FileManager fileManager;
	
	// properties 파일의 member.role.member 속성 값 반환
	@Value("${member.role.member}")
	private String memberRole;
	
	public MemberVO login(MemberVO memberVO) throws Exception{
		
		return memberMapper.login(memberVO);
	}
	
	public int join(MemberVO memberVO,MultipartFile mf) throws Exception{
		int result=memberMapper.join(memberVO);
		Map<String, String> map = new HashMap<>();
		map.put("id", memberVO.getId());
		map.put("roleName", "ROLE_HUMAN");
		
		
		result = memberMapper.setRoleAdd(map);
		String fileName=fileManager.fileSave(mf, "resources/upload/member");
		
		MemberFilesVO memberFilesVO= new MemberFilesVO();
		
		memberFilesVO.setId(memberVO.getId());
		memberFilesVO.setFileName(fileName);
		memberFilesVO.setOriName(mf.getOriginalFilename());
		memberMapper.addFile(memberFilesVO);
		
		return result;
	}
	
	public MemberVO mypage(MemberVO memberVO) throws Exception{
		return memberMapper.mypage(memberVO);
	}
	
	public int infoUpdate(MemberVO memberVO) throws Exception{
		return memberMapper.infoUpdate(memberVO);
	}
	public int delete(MemberVO memberVO) throws Exception{
		return memberMapper.delete(memberVO);
	}
}
