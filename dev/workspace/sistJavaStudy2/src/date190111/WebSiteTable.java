package date190111;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class WebSiteTable extends JFrame {
	
	public WebSiteTable() {
		JTable jtbWebSite;
		DefaultTableModel dtmWebSite;
		JScrollPane jspWebSite;
		
		ImageIcon daumImg = new ImageIcon("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/sistJavaStudy2/src/date190111/images/daum.png");
		ImageIcon naverImg = new ImageIcon("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/sistJavaStudy2/src/date190111/images/naver.png");
		ImageIcon googleImg = new ImageIcon("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/sistJavaStudy2/src/date190111/images/google.png");
		
		String[] columnNames = new String[] { "로고", "URL", "특징" };
		Object[][] rowData = new Object[][]{
				{ daumImg, "http://daum.net", "카카오프랜즈" },
				{ naverImg, "http://naver.net", "웹툰" },
				{ googleImg, "http://google.net", "좋은 검색 엔진" }
		};
		
		dtmWebSite = new DefaultTableModel(rowData, columnNames) {
			
			// table 아이템 변경 막기
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		// 입력된 클래스가 그대로 Cell(Column)에 표현되도록 method를 Override해야 함
		jtbWebSite = new JTable(dtmWebSite) {
			
			@Override
			public Class<?> getColumnClass(int column) {
				// row - JTable에 입력된 2차원 배열의 행에 속한다면
				// 모든 컬럼을 입력된 형으로 반환한다.
				
				// 다시말해, 어떤 행이든 간에 입력된 column의 class를 반환하도록 한 것
				return getValueAt(0, column).getClass();
			}
		};
		
		jtbWebSite.setRowHeight(60); // 행 높이 조절
		jtbWebSite.getTableHeader().setReorderingAllowed(false); // 컬럼(열) 이동 막기
		jtbWebSite.getTableHeader().setResizingAllowed(false); // 컬럼(열)너비 변경 막기
		jtbWebSite.getColumnModel().getColumn(0).setPreferredWidth(200); // 컬럼(열)너비 조절
		jspWebSite = new JScrollPane(jtbWebSite);
		
		add(jspWebSite);
		
		setBounds(400, 300, 600, 280);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new WebSiteTable();
	}
}
