package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.sist.user.vo.WebMemberVO;

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
	 * DBCP ��� Connection ��� �޼ҵ�
	 * @return Connection ��ü
	 */
	private Connection getConn() {
		Connection con = null;
		
		try {
			// 1. JNDI ��밴ü ����
			Context ctx = new InitialContext();
			
			// 2. DBCP���� DataSource ���
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/dbcp");
			
			// 3. DataSource���� Connection ���
			con = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	/**
	 * ���̵� �����ϴ��� �ߺ� �˻�
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
			// 1. JNDI ��밴ü ����
			// 2. DBCP���� DataSource ���
			// 3. DataSource���� Connection ���
			con = getConn();

			// 4. �������� ��ü ��� 
			String selectId = "SELECT id FROM web_member WHERE id=?";
			pstmt = con.prepareStatement(selectId);
			pstmt.setString(1, id);
			
			// 5. ���� ���� ��� ���
			rs = pstmt.executeQuery();
			
			flag = !rs.next(); // ��ȸ�Ǵ°� �ִ��� ������ ���θ� �Ǵ�
			
		} finally {
			// 6. ���� ����
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
		return flag;
	}
	
	/**
	 * �Էµ� ȸ�� ������ ������ DB�� �߰��ϴ� ��
	 * @param wm_vo
	 * @throws SQLException
	 */
	public void insertMember(WebMemberVO wm_vo) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConn();
			StringBuilder insertMember = new StringBuilder();
			
			insertMember
			.append(" insert into web_member(id,pass,name,ssn,gender,birth,age,marriage ")
			.append(" ,marriage_date,zipcode,addr1,addr2,greeting,ip_addr) ")
			.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			
			// 4.
			pstmt = con.prepareStatement(insertMember.toString());
			pstmt.setString(1, wm_vo.getId());
			pstmt.setString(2, wm_vo.getPass());
			pstmt.setString(3, wm_vo.getName());
			pstmt.setString(4, wm_vo.getSsn());
			pstmt.setString(5, wm_vo.getGender());
			pstmt.setString(6, wm_vo.getBirth());
			pstmt.setString(7, wm_vo.getAge());
			pstmt.setString(8, wm_vo.getMarriage());
			pstmt.setString(9, wm_vo.getMarriage_date());
			pstmt.setString(10, wm_vo.getZipcode());
			pstmt.setString(11, wm_vo.getAddr1());
			pstmt.setString(12, wm_vo.getAddr2());
			pstmt.setString(13, wm_vo.getGreeting());
			pstmt.setString(14, wm_vo.getIp_addr());
			
			// 5.
			pstmt.executeUpdate();
			
			String[] lang = wm_vo.getLang();
			
			if (lang != null) { // ���� �� �����ߴٸ�
				pstmt.close();
				
				StringBuilder insertLang = new StringBuilder();
				insertLang
				.append(" insert into web_lang(id, lang) ")
				.append(" values(?, ?) ");
				
				// 4, 5 ��° �۾��� ������ ����(���ɾ� �������̹Ƿ�)
				// 4.
				pstmt = con.prepareStatement(insertLang.toString());
				for(int i=0; i<wm_vo.getLang().length; i++) {
					pstmt.setString(1, wm_vo.getId());
					pstmt.setString(2, wm_vo.getLang()[i]);
					
					// 5.
					pstmt.executeUpdate();
				}
			}
			
		} finally {
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
	}
}
