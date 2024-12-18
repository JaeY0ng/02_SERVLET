package Db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/hikaricp")
public class C03HIKARIDATASOURCE extends HttpServlet {
	//
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String url;
	private String id;
	private String pw;
	
	private DataSource dataSource;
	//init
	@Override
	public void init() throws ServletException {
		
		try {
			
		    Context initContext = new InitialContext();
		    Context envContext  = (Context)initContext.lookup("java:/comp/env");
		    dataSource = (DataSource)envContext.lookup("jdbc/HikariDataSource");  
		    conn = dataSource.getConnection();
		    System.out.println("Connection : "+ conn);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//service
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("DB CONNECTION : " + conn);
	}
}
