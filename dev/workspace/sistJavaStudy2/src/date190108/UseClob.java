package date190108;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.connection.GetConnection;

public class UseClob {
	
	public UseClob() throws SQLException, IOException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		GetConnection gc = GetConnection.getInstance();
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		String selectClob 
		 = "SELECT subject, news, reporter, TO_CHAR(input_date, 'yyyy-mm-dd') input_date FROM test_clob";
		
		BufferedReader br = null;
		
		try {
			con = gc.getConn(url, id, pass);
			pstmt = con.prepareStatement(selectClob);
			
			rs = pstmt.executeQuery();
			
			System.out.println("��ȣ\t����\t�ۼ���\t���\n");
			System.out.println("-----------------------------------------------------");
			int cnt = 1;
			String reporter = "", input_date="";
			StringBuilder news = null;
			String temp = "";
			while(rs.next()) {
				
				reporter = rs.getString("reporter");
				input_date = rs.getString("input_date");
				news = new StringBuilder();
				
				// CLOB �����͸� ��� ���� ��Ʈ�� ����
				br = new BufferedReader(rs.getClob("news").getCharacterStream());
				while((temp = br.readLine()) != null) {
					news.append(temp).append("\n");
				}
				
				System.out.printf("%d\t%s\t%s\t%s\n", cnt, reporter, input_date, news);
				cnt++;
			}
			System.out.println("-----------------------------------------------------");
			
		} finally {
			if (br != null) { br.close(); }
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
	}
	
	public static void main(String[] args) {
		
		try {
			new UseClob();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
