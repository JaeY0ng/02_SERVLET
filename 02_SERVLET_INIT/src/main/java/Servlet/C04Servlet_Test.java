package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/join.do") // 외부로의 부터 요청 처리 하기 위함
public class C04Servlet_Test extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET /join.do");
		req.getRequestDispatcher("/WEB-INF/join.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST /join.do");
		
		// 파라미터 받기
		String userid = req.getParameter("userid");
		String password = req.getParameter("password");
		System.out.printf("%s %s \n", userid, password);
		// 유효성 체크

		// 서비스 실행
		HttpSession session = req.getSession();
		session.setAttribute("userid", userid);
		session.setAttribute("password", password);

		// 뷰로 이동 (or 내용 전달)
		// Forwarding
		// req.getRequestDispatcher("/main.jsp").forward(req, resp);
		// Redirect
		resp.sendRedirect(req.getContextPath() + "/main.do");
	}

}
