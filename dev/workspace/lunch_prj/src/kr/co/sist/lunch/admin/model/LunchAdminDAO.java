package kr.co.sist.lunch.admin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.lunch.admin.vo.AdminLoginVO;
import kr.co.sist.lunch.admin.vo.LunchVO;

public class LunchAdminDAO {
	
	private static LunchAdminDAO la_dao;
	
	private LunchAdminDAO() {
		// 1. 드라이버 로딩은 생성자에서 수행
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
	public static LunchAdminDAO getInstance() {
		if (la_dao == null) {
			la_dao = new LunchAdminDAO();
		}
		return la_dao;
	}
	
	public Connection getConnection() throws SQLException {
		// 2. Connection 얻기
		String url = "jdbc:oracle:thin:@211.63.89.144:1521:orcl";
		String user = "scott";
		String password = "tiger";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;
	}
	
	/**
	 * 입력된 도시락 코드, 이미지, 도시락명, 단가 조회
	 * @return
	 * @throws SQLException
	 */
	public List<LunchVO> selectLunch() throws SQLException {
		List<LunchVO> list = new ArrayList<LunchVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1,2
			con = getConnection();
			
			// 3.
			String selectLunch = "SELECT LUNCH_CODE, LUNCH_NAME, IMG, PRICE FROM LUNCH";
			pstmt = con.prepareStatement(selectLunch);
			// 4,5
			rs = pstmt.executeQuery();
			
			LunchVO lv = null;
			while(rs.next()) {
				lv = new LunchVO(rs.getString("LUNCH_CODE"), rs.getString("LUNCH_NAME"),
						rs.getString("IMG"), rs.getInt("PRICE"));
				list.add(lv);
			}
			
		} finally {
			// 6.
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return list;
	}
	
	/*public static void main(String[] args) {
		try {
			System.out.println(new LunchAdminDAO().getInstance().selectLunch());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
	
	/**
	 * ID와 Password를 입력받아 lunch_admin에서 이름을 조회하는 일
	 * @param alvo
	 * @return
	 * @throws SQLException
	 */
	public String login(AdminLoginVO alvo) throws SQLException {
		String adminName = "";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1, 2.
			con = getConnection();
			
			String selectName = "SELECT NAME FROM LUNCH_ADMIN WHERE ID=? AND PASS=?";
			// 3.
			pstmt = con.prepareStatement(selectName);
			// 4.
			pstmt.setString(1, alvo.getId());
			pstmt.setString(2, alvo.getPass());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				adminName = rs.getString("NAME");
			}
			
		} finally {
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return adminName;
	}
}
