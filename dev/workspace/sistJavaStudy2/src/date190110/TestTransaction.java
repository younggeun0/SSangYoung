package date190110;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 * Transaction처리
 * @author owner
 */
public class TestTransaction {
	
	// commit과 rollback을 DB작업 외부에서 처리할 수 있도록
	// Connection을 class field에 정의.
	private Connection con = null;

	// transaction에 사용할 쿼리의 수만큼 쿼리실행객체를 선언
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

		// auto commit 해제
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

		// 트랜잭션에 해당하는 모든 쿼리의 목표 수행 수를 비교하여
		// commit/ rollback 여부를 결정한다.
		if (cnt1 == 1 && cnt2 == 1) {
			flag = true;
		}
		return flag;
	}
	
	public void add() { 
		String inputData = 
			JOptionPane.showInputDialog("제목과 작성자를 입력해주세요.\n예) 제목-작성자");
		
		String[] data = inputData.split("-");
		
		if (data.length != 2) {
			JOptionPane.showMessageDialog(null, "입력형식을 확인해주세요.");
			return;
		}
		
		TransactionVO tv = new TransactionVO(data[0], data[1]);
		
		try {
			// DB업무를 사용하는 곳에서 수행 결과를 받아 
			boolean flag = insert(tv);
			if (flag) {
				con.commit();
				System.out.println("커밋");
				// insert는 성공하거나 예외(catch)
			} else { 
				// update나 delete가 transaction일 때 else문이 필요
				con.rollback();
				System.out.println("update나 delete의 롤백");
			};
		} catch (SQLException se) {
			try {
				con.rollback();
				System.out.println("insert 롤백");
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
