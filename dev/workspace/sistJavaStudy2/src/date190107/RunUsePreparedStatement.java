package date190107;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import date190104.CpDeptVO;

public class RunUsePreparedStatement {

	private static final String ADD_EMP = "1";
	private static final String MODIFY_EMP = "2";
	private static final String REMOVE_EMP = "3";
	private static final String SEARCH_ALL_EMP = "4";
	private static final String SEARCH_ONE_EMP = "5";
	private static final String EXIT = "6";
	
	private UsePreparedStatementDAO ups_dao;
	
	public RunUsePreparedStatement() {
		ups_dao = new UsePreparedStatementDAO();
	}

	public void addCpEmp2() {
		String tempData = JOptionPane.showInputDialog("사원정보 추가\n입력 예)사원번호,사원명,연봉");

		if (tempData != null && !tempData.isEmpty()) {
			String[] data = tempData.split(",");

			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "입력형식을 확인해주세요.");
				return;
			}

			int empno = 0, sal = 0;
			String ename = "";

			try {
				empno = Integer.parseInt(data[0]);
				ename = data[1];
				sal = Integer.parseInt(data[2]);
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호와 연봉은 숫자입니다.");
				return;
			}

			// 처리된 입력 데이터를 VO에 설정하고
			CpEmp2VO cevo = new CpEmp2VO(empno, sal, ename);

			// VO의 값을 DB에 insert
			try {
				ups_dao.insertCpEmp2(cevo); // 추가 성공
				JOptionPane.showMessageDialog(null, empno + "번 사원정보가 입력되었습니다.");
			} catch (SQLException se) { // 예외

				String errMsg = "";

				switch (se.getErrorCode()) {
				case 1438:
					errMsg = "사원번호는 4자리이고, 연봉은 5자리 입니다.";
					break;
				case 12899:
					errMsg = "사원명이 너무 깁니다.";
					break;
				default:
					errMsg = "뎨둉합니다. 시스템에 문제가 발생했습니다." + "잠시 후 다시 시도해주세요.";
				}
				JOptionPane.showMessageDialog(null, errMsg);
				se.printStackTrace();
			}
		}
	}

	public void modifyCpEmp2() {

	}

	public void removeCpEmp2() {

	}

	public void searchAllCpEmp2() {

	}

	public void searchOneCpEmp2() {

	}

	public static void main(String[] args) {
		RunUsePreparedStatement rps = new RunUsePreparedStatement();

		boolean exitFlag = false;
		String inputMenu = "";

		do {
			inputMenu = JOptionPane.showInputDialog("메뉴 선택\n1.사원추가 " + "2.사원변경 3.사원삭제 4.전체사원조회 5.특정사원조회 6.종료");
			if (inputMenu != null) {
				switch (inputMenu) {
				case RunUsePreparedStatement.ADD_EMP:
					rps.addCpEmp2();
					break;
				case RunUsePreparedStatement.MODIFY_EMP:
					rps.modifyCpEmp2();
					break;
				case RunUsePreparedStatement.REMOVE_EMP:
					rps.removeCpEmp2();
					break;
				case RunUsePreparedStatement.SEARCH_ALL_EMP:
					rps.searchAllCpEmp2();
					break;
				case RunUsePreparedStatement.SEARCH_ONE_EMP:
					rps.searchOneCpEmp2();
					break;
				case RunUsePreparedStatement.EXIT:
					exitFlag = true;
					break;
				default:
					JOptionPane.showMessageDialog(null, inputMenu + "는 제공되는 서비스가 아닙니다.");
					break;
				}
			} else {
				exitFlag = true;
			}
		} while (!exitFlag);
		JOptionPane.showMessageDialog(null, "사용해 주셔서 감사합니다.");
	}
}
