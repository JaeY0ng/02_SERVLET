package Domain.Common.Service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import Domain.Common.DAO.UserDAOImpl;
import Domain.Common.DAO.ConnectionPool.ConnectionPool;
import Domain.Common.DTO.UserDTO;

public class UserServiceImpl {

	//
	private UserDAOImpl userDaoImpl;

	
	private ConnectionPool connectionPool;
	
	//싱글톤 패턴 코드(추가해주세요 - )
	private UserServiceImpl() throws Exception{
		userDaoImpl = UserDAOImpl.getInstance();
		this.connectionPool = ConnectionPool.getInstance();
		
	}
	
	private static UserServiceImpl instance;
	public static UserServiceImpl getInstance() throws Exception {
		if(instance==null)
			instance = new UserServiceImpl();
		return instance;
	}
	
	//CRUD
	//회원가입 함수명(1)
	public boolean memberJoin(UserDTO userDto) throws Exception {
		//비즈니스 유효성 체크 항목 고려
		return userDaoImpl.insert(userDto) > 0;
	}
	

	//로그인
	public Map<String, Object> login(UserDTO userDto, HttpSession session) throws Exception {
		//TX Start
		Map<String,Object> returnValue=null;
		try {
				connectionPool.beginTransaction();
				returnValue = new HashMap();
				
				//로그인 상태인지 여부 확인
				String username = (String)session.getAttribute("username");
				String role = (String)session.getAttribute("role");
				
				if(username!=null || role!=null) {
					returnValue.put("success", false);
					returnValue.put("message", "로그인된 상태입니다.");
					return returnValue;
				}
				
				
				//요청한 username 과 동일한 계정이 있는지확인(tbl_user)
				UserDTO dbUserDto = userDaoImpl.select(userDto.getUsername());
				if(dbUserDto==null) {
					returnValue.put("success", false);
					returnValue.put("message", "계정이 존재하지 않습니다.");
					return returnValue;	
				}
				
				//요청한 password 가 db에 저장된 password와 동일한지 확인
				String pw = userDto.getPassword();
				String dbPw = dbUserDto.getPassword();
				if(!pw.equals(dbPw)) {
					returnValue.put("success", false);
					returnValue.put("message", "패스워드가 일치하지 않습니다.");
					return returnValue;		
				}
				
				//session객체 생성후 table 저장
				session.setAttribute("username", username);
				session.setAttribute("role", dbUserDto.getRole());
				
				//sessionId를 반환
				returnValue.put("success", true);
				returnValue.put("message", "로그인 성공!");
				
				connectionPool.commitTransaction();
		}catch(Exception e) {
			connectionPool.rollbackTransaction();
			throw e;
		}
		return returnValue;
	}
	
	
	
//	
//	public Map<String,Object> logout(int sessionId) throws Exception{
//		//TX Start
//		Map<String,Object> returnValue=null;
//		
//		try {
//				connectionPool.beginTransaction();	//tx start
//				returnValue = new HashMap();
//
//				//1
//				SessionDto sessionDto = sessionDaoImpl.select(sessionId);
//				if(sessionDto==null) {
//					returnValue.put("success", false);
//					returnValue.put("message", "로그인상태가 아닙니다");
//					return returnValue;
//				}
//				
//				//2
//				int result = sessionDaoImpl.delete(sessionId);
//				if(result>0) {
//					returnValue.put("success", true);
//					returnValue.put("message", "로그아웃 완료!");
//					
//				}
//				connectionPool.commitTransaction(); //tx end
//				
//				
//		}catch(Exception e) {
//			connectionPool.rollbackTransaction();
//			System.out.println("TEST");
//			throw e;
//		}
//		
//		return returnValue;
//	}
//	
//	
//	public SessionDto getSession(int sessionId) throws Exception{
//		return sessionDaoImpl.select(sessionId);
//	}
	
	//회원수정(2)
	//회원탈퇴(3)
	//회원정보조회(4)
	//회원전체정보조회(5)

	//로그인 함수명(6 - )
	//로그아웃 함수명(7 - )
	//
	

}
