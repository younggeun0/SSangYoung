package date181217.hwrevision;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Process {
	
	private List<DataVO> list;
	private int javaTot, oracleTot;

	public Process() {
		
		list = new ArrayList<DataVO>();
		
		while(true) {
			inputMenu();
		}
	}
	
	public boolean addData() {
		String[] data = JOptionPane.showInputDialog("�������Է�\n��) �̸�,�ڹ�����,����Ŭ����").split(",");

		if (data.length == 3) {
			
			try {
				for(int i=0; i<data.length; i++) {
					data[i] = data[i].trim();
				}
				
				int javaScore = Integer.parseInt(data[1]);
				int oracleScore = Integer.parseInt(data[2]);
				
				if ((javaScore > -1 && javaScore < 101) && (oracleScore > -1 && oracleScore < 101)) {
					DataVO dataVO = new DataVO(data[0], javaScore, oracleScore);
					
					list.add(dataVO);
					
					return true;
				} else {
					JOptionPane.showMessageDialog(null, "������ 0~100 ���̰��� �Է� �����մϴ�!");
					return false;
				}
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "������ ���ڸ� �Է� �����մϴ�!");
				return false;
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "�̸�, �ڹ�����, ����Ŭ����\n�̷��� ������ ���� �Է����ּ���");
			return false;
		}
		
	}
	
	public void viewData() {
		
		if(list.isEmpty()) {
			JOptionPane.showMessageDialog(null, "�����Ͱ� �����ϴ�.");
			return;
		} else {
			
			JTextArea jta = new JTextArea(10,40);
			jta.setEditable(false);
			jta.append("��ȣ\t�̸�\t�ڹ�\t����Ŭ\t����\t���\n");
			
			for(int i=0; i<list.size(); i++) {
				int javaScore = list.get(i).getJavaScore();
				int oracleScore = list.get(i).getOracleScore();
				
				jta.append((i+1)+"\t"+list.get(i).getName()+"\t"
						+javaScore+"\t"+oracleScore+"\t"+(javaScore+oracleScore)
						+"\t"+((javaScore+oracleScore)/2)+"\n");
				javaTot += javaScore;
				oracleTot += oracleScore;
			}
			jta.append("\t\t\t\t���� : "+(javaTot+oracleTot)+"\t ��� : "+((javaTot+oracleTot)/(list.size()*2)));
			
			JOptionPane.showMessageDialog(null, jta);
		}
		
	}
	
	public void inputMenu() {
		try {
			int menu = Integer.parseInt(JOptionPane.showInputDialog("�޴��Է�\n1.�Է� 2.��� 3.����"));

			if (menu == 1) {
				addData();
			}
			
			if (menu == 2) {
				viewData();
			}
			
			if (menu == 3) {
				switch (JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?")) {
				case JOptionPane.OK_OPTION:
					System.exit(0);
				}
			}
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "�޴��� 1~3 ���ڸ� �Է°����մϴ�.");
		}
	}
}
