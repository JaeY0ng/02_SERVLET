package Servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.MemberDTO;
import Utils.MemberDBUtils;

@WebServlet("/memberJoin.do")
public class MemberJoinServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("GET /memberJoin.do");
		try {
			MemberDBUtils.conn(); // db연결
			int maxCustno = MemberDBUtils.maxCustno();

			// 제거
			MemberDBUtils.rs.close();
			MemberDBUtils.pstmt.close();
			MemberDBUtils.conn.close();

			LocalDateTime today = LocalDateTime.now();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // yy MM dd HH mm ss
			String fmtToday = today.format(formatter);
			System.out.println(fmtToday);

			req.setAttribute("maxCustno", maxCustno);
			req.setAttribute("fmtToday", fmtToday);
			
			req.getRequestDispatcher("/WEB-INF/memberJoin.jsp").forward(req, resp);
				
		} catch (Exception e) {
			// 예외페이지로 이동 요청
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("POST /memberJoin.do");
		
		req.setCharacterEncoding("UTF-8");
		
		int custno = Integer.parseInt(req.getParameter("custno"));
		String custname = req.getParameter("custname");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 LocalDate joindate = LocalDate.parse(req.getParameter("joindate"),formatter);
		 System.out.println("Date : " + joindate);
		 
		 char grade = req.getParameter("grade").charAt(0);
		 String city = req.getParameter("city");	
		 
		 MemberDTO memberDto = new MemberDTO(custno,custname,phone,address,joindate,grade,city);
		 System.out.println("memberDto : " + memberDto);
		 
		 //유효성 체크 x
		
		//DB Insert
		 try {
		MemberDBUtils.conn();
		MemberDBUtils.insert(memberDto);
		MemberDBUtils.pstmt.close();
		MemberDBUtils.conn.close();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }

		System.out.printf("%s %s %s %s %s %s %s \n", custno, custname, phone, address, joindate, grade, city);
		
		
		// 유효성 체크는 isValid 메서드 만들어서 따로

		
		
		// 뷰로 이동 (Redirect)
		resp.sendRedirect(req.getContextPath() + "/index.do");
		
		
		
		// Forwarding
		//req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		// Redirect
		
	}

	
	private boolean isVaild(MemberDTO dto) {
		return false; // 유효성 검사
	}
	
}
