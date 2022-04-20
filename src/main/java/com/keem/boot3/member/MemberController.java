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
	public String getMember() {
		return "member";
	}

	
	@GetMapping("join")
	public void join() throws Exception {

	}

	@PostMapping("join")
	public String join(MemberVO memberVO, MultipartFile mf) throws Exception {
		int result = memberService.join(memberVO, mf);
		return "redirect:../";
	}

	@GetMapping("login")
	public void login(Model model,
			@CookieValue(value = "rememberID", defaultValue = "", required = false) String rememberID)
			throws Exception {

	}

	@PostMapping("login")
	public String login(MemberVO memberVO, HttpSession session, String remember, Model model,
			HttpServletResponse response) throws Exception {
		System.out.println("Remember:" + remember);
		if (remember != null && remember.equals("1")) {
			Cookie cookie = new Cookie("remember", memberVO.getId());
			// 남아있게 만들기
			cookie.setMaxAge(-1);
			response.addCookie(cookie);

		} else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}

		memberVO = memberService.login(memberVO);
		String path = "redirect:./login";
		if (memberVO != null) {
			// 로그인한 사용자의 정보 Session에 들어가 있음 member 라는 이름으로
			session.setAttribute("member", memberVO);
			path = "redirect:../";
		}

		return path;
	}

	@GetMapping("mypage")
	public ModelAndView mypage(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO=(MemberVO)session.getAttribute("member");
		memberVO=memberService.mypage(memberVO);
		
		mv.addObject("dto",memberVO);
		mv.setViewName("member/mypage");
		return mv;
	}
	@GetMapping("logout")
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	@GetMapping("delete")
	public String delete(HttpSession session,MemberVO memberVO) throws Exception{
		int result = memberService.delete(memberVO);
		session.invalidate();
		return "redirect:../";
	}
	
	@GetMapping("infoUpdate")
	public ModelAndView infoUpdate(MemberVO memberVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberVO=memberService.mypage(memberVO);
		mv.addObject("member",memberVO);
		mv.setViewName("member/infoUpdate");
		return mv;
	}
	@PostMapping("infoUpdate")
	public String infoUpdate(MemberVO memberVO,HttpSession session) throws Exception{
		int result= memberService.infoUpdate(memberVO);
		return "redirect:./mypage";
	}
}
