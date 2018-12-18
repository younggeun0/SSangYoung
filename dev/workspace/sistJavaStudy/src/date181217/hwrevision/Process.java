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
		String input = JOptionPane.showInputDialog("데이터입력\n예) 이름,자바점수,오라클점수");
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
					JOptionPane.showMessageDialog(null, "점수는 0~100 사이값만 입력 가능합니다!");
					return false;
				}
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "점수는 숫자만 입력 가능합니다!");
				return false;
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "이름, 자바점수, 오라클점수\n이렇게 세개의 값만 입력해주세요");
			return false;
		}
		
	}
	
	public void viewData() {
		
		if(list.isEmpty()) {
			JOptionPane.showMessageDialog(null, "데이터가 없습니다.");
			return;
		} 
		
		JTextArea jta = new JTextArea(10,40);
		jta.setEditable(false);
		
		StringBuilder viewData = new StringBuilder();
		viewData.append("번호\t이름\t자바\t오라클\t총점\t평균\n");
		
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
		
		viewData.append("\n\n\t\t\t\t총점 : "+scoreTot+"\t 평균 : "+(String.format("%5.2f", scoreTot/(double)(list.size()*2))));
		
		jta.append(viewData.toString());
		JOptionPane.showMessageDialog(null, jta);
	}
	
	public void inputMenu() {
		
		boolean exitFlag = false;
		do {
			
			try {
				int menu = parseInt(JOptionPane.showInputDialog("메뉴입력\n1.입력 2.출력 3.종료"));
				
				switch(menu) {
				case INSERT_DATA:

					if(addData()) {
						JOptionPane.showMessageDialog(null, "추가됐습니다!");
					} 
					
					break;
				case VIEW_DATA:
					viewData();
					
					break;
				case EXIT:
					switch (JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?")) {
					case JOptionPane.OK_OPTION:
						exitFlag = true;
						break;
					}
					break;
				}
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "메뉴는 1~3 숫자만 입력가능합니다.");
			}
		} while(!exitFlag);
	}
}
