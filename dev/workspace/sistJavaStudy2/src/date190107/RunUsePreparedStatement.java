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
				"������� �߰�\n�Է� ��)�����ȣ,�����,����");

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
					errMsg = "���E�մϴ�. �ý��ۿ� ������ �߻��߽��ϴ�. "
							+ "��� �� �ٽ� �õ����ּ���.";
				}
				JOptionPane.showMessageDialog(null, errMsg);
				se.printStackTrace();
			}
		}
	}

	public void modifyCpEmp2() {
		String tempData = JOptionPane
				.showInputDialog("������� ����\n" + "�����ȣ�� ��ġ�ϴ� "
						+ "������ ������ �����մϴ�.\n" + "�Է� ��)�����ȣ,�����,����");

		if (tempData != null && !tempData.isEmpty()) {
			String[] data = tempData.split(",");

			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ�����ּ���.");
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
				JOptionPane.showMessageDialog(null, "�����ȣ�� ������ �����Դϴ�.");
				return;
			}

			// ó���� �Է� �����͸� VO�� �����ϰ�
			CpEmp2VO cevo = new CpEmp2VO(empno, sal, ename);

			// VO�� ���� DB�� insert
			try {
				String msg = "";
				if (ups_dao.updateCpEmp2(cevo)) { // ����� ���ڵ� ����
					msg = empno + "�� ����� ������ �����Ͽ����ϴ�.";
				} else { // ����� ���ڵ尡 �������� X
					msg = empno + "�� ����� �������� �ʽ��ϴ�.";
				}
				JOptionPane.showMessageDialog(null, msg);
			} catch (SQLException se) { // ����
				String errMsg = "";

				switch (se.getErrorCode()) {
				case 12899:
					errMsg = "������� �ʹ� ��ϴ�.";
					break;
				default:
					errMsg = "���E�մϴ�. �ý��ۿ� ������ �߻��߽��ϴ�."
							+ "��� �� �ٽ� �õ����ּ���.";
				}
				JOptionPane.showMessageDialog(null, errMsg);
				se.printStackTrace();
			}
		}
	}

	public void removeCpEmp2() {
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
				String msg = empno + "�� ����� �������� �ʽ��ϴ�.";

				if (ups_dao.deleteCpEmp2(empno)) {
					msg = empno + "�� ��� ������ �����Ͽ����ϴ�.";
				}

				JOptionPane.showMessageDialog(null, msg);

			} catch (SQLException se) {
				JOptionPane.showMessageDialog(null, "�˼��մϴ�. ������ �߻��Ͽ����ϴ�.");
				se.printStackTrace();
			}
		}
	}

	public void searchAllCpEmp2() {
		StringBuilder viewCpEmp2 = new StringBuilder();
		viewCpEmp2
		.append("------------------------------------------------------------")
		.append("--------------------------------------------------------------\n")
		.append("��ȣ\t�����ȣ\t�����\t�Ի���\t\t����\n")
		.append("------------------------------------------------------------")
		.append("--------------------------------------------------------------\n");

		int rowCount = 0;
		try {
			// DB���� ��ȸ�� ��� �ޱ�
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
				viewCpEmp2.append("�Էµ� ��������� �������� �ʽ��ϴ�.\n");
			}

		} catch (SQLException e) {
			viewCpEmp2.append("DBMS���� ������ �߻��߽��ϴ�. ����\n");
			e.printStackTrace();
		}

		viewCpEmp2
		.append("------------------------------------------------------------")
		.append("--------------------------------------------------------------\n")
		.append("\t\t�� ").append(rowCount).append("���� ��������� ��ȸ�Ǿ����ϴ�.");

		JTextArea jta = new JTextArea(15, 45);
		jta.setEditable(false);
		jta.setText(viewCpEmp2.toString()); // ������� ��µ����͸� T.A�� ����
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("��ü ��� ��ȸ ���"));
		JOptionPane.showMessageDialog(null, jsp);
	}

	public void searchOneCpEmp2() {
		String inputData = JOptionPane.showInputDialog("�����ȸ\n" + "��ȸ�� �����ȣ�� �Է�");

		if (inputData != null && !inputData.isEmpty()) {
			int empno = 0;
			try {
				empno = Integer.parseInt(inputData);
				// �����ȣ�� �Է��Ͽ� �����ȣ�� �ش��ϴ� ��������� ��ȸ
				// ��ȸ�� ����� �ִٸ� ������ ��ü(CpEmp2OneVO)�� ��ȯ�ǰ� 
				// ��ȸ�� �μ��� ���ٸ� null�� ��ȯ�ȴ�.
				CpEmp2OneVO cevo = ups_dao.selectOneCpEmp2(empno);

				SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy EEEEE");
				
				StringBuilder viewData = new StringBuilder();
				viewData
				.append("����� : ").append(cevo.getEname())
				.append(", ���� : ").append(cevo.getSal())
				.append(", �Ի��� : ").append(sdf.format(cevo.getHiredate()));

				JLabel lbl = new JLabel(viewData.toString());
				lbl.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
				JOptionPane.showMessageDialog(null, lbl);
			} catch (NullPointerException npe) {
				// �����ϴ� �μ� ��ȣ�� ����
				try {
					List<Integer> listEmpNo = ups_dao.selectAllCpEmpNo();
					
					if (!listEmpNo.isEmpty()) {
						
						StringBuilder msg = new StringBuilder();
						msg.append(empno).append("����� �������� �ʽ��ϴ�. ");
						for(int i=0; i<listEmpNo.size(); i++) {
							if (i == listEmpNo.size()-1) {
								msg.append(listEmpNo.get(i));
							} else {
								msg.append(listEmpNo.get(i)).append(", ");
							}
						}
						
						msg.append(" �� ����� �����մϴ�.");
						JOptionPane.showMessageDialog(null, msg);
						
					} else {
						JOptionPane.showMessageDialog(null, "� ����� �������� �ʽ��ϴ�.");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�����ȣ�� �������·� �Է��ϼž� �մϴ�.");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "DB �������� ���� �߻�");
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		RunUsePreparedStatement rps = new RunUsePreparedStatement();

		boolean exitFlag = false;
		String inputMenu = "";

		do {
			inputMenu = JOptionPane.showInputDialog("�޴� ����\n1.����߰� " 
					+ "2.������� 3.������� 4.��ü�����ȸ 5.Ư�������ȸ 6.����");
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
							+ "�� �����Ǵ� ���񽺰� �ƴմϴ�.");
					break;
				}
			} else {
				exitFlag = true;
			}
		} while (!exitFlag);
		JOptionPane.showMessageDialog(null, "����� �ּż� �����մϴ�.");
	}
}
