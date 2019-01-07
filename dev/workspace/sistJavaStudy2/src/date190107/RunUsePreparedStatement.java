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
		String tempData = JOptionPane.showInputDialog("������� �߰�\n�Է� ��)�����ȣ,�����,����");

		if (tempData != null && !tempData.isEmpty()) {
			String[] data = tempData.split(",");

			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ�����ּ���.");
				return;
			}

			int empno = 0, sal = 0;
			String ename = "";

			try {
				empno = Integer.parseInt(data[0]);
				ename = data[1];
				sal = Integer.parseInt(data[2]);
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�����ȣ�� ������ �����Դϴ�.");
				return;
			}

			// ó���� �Է� �����͸� VO�� �����ϰ�
			CpEmp2VO cevo = new CpEmp2VO(empno, sal, ename);

			// VO�� ���� DB�� insert
			try {
				ups_dao.insertCpEmp2(cevo); // �߰� ����
				JOptionPane.showMessageDialog(null, empno + "�� ��������� �ԷµǾ����ϴ�.");
			} catch (SQLException se) { // ����

				String errMsg = "";

				switch (se.getErrorCode()) {
				case 1438:
					errMsg = "�����ȣ�� 4�ڸ��̰�, ������ 5�ڸ� �Դϴ�.";
					break;
				case 12899:
					errMsg = "������� �ʹ� ��ϴ�.";
					break;
				default:
					errMsg = "���E�մϴ�. �ý��ۿ� ������ �߻��߽��ϴ�." + "��� �� �ٽ� �õ����ּ���.";
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
			inputMenu = JOptionPane.showInputDialog("�޴� ����\n1.����߰� " + "2.������� 3.������� 4.��ü�����ȸ 5.Ư�������ȸ 6.����");
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
					JOptionPane.showMessageDialog(null, inputMenu + "�� �����Ǵ� ���񽺰� �ƴմϴ�.");
					break;
				}
			} else {
				exitFlag = true;
			}
		} while (!exitFlag);
		JOptionPane.showMessageDialog(null, "����� �ּż� �����մϴ�.");
	}
}
