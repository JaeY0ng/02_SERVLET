package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class C03Servlet_Test extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET /login.do...");
		//파라미터 받기
		String userid = req.getParameter("userid"); 
		String password = req.getParameter("password"); 
		System.out.printf("%s %s \n",userid,password);
		//유효성 체크
		
		
		//서비스 실행
		HttpSession session = req.getSession();
		session.setAttribute("userid",userid);
		session.setAttribute("password",password);
		
		//뷰로 이동 (or 내용 전달)
		//Forwarding
		//req.getRequestDispatcher("/main.jsp").forward(req, resp);
		//Redirect
		resp.sendRedirect(req.getContextPath() + "/main.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST /login.do...");
		//파라미터 받기
		String userid = req.getParameter("userid"); 
		String password = req.getParameter("password"); 
		System.out.printf("%s %s \n",userid,password);
		//유효성 체크
		
		
		//서비스 실행
		HttpSession session = req.getSession();
		session.setAttribute("userid",userid);
		session.setAttribute("password",password);
		
		//뷰로 이동 (or 내용 전달)
		//Forwarding
		//req.getRequestDispatcher("/main.jsp").forward(req, resp);
		//Redirect
		resp.sendRedirect(req.getContextPath() + "/main.jsp");
	}
		
	


	
}
