package date190110.callabaleStatement;

import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class RunUseCallableStatement {

	private static final String ADD_EMP = "1";
	private static final String MODIFY_EMP = "2";
	private static final String REMOVE_EMP = "3";
	private static final String SEARCH_ALL_EMP = "4";
	private static final String SEARCH_ONE_EMP = "5";
	private static final String EXIT = "6";

	private UseCallableStatementDAO ucs_dao;

	public RunUseCallableStatement() {
		// DAO는 싱글턴패턴으로 만들어진 클래스, 객체를 받아 사용
		ucs_dao = UseCallableStatementDAO.getInstance();
	}

	public void addTestProc() {
		String tempData = JOptionPane.showInputDialog("사원정보 추가\n입력 예)사원번호,사원명,연봉,직책");

		if (tempData != null && !tempData.isEmpty()) {
			String[] data = tempData.split(",");

			if (data.length != 4) {
				JOptionPane.showMessageDialog(null, "입력형식을 확인해주세요.");
				return;
			}

			int empno = 0, sal = 0;
			String ename = "", job = "";

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

	public void modifyTestProc() {
		String tempData = JOptionPane
				.showInputDialog("사원정보 변경\n" + "사원번호에 일치하는 " + "직급과 연봉을 변경합니다.\n" + "입력 예)사원번호,직급,연봉");

		if (tempData != null && !tempData.isEmpty()) {
			String[] data = tempData.split(",");

			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "입력형식을 확인해주세요.");
				return;
			}

			int empno = 0;
			String job = "";
			int sal = 0;

			try {
				empno = Integer.parseInt(data[0].trim());
				job = data[1].trim();
				sal = Integer.parseInt(data[2].trim());
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호나 연봉은 숫자입니다.");
				return;
			}

			// 처리된 입력 데이터를 VO에 설정하고
			TestProcUpdateVO tpuvo = new TestProcUpdateVO(empno, sal, job);

			// VO의 값을 DB에 insert
			String msg;
			try {
				msg = ucs_dao.updateProc(tpuvo);
				JOptionPane.showMessageDialog(null, msg);
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(null, "ㅈㅅ! 잠시 후 다시 시도해주세요.");
				se.printStackTrace();
			}
		}
	}

	public void searchAllTestProc() {
		StringBuilder viewTestProc = new StringBuilder();
		viewTestProc.append("----------------------------------------------------------------------------")
				.append("-----------------------------------------------------------------\n")
				.append("번호\t사원번호\t사원명\t입사일\t\t연봉\t 직무\n")
				.append("----------------------------------------------------------------------------")
				.append("-----------------------------------------------------------------\n");

		int rowCount = 0;
		try {
			// DB에서 조회한 결과 받기
			List<TestProcAllVO> list = ucs_dao.selectAllTestProc();
			TestProcAllVO tpavo = null;

			rowCount = list.size();
			for (int i = 0; i < list.size(); i++) {
				tpavo = list.get(i);
				viewTestProc.append(i + 1).append("\t").append(tpavo.getEmpno()).append("\t").append(tpavo.getEname())
						.append("\t").append(tpavo.getHiredate()).append("\t").append(tpavo.getSal()).append("\t")
						.append(tpavo.getJob()).append("\n");
			}

			if (list.isEmpty()) { // (list.isEmpty) == (list.size == 0)
				viewTestProc.append("입력된 사원정보가 존재하지 않습니다.\n");
			}

		} catch (SQLException e) {
			viewTestProc.append("DBMS에서 문제가 발생했습니다. ㅈㅅ\n");
			e.printStackTrace();
		}

		viewTestProc.append("----------------------------------------------------------------------------")
				.append("-----------------------------------------------------------------\n").append("\t\t총 ")
				.append(rowCount).append("명의 사원정보가 조회되었습니다.");

		JTextArea jta = new JTextArea(15, 53);
		jta.setEditable(false);
		jta.setText(viewTestProc.toString()); // 만들어진 출력데이터를 T.A에 설정
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("전체 사원 조회 결과"));
		JOptionPane.showMessageDialog(null, jsp);
	}

	public void searchOneTestProc() {
		String inputData = JOptionPane.showInputDialog("사원조회\n" + "조회할 사원번호를 입력");

		if (inputData != null && !inputData.isEmpty()) {
			int empno = 0;
			try {
				empno = Integer.parseInt(inputData);
				TestProcOneVO tpovo = ucs_dao.selectOneTestProc(empno);

				StringBuilder viewData = new StringBuilder();
				viewData
				.append("사원명 : ").append(tpovo.getEname())
				.append(", 연봉 : ").append(tpovo.getSal())
				.append(", 직급 : ").append(tpovo.getJob())
				.append(", 입사일 : ").append(tpovo.getHiredate());

				JLabel lbl = new JLabel(viewData.toString());
				lbl.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
				JOptionPane.showMessageDialog(null, lbl);
			} catch (NullPointerException npe) {
				JOptionPane.showMessageDialog(null, empno + "사원은 존재하지 않습니다. ");
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호는 정수형태로 입력하셔야 합니다.");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "DB 서버에서 문제 발생");
				e.printStackTrace();
			}
		}
	}

	public void removeTestProc() {
		String inputData = JOptionPane.showInputDialog("사원 삭제\n" + "삭제할 사원번호를 입력해주세요.");

		if (inputData != null && !inputData.isEmpty()) {
			int empno = 0;

			try {
				empno = Integer.parseInt(inputData.trim());
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호는 숫자여야 합니다.");
				return;
			}

			try {
				String msg = ucs_dao.deleteProc(empno);
				JOptionPane.showMessageDialog(null, msg);

			} catch (SQLException se) {
				JOptionPane.showMessageDialog(null, "죄송합니다. 문제가 발생하였습니다.");
				se.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		RunUseCallableStatement rcs = new RunUseCallableStatement();

		boolean exitFlag = false;
		String inputMenu = "";

		do {
			inputMenu = JOptionPane.showInputDialog("메뉴 선택\n1.사원추가 " + "2.사원변경 3.사원삭제 4.전체사원조회 5.특정사원조회 6.종료");
			if (inputMenu != null) {
				switch (inputMenu) {
				case RunUseCallableStatement.ADD_EMP:
					rcs.addTestProc();
					break;
				case RunUseCallableStatement.MODIFY_EMP:
					rcs.modifyTestProc();
					break;
				case RunUseCallableStatement.REMOVE_EMP:
					rcs.removeTestProc();
					break;
				case RunUseCallableStatement.SEARCH_ALL_EMP:
					rcs.searchAllTestProc();
					break;
				case RunUseCallableStatement.SEARCH_ONE_EMP:
					rcs.searchOneTestProc();
					break;
				case RunUseCallableStatement.EXIT:
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
