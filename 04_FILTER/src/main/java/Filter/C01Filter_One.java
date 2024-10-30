package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/main.do")
public class C01Filter_One implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		//Request전 처리코드
		System.out.println("[FILTER] FILTER_ONE START");
		chain.doFilter(req, resp); // 관련된 체인들을 넘어가다가 더 이상 넘어갈 체인 이 없으면 req로 넘어감
		//Response 후 처리코드
		System.out.println("[FILTER] FILTER_ONE END...");
	}
	
}
