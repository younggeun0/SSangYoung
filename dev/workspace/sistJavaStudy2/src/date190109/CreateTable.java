package date190109;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 * DDL (Data Definition Language) : CREATE, DROP, TRUNCATE
 * @author owner
 */
public class CreateTable {

	public CreateTable() throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// thin드라이버 한계상 프로시저, 함수 등은 만들 수 없다.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";

			con = GetConnection.getInstance().getConn(url, id, pass);

			// 3.4.5 은 여러번 사용가능(쿼리문 생성객체 얻고 바인드변수 설정, 연결끊기)
			// pstmt 여러번 연결 끊기 또는 pstmt를 여러개 만들어서 처리할 수 있다.
			String tableName = JOptionPane.showInputDialog("생성할 테이블명을 입력");
			
			StringBuilder selectTname = new StringBuilder();
			selectTname.append("SELECT tname FROM tab WHERE tname=?");
			// 4.
			pstmt = con.prepareStatement(selectTname.toString());
			pstmt.setString(1, tableName.toUpperCase());
			
			rs = pstmt.executeQuery();
			
			boolean flag = false; 
			
			if (rs.next()) {
				flag = 
					JOptionPane.showConfirmDialog(null, 
						"테이블이 존재합니다. 삭제한 후 생성하시겠습니까?") == JOptionPane.OK_OPTION;
			}
			// 5.
			pstmt.close(); // pstmt를 끊고 재사용 하도록 한다. 안끊으면 메모리 누수 발생 가능
			
			if (flag) { // 테이블을 삭제한 후 다시 테이블 생성
				// 3.
				StringBuilder dropTable = new StringBuilder();
				dropTable.append("DROP TABLE ").append(tableName);
				
				pstmt = con.prepareStatement(dropTable.toString());
				// 4.
				pstmt.execute();
				// 5.
				pstmt.close();
			}
			
			StringBuilder createTable = new StringBuilder();
			
			createTable
			.append(" CREATE TABLE ").append(tableName).append("(")
			.append(" 	name VARCHAR2(12) NOT NULL, ")
			.append(" 	age	NUMBER(3) NOT NULL, ")
			.append("   id VARCHAR2(20) CONSTRAINT pk_").append(tableName).append(" PRIMARY KEY)");
			
			pstmt = con.prepareStatement(createTable.toString());
			
			// 수행된 결과는 항상 false가 반환되나 잘 생성된다. 
			pstmt.execute(); 
			JOptionPane.showMessageDialog(null, "테이블이 생성되었습니다.");
			
		} finally {
			if (rs != null) { rs.close(); }
			if (con != null) { con.close(); }
			if (pstmt != null) { pstmt.close(); }
		}
	}
	
	public static void main(String[] args) {
		try {
			new CreateTable();
		} catch (SQLException e) {
			// 테이블이 존재할 땐 예외처리
			JOptionPane.showMessageDialog(null, "테이블이 이미 존재합니다.");
			e.printStackTrace();
		}
	}
}
