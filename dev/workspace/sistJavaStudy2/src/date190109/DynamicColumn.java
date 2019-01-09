package date190109;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 * 컬럼명이 동적으로 변경되는 경우<br>
 * 컬럼명을 입력받아 해당 컬럼명으로 조회 EMP테이블 조회 사원번호와 컬럼명()을 입력받아 조회
 * 
 * @author owner
 */
public class DynamicColumn {

	public DynamicColumn() throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String[] columnName = { "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno" };
		String input = JOptionPane.showInputDialog("사원번호와 컬럼명 하나를 입력해주세요.\n예) 사원번호,컬럼명");
		// CSV - comma separated value

		String[] temp = input.split(",");

		if (temp.length != 2) {
			JOptionPane.showMessageDialog(null, "입력형식을 확인하세요.");
			return;
		}

		try {
			int empno = Integer.parseInt(temp[0].trim());
			String inputColumn = temp[1].trim();

			boolean columnFlag = false;

			for (String column : columnName) {
				if (column.equals(inputColumn.toLowerCase())) { // DB테이블의 컬럼명과 같은 컬럼명이라면
					columnFlag = true;
				}
			}

			if (!columnFlag) {
				JOptionPane.showMessageDialog(null, inputColumn + "은 EMP테이블에 컬럼으로 존재하지 않습니다.");
				return;
			}

			try {
				
				// 1,2
				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				String id = "scott";
				String pass = "tiger";
				
				con = GetConnection.getInstance().getConn(url, id, pass);

				// 컬럼명이 hiredate인 경우 문자열로 처리하기 위해 TO_CHAR함수를 사용. 
				if (inputColumn.equals("hiredate")) {
					inputColumn = "TO_CHAR(hiredate, 'yyyy-mm-dd EEEEE') hiredate";
				}
				
				StringBuilder selectEmp = new StringBuilder();
				
				// 컬럼명, 테이블명은 바인드변수로 처리 되지 않는다. 쿼리문에 직접 넣어 사용한다.
				selectEmp.append("SELECT ").append(inputColumn).append(" FROM emp ").append("WHERE empno=?");
				
				// 3, 4
				pstmt = con.prepareStatement(selectEmp.toString());
				pstmt.setInt(1, empno);
				
				// 5.
				rs = pstmt.executeQuery();
				
				if (rs.next()) { // 사원번호로 조회된 레코드가 존재한다면 
					String stringData = "";
					int intData = 0;
					
					if (temp[1].trim().equals("ename")|| temp[1].trim().equals("job") // String 타입
							||temp[1].trim().equals("hiredate")) {
						stringData = rs.getString(temp[1].trim()); // temp[1].trim()대신 1을 사용가능
					} else {	// int 타입
						intData = rs.getInt(temp[1].trim());
					}
					JOptionPane.showMessageDialog(null, temp[1]+"으로 조회된 값 : "
							+(intData == 0 ? stringData : intData));
				} else {
					JOptionPane.showMessageDialog(null, "입력한 사원번호는 존재하지 않습니다.");
				}
				
				// 6.
			} finally {
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
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "사원번호는 숫자이어야 합니다.");
			return;
		} 

	}

	public static void main(String[] args) {
		try {
			new DynamicColumn();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
