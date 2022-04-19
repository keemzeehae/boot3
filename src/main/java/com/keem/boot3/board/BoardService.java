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
		Integer totalCount= boardMapper.total(pager);
		pager.makenum(totalCount);
		List<BoardVO> ar = boardMapper.getList(pager);
		
		return ar;
	}
	public int setAdd(BoardVO boardVO) throws Exception{
		int result = boardMapper.setAdd(boardVO);
		return result;
	}
}
