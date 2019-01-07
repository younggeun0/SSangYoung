package date190107.hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

public class RunSelectTable {
	
	public JComboBox<String> setTab() throws SQLException {
		JComboBox<String> jcbTab = new JComboBox<String>();
		jcbTab.addItem("테이블명");
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			
			con = DriverManager.getConnection(url, id, pwd);
			stmt = con.createStatement();
			
			// select distinct table_name from user_tab_cols;
			String sql = "SELECT tname FROM tab";
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				jcbTab.addItem(rs.getString("tname"));
			}
			
		} finally {
			if (rs != null) { rs.close(); }
			if (stmt != null) { stmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return jcbTab;
	}

	public static void main(String[] args) {
		RunSelectTable rst = new RunSelectTable();
		try {
			new SelectTableView(rst.setTab());
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		}
	}
}
