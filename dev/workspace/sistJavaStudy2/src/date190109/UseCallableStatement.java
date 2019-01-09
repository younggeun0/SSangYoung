package date190109;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 * Procedure 호출
 * @author owner
 */
public class UseCallableStatement {

	public UseCallableStatement() throws SQLException {
		
		Connection con = null;
		CallableStatement cstmt = null;
		
		String tempData = JOptionPane.showInputDialog("숫자 2개 입력\n예) 숫자,숫자");
		String[] numbers = tempData.split(",");
		
		if (numbers.length != 2) {
			JOptionPane.showMessageDialog(null, "두 개의 수만 입력해주세요.");
			return;
		}
		
		int num1 = 0, num2 = 0;
		
		try {
			num1 = Integer.parseInt(numbers[0]);
			num2 = Integer.parseInt(numbers[1]);
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "숫자를 입력해주세요.");
		}
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";
			
			// 2.
			con = GetConnection.getInstance().getConn(url, id, pass);
			
			// 3. 
			cstmt = con.prepareCall("{ call proc_plus(?,?,?) }");
			
			// 4. 바인드 변수에 값 설정
			// in parameter
			cstmt.setInt(1, num1);
			cstmt.setInt(2, num2);
			
			// out parameter
			cstmt.registerOutParameter(3, Types.NUMERIC);
			
			// 5. 쿼리(Procedure) 실행 후 결과 얻기
			// 프로시저 실행하면 in parameter와 out parameter에 값 할당
			
			cstmt.execute();
			
			int total = cstmt.getInt(3);
			
			JOptionPane.showMessageDialog(null, num1+" + "+num2+" = "+total);
			
			
		} finally {
			if (cstmt != null) { cstmt.close(); }
			if (con != null) { con.close(); }
		}
	}
	
	public static void main(String[] args) {
		
		try {
			new UseCallableStatement();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
