package date190109;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import kr.co.sist.connection.GetConnection;

/**
 * test_proc테이블에 사원번호, 사원명, 연봉, 직무를 추가하는 일
 * Procedure를 사용하여 CRUD
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

			// 3. 프로시저 실행객체 얻기
			cstmt = con.prepareCall("{ call insert_test_proc(?,?,?,?,?,?) }");
			
			// 4. 바인드변수에 값 넣기
			// in parameter
			cstmt.setInt(1, tpvo.getEmpno());
			cstmt.setString(2, tpvo.getEname());
			cstmt.setInt(3, tpvo.getSal());
			cstmt.setString(4, tpvo.getJob());
			
			// out parameter : 프로시저가 처리한 결과를 저장할 데이터형 설정
			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.registerOutParameter(6, Types.NUMERIC);
			
			// 5. 
			cstmt.executeQuery();
			
			// 프로시저가 실행된 후 out parameter에 설정된 값 얻기
			resultMsg = cstmt.getString(5);
			int rowCnt = cstmt.getInt(6);
			
			System.out.println("row cnt : "+rowCnt);
			
		} finally {
			// 6. 연결 끊기
			if (cstmt != null) { cstmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return resultMsg;
	}
	
	/*public static void main(String[] args) {
		UseCallableStatementDAO ucsdao = new UseCallableStatementDAO();
		TestProcVO tpvo = new TestProcVO(1112,9000,"김정운","대리");
		try {
			System.out.println(ucsdao.insertProc(tpvo));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
}
