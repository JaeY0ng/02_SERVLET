package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//URL : /login.do
//Page 위치 : /WEB-INF/view/login.jsp
//페이지 내 from username, password 를 입력받는 생성
//페이지 연결확인
/*@WebServlet("/login.do")*/
public class LoginPageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET /login.do");
		req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST /login.do");
		
		
		resp.setContentType("text/html; charset=UTF-8");
		//파라미터 받기
		String userid = req.getParameter("userid");
		String password = req.getParameter("password");
		System.out.printf("%s %s \n", userid, password);
		
		//유효성 체크
		
		//서비스(권한 체크만 하기 위한 처리...)
		HttpSession session = req.getSession();
		
		if("user1".equals(userid)) {
			session.setAttribute("userid", "user1");
			session.setAttribute("role", "ROLE_USER");
			
		}else if("admin".equals(userid)) {
			session.setAttribute("userid", "admin");
			session.setAttribute("role", "ROLE_ADMIN");
			
		}else if("member1".equals(userid)) {
			session.setAttribute("userid", "member1");
			session.setAttribute("role", "ROLE_MEMBER");
			
		}else {
			session.setAttribute("userid", "anonymous");
			session.setAttribute("role", null);
		}
		
		
		
		
		//뷰(리다이렉트)
		resp.sendRedirect(req.getContextPath() + "/main.do");
	}
	
	
}
