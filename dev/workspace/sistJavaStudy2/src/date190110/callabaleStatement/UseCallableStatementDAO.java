package date190110.callabaleStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.connection.GetConnection;
import oracle.jdbc.OracleTypes;

/**
 * test_proc테이블에 사원번호, 사원명, 연봉, 직무를 추가하는 일 Procedure를 사용하여 CRUD
 * 
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

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";

			// 2.
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

			System.out.println("row cnt : " + rowCnt);

		} finally {
			// 6. 연결 끊기
			if (cstmt != null) {
				cstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return resultMsg;
	}

	public String updateProc(TestProcUpdateVO tpuvo) throws SQLException {
		String resultMsg = "";

		Connection con = null;
		CallableStatement cstmt = null;

		try {

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";
			// 2.
			con = GetConnection.getInstance().getConn(url, id, pass);
			// 3.
			cstmt = con.prepareCall("{ call update_test_proc(?,?,?,?,?) }");

			// 4. 바운드 변수 값 넣기
			// in parameter
			cstmt.setInt(1, tpuvo.getEmpno());
			cstmt.setString(2, tpuvo.getJob());
			cstmt.setInt(3, tpuvo.getSal());

			// out parameter
			cstmt.registerOutParameter(4, Types.VARCHAR);
			cstmt.registerOutParameter(5, Types.NUMERIC);

			cstmt.execute(); // 부모의 method 사용, Procedure 실행

			// 실행 결과는 out parameter에 저장됨
			resultMsg = cstmt.getString(4);
			System.out.println("row cnt : " + cstmt.getInt(5));

		} finally {
			if (cstmt != null) {
				cstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return resultMsg;
	}

	public String deleteProc(int empno) throws SQLException {
		String resultMsg = "";

		Connection con = null;
		CallableStatement cstmt = null;

		try {

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";

			// 2.
			con = GetConnection.getInstance().getConn(url, id, pass);

			// 3.
			cstmt = con.prepareCall("{ call delete_test_proc(?,?,?) }");

			// 4. 바인드변수 값 설정
			// in parameter
			cstmt.setInt(1, empno);

			// out parameter
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.NUMERIC);

			// 5.
			cstmt.execute();

			// out parameter에 설정된 값 받기
			resultMsg = cstmt.getString(2);
			System.out.println("row cnt : " + cstmt.getInt(3));

		} finally {
			if (cstmt != null) {
				cstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return resultMsg;
	}

	public List<TestProcAllVO> selectAllTestProc() throws SQLException {
		List<TestProcAllVO> list = new ArrayList<TestProcAllVO>();

		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;

		try {

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";

			// 2.
			con = GetConnection.getInstance().getConn(url, id, pass);

			// 3.
			cstmt = con.prepareCall("{ call select_all_test_proc(?,?) }");

			// 4. 바인드 변수에 값 넣기
			// out parameter : SYS_REFCURSOR -> OracleTypes.CURSOR
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);

			// in parameter
			cstmt.setString(2, "mm-dd-yyyy day hh24:mi");

			cstmt.execute();

			// 커서의 제어권 받기
			rs = (ResultSet) cstmt.getObject(1);

			// 제어권을 받아 조회한 모든 컬럼값을 레코드를 VO에 할당하고 List에 추가
			TestProcAllVO tpavo = null;

			while (rs.next()) {
				tpavo = new TestProcAllVO(rs.getInt("empno"), rs.getInt("sal"), rs.getString("ename"),
						rs.getString("hiredate"), rs.getString("job"));
				list.add(tpavo);
			}

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (cstmt != null) {
				cstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return list;
	}

	public TestProcOneVO selectOneTestProc(int empno) throws SQLException {
		TestProcOneVO tpovo = null;

		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;

		try {

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";

			// 2.
			con = GetConnection.getInstance().getConn(url, id, pass);

			// 3.
			cstmt = con.prepareCall("{ call select_one_test_proc(?,?,?) }");
			// 4. 바인드 변수에 값 넣기
			// in parameter
			cstmt.setInt(1, empno);

			// out parameter
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.registerOutParameter(3, Types.VARCHAR);

			// 5.
			cstmt.execute();
			rs = (ResultSet) cstmt.getObject(2);

			if (rs.next()) {
				tpovo = new TestProcOneVO(rs.getInt("sal"), rs.getString("ename"), rs.getString("hiredate"),
						rs.getString("job"));
			}

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (cstmt != null) {
				cstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return tpovo;
	}

	/*// 단위테스트용 main method
	public static void main(String[] args) {
		UseCallableStatementDAO ucsdao = new UseCallableStatementDAO();
		try {
			TestProcOneVO vo = ucsdao.selectOneTestProc(1114);
			System.out.println(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
}
