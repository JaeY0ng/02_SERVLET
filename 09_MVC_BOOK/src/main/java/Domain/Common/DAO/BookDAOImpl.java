package Domain.Common.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.Common.DAO.ConnectionPool.ConnectionItem;
import Domain.Common.DAO.ConnectionPool.ConnectionPool;
import Domain.Common.DTO.BookDTO;



public class BookDAOImpl {
	//DBCONN 속성
//	private String id="root";
//	private String pw="1234";
//	private String url="jdbc:mysql://localhost:3306/bookDB";
//	
//	private Connection conn ;

	
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private ConnectionPool connectionPool;
	private ConnectionItem connItem;
	

	
	
	//싱글톤 패턴 처리코드
	private BookDAOImpl() throws SQLException, ClassNotFoundException {
	
		connectionPool = ConnectionPool.getInstance();
	};
	
	private static BookDAOImpl instance = null;
	public static BookDAOImpl getInstance() throws ClassNotFoundException, SQLException {
		if(instance == null)
			instance = new BookDAOImpl();
		return instance;
	}
	
	//CRUD 
	public List<BookDTO> select() throws Exception{
		
		List<BookDTO> list = new ArrayList();
		
		//Connection Pool code
		connItem = connectionPool.getConnection();
		Connection conn = connItem.getConn();
		pstmt = conn.prepareStatement("select * from tbl_book");
		
		rs = pstmt.executeQuery();
		BookDTO dto=null;
		if(rs!=null) {
			while(rs.next()) {
				dto = new BookDTO();
				dto.setBookCode(rs.getLong("bookCode"));
				dto.setBookName(rs.getString("bookName"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setIsbn(rs.getString("isbn"));
				
				list.add(dto);
			}
		}
		//Connection Pool code
		connectionPool.releaseConnection(connItem);
		
		return list;
	}
	
	public BookDTO select(long bookCode) throws Exception{
		
		//Connection Pool code
		connItem = connectionPool.getConnection();
		Connection conn = connItem.getConn();
		
		pstmt = conn.prepareStatement("select * from tbl_book where bookCode=?");
		pstmt.setLong(1, bookCode);
		
		rs = pstmt.executeQuery();
		BookDTO dto=null;
		if(rs!=null) {
			
			if(rs.next()) {
				dto = new BookDTO();
				dto.setBookCode(rs.getLong("bookCode"));
				dto.setBookName(rs.getString("bookName"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setIsbn(rs.getString("isbn"));
			}
			
		}
		
		//Connection Pool code
		connectionPool.releaseConnection(connItem);
		
		rs.close();
		pstmt.close();
		
		return dto;
	}


	public int insert(BookDTO dto) throws Exception{
		
		//Connection Pool code
		connItem = connectionPool.getConnection();
		Connection conn = connItem.getConn();
		
		pstmt = conn.prepareStatement("insert into tbl_book values(?,?,?,?)");
		pstmt.setLong(1,dto.getBookCode());
		pstmt.setString(2, dto.getBookName());
		pstmt.setString(3, dto.getPublisher());
		pstmt.setString(4, dto.getIsbn());
		
		int result =  pstmt.executeUpdate();
		
		//자원제거
		pstmt.close();
		//Connection Pool code
		connectionPool.releaseConnection(connItem);
		
		return result;
	}

	public int update(BookDTO dto) throws Exception{
		//Connection Pool code
		connItem = connectionPool.getConnection();
		Connection conn = connItem.getConn();
		
		pstmt = conn.prepareStatement("update tbl_book set bookName=?,publisher=?,isbn=? where bookCode=?");
		pstmt.setString(1, dto.getBookName());
		pstmt.setString(2, dto.getPublisher());
		pstmt.setString(3, dto.getIsbn());
		pstmt.setLong(4,dto.getBookCode());
		
		int result =  pstmt.executeUpdate();
		
		//자원제거
		pstmt.close();
		//Connection Pool code
		connectionPool.releaseConnection(connItem);
		
		return result;
		
	}
	
	public int delete(long bookCode) throws Exception {
		
		//Connection Pool code
		connItem = connectionPool.getConnection();
		Connection conn = connItem.getConn();
		
		pstmt = conn.prepareStatement("delete from tbl_book where bookCode=?");
		pstmt.setLong(1,bookCode);
		
		int result =  pstmt.executeUpdate();
		
		//자원제거
		pstmt.close();
		//Connection Pool code
		connectionPool.releaseConnection(connItem);
		
		return result;
	}

	public List<BookDTO> select(int offset, int amount) throws Exception{
		List<BookDTO> list = new ArrayList();
		
		//Connection Pool code
		connItem = connectionPool.getConnection();
		Connection conn = connItem.getConn();
		pstmt = conn.prepareStatement("SELECT * FROM bookdb.tbl_book order by bookcode desc limit ?,?");
		pstmt.setInt(1, offset);
		pstmt.setInt(2, amount);
		
		rs = pstmt.executeQuery();
		BookDTO dto=null;
		if(rs!=null) {
			while(rs.next()) {
				dto = new BookDTO();
				dto.setBookCode(rs.getLong("bookCode"));
				dto.setBookName(rs.getString("bookName"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setIsbn(rs.getString("isbn"));
				
				list.add(dto);
			}
		}
		//Connection Pool code
		connectionPool.releaseConnection(connItem);
		
		return list;
	}
	
	
	public int count() throws Exception{
		
		//Connection Pool code
		connItem = connectionPool.getConnection();
		Connection conn = connItem.getConn();
		int cnt=0;
		pstmt = conn.prepareStatement("select count(*) from tbl_book");
		rs = pstmt.executeQuery();
		
		if(rs!=null) {	
			if(rs.next()) {
				cnt= rs.getInt(1);
			}	
		}
		//Connection Pool code
		connectionPool.releaseConnection(connItem);
		
		rs.close();
		pstmt.close();
		
		return cnt;
	}


	
}
