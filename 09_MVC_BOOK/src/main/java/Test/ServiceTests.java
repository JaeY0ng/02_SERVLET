package Test;

import org.junit.jupiter.api.Test;

import Domain.Common.DTO.BookDTO;
import Domain.Common.Service.BookServiceImpl;

class ServiceTests {

	@Test
	void bookServiceTests() throws Exception {
		
		BookServiceImpl service = BookServiceImpl.getInstance();
		service.bookRegistration(new BookDTO(222222,"도서2","출판사2","4455"));
		
	}

}
