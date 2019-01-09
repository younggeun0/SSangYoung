package date190109;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 * Procedure ȣ��
 * @author owner
 */
public class UseCallableStatement {

	public UseCallableStatement() throws SQLException {
		
		Connection con = null;
		CallableStatement cstmt = null;
		
		String tempData = JOptionPane.showInputDialog("���� 2�� �Է�\n��) ����,����");
		String[] numbers = tempData.split(",");
		
		if (numbers.length != 2) {
			JOptionPane.showMessageDialog(null, "�� ���� ���� �Է����ּ���.");
			return;
		}
		
		int num1 = 0, num2 = 0;
		
		try {
			num1 = Integer.parseInt(numbers[0]);
			num2 = Integer.parseInt(numbers[1]);
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "���ڸ� �Է����ּ���.");
		}
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";
			
			// 2.
			con = GetConnection.getInstance().getConn(url, id, pass);
			
			// 3. 
			cstmt = con.prepareCall("{ call proc_plus(?,?,?) }");
			
			// 4. ���ε� ������ �� ����
			// in parameter
			cstmt.setInt(1, num1);
			cstmt.setInt(2, num2);
			
			// out parameter
			cstmt.registerOutParameter(3, Types.NUMERIC);
			
			// 5. ����(Procedure) ���� �� ��� ���
			// ���ν��� �����ϸ� in parameter�� out parameter�� �� �Ҵ�
			
			cstmt.execute();
			
			int total = cstmt.getInt(3);
			
			JOptionPane.showMessageDialog(null, num1+" + "+num2+" = "+total);
			
			
		} finally {
			if (cstmt != null) { cstmt.close(); }
			if (con != null) { con.close(); }
		}
	}
	
	public static void main(String[] args) {
		
		try {
			new UseCallableStatement();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
