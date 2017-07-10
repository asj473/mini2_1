package kr.co.mlec.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.mlec.vo.MemberVO;



// @Controller붙일 필요 없다 (spring-mvc.xml에서 빈 등록하고, 인터셉터 기능하라고 설정해줘야 한다)
public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	
	// preHandle() : 특정 페이지에 가기 전에 먼저 핸들링 하는 메소드
	@Override // 파라미터로 받은 Object handler는 무슨 역할?? 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("인터셉터 호출됨");
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("user");
		if (member != null) {
			System.out.println("인터셉터. 로그인 되어있음");
			return true; // true면 기존에 이동하려 했던 곳으로 이동 시킨다
		}
		System.out.println("인터셉터. 로그인 안되어있음");
		response.sendRedirect("http://localhost:8000/themat/member/loginForm.do");
//		response.sendRedirect("http://localhost:8000/themat/view/member/loginForm.html");
		return false;
	}
	
	
	
	
	
	
	
	
}
