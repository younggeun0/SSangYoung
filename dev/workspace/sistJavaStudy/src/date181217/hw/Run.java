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
			menu = JOptionPane.showInputDialog("메뉴선택\n1.입력 2.출력 3.종료");
			try {
				if (Integer.parseInt(menu) == 1) {

					String[] data = JOptionPane.showInputDialog("데이터입력\n예)이름,자바점수,오라클점수").split(",");

					try {
						checkInput(data);

					} catch (NumberFormatException ne) {
						JOptionPane.showMessageDialog(null, "점수는 숫자만 입력가능합니다.", "에러", JOptionPane.WARNING_MESSAGE);
					}
				}

				if (Integer.parseInt(menu) == 2) {
					if (listData.isEmpty()) {
						JOptionPane.showMessageDialog(null, "데이터가 없습니다.");
					} else {
						showTextArea();
					}
				}

			} catch (NumberFormatException ne) {
				JOptionPane.showMessageDialog(null, "숫자(1~3)만 입력가능합니다.");
				menu = "-1";
			}
		} while (Integer.parseInt(menu) != 3);
	}

	public void checkInput(String[] data) {
		if (data.length == 3) {
			int java = Integer.parseInt(data[1]);
			int oracle = Integer.parseInt(data[2]);

			if (!((java > -1 && java < 101) && (oracle > -1 && oracle < 101))) {
				JOptionPane.showMessageDialog(null, "점수는 0~100만 입력가능합니다.", "에러", JOptionPane.WARNING_MESSAGE);
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
			JOptionPane.showMessageDialog(null, "입력값의 수가 틀립니다.", "에러", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void showTextArea() {
		int javaScore = 0, oracleScore = 0, sum = 0;
		double avg = 0;
		JTextArea jta = new JTextArea(10, 30);
		jta.setEditable(false);

		jta.append("번호\t이름\t자바\t오라클\t총점\t평균\t\n");

		for (int i = 0; i < listData.size(); i++) {
			javaScore = listData.get(i).getJavaScore();
			oracleScore = listData.get(i).getOracleScore();

			jta.append((i + 1) + "\t" + listData.get(i).getName() + "\t" + javaScore + "\t" + oracleScore + "\t"
					+ (javaScore + oracleScore) + "\t" + ((double) (javaScore + oracleScore) / 2) + "\n");

			sum += javaScore + oracleScore;
			avg += ((double) (javaScore + oracleScore) / 2);
		}
		jta.append("\t\t\t\t총점 : " + sum + "\t 평균 : " + ((double) (avg / listData.size())));

		JOptionPane.showMessageDialog(null, jta);
	}

	public static void main(String[] args) {
		new Run();
	}
}
