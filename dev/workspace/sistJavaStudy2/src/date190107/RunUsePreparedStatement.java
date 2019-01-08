package date190107;

import java.awt.Font;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

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
		String tempData = JOptionPane.showInputDialog(
				"사원정보 추가\n입력 예)사원번호,사원명,연봉");

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
					errMsg = "뎨둉합니다. 시스템에 문제가 발생했습니다. "
							+ "잠시 후 다시 시도해주세요.";
				}
				JOptionPane.showMessageDialog(null, errMsg);
				se.printStackTrace();
			}
		}
	}

	public void modifyCpEmp2() {
		String tempData = JOptionPane
				.showInputDialog("사원정보 변경\n" + "사원번호에 일치하는 "
						+ "사원명과 연봉을 변경합니다.\n" + "입력 예)사원번호,사원명,연봉");

		if (tempData != null && !tempData.isEmpty()) {
			String[] data = tempData.split(",");

			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "입력형식을 확인해주세요.");
				return;
			}

			int empno = 0;
			String ename = "";
			int sal = 0;

			try {
				empno = Integer.parseInt(data[0].trim());
				ename = data[1].trim();
				sal = Integer.parseInt(data[2].trim());
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호나 연봉은 숫자입니다.");
				return;
			}

			// 처리된 입력 데이터를 VO에 설정하고
			CpEmp2VO cevo = new CpEmp2VO(empno, sal, ename);

			// VO의 값을 DB에 insert
			try {
				String msg = "";
				if (ups_dao.updateCpEmp2(cevo)) { // 변경된 레코드 존재
					msg = empno + "번 사원의 정보를 변경하였습니다.";
				} else { // 변경된 레코드가 존재하지 X
					msg = empno + "번 사원은 존재하지 않습니다.";
				}
				JOptionPane.showMessageDialog(null, msg);
			} catch (SQLException se) { // 예외
				String errMsg = "";

				switch (se.getErrorCode()) {
				case 12899:
					errMsg = "사원명이 너무 깁니다.";
					break;
				default:
					errMsg = "뎨둉합니다. 시스템에 문제가 발생했습니다."
							+ "잠시 후 다시 시도해주세요.";
				}
				JOptionPane.showMessageDialog(null, errMsg);
				se.printStackTrace();
			}
		}
	}

	public void removeCpEmp2() {
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
				String msg = empno + "번 사원은 존재하지 않습니다.";

				if (ups_dao.deleteCpEmp2(empno)) {
					msg = empno + "번 사원 정보를 삭제하였습니다.";
				}

				JOptionPane.showMessageDialog(null, msg);

			} catch (SQLException se) {
				JOptionPane.showMessageDialog(null, "죄송합니다. 문제가 발생하였습니다.");
				se.printStackTrace();
			}
		}
	}

	public void searchAllCpEmp2() {
		StringBuilder viewCpEmp2 = new StringBuilder();
		viewCpEmp2
		.append("------------------------------------------------------------")
		.append("--------------------------------------------------------------\n")
		.append("번호\t사원번호\t사원명\t입사일\t\t연봉\n")
		.append("------------------------------------------------------------")
		.append("--------------------------------------------------------------\n");

		int rowCount = 0;
		try {
			// DB에서 조회한 결과 받기
			List<CpEmp2AllVO> list = ups_dao.selectAllCpEmp2();
			CpEmp2AllVO cevo = null;

			rowCount = list.size();
			for (int i = 0; i < list.size(); i++) {
				cevo = list.get(i);
				viewCpEmp2
				.append(i + 1).append("\t")
				.append(cevo.getEmpno()).append("\t")
				.append(cevo.getEname()).append("\t")
				.append(cevo.getHiredate()).append("\t\t")
				.append(cevo.getSal()).append("\n");
			}
			
			if (list.isEmpty()) { // (list.isEmpty) == (list.size == 0)
				viewCpEmp2.append("입력된 사원정보가 존재하지 않습니다.\n");
			}

		} catch (SQLException e) {
			viewCpEmp2.append("DBMS에서 문제가 발생했습니다. ㅈㅅ\n");
			e.printStackTrace();
		}

		viewCpEmp2
		.append("------------------------------------------------------------")
		.append("--------------------------------------------------------------\n")
		.append("\t\t총 ").append(rowCount).append("명의 사원정보가 조회되었습니다.");

		JTextArea jta = new JTextArea(15, 45);
		jta.setEditable(false);
		jta.setText(viewCpEmp2.toString()); // 만들어진 출력데이터를 T.A에 설정
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("전체 사원 조회 결과"));
		JOptionPane.showMessageDialog(null, jsp);
	}

	public void searchOneCpEmp2() {
		String inputData = JOptionPane.showInputDialog("사원조회\n" + "조회할 사원번호를 입력");

		if (inputData != null && !inputData.isEmpty()) {
			int empno = 0;
			try {
				empno = Integer.parseInt(inputData);
				// 사원번호를 입력하여 사원번호에 해당하는 사원정보를 조회
				// 조회된 사원이 있다면 생성된 객체(CpEmp2OneVO)가 반환되고 
				// 조회된 부서가 없다면 null이 반환된다.
				CpEmp2OneVO cevo = ups_dao.selectOneCpEmp2(empno);

				SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy EEEEE");
				
				StringBuilder viewData = new StringBuilder();
				viewData
				.append("사원명 : ").append(cevo.getEname())
				.append(", 연봉 : ").append(cevo.getSal())
				.append(", 입사일 : ").append(sdf.format(cevo.getHiredate()));

				JLabel lbl = new JLabel(viewData.toString());
				lbl.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
				JOptionPane.showMessageDialog(null, lbl);
			} catch (NullPointerException npe) {
				// 존재하는 부서 번호를 제공
				try {
					List<Integer> listEmpNo = ups_dao.selectAllCpEmpNo();
					
					if (!listEmpNo.isEmpty()) {
						
						StringBuilder msg = new StringBuilder();
						msg.append(empno).append("사원은 존재하지 않습니다. ");
						for(int i=0; i<listEmpNo.size(); i++) {
							if (i == listEmpNo.size()-1) {
								msg.append(listEmpNo.get(i));
							} else {
								msg.append(listEmpNo.get(i)).append(", ");
							}
						}
						
						msg.append(" 번 사원만 존재합니다.");
						JOptionPane.showMessageDialog(null, msg);
						
					} else {
						JOptionPane.showMessageDialog(null, "어떤 사원도 존재하지 않습니다.");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호는 정수형태로 입력하셔야 합니다.");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "DB 서버에서 문제 발생");
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		RunUsePreparedStatement rps = new RunUsePreparedStatement();

		boolean exitFlag = false;
		String inputMenu = "";

		do {
			inputMenu = JOptionPane.showInputDialog("메뉴 선택\n1.사원추가 " 
					+ "2.사원변경 3.사원삭제 4.전체사원조회 5.특정사원조회 6.종료");
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
					JOptionPane.showMessageDialog(null, inputMenu 
							+ "는 제공되는 서비스가 아닙니다.");
					break;
				}
			} else {
				exitFlag = true;
			}
		} while (!exitFlag);
		JOptionPane.showMessageDialog(null, "사용해 주셔서 감사합니다.");
	}
}
