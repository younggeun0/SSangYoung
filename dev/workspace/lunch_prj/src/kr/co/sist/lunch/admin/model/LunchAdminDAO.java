package kr.co.sist.lunch.admin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.lunch.admin.view.LunchMainView;
import kr.co.sist.lunch.admin.vo.AdminLoginVO;
import kr.co.sist.lunch.admin.vo.LunchAddVO;
import kr.co.sist.lunch.admin.vo.LunchDetailVO;
import kr.co.sist.lunch.admin.vo.LunchVO;

public class LunchAdminDAO {
	
	private static LunchAdminDAO la_dao;
	
	private LunchAdminDAO() {
		// 1. ����̹� �ε��� �����ڿ��� ����
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
		// 2. Connection ���
		String url = "jdbc:oracle:thin:@211.63.89.144:1521:orcl";
		String user = "scott";
		String password = "tiger";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;
	}
	
	public boolean deleteLunch(String lunchCode) throws SQLException {
		boolean flag = false;

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String deleteLunch = "DELETE FROM LUNCH WHERE LUNCH_CODE=?";
			pstmt = con.prepareStatement(deleteLunch);
			pstmt.setString(1, lunchCode);
			
			int cnt = pstmt.executeUpdate();
			
			if (cnt == 1) {
				flag = true;
			}
			
		} finally {
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return flag;
	}
	
	/**
	 * ���ö� ������ �߰��ϴ� ��
	 * @param lav
	 * @throws SQLException
	 */
	public void insertLunch(LunchAddVO lav) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = getConnection();
			String insertLunch = "INSERT INTO LUNCH(LUNCH_CODE, LUNCH_NAME, IMG, SPEC, PRICE, ID) VALUES(LUNCH_CODE,?,?,?,?,?)";
			pstmt = con.prepareStatement(insertLunch);
			pstmt.setString(1, lav.getLunchName());
			pstmt.setString(2, lav.getImg());
			pstmt.setString(3, lav.getSpec());
			pstmt.setInt(4, lav.getPrice());
			pstmt.setString(5, LunchMainView.adminId);
			
			pstmt.executeUpdate();
			
		} finally {
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
	}
	
	/**
	 * �ԷµǴ� �ڵ忡 ���� ���ö� �������� ��ȸ
	 * @param lunchCode
	 * @return
	 * @throws SQLException
	 */
	public LunchDetailVO selectDetailLunch(String lunchCode) throws SQLException {
		LunchDetailVO ldvo = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String selectDetailVO = "SELECT IMG, LUNCH_NAME, TO_CHAR(INPUT_DATE, 'YYYY-MM-DD') INPUT_DATE, SPEC, PRICE FROM LUNCH WHERE LUNCH_CODE=?";
			pstmt = con.prepareStatement(selectDetailVO);
			pstmt.setString(1, lunchCode);
			
			rs = pstmt.executeQuery();
			// �Էµ� �ڵ�� ��ȸ�� ���ڵ尡 ������ �� VO�� �����ϰ� �� �߰�
			
			if (rs.next()) {
				ldvo = new LunchDetailVO(lunchCode, 
					rs.getString("LUNCH_NAME"), rs.getString("INPUT_DATE"),
					rs.getString("SPEC"),rs.getInt("PRICE"), rs.getString("IMG"));
			}
			
		} finally {
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return ldvo;
	}
	
	/**
	 * �Էµ� ���ö� �ڵ�, �̹���, ���ö���, �ܰ� ��ȸ
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
			String selectLunch = "SELECT LUNCH_CODE, LUNCH_NAME, IMG, PRICE FROM LUNCH ORDER BY LUNCH_CODE DESC";
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
	
	/*public static void main(String[] args) { // �����׽�Ʈ��
		try {
			System.out.println(new LunchAdminDAO().getInstance().selectDetailLunch("L_00000001"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
	
	/**
	 * ID�� Password�� �Է¹޾� lunch_admin���� �̸��� ��ȸ�ϴ� ��
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
