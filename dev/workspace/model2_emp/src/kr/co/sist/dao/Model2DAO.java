package kr.co.sist.dao;

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

import kr.co.sist.vo.DeptVO;
import kr.co.sist.vo.EmpVO;

public class Model2DAO {
	
	private static Model2DAO j_dao;
	
	private Model2DAO() {}
	
	public static Model2DAO getInstance() {
		if (j_dao == null) {
			j_dao = new Model2DAO();
		}
		
		return j_dao;
	}
	
	public Connection getConn() throws SQLException {
		Connection con = null;
		
		try {
			// DBCP
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/model2_dbcp");
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
	
	public List<DeptVO> selectDeptList() throws SQLException {
		List<DeptVO> list = new ArrayList<DeptVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConn();
			
			StringBuilder selectDept = new StringBuilder();
			selectDept
			.append(" select deptno, dname, loc ")
			.append(" from dept ");
			
			pstmt = con.prepareStatement(selectDept.toString());
			
			rs = pstmt.executeQuery();
			
			DeptVO dvo = null;
			while(rs.next()) {
				dvo = new DeptVO(rs.getInt("deptno"),
						rs.getString("dname"), rs.getString("loc")); 
				
				list.add(dvo);
			}
			
		} finally {
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return list;
	}
}
