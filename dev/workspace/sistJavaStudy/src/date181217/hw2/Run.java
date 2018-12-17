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
				menu = JOptionPane.showInputDialog("메뉴선택\n1.입력 2.출력 3.종료");

				if (Integer.parseInt(menu) == 1) {
					
					String[] input = JOptionPane.showInputDialog(
							"데이터입력\n예) 이름, 자바점수, 오라클점수").split(",");
					
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
								JOptionPane.showMessageDialog(null, "점수는 0~100 사이값만 입력가능합니다.");
							}
						} catch (NumberFormatException ne) {
							JOptionPane.showMessageDialog(null, "점수는 숫자만 입력가능합니다.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "이름, 자바점수, 오라클점수만 입력해주세요.");
					}
				}
				
				if (Integer.parseInt(menu) == 2) {
					
					if (listData.isEmpty()) {
						JOptionPane.showMessageDialog(null, "데이터가 없습니다.");
					} else {
						JTextArea jta = new JTextArea(10, 40);
						jta.setEditable(false);
						
						int javaScore = 0, oracleScore = 0;
						int sum = 0, avg = 0;

						jta.append("번호\t이름\t자바\t오라클\t총점\t평균\n");
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
						
						jta.append("\t\t\t총점 : "+sum+" 평균 : "+(avg/listData.size()));
						
						JOptionPane.showMessageDialog(null, jta);
					}
				}
				
				
			} catch (NumberFormatException ne) {
				JOptionPane.showMessageDialog(null, "숫자 1~3만 입력가능합니다.");
				menu = "-1";
			}
		} while(Integer.parseInt(menu) != 3);
	}

	public static void main(String[] args) {
		new Run();
	}
}
