package date190110.create_table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.connection.GetConnection;

public class RunCreateTableView {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<String> getTabNames() throws SQLException {
		List<String> listTabNames = new ArrayList<String>();
		
		con = GetConnection.getInstance()
				.getConn("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		
		String sql = "SELECT tname FROM tab";
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			listTabNames.add(rs.getString("tname"));
		}
			
		close();
		return listTabNames;
	}
	
	public void close() throws SQLException {
		if (rs != null) { rs.close(); }
		if (pstmt != null) { pstmt.close(); }
		if (con != null) { con.close(); }
	}
	

	public static void main(String[] args) {
		
		try {
			List<String> listTabNames = new RunCreateTableView().getTabNames();
			new CreateTableView(listTabNames);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
