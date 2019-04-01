package ajax0401;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class WebMemberDAO {
	
	private static WebMemberDAO wm_dao;
	
	private WebMemberDAO() {
		
	}
	
	public static WebMemberDAO getInstance() {
		if (wm_dao == null) {
			wm_dao = new WebMemberDAO();
		}
		
		return wm_dao;
	}
	
	/**
	 * DBCP 사용 Connection 얻는 메소드
	 * @return Connection 객체
	 */
	private Connection getConn() {
		Connection con = null;
		
		try {
			// 1. JNDI 사용객체 생성
			Context ctx = new InitialContext();
			
			// 2. DBCP에서 DataSource 얻기
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/jsp_dbcp");
			
			// 3. DataSource에서 Connection 얻기
			con = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	/**
	 * 아이디가 존재하는지 중복 검사
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean selectId(String id) throws SQLException {
		boolean flag = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1. JNDI 사용객체 생성
			// 2. DBCP에서 DataSource 얻기
			// 3. DataSource에서 Connection 얻기
			con = getConn();

			// 4. 쿼리수행 객체 얻기 
			String selectId = "SELECT id FROM web_member WHERE id=?";
			pstmt = con.prepareStatement(selectId);
			pstmt.setString(1, id);
			
			// 5. 쿼리 실행 결과 얻기
			rs = pstmt.executeQuery();
			
			flag = !rs.next(); // 조회되는게 있는지 없는지 여부만 판단
			
		} finally {
			// 6. 연결 끊기
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
		return flag;
	}
}
