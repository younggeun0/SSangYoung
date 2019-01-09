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
				"������� �߰�\n�Է� ��)�����ȣ,�����,����,��å");

		if (tempData != null && !tempData.isEmpty()) {
			String[] data = tempData.split(",");

			if (data.length != 4) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ�����ּ���.");
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
				JOptionPane.showMessageDialog(null, "�����ȣ�� ������ �����Դϴ�.");
				return;
			}

			// ó���� �Է� �����͸� VO�� �����ϰ�
			TestProcVO tpvo = new TestProcVO(empno, sal, ename, job);

			// VO�� ���� DB�� insert
			try {
				String msg = "";
				msg = ucs_dao.insertProc(tpvo); // �߰� ����
				JOptionPane.showMessageDialog(null, msg);
			} catch (SQLException se) { // ����

				JOptionPane.showMessageDialog(null, "DBMS�� ������ �߻��߽��ϴ�.");
				se.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		RunUseCallableStatement rcs = new RunUseCallableStatement();

		boolean exitFlag = false;
		String inputMenu = "";

		do {
			inputMenu = JOptionPane.showInputDialog("�޴� ����\n1.����߰� " 
					+ "2.������� 3.������� 4.��ü�����ȸ 5.Ư�������ȸ 6.����");
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
							+ "�� �����Ǵ� ���񽺰� �ƴմϴ�.");
					exitFlag = true;
					break;
				}
			} else {
				exitFlag = true;
			}
		} while (!exitFlag);
		JOptionPane.showMessageDialog(null, "����� �ּż� �����մϴ�.");
	}
}
