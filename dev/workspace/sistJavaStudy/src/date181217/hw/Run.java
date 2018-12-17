package date181217.hw;

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
			menu = JOptionPane.showInputDialog("�޴�����\n1.�Է� 2.��� 3.����");
			try {
				if (Integer.parseInt(menu) == 1) {

					String[] data = JOptionPane.showInputDialog("�������Է�\n��)�̸�,�ڹ�����,����Ŭ����").split(",");

					try {
						checkInput(data);

					} catch (NumberFormatException ne) {
						JOptionPane.showMessageDialog(null, "������ ���ڸ� �Է°����մϴ�.", "����", JOptionPane.WARNING_MESSAGE);
					}
				}

				if (Integer.parseInt(menu) == 2) {
					if (listData.isEmpty()) {
						JOptionPane.showMessageDialog(null, "�����Ͱ� �����ϴ�.");
					} else {
						showTextArea();
					}
				}

			} catch (NumberFormatException ne) {
				JOptionPane.showMessageDialog(null, "����(1~3)�� �Է°����մϴ�.");
				menu = "-1";
			}
		} while (Integer.parseInt(menu) != 3);
	}

	public void checkInput(String[] data) {
		if (data.length == 3) {
			int java = Integer.parseInt(data[1]);
			int oracle = Integer.parseInt(data[2]);

			if (!((java > -1 && java < 101) && (oracle > -1 && oracle < 101))) {
				JOptionPane.showMessageDialog(null, "������ 0~100�� �Է°����մϴ�.", "����", JOptionPane.WARNING_MESSAGE);
			}
			for (int i = 0; i < data.length; i++) {
				data[i] = data[i].trim();
			}

			DataVO dataVO = new DataVO();
			dataVO.setName(data[0]);
			dataVO.setJavaScore(Integer.parseInt(data[1]));
			dataVO.setOracleScore(Integer.parseInt(data[2]));

			listData.add(dataVO);
		} else {
			JOptionPane.showMessageDialog(null, "�Է°��� ���� Ʋ���ϴ�.", "����", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void showTextArea() {
		int javaScore = 0, oracleScore = 0, sum = 0;
		double avg = 0;
		JTextArea jta = new JTextArea(10, 30);
		jta.setEditable(false);

		jta.append("��ȣ\t�̸�\t�ڹ�\t����Ŭ\t����\t���\t\n");

		for (int i = 0; i < listData.size(); i++) {
			javaScore = listData.get(i).getJavaScore();
			oracleScore = listData.get(i).getOracleScore();

			jta.append((i + 1) + "\t" + listData.get(i).getName() + "\t" + javaScore + "\t" + oracleScore + "\t"
					+ (javaScore + oracleScore) + "\t" + ((double) (javaScore + oracleScore) / 2) + "\n");

			sum += javaScore + oracleScore;
			avg += ((double) (javaScore + oracleScore) / 2);
		}
		jta.append("\t\t\t\t���� : " + sum + "\t ��� : " + ((double) (avg / listData.size())));

		JOptionPane.showMessageDialog(null, jta);
	}

	public static void main(String[] args) {
		new Run();
	}
}
