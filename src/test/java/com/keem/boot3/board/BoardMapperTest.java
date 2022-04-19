package com.keem.boot3.board;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.keem.boot3.util.Pager;
@SpringBootTest
class BoardMapperTest {

	@Autowired
	private BoardMapper boardMapper;
	
	//@Test
	void getFileDetail() throws Exception{
		BoardFilesVO boardFilesVO= new BoardFilesVO();
		boardFilesVO.setNum(3L);
		boardFilesVO=boardMapper.getFileDetail(boardFilesVO);
		System.out.println(boardFilesVO.toString());
		assertNotNull(boardFilesVO);
		
		
	}
	
	//@Test
	void getFileList() throws Exception{
		List<BoardFilesVO> ar = boardMapper.getFileList();
		
		assertEquals(0, ar.size());
	}
	//@Test
	void setFileDelete() throws Exception{
		BoardFilesVO boardFilesVO = new BoardFilesVO();
		boardFilesVO.setNum(4L);
		int result=boardMapper.setFileDelete(boardFilesVO);
		assertEquals(1, result);
	}
	
	//@Test
	void setFileAdd() throws Exception{
		BoardFilesVO boardFilesVO= new BoardFilesVO();
		boardFilesVO.setFileName("first fileName2");
		boardFilesVO.setOriName("first oriName2");
		boardFilesVO.setNum(4L);
		int result= boardMapper.setFileAdd(boardFilesVO);
		assertEquals(1, result);
	}
	
	@Test
	void test() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(112L);
		boardVO=boardMapper.getDetail(boardVO);
		System.out.println(boardVO.toString());
		assertNotNull(boardVO);
	}

	//@Test
	void getList() throws Exception{
		Pager pager = new Pager(); 
		pager.makeRow();
		List<BoardVO> ar = boardMapper.getList(pager);
		System.out.println(ar);
		assertEquals(10,ar.size());
	
	}
	
	//@Test
	void setAdd() throws Exception{
		for(int i=0;i<100;i++) {
		if (i%10==0) {
			Thread.sleep(1000);
		}
			
		BoardVO boardVO= new BoardVO();
		boardVO.setTitle("spring"+i);
		boardVO.setContents("spring test"+i);
		boardVO.setWriter("Lee"+i);
		int result=boardMapper.setAdd(boardVO);
		}		
//		assertEquals(1, result);
	}
	//@Test
	void setUpdate() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(3L);
		boardVO.setTitle("MODIFY");
		boardVO.setContents("spring boot");
		
		int result=boardMapper.setUpdate(boardVO);
		assertEquals(1,result);
	}
	//@Test
	void setDelete() throws Exception{
		BoardVO boardVO= new BoardVO();
		boardVO.setNum(5L);
		int result = boardMapper.setDelete(boardVO);
		assertEquals(1, result);
	}
}
