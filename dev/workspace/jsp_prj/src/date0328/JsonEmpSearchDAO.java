package date0328;

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

public class JsonEmpSearchDAO {
	
	private static JsonEmpSearchDAO j_dao;
	
	private JsonEmpSearchDAO() {}
	
	public static JsonEmpSearchDAO getInstance() {
		if (j_dao == null) {
			j_dao = new JsonEmpSearchDAO();
		}
		
		return j_dao;
	}
	
	public Connection getConn() throws SQLException {
		Connection con = null;
		
		try {
			// DBCP
			Context ctx = new InitialContext();
			System.out.println(ctx);
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/jsp_dbcp");
			System.out.println(ds);
			con = ds.getConnection();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} 
					
		return con;
	}
	
	public List<EmpVO> selectEmpList(int deptno) throws SQLException {
		List<EmpVO> list = new ArrayList<EmpVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConn();
			
			StringBuilder selectEmp = new StringBuilder();
			selectEmp
			.append(" select empno, ename, job, to_char(hiredate,'yyyy-MM-dd') hiredate, sal ")
			.append(" from emp ")
			.append(" where deptno = ? ")
			.append(" order by sal ");
			
			pstmt = con.prepareStatement(selectEmp.toString());
			pstmt.setInt(1, deptno);
			
			rs = pstmt.executeQuery();
			
			EmpVO evo = null;
			while(rs.next()) {
				evo = new EmpVO(rs.getInt("empno"), rs.getInt("sal"),
						rs.getString("ename"), rs.getString("job"),
						rs.getString("hiredate"));
				
				list.add(evo);
			}
			
		} finally {
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return list;
	}
	/*public static void main(String[] args) {
		try {
			// DBCP는 tomcat에서 만들기 때문에 
			// main메소드로 단위테스트하면 NullPointException 에러발생
			System.out.println(JsonEmpSearchDAO.getInstance().selectEmpList());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
}
