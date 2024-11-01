package Db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jdbc")
public class C01JDBC extends HttpServlet{

	private String url="jdbc:mysql://localhost/bookdb";
	private String id="root";
	private String pw="1234";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url,id,pw);
				System.out.println("init... conn : " + conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("service..invoke..conn : " + conn);
	}


	


	
}
