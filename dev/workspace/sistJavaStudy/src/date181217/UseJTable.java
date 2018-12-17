package date181217;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * MVC Pattern이 적용된 class 
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJTable extends JFrame implements ActionListener {

	private JTable jt;
	private JButton btnAdd;
	private DefaultTableModel dtm;
	private UseJTable ujt;
	
	public UseJTable() {
		super("JTable 연습");
		ujt = this;
		
		// 1. 데이터를 관리하는 Model 클래스 생성
		String[] columnName = {"번호","이름","주소","이메일"};
		String[][] rowData = { 
				{ "1","이재찬","인천시 소래동","chan@test.com" }, 
				{ "2","정택성","서울시 구로동","teack@test.co.kr" }, 
				{ "3","이재현","경기도 안양시","hyun@test.com" } };
		
		// 수정불가능하도록 변경
		dtm = new DefaultTableModel(rowData, columnName) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		
		// 2. 데이터를 보여주는 View 클래스 생성
		jt = new JTable(dtm);
		// 테이블 컬럼의 크기 변경 : 컬럼은 하나의 필드 넓이를 변경하면 
		// 하위 모든 컬럼은 동일한 크기를 적용받음
		// 컬럼크기변경 1. 컬럼을 얻는다.
		TableColumn tcNum = jt.getColumnModel().getColumn(0);
		
		// 컬럼크기변경 2. 컬럼의 크기 변경.
		tcNum.setPreferredWidth(50);
		
		// 이렇게 한줄로 처리 가능
		jt.getColumnModel().getColumn(1).setPreferredWidth(100);
		jt.getColumnModel().getColumn(2).setPreferredWidth(200);
		jt.getColumnModel().getColumn(3).setPreferredWidth(150);
		
		// 행의 높이 변경
		jt.setRowHeight(29);
		
		btnAdd =  new JButton("데이터 추가");
		JPanel jp = new JPanel();
		jp.add(btnAdd);
		
		// 3. Column의 이름과 Scrollbar를 사용할 수 있도록 JScrollPane에 배치
		JScrollPane jsp = new JScrollPane(jt);
		
		add(BorderLayout.CENTER, jsp);
		add(BorderLayout.SOUTH, jp);
		
		btnAdd.addActionListener(this);
		
		UseJTable.TableEvt te = this.new TableEvt();
		jt.addMouseListener(te);
		
		setBounds(300, 250, 500, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String inputData = JOptionPane.showInputDialog("데이터입력\n예)번호,이름,주소,이메일");
		
		String[] tempData = inputData.split(",");
		
		if (tempData.length != 4) {
			JOptionPane.showMessageDialog(this, 
					"입력 데이터의 형태는 \n 번호,이름,주소,이메일이어야 합니다.", 
					"입력 오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		// 입력된 데이터를 화면에 보여주기 위해 DefaultTableModel에 추가
		// Object이 String의 부모이므로, String은 Object의 자식이므로 매개변수로 들어갈 수 있음
		dtm.addRow(tempData);
	}
	///////////////////////////////// inner class 시작 /////////////////////////////////////
	public class TableEvt extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			int selectedRow = jt.getSelectedRow(); 
			
			int flag = JOptionPane.showConfirmDialog(ujt, 
					"예를 누르면 조회, 아니오를 누르면 삭제");
			
			switch(flag) {
			case JOptionPane.OK_OPTION:
				int columnCount = jt.getColumnCount();
				
				// 선택된 행의 정보를 가져와서 Dialog로 보여주기
				String selectedVal;
				StringBuilder viewData = new StringBuilder();
				for(int i=0; i<columnCount; i++) {
					selectedVal = (String)jt.getValueAt(selectedRow, i);
					viewData.append(selectedVal).append("\n");
				}
				
				JOptionPane.showMessageDialog(ujt, viewData, "행 결과", JOptionPane.PLAIN_MESSAGE);
				break;
			case JOptionPane.NO_OPTION:
				// 선택한 행을 지우기
				switch(JOptionPane.showConfirmDialog(ujt, "정말 삭제하시겠습니까?")) {
				case JOptionPane.OK_OPTION:
					dtm.removeRow(selectedRow);
					break;
				}
			}
		}
	}
	///////////////////////////////// inner class 끝 ///////////////////////////////////////
	public static void main(String[] args) {
		new UseJTable();
	}
}
