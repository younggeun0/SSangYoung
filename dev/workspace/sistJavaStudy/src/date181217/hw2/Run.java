package date181217.hw2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Run {

	private List<DataVO> listData;
	
	public Run() {
		
		listData = new ArrayList<DataVO>();
		String menu = null;
		
		do {
			try {
				menu = JOptionPane.showInputDialog("�޴�����\n1.�Է� 2.��� 3.����");

				if (Integer.parseInt(menu) == 1) {
					
					String[] input = JOptionPane.showInputDialog(
							"�������Է�\n��) �̸�, �ڹ�����, ����Ŭ����").split(",");
					
					if (input.length == 3) {

						try {
							
							int javaScore = Integer.parseInt(input[1]);
							int oracleScore = Integer.parseInt(input[2]);
							
							if ((javaScore > -1 && javaScore < 101 ) &&
									(oracleScore > -1 && oracleScore < 101)) {
								
								DataVO dataVO = new DataVO();
								dataVO.setName(input[0]);
								dataVO.setJavaScore(Integer.parseInt(input[1]));
								dataVO.setOracleScore(Integer.parseInt(input[2]));
								
								listData.add(dataVO);
							} else {
								JOptionPane.showMessageDialog(null, "������ 0~100 ���̰��� �Է°����մϴ�.");
							}
						} catch (NumberFormatException ne) {
							JOptionPane.showMessageDialog(null, "������ ���ڸ� �Է°����մϴ�.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "�̸�, �ڹ�����, ����Ŭ������ �Է����ּ���.");
					}
				}
				
				if (Integer.parseInt(menu) == 2) {
					
					if (listData.isEmpty()) {
						JOptionPane.showMessageDialog(null, "�����Ͱ� �����ϴ�.");
					} else {
						JTextArea jta = new JTextArea(10, 40);
						jta.setEditable(false);
						
						int javaScore = 0, oracleScore = 0;
						int sum = 0, avg = 0;

						jta.append("��ȣ\t�̸�\t�ڹ�\t����Ŭ\t����\t���\n");
						for(int i=0; i<listData.size(); i++) {
							javaScore = listData.get(i).getJavaScore();
							oracleScore = listData.get(i).getOracleScore();
							
							jta.append((i+1)+"\t"+listData.get(i).getName()
									+"\t"+javaScore+"\t"
									+oracleScore+"\t"
									+(javaScore+oracleScore)+"\t"+
									+((javaScore+oracleScore)/2)+"\n");
							sum += javaScore+oracleScore;
							avg += (javaScore+oracleScore)/2;
						}
						
						jta.append("\t\t\t���� : "+sum+" ��� : "+(avg/listData.size()));
						
						JOptionPane.showMessageDialog(null, jta);
					}
				}
				
				
			} catch (NumberFormatException ne) {
				JOptionPane.showMessageDialog(null, "���� 1~3�� �Է°����մϴ�.");
				menu = "-1";
			}
		} while(Integer.parseInt(menu) != 3);
	}

	public static void main(String[] args) {
		new Run();
	}
}
