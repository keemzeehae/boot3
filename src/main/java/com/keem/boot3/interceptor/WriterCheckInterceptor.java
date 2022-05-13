package com.keem.boot3.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.keem.boot3.board.BoardMapper;
import com.keem.boot3.board.BoardVO;
import com.keem.boot3.member.MemberVO;

@Component
public class WriterCheckInterceptor implements HandlerInterceptor {

	@Autowired
	private BoardMapper boardMapper;

//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView)throws Exception{
//		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
//		
//		Map<String, Object> map= modelAndView.getModel();
//		BoardVO boardVO = (BoardVO)map.get("vo");
//		
//		if(!boardVO.getWriter().equals(memberVO.getId())) {
//			modelAndView.addObject("message","작성자만 가능합니다.");
//			modelAndView.addObject("path","./list");
//			modelAndView.setViewName("common/getResult");
//			
//		}
//	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		
	
		//request.getParameter("파라미터이름");
		//이름 num이라는 String, value도 String 이다. 
		String num = request.getParameter("num");
		System.out.println(num);
		BoardVO boardVO= new BoardVO();
		//Long타입으로 전환한 후에 넣어줌 Long.parseLong
		boardVO.setNum(Long.parseLong(num));
		boardVO = boardMapper.getDetail(boardVO);
		
		MemberVO memberVO= (MemberVO)request.getSession().getAttribute("member");
		
		
		//boolean check=false;
		//작성자와 로그인 한 사용자의 id가 일치하면 통과
		if(boardVO.getWriter().equals(memberVO.getId())) {
			//if 내에서 return을 만나면 그 즉시 종료
			return true;
		}else {
			//일치하지 않으면 list로 redirect 하자
			response.sendRedirect("./list");
			
			return false;
		}
	}
}
