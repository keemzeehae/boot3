package com.keem.boot3.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.keem.boot3.util.Pager;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "board";
		
	}
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardVO> ar = boardService.getList(pager);
		mv.addObject("list",ar);
		mv.setViewName("board/list");
		return mv;
	}

	@GetMapping("add")
	public void setAdd()throws Exception{
		
	}
	
	@PostMapping("add")
	public String setAdd(BoardVO boardVO) throws Exception{
		int result= boardService.setAdd(boardVO);
		
		return "redirect:./list";
	}
	
}
