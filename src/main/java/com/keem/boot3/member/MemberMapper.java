package com.keem.boot3.member;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	//회원가입
	public int join(MemberVO memberVO) throws Exception;
	
	//로그인
	public MemberVO login(MemberVO memberVO) throws Exception;
	
	//my page
	public MemberVO mypage(MemberVO memberVO) throws Exception;

	//회원수정
	public int infoUpdate(MemberVO memberVO) throws Exception;

	//회원탈퇴
	public int delete(MemberVO memberVO) throws Exception;
	
	//파일 추가
	public int addFile(MemberFilesVO memberFilesVO) throws Exception;
	
	//상세파일
	public MemberFilesVO detailFile(MemberFilesVO memberFilesVO) throws Exception;
	
	//role
	public int setRoleAdd(Map<String, String> map) throws Exception;
}
