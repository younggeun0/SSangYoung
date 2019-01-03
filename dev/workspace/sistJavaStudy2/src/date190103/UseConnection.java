package date190103;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC(Java DataBase Connectivity)를 사용하여 DBMS의 Connection을 얻기
 * @author owner
 */
public class UseConnection {
	public UseConnection() throws SQLException {
		// 1. Driver Loading
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		// 2. 로딩된 드라이버를 사용하여 DB연동 Connection 얻기
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id = "scott";
		String pw = "tiger";
		
		Connection con = null;
		Statement stmt = null;

		try {
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("DB 연결 얻기 성공 : " + con);
			
			// 3. 쿼리문 생성객체 얻기
			stmt = con.createStatement();
			
			// 4. 쿼리문 실행 후 결과 얻기
			String insertQuery = "INSERT INTO CP_EMP2(empno,ename,hiredate,sal) "
					+ "VALUES(1234,'공선의',SYSDATE,3000)";
			int cnt = stmt.executeUpdate(insertQuery);
			System.out.println(cnt+"건 추가 성공");
			
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
