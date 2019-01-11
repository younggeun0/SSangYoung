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
		
		String[] columnNames = new String[] { "�ΰ�", "URL", "Ư¡" };
		Object[][] rowData = new Object[][]{
				{ daumImg, "http://daum.net", "īī��������" },
				{ naverImg, "http://naver.net", "����" },
				{ googleImg, "http://google.net", "���� �˻� ����" }
		};
		
		dtmWebSite = new DefaultTableModel(rowData, columnNames) {
			
			// table ������ ���� ����
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		// �Էµ� Ŭ������ �״�� Cell(Column)�� ǥ���ǵ��� method�� Override�ؾ� ��
		jtbWebSite = new JTable(dtmWebSite) {
			
			@Override
			public Class<?> getColumnClass(int column) {
				// row - JTable�� �Էµ� 2���� �迭�� �࿡ ���Ѵٸ�
				// ��� �÷��� �Էµ� ������ ��ȯ�Ѵ�.
				
				// �ٽø���, � ���̵� ���� �Էµ� column�� class�� ��ȯ�ϵ��� �� ��
				return getValueAt(0, column).getClass();
			}
		};
		
		jtbWebSite.setRowHeight(60); // �� ���� ����
		jtbWebSite.getTableHeader().setReorderingAllowed(false); // �÷�(��) �̵� ����
		jtbWebSite.getTableHeader().setResizingAllowed(false); // �÷�(��)�ʺ� ���� ����
		jtbWebSite.getColumnModel().getColumn(0).setPreferredWidth(200); // �÷�(��)�ʺ� ����
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
