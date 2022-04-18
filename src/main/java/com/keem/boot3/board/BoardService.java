package com.keem.boot3.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keem.boot3.util.Pager;

@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	public List<BoardVO> getList(Pager pager) throws Exception{
		pager.makeRow();
		List<BoardVO> ar = boardMapper.getList(pager);
		
		return ar;
	}
	
}
