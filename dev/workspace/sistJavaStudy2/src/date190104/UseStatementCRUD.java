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
 * Statement��ü�� ����Ͽ� CRUD�� ������ Ŭ����
 * CRUD�� Create, Read, Update, Delete�� ����
 * @author owner
 */
public class UseStatementCRUD {

	/**
	 * VO�� �Է¹޾� VO�� ���� CP_DEPT ���̺� �߰�
	 * @param cdvo �μ���ȣ, �μ��� ��ġ�� ���� VO
	 * @throws SQLException 
	 */
	public void insertCpDept(CpDeptVO cdvo) throws SQLException {
		// 1. ����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		Connection con = null;
		Statement stmt = null;
		try {
			// 2. Connection ���
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			
			con = DriverManager.getConnection(url, id, pwd);
			
			// 3. ������ ������ü ���
			stmt = con.createStatement(); 
			
			// 4. �������� �� ��� ���
			StringBuilder insertCpDept = new StringBuilder();
			insertCpDept
			.append("insert into cp_dept(deptno, dname, loc) values(")
			.append(cdvo.getDeptno()).append(",'")
			.append(cdvo.getDname()).append("','")
			.append(cdvo.getLoc()).append("')");
			
			int cnt = stmt.executeUpdate(insertCpDept.toString());
			System.out.println(cnt);
		} finally {
		// 5. ���� ����
			if (stmt != null) { stmt.close(); }
			if (con != null) { con.close(); }
		}
	}
	
	public boolean updateCpDept(CpDeptVO cdvo) throws SQLException {
		boolean flag = false;
		
		// 1. ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con = null;
		Statement stmt = null;
		try {
			// 2. Connection ���
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			con = DriverManager.getConnection(url, id, pwd);

			// 3. ������ ������ü ���
			stmt = con.createStatement();
		
			// 4. ���� ���� �� ��� ���
			StringBuilder updateCpDept = new StringBuilder();
			updateCpDept
			.append("update cp_dept set ")
			.append("dname='").append(cdvo.getDname()).append("',")
			.append("loc='").append(cdvo.getLoc()).append("' ")
			.append("where deptno=").append(cdvo.getDeptno());
			
			int cnt = stmt.executeUpdate(updateCpDept.toString());
			
			// ���̺��� ������ �μ���ȣ�� PK�̹Ƿ� ���ุ ���� �ȴ�.
			if (cnt != 0) {
				flag = true;
			}
		} finally {
			// 5. ���� ����
			if (stmt != null) { stmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return flag;
	}
	
	public boolean deleteCpDept(int deptno) throws SQLException {
		boolean flag = false;
		
		// 1.����̹� �ε� 
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		Connection con = null;
		Statement stmt = null;
		
		try {
			// 2.Connection ���
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			
			con = DriverManager.getConnection(url, id, pwd);
		
			// 3.������ ������ü ���
			stmt = con.createStatement();
		
			// 4.���� ���� �� ��� ���
			StringBuilder deleteCpDept = new StringBuilder();
			deleteCpDept
			.append("delete from cp_dept where deptno=").append(deptno);
			
			int cnt = stmt.executeUpdate(deleteCpDept.toString());
			
			if (cnt != 0) {
				flag = true;
			}
		
		} finally {
			// 5.���� ����
			if (stmt != null) { stmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return flag;
	}
	
	public List<CpDeptVO> selectAllCpDept() throws SQLException {
		List<CpDeptVO> list = new ArrayList<CpDeptVO>();
		
		// 1. ����̹� �ε�
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
			
			// 2. Connection ���
			con = DriverManager.getConnection(url, id, pwd);
			// 3. ������ ���� ��ü ���
			stmt = con.createStatement();
			
			// 4. ������ ���� �� ��� ���
			String selectAllCpDept = "select deptno,dname,loc from cp_dept";
			
			rs = stmt.executeQuery(selectAllCpDept);
		
			CpDeptVO cdvo = null;
			while(rs.next()) { // ��ȸ�� ���ڵ尡 �����Ѵٸ�
				
				// �÷� �ε����� ��ȸ(�����)
				// System.out.println(rs.getInt(1) +" "+rs.getString(2)+" "+rs.getString(3)); 
				
				// �÷������� ��ȸ(����)
				// ��ȸ ����� VO�� ����
				cdvo = new CpDeptVO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				
				// ���� �̸����� ������ cdvo ��ü�� ������� �ʵ��� �����ϱ� ���� list�� �߰�
				list.add(cdvo);
			}
			
		} finally {
			// 5. ���� ����
			if (rs != null) { rs.close(); }
			if (stmt != null) { stmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return list;
	}
	
	public OneCpDeptVO selectOneCpDept(int deptno) throws SQLException {
		OneCpDeptVO ocdvo = null;
		
		// 1.����̹� �ε�
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
			
			// 2.Connection ���
			con = DriverManager.getConnection(url, id, pwd);
			
			// 3.������ ������ü ���
			stmt = con.createStatement();
			
			StringBuilder selectOneCpDept = new StringBuilder(); 
			selectOneCpDept
			.append("select dname,loc from cp_dept where deptno=")
			.append(deptno);
		
			// 4.������ ���� �� ��� ���
			rs = stmt.executeQuery(selectOneCpDept.toString());
			
			// PK�� deptno�� ��ȸ�ϴϱ� ���ڵ尡 �����Ѵٸ� �Ѱ��� ����
			// rs.next();
			// rs.getInt ... �̷������� ¥�� �ȵ�
			if (rs.next()) { // ��ȸ�� ���ڵ尡 ���� �Ѵٸ�
				ocdvo = new OneCpDeptVO(rs.getString("dname"), rs.getString("loc")); 
			}
		
		// 5.���� ����
		} finally {
			if (rs != null) { rs.close(); }
			if (stmt != null) { stmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return ocdvo; // ��ȸ�� �ȵǸ� null
	}
	
	/**
	 * CP_DEPT ���̺��� ��� �μ���ȣ�� ��ȸ
	 * @return
	 * @throws SQLException
	 */
	public List<Integer> selectAllCpDeptNo() throws SQLException {
		List<Integer> list = new ArrayList<Integer>();
		
		// 1. ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 2. Connection ���
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			
			con = DriverManager.getConnection(url, id, pwd);
			
			// 3. ������ ���� ��ü ���
			stmt = con.createStatement();

			// 4. ������ ���� �� ��� ���
			String selectAllCpDeptNo = "select deptno from cp_dept order by deptno";
			
			rs = stmt.executeQuery(selectAllCpDeptNo);
			
			
			while(rs.next()) {
				list.add(rs.getInt("deptno"));
			}
			
		} finally {
			// 5. ���� ����
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (con != null) con.close();
		}
		
		return list;
	}
}
