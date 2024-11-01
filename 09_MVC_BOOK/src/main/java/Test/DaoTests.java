package Test;

import java.util.List;

import org.junit.jupiter.api.Test;

import Domain.Common.DAO.BookDAOImpl;
import Domain.Common.DTO.BookDTO;

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

}
