package date190109;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import date190107.preparedStatement.CpEmp2VO;
import date190107.preparedStatement.RunUsePreparedStatement;

public class RunUseCallableStatement {
	
	private static final String ADD_EMP = "1";
	private static final String MODIFY_EMP = "2";
	private static final String REMOVE_EMP = "3";
	private static final String SEARCH_ALL_EMP = "4";
	private static final String SEARCH_ONE_EMP = "5";
	private static final String EXIT = "6";
	
	private UseCallableStatementDAO ucs_dao;
	
	public RunUseCallableStatement() {
		ucs_dao = UseCallableStatementDAO.getInstance();
	}
	
	public void addTestProc() {
		String tempData = JOptionPane.showInputDialog(
				"사원정보 추가\n입력 예)사원번호,사원명,연봉,직책");

		if (tempData != null && !tempData.isEmpty()) {
			String[] data = tempData.split(",");

			if (data.length != 4) {
				JOptionPane.showMessageDialog(null, "입력형식을 확인해주세요.");
				return;
			}

			int empno = 0, sal = 0;
			String ename = "", job ="";

			try {
				empno = Integer.parseInt(data[0].trim());
				ename = data[1];
				sal = Integer.parseInt(data[2].trim());
				job = data[3];
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호와 연봉은 숫자입니다.");
				return;
			}

			// 처리된 입력 데이터를 VO에 설정하고
			TestProcVO tpvo = new TestProcVO(empno, sal, ename, job);

			// VO의 값을 DB에 insert
			try {
				String msg = "";
				msg = ucs_dao.insertProc(tpvo); // 추가 성공
				JOptionPane.showMessageDialog(null, msg);
			} catch (SQLException se) { // 예외

				JOptionPane.showMessageDialog(null, "DBMS에 문제가 발생했습니다.");
				se.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		RunUseCallableStatement rcs = new RunUseCallableStatement();

		boolean exitFlag = false;
		String inputMenu = "";

		do {
			inputMenu = JOptionPane.showInputDialog("메뉴 선택\n1.사원추가 " 
					+ "2.사원변경 3.사원삭제 4.전체사원조회 5.특정사원조회 6.종료");
			if (inputMenu != null) {
				switch (inputMenu) {
				case RunUseCallableStatement.ADD_EMP:
					rcs.addTestProc();
					break;
				/*case RunUsePreparedStatement.MODIFY_EMP:
					rcs.modifyCpEmp2();
					break;
				case RunUsePreparedStatement.REMOVE_EMP:
					rcs.removeCpEmp2();
					break;
				case RunUsePreparedStatement.SEARCH_ALL_EMP:
					rcs.searchAllCpEmp2();
					break;
				case RunUsePreparedStatement.SEARCH_ONE_EMP:
					rcs.searchOneCpEmp2();
					break;
				case RunUsePreparedStatement.EXIT:
					exitFlag = true;
					break;*/
				default:
					JOptionPane.showMessageDialog(null, inputMenu 
							+ "는 제공되는 서비스가 아닙니다.");
					exitFlag = true;
					break;
				}
			} else {
				exitFlag = true;
			}
		} while (!exitFlag);
		JOptionPane.showMessageDialog(null, "사용해 주셔서 감사합니다.");
	}
}
