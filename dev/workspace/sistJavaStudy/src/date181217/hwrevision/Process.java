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
		String[] data = JOptionPane.showInputDialog("데이터입력\n예) 이름,자바점수,오라클점수").split(",");

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
		} else {
			
			JTextArea jta = new JTextArea(10,40);
			jta.setEditable(false);
			jta.append("번호\t이름\t자바\t오라클\t총점\t평균\n");
			
			for(int i=0; i<list.size(); i++) {
				int javaScore = list.get(i).getJavaScore();
				int oracleScore = list.get(i).getOracleScore();
				
				jta.append((i+1)+"\t"+list.get(i).getName()+"\t"
						+javaScore+"\t"+oracleScore+"\t"+(javaScore+oracleScore)
						+"\t"+((javaScore+oracleScore)/2)+"\n");
				javaTot += javaScore;
				oracleTot += oracleScore;
			}
			jta.append("\t\t\t\t총점 : "+(javaTot+oracleTot)+"\t 평균 : "+((javaTot+oracleTot)/(list.size()*2)));
			
			JOptionPane.showMessageDialog(null, jta);
		}
		
	}
	
	public void inputMenu() {
		try {
			int menu = Integer.parseInt(JOptionPane.showInputDialog("메뉴입력\n1.입력 2.출력 3.종료"));

			if (menu == 1) {
				addData();
			}
			
			if (menu == 2) {
				viewData();
			}
			
			if (menu == 3) {
				switch (JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?")) {
				case JOptionPane.OK_OPTION:
					System.exit(0);
				}
			}
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "메뉴는 1~3 숫자만 입력가능합니다.");
		}
	}
}
