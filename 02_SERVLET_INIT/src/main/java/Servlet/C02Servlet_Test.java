package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


public class C02Servlet_Test extends HttpServlet {

	@Override
	public void init() throws ServletException {
		//
		System.out.println("INIT-2 INVOKE..");
	}
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		//--
		System.out.println("SERVICE-2 INVOKE..");
	}

	@Override
	public void destroy() {
		System.out.println("DESTORY-2 INVOKE..");
	}

	
}