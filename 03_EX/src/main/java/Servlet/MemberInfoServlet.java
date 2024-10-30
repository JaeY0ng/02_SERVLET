package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.MemberDTO;
import Utils.MemberDBUtils;

@WebServlet("/memberInfo.do")
public class MemberInfoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			MemberDBUtils.conn();
			
			List<MemberDTO> list = MemberDBUtils.select();

			MemberDBUtils.rs.close();
			MemberDBUtils.pstmt.close();
			MemberDBUtils.conn.close();
			
			req.getRequestDispatcher("/WEB-INF/memberInfo.jsp").forward(req,resp);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
}
