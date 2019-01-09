package date190109;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import kr.co.sist.connection.GetConnection;

/**
 * test_proc���̺� �����ȣ, �����, ����, ������ �߰��ϴ� ��
 * Procedure�� ����Ͽ� CRUD
 * @author owner
 */
public class UseCallableStatementDAO {
	// DAO - Data Access Object
	
	private static UseCallableStatementDAO ucs_dao;
	
	private UseCallableStatementDAO() {
		
	}
	
	public static UseCallableStatementDAO getInstance() {
		if (ucs_dao == null) {
			ucs_dao = new UseCallableStatementDAO();
		}
		return ucs_dao;
	}
	
	public String insertProc(TestProcVO tpvo) throws SQLException {
		String resultMsg = "";
		
		Connection con = null;
		CallableStatement cstmt = null;
		
		try {
			
			// 1.
			// 2.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";
			
			con = GetConnection.getInstance().getConn(url, id, pass);

			// 3. ���ν��� ���ఴü ���
			cstmt = con.prepareCall("{ call insert_test_proc(?,?,?,?,?,?) }");
			
			// 4. ���ε庯���� �� �ֱ�
			// in parameter
			cstmt.setInt(1, tpvo.getEmpno());
			cstmt.setString(2, tpvo.getEname());
			cstmt.setInt(3, tpvo.getSal());
			cstmt.setString(4, tpvo.getJob());
			
			// out parameter : ���ν����� ó���� ����� ������ �������� ����
			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.registerOutParameter(6, Types.NUMERIC);
			
			// 5. 
			cstmt.executeQuery();
			
			// ���ν����� ����� �� out parameter�� ������ �� ���
			resultMsg = cstmt.getString(5);
			int rowCnt = cstmt.getInt(6);
			
			System.out.println("row cnt : "+rowCnt);
			
		} finally {
			// 6. ���� ����
			if (cstmt != null) { cstmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return resultMsg;
	}
	
	/*public static void main(String[] args) {
		UseCallableStatementDAO ucsdao = new UseCallableStatementDAO();
		TestProcVO tpvo = new TestProcVO(1112,9000,"������","�븮");
		try {
			System.out.println(ucsdao.insertProc(tpvo));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
}
