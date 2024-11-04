package Domain.Common.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Domain.Common.DTO.UserDTO;
import Domain.Common.DAO.ConnectionPool.ConnectionItem;
import Domain.Common.DAO.ConnectionPool.ConnectionPool;

public class UserDAOImpl {
	// DBCONN 속성
//	private String id = "root";
//	private String pw = "1234";
//	private String url = "jdbc:mysql://localhost:3306/bookdb";
//
//	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	ConnectionPool connectionPool;

	// 싱글톤 패턴
	private UserDAOImpl() throws Exception {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		conn = DriverManager.getConnection(url, id, pw);
//		System.out.println("UserDAOImpl DB Connection Success");

		this.connectionPool = ConnectionPool.getInstance();
	};

	private static UserDAOImpl instance;

	public static UserDAOImpl getInstance() throws Exception {
		if (instance == null)
			instance = new UserDAOImpl();
		return instance;

	}

	public List<UserDTO> select() throws Exception {
		List<UserDTO> list = new ArrayList();
		ConnectionItem connItem = connectionPool.getConnection();
		Connection conn = connItem.getConn();

		pstmt = conn.prepareStatement("select * from tbl_user");

		rs = pstmt.executeQuery();
		UserDTO dto = null;
		if (rs != null) {
			while (rs.next()) {

				dto = new UserDTO();
				dto.setUsername(rs.getString("username"));
				dto.setPassword(rs.getString("password"));
				dto.setRole(rs.getString("role"));
				dto.setLocked(rs.getBoolean(0));

				list.add(dto);
			}
		}
		return list;
	}

	public UserDTO select(String username) throws Exception {
		ConnectionItem connItem = connectionPool.getConnection();
		Connection conn = connItem.getConn();

		List<UserDTO> list = new ArrayList();

		pstmt = conn.prepareStatement("select * from tbl_user where username=?");
		pstmt.setString(1, username);

		rs = pstmt.executeQuery();
		UserDTO dto = null;
		if (rs != null) {
			if(rs.next()) {
			dto = new UserDTO();
			dto.setUsername(rs.getString("username"));
			dto.setPassword(rs.getString("password"));
			dto.setRole(rs.getString("role"));
			dto.setLocked(rs.getBoolean("isLocked"));
		}
	}
	//Connection Pool code
	connectionPool.releaseConnection(connItem);
	
	rs.close();
	pstmt.close();
	
	return dto;
}

	public int insert(UserDTO dto) throws Exception {
		// Connection Pool code
		ConnectionItem connItem = connectionPool.getConnection();
		Connection conn = connItem.getConn();

		pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?,?)");
		pstmt.setString(1, dto.getUsername());
		pstmt.setString(2, dto.getPassword());
		pstmt.setString(3, dto.getRole());
		pstmt.setBoolean(4, false);

		int result = pstmt.executeUpdate();
		return result;
	}

	public int update(UserDTO dto) throws Exception {
		// Connection Pool code
		ConnectionItem connItem = connectionPool.getConnection();
		Connection conn = connItem.getConn();
		
		pstmt = conn.prepareStatement("update tbl_user set Password=?,Role=?,isLocked=? where Username=?");
		pstmt.setString(1, dto.getPassword());
		pstmt.setString(2, dto.getRole());
		pstmt.setBoolean(3, false);
		pstmt.setString(4, dto.getUsername());

		int result = pstmt.executeUpdate();

		// 자원제거
		pstmt.close();

		return result;
	}

	public int delete(String username) throws Exception {
		// Connection Pool code
		ConnectionItem connItem = connectionPool.getConnection();
		Connection conn = connItem.getConn();
		
		pstmt = conn.prepareStatement("delete from tbl_user where Username=?");
		pstmt.setString(1, username);

		int result = pstmt.executeUpdate();

		// 자원제거
		pstmt.close();

		return result;
	}

}
