package com.keem.boot3.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
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
	@GetMapping("fileDown")
	public ModelAndView getFileDown(BoardFilesVO boardFilesVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardFilesVO = boardService.getFileDetail(boardFilesVO);
		//속성명은 fileDown 클래스에서 사용하는 이름과 동일하게
		mv.addObject("fileVO",boardFilesVO);
		//Bean(클래스)의 이름과 동일하게 FileDown클래스에서 Component옆에 준 이름 Component("fd") 라고 주면 setViewName도 "fd"가 된다.
		mv.setViewName("fileDown");
		return mv;
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
	public String setAdd(BoardVO boardVO,MultipartFile [] files) throws Exception{
		
	
		int result= boardService.setAdd(boardVO,files);
		
		return "redirect:./list";
	}
	
	@GetMapping("detail")
	public ModelAndView getDetail(BoardVO boardVO) throws Exception{
		ModelAndView mv= new ModelAndView();
		boardVO=boardService.getDetail(boardVO);
		mv.addObject("detail",boardVO);
		mv.setViewName("board/detail");
		return mv;
	}
	
	
	@GetMapping("update")
	public ModelAndView setUpdate(BoardVO boardVO) throws Exception{
		ModelAndView mv= new ModelAndView();
		boardVO=boardService.getDetail(boardVO);
		mv.setViewName("board/update");
		mv.addObject("vo",boardVO);
		return mv;
	}
	
	@PostMapping("update")
	public ModelAndView setUpdate(ModelAndView mv,BoardVO boardVO) throws Exception{
		int result = boardService.setUpdate(boardVO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	@GetMapping("delete")
	public String setDelete(BoardVO boardVO) throws Exception{
		int result= boardService.setDelete(boardVO);
		return "redirect:./list";
	}
}
