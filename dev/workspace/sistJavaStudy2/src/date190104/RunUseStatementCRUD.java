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
		String tempData = JOptionPane.showInputDialog("�μ����� �߰�\n�Է� ��)�μ���ȣ,�μ���,��ġ");

		if (tempData != null && !tempData.isEmpty()) {
			String[] data = tempData.split(",");

			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ�����ּ���.");
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
				JOptionPane.showMessageDialog(null, "�μ���ȣ�� �����Դϴ�.");
				return;
			}

			// ó���� �Է� �����͸� VO�� �����ϰ�
			CpDeptVO cdvo = new CpDeptVO(deptno, dname, loc);

			// VO�� ���� DB�� insert
			try {
				us_crud.insertCpDept(cdvo); // �߰� ����
				JOptionPane.showMessageDialog(null, deptno + "�� �μ������� �߰�");
			} catch (SQLException se) { // ����

				String errMsg = "";

				switch (se.getErrorCode()) {
				case 1:
					errMsg = deptno + "�� �μ��� �̹� �����մϴ�.";
					break;
				case 1438:
					errMsg = "�μ� ��ȣ�� ���ڸ� �Դϴ�.";
					break;
				case 12899:
					errMsg = "�μ����̳� ��ġ�� �ʹ� ��ϴ�.";
					break;
				default:
					errMsg = "���E�մϴ�. �ý��ۿ� ������ �߻��߽��ϴ�." + "��� �� �ٽ� �õ����ּ���.";
				}
				JOptionPane.showMessageDialog(null, errMsg);
				se.printStackTrace();
			}

		}
	}

	public void modifyCpDept() {
		String tempData = JOptionPane
				.showInputDialog("�μ����� ����\n" + "�μ���ȣ�� ��ġ�ϴ� �μ���� ��ġ�� �����մϴ�.\n" + "�Է� ��)�μ���ȣ,�μ���,��ġ");

		if (tempData != null && !tempData.isEmpty()) {
			String[] data = tempData.split(",");

			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ�����ּ���.");
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
				JOptionPane.showMessageDialog(null, "�μ���ȣ�� �����Դϴ�.");
				return;
			}

			// ó���� �Է� �����͸� VO�� �����ϰ�
			CpDeptVO cdvo = new CpDeptVO(deptno, dname, loc);

			// VO�� ���� DB�� insert
			try {
				String msg = "";
				if (us_crud.updateCpDept(cdvo)) { // ����� ���ڵ� ����
					msg = deptno + "�� �μ��� ������ �����Ͽ����ϴ�.";
				} else { // ����� ���ڵ尡 �������� X
					msg = deptno + "�� �μ��� �������� �ʽ��ϴ�.";
				}
				JOptionPane.showMessageDialog(null, msg);
			} catch (SQLException se) { // ����
				String errMsg = "";

				switch (se.getErrorCode()) {
				case 12899:
					errMsg = "�μ����̳� ��ġ�� �ʹ� ��ϴ�.";
					break;
				default:
					errMsg = "���E�մϴ�. �ý��ۿ� ������ �߻��߽��ϴ�." + "��� �� �ٽ� �õ����ּ���.";
				}
				JOptionPane.showMessageDialog(null, errMsg);
				se.printStackTrace();
			}
		}
	}

	public void removeCpDept() {
		String inputData = JOptionPane.showInputDialog("�μ� ����\n" + "������ �μ���ȣ�� �Է����ּ���.");

		if (inputData != null && !inputData.isEmpty()) {
			int deptno = 0;

			try {
				deptno = Integer.parseInt(inputData);
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�μ���ȣ�� ���ڿ��� �մϴ�.");
				return;
			}

			try {
				String msg = deptno + "�� �μ��� �������� �ʽ��ϴ�.";

				if (us_crud.deleteCpDept(deptno)) {
					msg = deptno + "�� �μ� ������ �����Ͽ����ϴ�.";
				}

				JOptionPane.showMessageDialog(null, msg);

			} catch (SQLException se) {
				JOptionPane.showMessageDialog(null, "�˼��մϴ�. ������ �߻��Ͽ����ϴ�.");
				se.printStackTrace();
			}
		}
	}

	public void searchAllCpDept() {

		StringBuilder viewCpDept = new StringBuilder();
		viewCpDept.append("------------------------------------------------------------------------------\n")
				.append("��ȣ\t�μ���ȣ\t�μ���\t��ġ\n")
				.append("------------------------------------------------------------------------------\n");

		int rowCount = 0;
		try {
			// DB���� ��ȸ�� ��� �ޱ�
			List<CpDeptVO> list = us_crud.selectAllCpDept();
			CpDeptVO cdvo = null;

			rowCount = list.size();
			for (int i = 0; i < list.size(); i++) {
				cdvo = list.get(i);
				viewCpDept.append(i + 1).append("\t").append(cdvo.getDeptno()).append("\t").append(cdvo.getDname())
						.append("\t").append(cdvo.getLoc()).append("\n");
			}
			if (list.isEmpty()) { // list.isEmpty ���� ����. list.size == 0
				viewCpDept.append("�Էµ� �μ������� �������� �ʽ��ϴ�.\n");
			}

		} catch (SQLException e) {
			viewCpDept.append("DBMS���� ������ �߻��߽��ϴ�. ����\n");
			e.printStackTrace();
		}

		viewCpDept.append("------------------------------------------------------------------------------\n")
				.append("\t�� ").append(rowCount).append("���� �μ������� ��ȸ�Ǿ����ϴ�.");

		JTextArea jta = new JTextArea(15, 30);
		jta.setEditable(false);
		jta.setText(viewCpDept.toString()); // ������� ��µ����͸� T.A�� ����
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("��ü �μ� ��ȸ ���"));
		JOptionPane.showMessageDialog(null, jsp);
	}

	public void searchOneCpDept() {

		String inputData = JOptionPane.showInputDialog("�μ���ȸ\n" + "��ȸ�� �μ���ȣ�� �Է�");

		if (inputData != null && !inputData.isEmpty()) {
			int deptno = 0;
			try {
				deptno = Integer.parseInt(inputData);
				// �μ���ȣ�� �Է��Ͽ� �μ���ȣ�� �ش��ϴ� �μ������� ��ȸ
				// ��ȸ�� �μ��� �ִٸ� ������ ��ü�� ��ȯ�ǰ� ��ȸ�� �μ��� ���ٸ�
				// null�� ��ȯ�ȴ�.
				OneCpDeptVO ocdvo = us_crud.selectOneCpDept(deptno);

				StringBuilder viewData = new StringBuilder();
				viewData.append("�μ��� : ").append(ocdvo.getDname()).append(", ��ġ : ").append(ocdvo.getLoc());

				JLabel lbl = new JLabel(viewData.toString());
				lbl.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
				JOptionPane.showMessageDialog(null, lbl);
			} catch (NullPointerException npe) {
				// �����ϴ� �μ� ��ȣ�� ����
				try {
					List<Integer> listDeptNo = us_crud.selectAllCpDeptNo();
					
					if (!listDeptNo.isEmpty()) {
						StringBuilder msg = new StringBuilder();
						msg.append(deptno).append("�μ��� �������� �ʽ��ϴ�. ");
						for(int i=0; i<listDeptNo.size(); i++) {
							if (i == listDeptNo.size()-1) {
								msg.append(listDeptNo.get(i));
							} else {
								msg.append(listDeptNo.get(i)).append(", ");
							}
						}
						msg.append(" �� �μ��� �����մϴ�.");
						JOptionPane.showMessageDialog(null, msg);
						
					} else {
						JOptionPane.showMessageDialog(null, "� �μ��� �������� �ʽ��ϴ�.");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�μ���ȣ�� �������·� �Է��ϼž� �մϴ�.");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "DB �������� ���� �߻�");
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		RunUseStatementCRUD rus_crud = new RunUseStatementCRUD();

		boolean exitFlag = false;
		String inputMenu = "";

		do {
			inputMenu = JOptionPane.showInputDialog("�޴� ����\n1.�μ��߰� " + "2.�μ����� 3.�μ����� 4.��ü�μ���ȸ 5.Ư���μ���ȸ 6.����");
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
