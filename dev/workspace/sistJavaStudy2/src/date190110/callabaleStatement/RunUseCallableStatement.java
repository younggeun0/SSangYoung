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
		// DAO�� �̱����������� ������� Ŭ����, ��ü�� �޾� ���
		ucs_dao = UseCallableStatementDAO.getInstance();
	}

	public void addTestProc() {
		String tempData = JOptionPane.showInputDialog("������� �߰�\n�Է� ��)�����ȣ,�����,����,��å");

		if (tempData != null && !tempData.isEmpty()) {
			String[] data = tempData.split(",");

			if (data.length != 4) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ�����ּ���.");
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

	public void modifyTestProc() {
		String tempData = JOptionPane
				.showInputDialog("������� ����\n" + "�����ȣ�� ��ġ�ϴ� " + "���ް� ������ �����մϴ�.\n" + "�Է� ��)�����ȣ,����,����");

		if (tempData != null && !tempData.isEmpty()) {
			String[] data = tempData.split(",");

			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ�����ּ���.");
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
				JOptionPane.showMessageDialog(null, "�����ȣ�� ������ �����Դϴ�.");
				return;
			}

			// ó���� �Է� �����͸� VO�� �����ϰ�
			TestProcUpdateVO tpuvo = new TestProcUpdateVO(empno, sal, job);

			// VO�� ���� DB�� insert
			String msg;
			try {
				msg = ucs_dao.updateProc(tpuvo);
				JOptionPane.showMessageDialog(null, msg);
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(null, "����! ��� �� �ٽ� �õ����ּ���.");
				se.printStackTrace();
			}
		}
	}

	public void searchAllTestProc() {
		StringBuilder viewTestProc = new StringBuilder();
		viewTestProc.append("----------------------------------------------------------------------------")
				.append("-----------------------------------------------------------------\n")
				.append("��ȣ\t�����ȣ\t�����\t�Ի���\t\t����\t ����\n")
				.append("----------------------------------------------------------------------------")
				.append("-----------------------------------------------------------------\n");

		int rowCount = 0;
		try {
			// DB���� ��ȸ�� ��� �ޱ�
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
				viewTestProc.append("�Էµ� ��������� �������� �ʽ��ϴ�.\n");
			}

		} catch (SQLException e) {
			viewTestProc.append("DBMS���� ������ �߻��߽��ϴ�. ����\n");
			e.printStackTrace();
		}

		viewTestProc.append("----------------------------------------------------------------------------")
				.append("-----------------------------------------------------------------\n").append("\t\t�� ")
				.append(rowCount).append("���� ��������� ��ȸ�Ǿ����ϴ�.");

		JTextArea jta = new JTextArea(15, 53);
		jta.setEditable(false);
		jta.setText(viewTestProc.toString()); // ������� ��µ����͸� T.A�� ����
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("��ü ��� ��ȸ ���"));
		JOptionPane.showMessageDialog(null, jsp);
	}

	public void searchOneTestProc() {
		String inputData = JOptionPane.showInputDialog("�����ȸ\n" + "��ȸ�� �����ȣ�� �Է�");

		if (inputData != null && !inputData.isEmpty()) {
			int empno = 0;
			try {
				empno = Integer.parseInt(inputData);
				TestProcOneVO tpovo = ucs_dao.selectOneTestProc(empno);

				StringBuilder viewData = new StringBuilder();
				viewData
				.append("����� : ").append(tpovo.getEname())
				.append(", ���� : ").append(tpovo.getSal())
				.append(", ���� : ").append(tpovo.getJob())
				.append(", �Ի��� : ").append(tpovo.getHiredate());

				JLabel lbl = new JLabel(viewData.toString());
				lbl.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
				JOptionPane.showMessageDialog(null, lbl);
			} catch (NullPointerException npe) {
				JOptionPane.showMessageDialog(null, empno + "����� �������� �ʽ��ϴ�. ");
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�����ȣ�� �������·� �Է��ϼž� �մϴ�.");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "DB �������� ���� �߻�");
				e.printStackTrace();
			}
		}
	}

	public void removeTestProc() {
		String inputData = JOptionPane.showInputDialog("��� ����\n" + "������ �����ȣ�� �Է����ּ���.");

		if (inputData != null && !inputData.isEmpty()) {
			int empno = 0;

			try {
				empno = Integer.parseInt(inputData.trim());
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�����ȣ�� ���ڿ��� �մϴ�.");
				return;
			}

			try {
				String msg = ucs_dao.deleteProc(empno);
				JOptionPane.showMessageDialog(null, msg);

			} catch (SQLException se) {
				JOptionPane.showMessageDialog(null, "�˼��մϴ�. ������ �߻��Ͽ����ϴ�.");
				se.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		RunUseCallableStatement rcs = new RunUseCallableStatement();

		boolean exitFlag = false;
		String inputMenu = "";

		do {
			inputMenu = JOptionPane.showInputDialog("�޴� ����\n1.����߰� " + "2.������� 3.������� 4.��ü�����ȸ 5.Ư�������ȸ 6.����");
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
