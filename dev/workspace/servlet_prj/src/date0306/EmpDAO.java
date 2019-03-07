package date0306;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class EmpDAO { // DAO - Data Access Object
	public List<EmpVO> selectAllEmp() throws SQLException {
		List<EmpVO> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1. JNDI 사용객체 생성
			Context ctx = new InitialContext();
			
			// 2. DataSource를 DBCP에서 꺼내온다.
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/dbcp");
			
			// 3. Connection 얻기
			con = ds.getConnection();
			
			// 4. 쿼리문 수행 객체 얻기
			StringBuilder selectAllEmp = new StringBuilder();
			selectAllEmp
			.append(" select empno, ename, job, mgr, to_char(hiredate,'yyyy-MM-dd') hiredate, sal ")
			.append(" from emp ")
			.append(" order by sal ");
			
			pstmt = con.prepareStatement(selectAllEmp.toString());
			
			// 5. 쿼리문 수행 후 결과 얻기.
			rs = pstmt.executeQuery();
			
			EmpVO evo = null;
			while(rs.next()) {
				evo = new EmpVO(rs.getInt("empno"), rs.getInt("mgr"), rs.getInt("sal"),
						rs.getString("ename"), rs.getString("job"), rs.getString("hiredate"));
				list.add(evo);		
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			// 6. 연결 끊기 
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
		return list;
	}
}
