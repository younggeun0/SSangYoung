package date190108;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import kr.co.sist.connection.GetConnection;

/**
 * ResultSetMetaData <br/>
 * 실행되는 조회쿼리문을 사용하여 컬럼정보를 얻을 때 사용하는 interface
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
			// 컬럼의 정보 얻기
			
			int cnt = rsmd.getColumnCount();
			System.out.println("컬럼의 수 : "+ cnt);
			System.out.println("처음 컬럼의 컬럼명(Name) : "+rsmd.getColumnName(1));
			System.out.println("처음 컬럼의 컬럼명(Label) : "+rsmd.getColumnLabel(1));
			String colType = rsmd.getColumnTypeName(1);
			System.out.println("처음 컬럼의 데이터형 명 : "+colType);
			int colPrecision = rsmd.getPrecision(1);
			System.out.println("처음 컬럼의 크기 : "+colPrecision);
			
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
