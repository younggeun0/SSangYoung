package date190107;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsePreparedStatementDAO {

	public UsePreparedStatementDAO() {

	}

	private Connection getConn() throws SQLException {
		Connection con = null;

		// 1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		// 2. Connection 얻기
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id = "scott";
		String pass = "tiger";

		con = DriverManager.getConnection(url, id, pass);

		return con;
	}

	/**
	 * 사원번호, 사원명, 연봉을 입력받아 CpEmp2테이블에 삽입하는 일
	 * 
	 * @param cevo
	 * @throws SQLException
	 */
	public void insertCpEmp2(CpEmp2VO cevo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			// 1. 드라이버 로딩
			// 2. Connection 얻기
			con = getConn();

			// 3. 쿼리문 생성객체 얻기 : PreparedStatement객체는 실행되는 쿼리문을 알고 있다.
			String insertCpEmp2 = "INSERT INTO cp_emp2(empno,ename,hiredate,sal) VALUES(?,?,SYSDATE,?)";
			pstmt = con.prepareStatement(insertCpEmp2);

			// 4. 바인드 변수에 값 설정
			pstmt.setInt(1, cevo.getEmpno());
			pstmt.setString(2, cevo.getEname());
			pstmt.setInt(3, cevo.getSal());

			// 5. 쿼리 수행 후 결과 얻기
			pstmt.executeUpdate();

		} finally {
			// 6. 연결끊기
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * 사원번호, 사원명, 연봉을 입력받아 사원번호에 해당하는 사원명, 연봉을 변경하는 일
	 * 
	 * @param cevo
	 * @return
	 * @throws SQLException
	 */
	public boolean updateCpEmp2(CpEmp2VO cevo) throws SQLException {
		boolean flag = false;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// 1. 드라이버 로딩
			// 2. Connection 얻기
			con = getConn();

			// 3. 쿼리문 생성객체 얻기
			String updateCpEmp2 = "UPDATE cp_emp2 SET ename=?, sal=? WHERE empno=?";
			pstmt = con.prepareStatement(updateCpEmp2);

			// 4. 바인드 변수에 값 넣기
			pstmt.setString(1, cevo.getEname());
			pstmt.setInt(2, cevo.getSal());
			pstmt.setInt(3, cevo.getEmpno());

			// 5. 쿼리문 수행 후 결과 얻기
			int cnt = pstmt.executeUpdate();

			if (cnt != 0) { // 수행되면 1~n개가 변경됨
				flag = true;
			}

		} finally {
			// 6. 연결 끊기
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return flag;
	}

	/**
	 * 사원번호를 입력받아 사원번호에 해당하는 사원을 삭제하는 일.
	 * 
	 * @param empno
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteCpEmp2(int empno) throws SQLException {
		boolean flag = false;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// 1. 드라이버 로딩
			// 2. Connection 얻기
			con = getConn();

			String deleteCpEmp2 = "DELETE FROM cp_emp2 WHERE empno=?";
			// 3. 쿼리문 생성 객체 얻기
			pstmt = con.prepareStatement(deleteCpEmp2);
			// 4. 바인드변수에 값 설정
			pstmt.setInt(1, empno);

			// 5. 쿼리 수행 후 결과 얻기
			int cnt = pstmt.executeUpdate();

			if (cnt != 0) {
				flag = true;
			}

		} finally {
			// 6. 연결 끊기
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return flag;
	}

	/**
	 * 모든 사원정보 조회
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<CpEmp2AllVO> selectAllCpEmp2() throws SQLException {
		List<CpEmp2AllVO> list = new ArrayList<CpEmp2AllVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. 드라이버로딩
			// 2. Connection 얻기
			con = getConn();

			String selectAllCpEmp2 = "SELECT empno, ename, "
					+ "TO_CHAR(hiredate, 'yyyy-mm-dd') hiredate, sal FROM cp_emp2";
			// 3. 쿼리문 생성 객체 얻기
			// 4. 바인드변수에 값넣기(생략)
			pstmt = con.prepareStatement(selectAllCpEmp2);

			// 5. 쿼리문 수행 후 결과 얻기
			rs = pstmt.executeQuery();

			// 조회한 결과를 VO에 할당
			CpEmp2AllVO cevo = null;
			while (rs.next()) {
				cevo = new CpEmp2AllVO(rs.getInt("empno"), rs.getInt("sal"), rs.getString("ename"),
						rs.getString("hiredate"));
				list.add(cevo);
			}

		} finally {
			// 연결 끊기
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

		return list;
	}

	/**
	 * 입력되는 사원번호에 해당하는 사원정보 조회
	 * 
	 * @param empno
	 * @return
	 * @throws SQLException
	 */
	public CpEmp2OneVO selectOneCpEmp2(int empno) throws SQLException {
		CpEmp2OneVO cevo = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. 드라이버 로딩
			// 2. Connection 얻기
			con = getConn();

			// 3. 쿼리문 생성객체 얻기
			String selectOneCpEmp2 = "SELECT ename, sal, hiredate FROM cp_emp2 WHERE empno=?";
			pstmt = con.prepareStatement(selectOneCpEmp2);

			// 4. 바인드 변수에 값 설정
			pstmt.setInt(1, empno);

			// 5. 쿼리문 수행 결과 얻기
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cevo = new CpEmp2OneVO(rs.getInt("sal"), rs.getString("ename"), rs.getDate("hiredate"));
			}

		} finally {
			// 6. 연결 끊기
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

		return cevo;
	}
	
	public List<Integer> selectAllCpEmpNo() throws SQLException {
		List<Integer> list = new ArrayList<Integer>();
		
		// 1. 드라이버 로딩
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 2. Connection 얻기
			con = getConn();
			
			// 3. 쿼리문 생성 객체 얻기
			String selectAllCpEmpNo = "SELECT empno FROM cp_emp2 ORDER BY empno";
			pstmt = con.prepareStatement(selectAllCpEmpNo);

			// 4. 쿼리문 실행 후 결과 얻기
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getInt("empno"));
			}
			
		} finally {
			// 5. 연결 끊기
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		
		return list;
	}

	/*public static void main(String[] args) { // 단위 테스트용 main method(개발 후 지움)
		UsePreparedStatementDAO u = new UsePreparedStatementDAO();
		try {
			CpEmp2OneVO c = u.selectOneCpEmp2(3);
			System.out.println(c);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}*/

}
