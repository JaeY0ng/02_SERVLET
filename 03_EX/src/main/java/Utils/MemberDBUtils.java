package Utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import DTO.MemberDTO;

public class MemberDBUtils {

	private static String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static String id = "system";
	private static String pw = "1234";

	public static Connection conn;
	public static PreparedStatement pstmt;
	public static ResultSet rs;

	public static void conn() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection(url, id, pw);
	}

	public static void insert(MemberDTO dto) throws Exception {
		pstmt = conn.prepareStatement("insert into member_tbl_02 values(?,?,?,?,?,?,?)");
		pstmt.setInt(1, dto.getCustno());
		pstmt.setString(2, dto.getCustname());
		pstmt.setString(3, dto.getPhone());
		pstmt.setString(4, dto.getAddress());
		pstmt.setDate(5, Date.valueOf(dto.getJoinDate()));
		pstmt.setString(6, dto.getGrade() + "");
		pstmt.setString(7, dto.getCity());

		int result = pstmt.executeUpdate();

	}

	public static void update(MemberDTO dto) throws Exception {
//		pstmt = conn.prepareStatement("insert into member_tbl_02 values(?,?,?,?,?,?,?)");
		pstmt = conn.prepareStatement("update member_tbl_02 set custname=?, phone=?, address=?, joindate=?, grade=?, city=? where custno=?");
		
		pstmt.setString(1, dto.getCustname());
		pstmt.setString(2, dto.getPhone());
		pstmt.setString(3, dto.getAddress());
		pstmt.setDate(4, Date.valueOf(dto.getJoinDate()));
		pstmt.setString(5, dto.getGrade() + "");
		pstmt.setString(6, dto.getCity());
		pstmt.setInt(7, dto.getCustno());

		int result = pstmt.executeUpdate();
	}

	public static void delete() throws Exception {
	}

	public static MemberDTO select(int custno) throws Exception {
		MemberDTO dto = null;
		pstmt = conn.prepareStatement("select * from member_tbl_02 where custno=" + custno);
		rs = pstmt.executeQuery();
		if (rs != null) {
			if (rs.next()) {
				dto = new MemberDTO();
				dto.setCustno(rs.getInt("custno"));
				dto.setCustname(rs.getString("custname"));
				dto.setPhone(rs.getString("phone"));
				dto.setAddress(rs.getString("address"));
				dto.setJoinDate(rs.getDate("joindate").toLocalDate());
				dto.setGrade(rs.getString("grade").charAt(0));
				dto.setCity(rs.getString("city"));

			}
		}
		return dto;
	}

	public static List<MemberDTO> select() throws Exception {
		List<MemberDTO> list = new ArrayList();
		MemberDTO dto = null;
		pstmt = conn.prepareStatement("select * from member_tbl_02");
		rs = pstmt.executeQuery();
		if (rs != null) {

			while (rs.next()) {
				dto = new MemberDTO();
				dto.setCustno(rs.getInt("custno"));
				dto.setCustname(rs.getString("custname"));
				dto.setPhone(rs.getString("phone"));
				dto.setAddress(rs.getString("address"));
				dto.setJoinDate(rs.getDate("joindate").toLocalDate());
				dto.setGrade(rs.getString("grade").charAt(0));
				dto.setCity(rs.getString("city"));

				list.add(dto);
			}

		}

		return list;

	}

	public static int maxCustno() throws Exception {
		int maxCustno = 0;
		pstmt = conn.prepareStatement("select max(custno) from member_tbl_02");
		rs = pstmt.executeQuery();
		if (rs != null) {
			if (rs.next()) {
				maxCustno = rs.getInt(1);
			}
		}
		return maxCustno;
	}

}
