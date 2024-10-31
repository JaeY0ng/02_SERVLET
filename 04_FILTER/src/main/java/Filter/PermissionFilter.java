package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//user.do /member.do /admin.do
public class PermissionFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//
		System.out.println("[FIlter] PermissionFilter..Start");
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		String role = (String)session.getAttribute("role");
		if(role==null) {
			resp.sendRedirect(req.getContextPath()+"/login.do");
			return;
	}
		
		chain.doFilter(request, response);

		System.out.println("[FIlter] PermissionFilter..End");
	}

}
