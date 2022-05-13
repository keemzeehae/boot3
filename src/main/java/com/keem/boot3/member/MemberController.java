package com.keem.boot3.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.compiler.ast.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@ModelAttribute("member")
	public String getBoard() {
		return "member";
	}

	
	@GetMapping("join")
	public ModelAndView join() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/join");
		return mv;
	}

	@PostMapping("join")
	public ModelAndView join(MemberVO memberVO, MultipartFile files) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = memberService.join(memberVO, files);
		mv.setViewName("redirect:../");
		return mv;
	}

	@PostMapping("login")
	public ModelAndView login(MemberVO memberVO, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		memberVO = memberService.login(memberVO);
		mv.setViewName("member/login");
		
		if(memberVO!=null) {
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:../");
		}
		
		return mv;
	}
	
	@GetMapping("login")
	public ModelAndView login()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/login");
		return mv;
	}

	@GetMapping("mypage")
	public ModelAndView mypage(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO=(MemberVO)session.getAttribute("member");
		memberVO=memberService.mypage(memberVO);
		
		mv.addObject("vo",memberVO);
		mv.setViewName("member/mypage");
		return mv;
	}
	@GetMapping("logout")
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	@GetMapping("delete")
	public ModelAndView delete(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO=(MemberVO)session.getAttribute("member");
		int result = memberService.delete(memberVO);
		session.invalidate();
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@GetMapping("infoUpdate")
	public ModelAndView infoUpdate(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		memberVO=memberService.mypage(memberVO);
		mv.addObject("vo",memberVO);
		mv.setViewName("member/infoUpdate");
		return mv;
	}
	
	@PostMapping("infoUpdate")
	public ModelAndView infoUpdate(MemberVO memberVO,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO vo=(MemberVO)session.getAttribute("member");
		memberVO.setId(vo.getId());
		int result= memberService.infoUpdate(memberVO);
		mv.setViewName("redirect:./mypage");
		return mv;
		
	}
}
