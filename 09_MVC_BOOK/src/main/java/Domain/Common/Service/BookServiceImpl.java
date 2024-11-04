package Domain.Common.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Domain.Common.DAO.BookDAOImpl;
import Domain.Common.DAO.ConnectionPool.ConnectionPool;
import Domain.Common.DTO.BookDTO;
import Domain.Common.DTO.Criteria;
import Domain.Common.DTO.PageDTO;

public class BookServiceImpl {
	
	//BookDao 연결
	private BookDAOImpl bookDaoImpl;
	
	//UserService 연결
	//private UserServiceImpl userServiceImpl;
	
	//ConnectionPool
	private ConnectionPool connectionPool;
	
	//싱글톤 패턴 처리코드
	private BookServiceImpl() throws Exception {
		System.out.println("[SERVICE] BookServiceImpl()..");
		bookDaoImpl = BookDAOImpl.getInstance();
		//TX
		this.connectionPool = ConnectionPool.getInstance();
		//
		//this.userServiceImpl = userServiceImpl.getInstance();

	};
	private static BookServiceImpl instance;
	public static BookServiceImpl getInstance() throws Exception {
		if(instance==null)
			instance = new BookServiceImpl();
		return instance;
	}
	
	//도서등록
	public Map<String,Object> bookRegistration(BookDTO dto) throws Exception{

		Map<String,Object> returnValue = new HashMap();
		int result=0;
		try {
			connectionPool.beginTransaction(); //tx start
//			
//			//
//			SessionDto sessionDto =  userServiceImpl.getSession(sessionId);
//			if(sessionDto==null) {
//				returnValue.put("success", false);
//				returnValue.put("message", "로그인이 필요한 서비스입니다.");	
//			}else{
//				
//				String role = sessionDto.getRole(); 
//				//ROLE_MEMBER인지 확인
//				if(!"ROLE_MEMBER".equals(role)) {
//					returnValue.put("success", false);
//					returnValue.put("message", "사서계정권한이 필요합니다.");			
//				}
//				else {
//					//사서권한 확인(ROLE_MEMBER)
//					BookDto dbBookDto = bookDaoImpl.select(dto.getBookCode());
//					if(dbBookDto!=null) {
//						returnValue.put("success", false);
//						returnValue.put("message", "동일 도서가 존재합니다.");					
//					}else {
						
					  result = bookDaoImpl.insert(dto);
					  if(result>0) {
							returnValue.put("success", true);
							returnValue.put("message", "도서등록 완료!"); 				  
					  }
//							
//					  else {
//							returnValue.put("success", false);
//							returnValue.put("message", "도서등록 실패.. 관리자에게 문의하세요"); 		  
//					  }
//						
//					  
//					}
//					
//					
//				}
//				
//			}
	
			connectionPool.commitTransaction(); //tx end
		
		}catch(Exception e) {
			connectionPool.rollbackTransaction();//
			throw e;
		}
		

		return returnValue;
	}
	
	
	
	//도서내용수정
	
	public boolean bookUpdate(BookDTO dto) throws Exception {
		
		return bookDaoImpl.update(dto) > 0;
	}
	//도서삭제
	
	public boolean bookRemove(long bookCode) throws Exception {
		return bookDaoImpl.delete(bookCode) > 0;
	}
	
	//도서 조회(단건 - BookDto)
	public BookDTO getBook(long bookCode) throws Exception{
		
		return bookDaoImpl.select(bookCode);
	}
	
	
	//도서 조회(다건 - List<BookDto))
	public List<BookDTO> getBooks() throws Exception {
		//Tx
		//페이징처리
		//키워드처리
		return bookDaoImpl.select();
	}

	//조건부검색(Criteria)
public Map<String,Object> getBooks(Criteria criteria)  throws Exception{
		
		Map<String,Object> rvalue = new HashMap();
		// TODO Auto-generated method stub
		List<BookDTO> list = null;
		try {
			connectionPool.beginTransaction();
			
			
			if(criteria.getType()==null ) {
				//전체검색
				int offset = (criteria.getPageno()-1) * criteria.getAmount();		
				list =  bookDaoImpl.select(offset,criteria.getAmount());
				
				//PageDto구하기
				int total = bookDaoImpl.count();
				PageDTO pageDto = new PageDTO(total, criteria);
				System.out.println("TOTAL : " + total);
				System.out.println("pageDto : " + pageDto);
				rvalue.put("list", list);
				rvalue.put("pageDto", pageDto);
				
			}
			
			else {
				
				//전체검색
				int offset = (criteria.getPageno()-1) * criteria.getAmount();		
				list =  bookDaoImpl.select(offset,criteria.getAmount(),criteria.getType(),criteria.getKeyword());
				
				//PageDto구하기
				int total = bookDaoImpl.count(criteria);
				PageDTO pageDto = new PageDTO(total, criteria);
				System.out.println("TOTAL : " + total);
				System.out.println("pageDto : " + pageDto);
				rvalue.put("list", list);
				rvalue.put("pageDto", pageDto);	
	
			}
			
			
			
			connectionPool.commitTransaction();
			
		}catch(SQLException e) {
			connectionPool.rollbackTransaction();
			throw new Exception(e);
		}
		
		return rvalue;
	}
	
	


}
