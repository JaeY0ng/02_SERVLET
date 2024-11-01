package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.Book.BookAddController;
import Controller.Book.BookListController;

/*@WebServlet("/*")*/
//			/* : 모든 요청 처리(모든경로(정적자원,/WEB-INF..))
//			/  : 모든 요청 처리(프로젝트 경로 기준, 여기는 /09_MVC_INIT 을 기준으로 하는 요청만 처리)
// 				 정적 자원 요청은 x , /WEB-INF/ 경로도 x
public class FrontController extends HttpServlet {

	private Map<String, SubController> map = new HashMap();

	public FrontController() throws ServletException {
		System.out.println("[FC] FrontController()...");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("[FC] init()...");
		// 요청 API 에 따른 SubController 저장

		String path = config.getServletContext().getContextPath();
		//HOME
		map.put(path+"/", new HomeController());
		
		//BOOK
		map.put(path + "/book/add", new BookAddController());
		map.put(path + "/book/list", new BookListController());
		map.put(path + "/book/update", null);
		map.put(path + "/book/delete", null);
		map.put(path + "/book/getAll", null);
		//USER
		map.put(path + "/user/join", null);
		map.put(path + "/user/myinfo", null);
		map.put(path + "/user/remove", null);
		map.put(path + "/user/login", null);
		map.put(path + "/user/logout", null);
	}
	
	
	
	// View - 로 부터의 요청 처리
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[FC] execute()...");
		String endPoint = req.getRequestURI(); // 사용자의 요청EP를 확인(/book, /user)
		SubController controller = map.get(endPoint); // 요청사항을 처리 할 SubController get
		controller.execute(req,resp); //
	}

	
	
}
