package date190109;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 * �÷����� �������� ����Ǵ� ���<br>
 * �÷����� �Է¹޾� �ش� �÷������� ��ȸ EMP���̺� ��ȸ �����ȣ�� �÷���()�� �Է¹޾� ��ȸ
 * 
 * @author owner
 */
public class DynamicColumn {

	public DynamicColumn() throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String[] columnName = { "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno" };
		String input = JOptionPane.showInputDialog("�����ȣ�� �÷��� �ϳ��� �Է����ּ���.\n��) �����ȣ,�÷���");
		// CSV - comma separated value

		String[] temp = input.split(",");

		if (temp.length != 2) {
			JOptionPane.showMessageDialog(null, "�Է������� Ȯ���ϼ���.");
			return;
		}

		try {
			int empno = Integer.parseInt(temp[0].trim());
			String inputColumn = temp[1].trim();

			boolean columnFlag = false;

			for (String column : columnName) {
				if (column.equals(inputColumn.toLowerCase())) { // DB���̺��� �÷���� ���� �÷����̶��
					columnFlag = true;
				}
			}

			if (!columnFlag) {
				JOptionPane.showMessageDialog(null, inputColumn + "�� EMP���̺� �÷����� �������� �ʽ��ϴ�.");
				return;
			}

			try {
				
				// 1,2
				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				String id = "scott";
				String pass = "tiger";
				
				con = GetConnection.getInstance().getConn(url, id, pass);

				// �÷����� hiredate�� ��� ���ڿ��� ó���ϱ� ���� TO_CHAR�Լ��� ���. 
				if (inputColumn.equals("hiredate")) {
					inputColumn = "TO_CHAR(hiredate, 'yyyy-mm-dd EEEEE') hiredate";
				}
				
				StringBuilder selectEmp = new StringBuilder();
				
				// �÷���, ���̺���� ���ε庯���� ó�� ���� �ʴ´�. �������� ���� �־� ����Ѵ�.
				selectEmp.append("SELECT ").append(inputColumn).append(" FROM emp ").append("WHERE empno=?");
				
				// 3, 4
				pstmt = con.prepareStatement(selectEmp.toString());
				pstmt.setInt(1, empno);
				
				// 5.
				rs = pstmt.executeQuery();
				
				if (rs.next()) { // �����ȣ�� ��ȸ�� ���ڵ尡 �����Ѵٸ� 
					String stringData = "";
					int intData = 0;
					
					if (temp[1].trim().equals("ename")|| temp[1].trim().equals("job") // String Ÿ��
							||temp[1].trim().equals("hiredate")) {
						stringData = rs.getString(temp[1].trim()); // temp[1].trim()��� 1�� ��밡��
					} else {	// int Ÿ��
						intData = rs.getInt(temp[1].trim());
					}
					JOptionPane.showMessageDialog(null, temp[1]+"���� ��ȸ�� �� : "
							+(intData == 0 ? stringData : intData));
				} else {
					JOptionPane.showMessageDialog(null, "�Է��� �����ȣ�� �������� �ʽ��ϴ�.");
				}
				
				// 6.
			} finally {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			}
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "�����ȣ�� �����̾�� �մϴ�.");
			return;
		} 

	}

	public static void main(String[] args) {
		try {
			new DynamicColumn();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
