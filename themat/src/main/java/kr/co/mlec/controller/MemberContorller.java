package kr.co.mlec.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mlec.service.MemberService;
import kr.co.mlec.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberContorller {
	@Autowired
	private MemberService memberService;
	
//	@Autowired  
//	private ServletContext servletContext;

	@RequestMapping("/loginForm.do")
	public String loginForm() throws Exception{
		System.out.println("loginForm.do들어옴");
		return "member/loginForm";
	}

	
	
	@RequestMapping("/login.do")
	@ResponseBody
	public MemberVO login(MemberVO member, HttpSession session) throws Exception{
		System.out.println(member.getId() + " : " + member.getPassword());
		
		System.out.println("login.do들어옴");
		MemberVO m = memberService.login(member);
		
		if(m != null){
			session.setAttribute("user", member);
			System.out.println("db에서 가져온 아이디 : " + m.getId());
			System.out.println("세션에서 가져온 아이디 : " + session.getAttribute("user") );
			System.out.println("로그인 성공");
			return m;
		} else {
			System.out.println("로그인 실패");
			return new MemberVO();
		}
	}

	
	
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) throws Exception{
		System.out.println("로그아웃 들어옴");
		session.invalidate();
		System.out.println("세션에 남은 유져 : " + session.getAttribute("user"));
		return "redirect:loginForm.do";
	}

}
