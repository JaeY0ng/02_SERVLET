package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.MemberDto;
import Utils.MemberDBUtils;

@WebServlet("/memberInfo.do")
public class MemberInfoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//DB SELECT 결과 전달(request객체 attr저장)
		try {
			MemberDBUtils.conn();
			List<MemberDto> list =  MemberDBUtils.select();
			
			req.setAttribute("list", list);
		}catch(Exception e) {
			System.out.println("DB EXCEPTION.." + e);
		}
		
		req.getRequestDispatcher("/WEB-INF/memberInfo.jsp").forward(req, resp);
	}

	
}
