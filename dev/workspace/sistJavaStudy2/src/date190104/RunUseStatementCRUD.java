package date190104;

import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class RunUseStatementCRUD {

	private static final String ADD_DEPT = "1";
	private static final String MODIFY_DEPT = "2";
	private static final String REMOVE_DEPT = "3";
	private static final String SEARCH_ALL_DEPT = "4";
	private static final String SEARCH_ONE_DEPT = "5";
	private static final String EXIT = "6";

	private UseStatementCRUD us_crud;

	public RunUseStatementCRUD() {
		us_crud = new UseStatementCRUD();
	}

	public void addCpDept() {
		String tempData = JOptionPane.showInputDialog("부서정보 추가\n입력 예)부서번호,부서명,위치");

		if (tempData != null && !tempData.isEmpty()) {
			String[] data = tempData.split(",");

			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "입력형식을 확인해주세요.");
				return;
			}

			int deptno = 0;
			String dname = "";
			String loc = "";

			try {
				deptno = Integer.parseInt(data[0]);
				dname = data[1];
				loc = data[2];
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "부서번호는 숫자입니다.");
				return;
			}

			// 처리된 입력 데이터를 VO에 설정하고
			CpDeptVO cdvo = new CpDeptVO(deptno, dname, loc);

			// VO의 값을 DB에 insert
			try {
				us_crud.insertCpDept(cdvo); // 추가 성공
				JOptionPane.showMessageDialog(null, deptno + "번 부서정보를 추가");
			} catch (SQLException se) { // 예외

				String errMsg = "";

				switch (se.getErrorCode()) {
				case 1:
					errMsg = deptno + "번 부서는 이미 존재합니다.";
					break;
				case 1438:
					errMsg = "부서 번호는 두자리 입니다.";
					break;
				case 12899:
					errMsg = "부서명이나 위치가 너무 깁니다.";
					break;
				default:
					errMsg = "뎨둉합니다. 시스템에 문제가 발생했습니다." + "잠시 후 다시 시도해주세요.";
				}
				JOptionPane.showMessageDialog(null, errMsg);
				se.printStackTrace();
			}

		}
	}

	public void modifyCpDept() {
		String tempData = JOptionPane
				.showInputDialog("부서정보 변경\n" + "부서번호에 일치하는 부서명과 위치를 변경합니다.\n" + "입력 예)부서번호,부서명,위치");

		if (tempData != null && !tempData.isEmpty()) {
			String[] data = tempData.split(",");

			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "입력형식을 확인해주세요.");
				return;
			}

			int deptno = 0;
			String dname = "";
			String loc = "";

			try {
				deptno = Integer.parseInt(data[0]);
				dname = data[1];
				loc = data[2];
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "부서번호는 숫자입니다.");
				return;
			}

			// 처리된 입력 데이터를 VO에 설정하고
			CpDeptVO cdvo = new CpDeptVO(deptno, dname, loc);

			// VO의 값을 DB에 insert
			try {
				String msg = "";
				if (us_crud.updateCpDept(cdvo)) { // 변경된 레코드 존재
					msg = deptno + "번 부서의 정보를 변경하였습니다.";
				} else { // 변경된 레코드가 존재하지 X
					msg = deptno + "번 부서는 존재하지 않습니다.";
				}
				JOptionPane.showMessageDialog(null, msg);
			} catch (SQLException se) { // 예외
				String errMsg = "";

				switch (se.getErrorCode()) {
				case 12899:
					errMsg = "부서명이나 위치가 너무 깁니다.";
					break;
				default:
					errMsg = "뎨둉합니다. 시스템에 문제가 발생했습니다." + "잠시 후 다시 시도해주세요.";
				}
				JOptionPane.showMessageDialog(null, errMsg);
				se.printStackTrace();
			}
		}
	}

	public void removeCpDept() {
		String inputData = JOptionPane.showInputDialog("부서 삭제\n" + "삭제할 부서번호를 입력해주세요.");

		if (inputData != null && !inputData.isEmpty()) {
			int deptno = 0;

			try {
				deptno = Integer.parseInt(inputData);
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "부서번호는 숫자여야 합니다.");
				return;
			}

			try {
				String msg = deptno + "번 부서는 존재하지 않습니다.";

				if (us_crud.deleteCpDept(deptno)) {
					msg = deptno + "번 부서 정보를 삭제하였습니다.";
				}

				JOptionPane.showMessageDialog(null, msg);

			} catch (SQLException se) {
				JOptionPane.showMessageDialog(null, "죄송합니다. 문제가 발생하였습니다.");
				se.printStackTrace();
			}
		}
	}

	public void searchAllCpDept() {

		StringBuilder viewCpDept = new StringBuilder();
		viewCpDept.append("------------------------------------------------------------------------------\n")
				.append("번호\t부서번호\t부서명\t위치\n")
				.append("------------------------------------------------------------------------------\n");

		int rowCount = 0;
		try {
			// DB에서 조회한 결과 받기
			List<CpDeptVO> list = us_crud.selectAllCpDept();
			CpDeptVO cdvo = null;

			rowCount = list.size();
			for (int i = 0; i < list.size(); i++) {
				cdvo = list.get(i);
				viewCpDept.append(i + 1).append("\t").append(cdvo.getDeptno()).append("\t").append(cdvo.getDname())
						.append("\t").append(cdvo.getLoc()).append("\n");
			}
			if (list.isEmpty()) { // list.isEmpty 둘은 같다. list.size == 0
				viewCpDept.append("입력된 부서정보가 존재하지 않습니다.\n");
			}

		} catch (SQLException e) {
			viewCpDept.append("DBMS에서 문제가 발생했습니다. ㅈㅅ\n");
			e.printStackTrace();
		}

		viewCpDept.append("------------------------------------------------------------------------------\n")
				.append("\t총 ").append(rowCount).append("개의 부서정보가 조회되었습니다.");

		JTextArea jta = new JTextArea(15, 30);
		jta.setEditable(false);
		jta.setText(viewCpDept.toString()); // 만들어진 출력데이터를 T.A에 설정
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("전체 부서 조회 결과"));
		JOptionPane.showMessageDialog(null, jsp);
	}

	public void searchOneCpDept() {

		String inputData = JOptionPane.showInputDialog("부서조회\n" + "조회할 부서번호를 입력");

		if (inputData != null && !inputData.isEmpty()) {
			int deptno = 0;
			try {
				deptno = Integer.parseInt(inputData);
				// 부서번호를 입력하여 부서번호에 해당하는 부서정보를 조회
				// 조회한 부서가 있다면 생성된 객체가 반환되고 조회된 부서가 없다면
				// null이 반환된다.
				OneCpDeptVO ocdvo = us_crud.selectOneCpDept(deptno);

				StringBuilder viewData = new StringBuilder();
				viewData.append("부서명 : ").append(ocdvo.getDname()).append(", 위치 : ").append(ocdvo.getLoc());

				JLabel lbl = new JLabel(viewData.toString());
				lbl.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
				JOptionPane.showMessageDialog(null, lbl);
			} catch (NullPointerException npe) {
				// 존재하는 부서 번호를 제공
				try {
					List<Integer> listDeptNo = us_crud.selectAllCpDeptNo();
					
					if (!listDeptNo.isEmpty()) {
						StringBuilder msg = new StringBuilder();
						msg.append(deptno).append("부서는 존재하지 않습니다. ");
						for(int i=0; i<listDeptNo.size(); i++) {
							if (i == listDeptNo.size()-1) {
								msg.append(listDeptNo.get(i));
							} else {
								msg.append(listDeptNo.get(i)).append(", ");
							}
						}
						msg.append(" 번 부서만 존재합니다.");
						JOptionPane.showMessageDialog(null, msg);
						
					} else {
						JOptionPane.showMessageDialog(null, "어떤 부서도 존재하지 않습니다.");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "부서번호는 정수형태로 입력하셔야 합니다.");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "DB 서버에서 문제 발생");
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		RunUseStatementCRUD rus_crud = new RunUseStatementCRUD();

		boolean exitFlag = false;
		String inputMenu = "";

		do {
			inputMenu = JOptionPane.showInputDialog("메뉴 선택\n1.부서추가 " + "2.부서변경 3.부서삭제 4.전체부서조회 5.특정부서조회 6.종료");
			if (inputMenu != null) {
				switch (inputMenu) {
				case RunUseStatementCRUD.ADD_DEPT:
					rus_crud.addCpDept();
					break;
				case RunUseStatementCRUD.MODIFY_DEPT:
					rus_crud.modifyCpDept();
					break;
				case RunUseStatementCRUD.REMOVE_DEPT:
					rus_crud.removeCpDept();
					break;
				case RunUseStatementCRUD.SEARCH_ALL_DEPT:
					rus_crud.searchAllCpDept();
					break;
				case RunUseStatementCRUD.SEARCH_ONE_DEPT:
					rus_crud.searchOneCpDept();
					break;
				case RunUseStatementCRUD.EXIT:
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
