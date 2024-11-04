package Test;

import org.junit.jupiter.api.Test;

import Domain.Common.DTO.BookDTO;
import Domain.Common.DTO.UserDTO;
import Domain.Common.Service.BookServiceImpl;
import Domain.Common.Service.UserServiceImpl;

class ServiceTests {

	@Test
	void bookServiceTests() throws Exception {
		
		BookServiceImpl service = BookServiceImpl.getInstance();
		service.bookRegistration(new BookDTO(222222,"도서2","출판사2","4455"));
		
	}
	@Test
	void userSeviceTests() throws Exception {
		
		UserServiceImpl service = UserServiceImpl.getInstance();
		service.memberJoin(new UserDTO("bbbb","222","ROLE_MEMBER",false));		
	}

}
