package date190109.hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CreateTableDAO {
	
	public CreateTableDAO(String sql, CreateTableView ctv) throws SQLException {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pw = "tiger";
			
			con = DriverManager.getConnection(url, id, pw);
			pstmt = con.prepareStatement(sql);
			
			pstmt.execute();
			JOptionPane.showMessageDialog(ctv, "테이블 생성 성공");
			
		} finally {
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
	}
}
