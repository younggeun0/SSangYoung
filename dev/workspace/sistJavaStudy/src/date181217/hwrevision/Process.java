package date181217.hwrevision;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import static java.lang.Integer.parseInt;

public class Process {
	
	private List<DataVO> list;
	private int scoreTot;
	
	private static final int INSERT_DATA = 1;
	private static final int VIEW_DATA = 2;
	private static final int EXIT = 3;

	public Process() {
		list = new ArrayList<DataVO>();
		inputMenu();
	}
	
	public boolean addData() {
		String input = JOptionPane.showInputDialog("�������Է�\n��) �̸�,�ڹ�����,����Ŭ����");
		String[] data = input.replaceAll(" ", "").split(",");

		if (data.length == 3) {
			
			try {
				int javaScore = parseInt(data[1]);
				int oracleScore = parseInt(data[2]);
				
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
		} 
		
		JTextArea jta = new JTextArea(10,40);
		jta.setEditable(false);
		
		StringBuilder viewData = new StringBuilder();
		viewData.append("��ȣ\t�̸�\t�ڹ�\t����Ŭ\t����\t���\n");
		
		int tempTot = 0;
		for(int i=0; i<list.size(); i++) {
			DataVO tempVO = list.get(i);
			int javaScore = tempVO.getJavaScore();
			int oracleScore = tempVO.getOracleScore();
			tempTot = javaScore + oracleScore;
			
			viewData.append(i+1).append("\t").append(tempVO.getName())
				.append("\t").append(javaScore).append("\t").append(oracleScore)
				.append("\t").append(tempTot).append("\t").append((tempTot/2)+"\n");
			scoreTot += tempTot;
			tempTot = 0;
		}
		
		viewData.append("\n\n\t\t\t\t���� : "+scoreTot+"\t ��� : "+(String.format("%5.2f", scoreTot/(double)(list.size()*2))));
		
		jta.append(viewData.toString());
		JOptionPane.showMessageDialog(null, jta);
	}
	
	public void inputMenu() {
		
		boolean exitFlag = false;
		do {
			
			try {
				int menu = parseInt(JOptionPane.showInputDialog("�޴��Է�\n1.�Է� 2.��� 3.����"));
				
				switch(menu) {
				case INSERT_DATA:

					if(addData()) {
						JOptionPane.showMessageDialog(null, "�߰��ƽ��ϴ�!");
					} 
					
					break;
				case VIEW_DATA:
					viewData();
					
					break;
				case EXIT:
					switch (JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?")) {
					case JOptionPane.OK_OPTION:
						exitFlag = true;
						break;
					}
					break;
				}
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�޴��� 1~3 ���ڸ� �Է°����մϴ�.");
			}
		} while(!exitFlag);
	}
}
