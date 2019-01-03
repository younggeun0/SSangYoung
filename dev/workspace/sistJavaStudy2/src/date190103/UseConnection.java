package date190103;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC(Java DataBase Connectivity)�� ����Ͽ� DBMS�� Connection�� ���
 * @author owner
 */
public class UseConnection {
	public UseConnection() throws SQLException {
		// 1. Driver Loading
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("����̹� �ε� ����");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		// 2. �ε��� ����̹��� ����Ͽ� DB���� Connection ���
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id = "scott";
		String pw = "tiger";
		
		Connection con = null;
		Statement stmt = null;

		try {
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("DB ���� ��� ���� : " + con);
			
			// 3. ������ ������ü ���
			stmt = con.createStatement();
			
			// 4. ������ ���� �� ��� ���
			String insertQuery = "INSERT INTO CP_EMP2(empno,ename,hiredate,sal) "
					+ "VALUES(1234,'������',SYSDATE,3000)";
			int cnt = stmt.executeUpdate(insertQuery);
			System.out.println(cnt+"�� �߰� ����");
			
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			new UseConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
