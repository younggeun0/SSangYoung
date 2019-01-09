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
			// thin����̹� �Ѱ�� ���ν���, �Լ� ���� ���� �� ����.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";

			con = GetConnection.getInstance().getConn(url, id, pass);

			// 3.4.5 �� ������ ��밡��(������ ������ü ��� ���ε庯�� ����, �������)
			// pstmt ������ ���� ���� �Ǵ� pstmt�� ������ ���� ó���� �� �ִ�.
			String tableName = JOptionPane.showInputDialog("������ ���̺���� �Է�");
			
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
						"���̺��� �����մϴ�. ������ �� �����Ͻðڽ��ϱ�?") == JOptionPane.OK_OPTION;
			}
			// 5.
			pstmt.close(); // pstmt�� ���� ���� �ϵ��� �Ѵ�. �Ȳ����� �޸� ���� �߻� ����
			
			if (flag) { // ���̺��� ������ �� �ٽ� ���̺� ����
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
			
			// ����� ����� �׻� false�� ��ȯ�ǳ� �� �����ȴ�. 
			pstmt.execute(); 
			JOptionPane.showMessageDialog(null, "���̺��� �����Ǿ����ϴ�.");
			
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
			// ���̺��� ������ �� ����ó��
			JOptionPane.showMessageDialog(null, "���̺��� �̹� �����մϴ�.");
			e.printStackTrace();
		}
	}
}
