package date190104;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Statement객체를 사용하여 CRUD를 구현한 클래스
 * CRUD는 Create, Read, Update, Delete의 약자
 * @author owner
 */
public class UseStatementCRUD {

	/**
	 * VO를 입력받아 VO의 값을 CP_DEPT 테이블에 추가
	 * @param cdvo 부서번호, 부서명 위치를 가진 VO
	 * @throws SQLException 
	 */
	public void insertCpDept(CpDeptVO cdvo) throws SQLException {
		// 1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		Connection con = null;
		Statement stmt = null;
		try {
			// 2. Connection 얻기
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			
			con = DriverManager.getConnection(url, id, pwd);
			
			// 3. 쿼리문 생성객체 얻기
			stmt = con.createStatement(); 
			
			// 4. 쿼리수행 후 결과 얻기
			StringBuilder insertCpDept = new StringBuilder();
			insertCpDept
			.append("insert into cp_dept(deptno, dname, loc) values(")
			.append(cdvo.getDeptno()).append(",'")
			.append(cdvo.getDname()).append("','")
			.append(cdvo.getLoc()).append("')");
			
			int cnt = stmt.executeUpdate(insertCpDept.toString());
			System.out.println(cnt);
		} finally {
		// 5. 연결 끊기
			if (stmt != null) { stmt.close(); }
			if (con != null) { con.close(); }
		}
	}
	
	public boolean updateCpDept(CpDeptVO cdvo) throws SQLException {
		boolean flag = false;
		
		// 1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con = null;
		Statement stmt = null;
		try {
			// 2. Connection 얻기
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			con = DriverManager.getConnection(url, id, pwd);

			// 3. 쿼리문 생성객체 얻기
			stmt = con.createStatement();
		
			// 4. 쿼리 수행 후 결과 얻기
			StringBuilder updateCpDept = new StringBuilder();
			updateCpDept
			.append("update cp_dept set ")
			.append("dname='").append(cdvo.getDname()).append("',")
			.append("loc='").append(cdvo.getLoc()).append("' ")
			.append("where deptno=").append(cdvo.getDeptno());
			
			int cnt = stmt.executeUpdate(updateCpDept.toString());
			
			// 테이블의 구조상 부서번호는 PK이므로 한행만 변경 된다.
			if (cnt != 0) {
				flag = true;
			}
		} finally {
			// 5. 연결 끊기
			if (stmt != null) { stmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return flag;
	}
	
	public boolean deleteCpDept(int deptno) throws SQLException {
		boolean flag = false;
		
		// 1.드라이버 로딩 
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		Connection con = null;
		Statement stmt = null;
		
		try {
			// 2.Connection 얻기
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			
			con = DriverManager.getConnection(url, id, pwd);
		
			// 3.쿼리문 생성객체 얻기
			stmt = con.createStatement();
		
			// 4.쿼리 수행 후 결과 얻기
			StringBuilder deleteCpDept = new StringBuilder();
			deleteCpDept
			.append("delete from cp_dept where deptno=").append(deptno);
			
			int cnt = stmt.executeUpdate(deleteCpDept.toString());
			
			if (cnt != 0) {
				flag = true;
			}
		
		} finally {
			// 5.연결 끊기
			if (stmt != null) { stmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return flag;
	}
	
	public List<CpDeptVO> selectAllCpDept() throws SQLException {
		List<CpDeptVO> list = new ArrayList<CpDeptVO>();
		
		// 1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			
			// 2. Connection 얻기
			con = DriverManager.getConnection(url, id, pwd);
			// 3. 쿼리문 생성 객체 얻기
			stmt = con.createStatement();
			
			// 4. 쿼리문 수행 후 결과 얻기
			String selectAllCpDept = "select deptno,dname,loc from cp_dept";
			
			rs = stmt.executeQuery(selectAllCpDept);
		
			CpDeptVO cdvo = null;
			while(rs.next()) { // 조회된 레코드가 존재한다면
				
				// 컬럼 인덱스로 조회(비권장)
				// System.out.println(rs.getInt(1) +" "+rs.getString(2)+" "+rs.getString(3)); 
				
				// 컬럼명으로 조회(권장)
				// 조회 결과를 VO에 저장
				cdvo = new CpDeptVO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				
				// 같은 이름으로 생성된 cdvo 객체를 사라지지 않도록 관리하기 위해 list에 추가
				list.add(cdvo);
			}
			
		} finally {
			// 5. 연결 끊기
			if (rs != null) { rs.close(); }
			if (stmt != null) { stmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return list;
	}
	
	public OneCpDeptVO selectOneCpDept(int deptno) throws SQLException {
		OneCpDeptVO ocdvo = null;
		
		// 1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			
			// 2.Connection 얻기
			con = DriverManager.getConnection(url, id, pwd);
			
			// 3.쿼리문 생성객체 얻기
			stmt = con.createStatement();
			
			StringBuilder selectOneCpDept = new StringBuilder(); 
			selectOneCpDept
			.append("select dname,loc from cp_dept where deptno=")
			.append(deptno);
		
			// 4.쿼리문 수행 후 결과 얻기
			rs = stmt.executeQuery(selectOneCpDept.toString());
			
			// PK인 deptno로 조회하니까 레코드가 존재한다면 한개만 존재
			// rs.next();
			// rs.getInt ... 이런식으로 짜면 안됨
			if (rs.next()) { // 조회된 레코드가 존재 한다면
				ocdvo = new OneCpDeptVO(rs.getString("dname"), rs.getString("loc")); 
			}
		
		// 5.연결 끊기
		} finally {
			if (rs != null) { rs.close(); }
			if (stmt != null) { stmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return ocdvo; // 조회가 안되면 null
	}
	
	/**
	 * CP_DEPT 테이블의 모든 부서번호를 조회
	 * @return
	 * @throws SQLException
	 */
	public List<Integer> selectAllCpDeptNo() throws SQLException {
		List<Integer> list = new ArrayList<Integer>();
		
		// 1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 2. Connection 얻기
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			
			con = DriverManager.getConnection(url, id, pwd);
			
			// 3. 쿼리문 생성 객체 얻기
			stmt = con.createStatement();

			// 4. 쿼리문 실행 후 결과 얻기
			String selectAllCpDeptNo = "select deptno from cp_dept order by deptno";
			
			rs = stmt.executeQuery(selectAllCpDeptNo);
			
			
			while(rs.next()) {
				list.add(rs.getInt("deptno"));
			}
			
		} finally {
			// 5. 연결 끊기
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (con != null) con.close();
		}
		
		return list;
	}
}
