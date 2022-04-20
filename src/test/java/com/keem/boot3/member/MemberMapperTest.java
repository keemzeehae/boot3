package com.keem.boot3.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class MemberMapperTest {

	@Autowired
	private MemberMapper memberMapper;
	
	//@Test
	void joinTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("ID2");
		memberVO.setPw("PW2");
		memberVO.setName("JIHYE");
		memberVO.setEmail("J@NAVER");
		memberVO.setPhone("010-1234-1111");
		int result= memberMapper.join(memberVO);
		
		assertEquals(1, result);
		
	}
	//@Test
	void loginTest() throws Exception{
		MemberVO memberVO =new MemberVO();
		memberVO.setId("ID1");
		memberVO.setPw("PW1");
		memberVO=memberMapper.login(memberVO);
		assertNotNull(memberVO.getId());
		assertNotNull(memberVO.getName());
	}
	//@Test
	void myPageTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("ID5");
		memberVO=memberMapper.mypage(memberVO);
		assertNotNull(memberVO);
	}
	//@Test
	void infoUpdate() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("ID5");
		memberVO.setName("지혜");
		memberVO.setEmail("김@naver");
		memberVO.setPhone("010-1234-0000");
		int result = memberMapper.infoUpdate(memberVO);
		
		assertEquals(1, result);
	}

	@Test
	void delete() throws Exception{
		MemberVO memberVO= new MemberVO();
		memberVO.setId("ID5");
		int result = memberMapper.delete(memberVO);
		assertEquals(1, result);
	}

}
