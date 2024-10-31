package Filter;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Type.ROLE;

//user.do /member.do /admin.do
@WebFilter("value={}")
public class PermissionFilter implements Filter {

	Map<String, ROLE> pageGradeMap = new HashMap(); // URL : Permission Value
													// /user.do : 0
													// /member.do : 1
													// /admin.do : 2

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String projectPath = filterConfig.getServletContext().getContextPath();

		pageGradeMap.put(projectPath + "/user.do", Type.ROLE_USER); // 0
		pageGradeMap.put(projectPath + "/member.do", Type.ROLE_MEMBER); // 1
		pageGradeMap.put(projectPath + "/admin.do", Type.ROLE_ADMIN); // 2

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("[Filter] PermissionFilter..Start");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		HttpSession session = req.getSession();
		ROLE myRole = (ROLE) session.getAttribute("role");
		if (myRole == null) {
			resp.sendRedirect(
					req.getContextPath() + "/login.do?message=" + URLEncoder.encode("로그인이 필요한 서비스입니다", "UTF-8"));
			return;
		}
		// role값 존재하는 경우
		String url = req.getRequestURI(); // /PJ/user.do , /PJ/member.do , /PJ/admin.do , etc..
		ROLE pageRole = pageGradeMap.get(url);
		System.out.println("URL : " + url + " pageRole : " + pageRole + " myRole : " + myRole);

		// pageRole<=myRole -> 허용
		if (pageRole.ordinal() > myRole.ordinal()) {
			// pageRole>myRole -> 권한부족(예외페이지로 이동 - Forward / Redirect error.jsp)
			throw new ServletException("해당 권한으로는 접근이 불가능한 페이지 입니다.");
		}

		chain.doFilter(request, response);

		System.out.println("[Filter] PermissionFilter..End");

	}

}
