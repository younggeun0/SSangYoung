package date181218.date1217hwrevision;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import static java.lang.Integer.parseInt;

import java.text.DecimalFormat;

public class ScoreProcess {

	private List<ScoreVO> listStu;
	private int totalScore;

	private static final int INPUT_DATA = 1;
	private static final int VIEW_DATA= 2;
	private static final int EXIT = 3;
	
	public ScoreProcess() {
		listStu = new ArrayList<ScoreVO>();
	}
	
	/**
	 * ���ø޴��� ����
	 */
	public void inputMenu() {
		
		String selectMenu = "", inputResult="";
		boolean exitFlag = false;
		do {
			selectMenu = JOptionPane.showInputDialog(
					"�޴�����\n1.�Է� 2.��� 3.����");
			try {
				switch (parseInt(selectMenu)) {
				case INPUT_DATA:
					inputResult="�������� ������ ���� �ʰų� "
							+ "������ ���������̾�� �մϴ�.";
					if (inputData()) {
						inputResult = "�߰�����";
					} 
					JOptionPane.showMessageDialog(null, inputResult);
					break;
				case VIEW_DATA:
					printData(); 	 break;
				case EXIT:
					exitFlag = true; break;
				default : 
					JOptionPane.showMessageDialog(null, 
							"�޴��� 1,2,3 �� �ϳ����� �մϴ�.");
				}
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, 
						"�޴��� �����̾�� �մϴ�.");
			}
		} while(!exitFlag);
	}
	
	/**
	 * ����ó���� �����͸� �Է¹ޱ�
	 * @return
	 */
	public boolean inputData() {
		boolean flag = false;
		
		String inputData = JOptionPane.showInputDialog(
				"�������Է�\n��) �̸�, �ڹ�����, ����Ŭ����");
		
		String[] data = inputData.replaceAll(" ", "").split(",");
		
		if (data.length == 3) { // �Է����Ŀ� ���� ��
			try {
				// �ڹ������� ����Ŭ������ �����̾�� �Ѵ�.
				ScoreVO sv = new ScoreVO(data[0], 
						parseInt(data[1]), parseInt(data[2]));
				
				listStu.add(sv); // ������ �����͸� list�� �߰�
				flag = true; // �������� ����
			} catch (NumberFormatException nfe) {
				flag = false;
			}
		}
		
		return flag;
	}
	
	/**
	 * �Է������� ����ϴ� ��
	 */
	public void printData() {

		if (listStu.isEmpty()) {
			JOptionPane.showMessageDialog(null, "����� �����Ͱ� �����ϴ�.");
			return;
		}
		
		StringBuilder viewData = new StringBuilder();
		viewData
		.append("---------------------------------------------------------------------------------------------------------\n")
		.append("��ȣ\t�̸�\t�ڹ�����\t����Ŭ����\t����\t���\n")
		.append("---------------------------------------------------------------------------------------------------------\n");
		int tempTotal = 0;
		ScoreVO sv = null;
		for(int i=0; i<listStu.size(); i++) {
			sv = listStu.get(i);
			tempTotal = sv.getJavaScore() + sv.getOracleScore();
			viewData.append(i+1).append("\t").append(sv.getName())
				.append("\t").append(sv.getJavaScore())
				.append("\t").append(sv.getOracleScore())
				.append("\t").append(tempTotal)
				.append("\t").append(tempTotal/2.0).append("\n");
			
			// �� �л��� �ڹ������� ����Ŭ ������ ���� ���� ������
			totalScore += tempTotal;
			// �� �л��� ���������� �ʱ�ȭ
			tempTotal = 0;
		}
		DecimalFormat df = new DecimalFormat("0.00");
		String avg = df.format(totalScore/(double)(listStu.size()*2));
		
		viewData
			.append("---------------------------------------------------------------------------------------------------------\n")
			.append("\t\t\t\t����").append(totalScore).append("\t���")
			.append(avg);
		
		JTextArea jta = new JTextArea(7, 50);
		jta.append(viewData.toString());
		JScrollPane jsp = new JScrollPane(jta);
		JOptionPane.showMessageDialog(null, jsp);
	}
	
	public static void main(String[] args) {
		ScoreProcess sp = new ScoreProcess();
		sp.inputMenu();
	}
}
