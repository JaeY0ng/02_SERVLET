package Db;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/dataSource")
public class C02DataSource extends HttpServlet {

	private DataSource dataSource;
	private Connection conn;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {

		try {

			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/MysqlDB");
			conn = dataSource.getConnection();
			System.out.println("Connection : " + conn);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
