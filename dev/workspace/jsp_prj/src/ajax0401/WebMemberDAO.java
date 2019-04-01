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
	 * DBCP ��� Connection ��� �޼ҵ�
	 * @return Connection ��ü
	 */
	private Connection getConn() {
		Connection con = null;
		
		try {
			// 1. JNDI ��밴ü ����
			Context ctx = new InitialContext();
			
			// 2. DBCP���� DataSource ���
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/jsp_dbcp");
			
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
}
