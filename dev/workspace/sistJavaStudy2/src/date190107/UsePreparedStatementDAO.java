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

		// 1. ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		// 2. Connection ���
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id = "scott";
		String pass = "tiger";

		con = DriverManager.getConnection(url, id, pass);

		return con;
	}

	/**
	 * �����ȣ, �����, ������ �Է¹޾� CpEmp2���̺� �����ϴ� ��
	 * 
	 * @param cevo
	 * @throws SQLException
	 */
	public void insertCpEmp2(CpEmp2VO cevo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			// 1. ����̹� �ε�
			// 2. Connection ���
			con = getConn();

			// 3. ������ ������ü ��� : PreparedStatement��ü�� ����Ǵ� �������� �˰� �ִ�.
			String insertCpEmp2 = "INSERT INTO cp_emp2(empno,ename,hiredate,sal) VALUES(?,?,SYSDATE,?)";
			pstmt = con.prepareStatement(insertCpEmp2);

			// 4. ���ε� ������ �� ����
			pstmt.setInt(1, cevo.getEmpno());
			pstmt.setString(2, cevo.getEname());
			pstmt.setInt(3, cevo.getSal());

			// 5. ���� ���� �� ��� ���
			pstmt.executeUpdate();

		} finally {
			// 6. �������
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * �����ȣ, �����, ������ �Է¹޾� �����ȣ�� �ش��ϴ� �����, ������ �����ϴ� ��
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
			// 1. ����̹� �ε�
			// 2. Connection ���
			con = getConn();

			// 3. ������ ������ü ���
			String updateCpEmp2 = "UPDATE cp_emp2 SET ename=?, sal=? WHERE empno=?";
			pstmt = con.prepareStatement(updateCpEmp2);

			// 4. ���ε� ������ �� �ֱ�
			pstmt.setString(1, cevo.getEname());
			pstmt.setInt(2, cevo.getSal());
			pstmt.setInt(3, cevo.getEmpno());

			// 5. ������ ���� �� ��� ���
			int cnt = pstmt.executeUpdate();

			if (cnt != 0) { // ����Ǹ� 1~n���� �����
				flag = true;
			}

		} finally {
			// 6. ���� ����
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
	 * �����ȣ�� �Է¹޾� �����ȣ�� �ش��ϴ� ����� �����ϴ� ��.
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
			// 1. ����̹� �ε�
			// 2. Connection ���
			con = getConn();

			String deleteCpEmp2 = "DELETE FROM cp_emp2 WHERE empno=?";
			// 3. ������ ���� ��ü ���
			pstmt = con.prepareStatement(deleteCpEmp2);
			// 4. ���ε庯���� �� ����
			pstmt.setInt(1, empno);

			// 5. ���� ���� �� ��� ���
			int cnt = pstmt.executeUpdate();

			if (cnt != 0) {
				flag = true;
			}

		} finally {
			// 6. ���� ����
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
	 * ��� ������� ��ȸ
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
			// 1. ����̹��ε�
			// 2. Connection ���
			con = getConn();

			String selectAllCpEmp2 = "SELECT empno, ename, "
					+ "TO_CHAR(hiredate, 'yyyy-mm-dd') hiredate, sal FROM cp_emp2";
			// 3. ������ ���� ��ü ���
			// 4. ���ε庯���� ���ֱ�(����)
			pstmt = con.prepareStatement(selectAllCpEmp2);

			// 5. ������ ���� �� ��� ���
			rs = pstmt.executeQuery();

			// ��ȸ�� ����� VO�� �Ҵ�
			CpEmp2AllVO cevo = null;
			while (rs.next()) {
				cevo = new CpEmp2AllVO(rs.getInt("empno"), rs.getInt("sal"), rs.getString("ename"),
						rs.getString("hiredate"));
				list.add(cevo);
			}

		} finally {
			// ���� ����
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
	 * �ԷµǴ� �����ȣ�� �ش��ϴ� ������� ��ȸ
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
			// 1. ����̹� �ε�
			// 2. Connection ���
			con = getConn();

			// 3. ������ ������ü ���
			String selectOneCpEmp2 = "SELECT ename, sal, hiredate FROM cp_emp2 WHERE empno=?";
			pstmt = con.prepareStatement(selectOneCpEmp2);

			// 4. ���ε� ������ �� ����
			pstmt.setInt(1, empno);

			// 5. ������ ���� ��� ���
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cevo = new CpEmp2OneVO(rs.getInt("sal"), rs.getString("ename"), rs.getDate("hiredate"));
			}

		} finally {
			// 6. ���� ����
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
		
		// 1. ����̹� �ε�
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 2. Connection ���
			con = getConn();
			
			// 3. ������ ���� ��ü ���
			String selectAllCpEmpNo = "SELECT empno FROM cp_emp2 ORDER BY empno";
			pstmt = con.prepareStatement(selectAllCpEmpNo);

			// 4. ������ ���� �� ��� ���
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getInt("empno"));
			}
			
		} finally {
			// 5. ���� ����
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		
		return list;
	}

	/*public static void main(String[] args) { // ���� �׽�Ʈ�� main method(���� �� ����)
		UsePreparedStatementDAO u = new UsePreparedStatementDAO();
		try {
			CpEmp2OneVO c = u.selectOneCpEmp2(3);
			System.out.println(c);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}*/

}
