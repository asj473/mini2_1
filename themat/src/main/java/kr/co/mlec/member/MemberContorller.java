package kr.co.mlec.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mlec.vo.UserVO;

@Controller
@RequestMapping("/member")
public class MemberContorller {


	@RequestMapping("/login.do")
	public void login(){
		System.out.println("aaaa");
		
		
		
	}

	@RequestMapping("/join.do")
	public void join(){
		System.out.println("1111");
		
		
	}
	
	
	@RequestMapping("/loginNext.do")
	@ResponseBody
	public String loginNext(HttpServletRequest request){
		System.out.println("2222");
		System.out.println("");

		System.out.println(request.getParameter("id"));
		String id = request.getParameter("id");
		UserVO user = new UserVO();
		user.setId(id);
		
		return "user";
	}

}
