package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//URL : /login.do
//Page 위치 : /WEB-INF/view/login.jsp
//페이지 내 from username, password 를 입력받는 생성
//페이지 연결확인
@WebServlet("/login.do")
public class LoginServletServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET /login.do");
		req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST /login.do");
		
		//파라미터 받기
		String userid = req.getParameter("userid");
		String password = req.getParameter("password");
		System.out.printf("%s %s \n", userid, password);
		
		//유효성 체크
		
		//서비스
		
		//뷰(리다이렉트)
		resp.sendRedirect(req.getContextPath() + "/main.do");
	}
	
	
}
