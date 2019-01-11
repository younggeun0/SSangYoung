package date190111.namecard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DB Table에 명함 정보를 추가, 모든 명함정보를 조회
 * @author owner
 */
public class NamecardDAO {
	
	private static NamecardDAO n_dao;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs; 
	
	private NamecardDAO() {
	}
	
	public static NamecardDAO getInstance() {
		if (n_dao == null) {
			n_dao = new NamecardDAO();
		}
		return n_dao;
	}
	
	public void insertNamecard(NamecardVO nv) throws SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "tiger";
		
		con = DriverManager.getConnection(url, user, password);
		
		String insertNamecard = 
			"INSERT INTO namecard(name,addr,img) VALUES(?,?,?)";
			
		pstmt = con.prepareStatement(insertNamecard);
		
		pstmt.setString(1, nv.getName());
		pstmt.setString(2, nv.getAddr());
		pstmt.setString(3, nv.getImg());
		
		pstmt.executeUpdate(); // insert는 성공 or 예외
		
		System.out.println("성공");
		close();
	}
	
	public List<NamecardVO> selectAllNamecard() throws SQLException {
		List<NamecardVO> list = new ArrayList<NamecardVO>();
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "tiger";
		
		con = DriverManager.getConnection(url, user, password);
		
		String selectAllNamecard =
			"SELECT name, addr, img FROM namecard ORDER BY input_date";
		pstmt = con.prepareStatement(selectAllNamecard);
		rs = pstmt.executeQuery();

		NamecardVO nv = null;
		while (rs.next()) {
			nv = new NamecardVO(rs.getString("name"), 
					rs.getString("addr"), rs.getString("img"));
			list.add(nv);
		}
		
		close();
		return list;
	}

	public void close() throws SQLException {
		if (rs != null) { rs.close(); }
		if (pstmt != null) { pstmt.close(); }
		if (con != null) { con.close(); }
	}
}

