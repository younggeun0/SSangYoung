package date190110;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 * Transactionó��
 * @author owner
 */
public class TestTransaction {
	
	// commit�� rollback�� DB�۾� �ܺο��� ó���� �� �ֵ���
	// Connection�� class field�� ����.
	private Connection con = null;

	// transaction�� ����� ������ ����ŭ �������ఴü�� ����
	private PreparedStatement pstmt1 = null;
	private PreparedStatement pstmt2 = null;

	public boolean insert(TransactionVO tv) throws SQLException {
		
		boolean flag = false;
		
		// 1.
		// 2.
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";

		con = GetConnection.getInstance().getConn(url, id, pass);

		// auto commit ����
		con.setAutoCommit(false);

		String sql1 = "INSERT INTO test_transaction1(subject, writer) values(?,?)";

		// 3.
		pstmt1 = con.prepareStatement(sql1);
		// 4.
		pstmt1.setString(1, tv.getSubject());
		pstmt1.setString(2, tv.getWriter());

		// 5.
		int cnt1 = pstmt1.executeUpdate();

		String sql2 = "INSERT INTO test_transaction2(subject, writer) values(?,?)";

		// 3.
		pstmt2 = con.prepareStatement(sql2);
		// 4.
		pstmt2.setString(1, tv.getSubject());
		pstmt2.setString(2, tv.getWriter());

		// 5.
		int cnt2 = pstmt2.executeUpdate();
		System.out.println(cnt1 + " " + cnt2);

		// Ʈ����ǿ� �ش��ϴ� ��� ������ ��ǥ ���� ���� ���Ͽ�
		// commit/ rollback ���θ� �����Ѵ�.
		if (cnt1 == 1 && cnt2 == 1) {
			flag = true;
		}
		return flag;
	}
	
	public void add() { 
		String inputData = 
			JOptionPane.showInputDialog("����� �ۼ��ڸ� �Է����ּ���.\n��) ����-�ۼ���");
		
		String[] data = inputData.split("-");
		
		if (data.length != 2) {
			JOptionPane.showMessageDialog(null, "�Է������� Ȯ�����ּ���.");
			return;
		}
		
		TransactionVO tv = new TransactionVO(data[0], data[1]);
		
		try {
			// DB������ ����ϴ� ������ ���� ����� �޾� 
			boolean flag = insert(tv);
			if (flag) {
				con.commit();
				System.out.println("Ŀ��");
				// insert�� �����ϰų� ����(catch)
			} else { 
				// update�� delete�� transaction�� �� else���� �ʿ�
				con.rollback();
				System.out.println("update�� delete�� �ѹ�");
			};
		} catch (SQLException se) {
			try {
				con.rollback();
				System.out.println("insert �ѹ�");
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
			se.printStackTrace();
		} finally {
			try {
				close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void close() throws SQLException {
		// 6.
		if (pstmt1 != null) { pstmt1.close(); }
		if (pstmt2 != null) { pstmt2.close(); }
		if (con != null) { con.close(); }
	}
	
	public static void main(String[] args) {
		TestTransaction tt = new TestTransaction();
		
		tt.add();
	}
}
