package kr.co.sist.lunch.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.lunch.user.vo.LunchDetailVO;
import kr.co.sist.lunch.user.vo.LunchListVO;
import kr.co.sist.lunch.user.vo.OrderAddVO;
import kr.co.sist.lunch.user.vo.OrderInfoVO;
import kr.co.sist.lunch.user.vo.OrderListVO;

/**
 * 도시락 주문자에 대한 DB처리 
 * @author owner
 */
public class LunchClientDAO {
	
	private static LunchClientDAO lc_dao;
	
	private LunchClientDAO() {
		
		try {
			// 1.
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
	public static LunchClientDAO getInstance() {
		if (lc_dao == null) {
			lc_dao = new LunchClientDAO();
		}
		return lc_dao;
	}
	
	public Connection getConn() throws SQLException {
		Connection con = null;
		
		String url = "jdbc:oracle:thin:@211.63.89.144:1521:orcl";
		String user = "scott";
		String password = "tiger";

		con = DriverManager.getConnection(url, user, password);
		
		return con;
	}
	
	/**
	 * DB에 추가된 모든 도시락 목록 조회
	 * @return
	 * @throws SQLException
	 */
	public List<LunchListVO> selectLunchList() throws SQLException {
		List<LunchListVO> list = new ArrayList<LunchListVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConn();
			
			String selectLunchList
			 = "SELECT LUNCH_CODE, LUNCH_NAME, IMG, SPEC FROM LUNCH ORDER BY LUNCH_CODE DESC";
			
			pstmt = con.prepareStatement(selectLunchList);
			
			rs = pstmt.executeQuery();
			
			LunchListVO llvo = null;
			while(rs.next()) {
				llvo = new LunchListVO(rs.getString("IMG"), rs.getString("LUNCH_CODE"),
						rs.getString("LUNCH_NAME"), rs.getString("SPEC"));
				list.add(llvo);
			}
			
		} finally {
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return list;
	}
	
	/**
	 * 도시락의 상세정보 조회
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
			
			con = getConn();
			String selectDetailLunch = 
					"SELECT LUNCH_NAME, IMG, SPEC, PRICE FROM LUNCH WHERE LUNCH_CODE=?";
			pstmt = con.prepareStatement(selectDetailLunch);	
			pstmt.setString(1, lunchCode);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
 				ldvo = new LunchDetailVO(lunchCode,
						rs.getString("LUNCH_NAME"), rs.getString("IMG"),
						rs.getString("SPEC"), rs.getInt("PRICE"));
			}
			
		} finally {
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return ldvo;
	}
	
	public boolean insertOrder(OrderAddVO oavo) throws SQLException {
		boolean flag = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			con = getConn();
			StringBuilder insertOrder = new StringBuilder();
			
			insertOrder.append("INSERT INTO ordering(order_num, order_name, phone, ip_address, lunch_code, quan)")
			.append("VALUES(order_code,?,?,?,?,?)");
			
			pstmt = con.prepareStatement(insertOrder.toString());
			pstmt.setString(1, oavo.getOrderName());
			pstmt.setString(2, oavo.getPhone());
			pstmt.setString(3, oavo.getIpAddress());
			pstmt.setString(4, oavo.getLunchCode());
			pstmt.setInt(5, oavo.getQuan());
			
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
	
	/*public static void main(String[] args) {
		LunchClientDAO lc_dao = LunchClientDAO.getInstance();
		try {
			System.out.println(lc_dao.insertOrder(new OrderAddVO("영근쓰", "010-2222-3333", "211.63.89.144", "L_00000002", 3)));
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}*/
	
	
	public List<OrderListVO> selectOrder(OrderInfoVO oivo) throws SQLException {
		List<OrderListVO> list = new ArrayList<OrderListVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
		} finally {
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
		return list;
	}
}
