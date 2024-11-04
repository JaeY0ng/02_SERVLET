package Test;

import java.util.List;

import org.junit.jupiter.api.Test;

import Domain.Common.DAO.BookDAOImpl;
import Domain.Common.DAO.UserDAOImpl;
import Domain.Common.DTO.BookDTO;
import Domain.Common.DTO.UserDTO;







class DaoTests {

	@Test
	void bookDaoCRUDTests() throws Exception {
		
		BookDAOImpl dao = BookDAOImpl.getInstance();	
		
		dao.insert(new BookDTO(112233,"도서도서","출판출판","12-12"));
	}
	
	@Test
	void bookDaoCRUDTests_2() throws Exception {
		
		BookDAOImpl dao = BookDAOImpl.getInstance();	
		List<BookDTO> list = dao.select(40,10);
		list.forEach(System.out::println);
		
	}
	@Test
	void bookDaoCRUDTests_3() throws Exception {
		
		BookDAOImpl dao = BookDAOImpl.getInstance();	
		int cnt = dao.count();
		System.out.println("CNT : " + cnt);
		
	}
	@Test
	public void bookDaoCRUDTests_4() throws Exception{
		
		BookDAOImpl dao = BookDAOImpl.getInstance();
		List<BookDTO> list = dao.select(0,10,"bookCode","11");
		list.forEach(System.out::println);
	}
	@Test
	void userDaoCRUDTests() throws Exception {
		
		UserDAOImpl dao = UserDAOImpl.getInstance();	
		
		dao.insert(new UserDTO("aaa","도서도서","출판출판",false));
	}
	
	
}
