package date190108;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import kr.co.sist.connection.GetConnection;

/**
 * ResultSetMetaData <br/>
 * ����Ǵ� ��ȸ�������� ����Ͽ� �÷������� ���� �� ����ϴ� interface
 * @author owner
 */
public class UseResultSetMetaData {
	
	public UseResultSetMetaData() throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;

		GetConnection gc = GetConnection.getInstance();
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		
		try {
			con = gc.getConn(url,id,pass);
			
			String selectEmp = "SELECT * FROM emp";
			pstmt = con.prepareStatement(selectEmp);
			rs = pstmt.executeQuery();
			
			rsmd = rs.getMetaData();
			// �÷��� ���� ���
			
			int cnt = rsmd.getColumnCount();
			System.out.println("�÷��� �� : "+ cnt);
			System.out.println("ó�� �÷��� �÷���(Name) : "+rsmd.getColumnName(1));
			System.out.println("ó�� �÷��� �÷���(Label) : "+rsmd.getColumnLabel(1));
			String colType = rsmd.getColumnTypeName(1);
			System.out.println("ó�� �÷��� �������� �� : "+colType);
			int colPrecision = rsmd.getPrecision(1);
			System.out.println("ó�� �÷��� ũ�� : "+colPrecision);
			
			System.out.println("--------------------------------------");
			
			StringBuilder output = new StringBuilder();
			for(int i=1; i<cnt; i++) {
				output
				.append(rsmd.getColumnLabel(i)).append("\t")
				.append(rsmd.getColumnTypeName(i)).append("\t")
				.append(rsmd.getPrecision(i)).append("\n");
			}
			System.out.println(output);
			System.out.println("--------------------------------------");
			
		} finally {
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
	}
	
	public static void main(String[] args) {
		try {
			new UseResultSetMetaData();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
