package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dto.MemberDto;
import Utils.MemberDBUtils;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET /login.do");
		req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST /login.do");
		
		
		//id/pw 인증처리
		String custname = req.getParameter("custname");
		String password = req.getParameter("password");
		
		//db로부터 role꺼냄
		MemberDto dto = null;
		try {
			MemberDBUtils.conn();
			dto = MemberDBUtils.select(custname);
			MemberDBUtils.rs.close();
			MemberDBUtils.pstmt.close();
			MemberDBUtils.conn.close();
			System.out.println("DTO : " + dto);
		}catch(Exception e) {
			System.out.println("ERROR :" + e);
		}
		//세션에 role
		HttpSession session = req.getSession();
		if(dto!=null && "admin".equals(dto.getCustname())) {
			session.setAttribute("custname", "admin");
			
			if("ROLE_ADMIN".equals(dto.getRole()))
			session.setAttribute("role", ROLE.ROLE_USER);
			else if("ROLE_USER".equals(dto.getRole()))
				session.setAttribute("role", ROLE.ROLE_USER);
		}
		
		System.out.println("ROLE : " + session.getAttribute("role"));
		
		resp.sendRedirect(req.getContextPath()+"/index.do");
	}
	
	

}
