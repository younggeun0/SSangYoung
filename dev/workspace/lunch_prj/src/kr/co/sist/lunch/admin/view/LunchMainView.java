package kr.co.sist.lunch.admin.view;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.admin.controller.LunchMainController;

@SuppressWarnings("serial")
public class LunchMainView extends JFrame {
	
	private JTabbedPane jtb;
	private DefaultTableModel dtmLunch, dtmOrder, dtmCalc; // 메뉴, 주문, 정산
	private JButton jbtAddLunch, jbtCalcOrder;
	private JComboBox<Integer> jcbYear, jcbMonth, jcbDay;
	private DefaultComboBoxModel<Integer> cbmYear, cbmMonth, cbmDay;
	private JTable jtLunch, jtOrder; // 메뉴, 주문

	public LunchMainView(String adminName) {
		super("도시락 관리 [로그인 계정 : "+adminName+"]");
		
		jtb = new JTabbedPane();
		// 도시락 
		String[] lunchColumns = { "번호", "도시락 코드", "이미지", "도시락명", "가격" };
		dtmLunch = new DefaultTableModel(lunchColumns, 4);
		
		// 주문
		String[] orderColumns = { "번호", "주문번호","도시락 코드",
				"도시락명", "주문자명", "수량", "가격", "주문일",
				"연락처", "주문자 IP", "제작상태" };
		dtmOrder = new DefaultTableModel(orderColumns, 4);
		
		// 정산
		String[] calcColumns = { "번호", "도시락명", "수량", "가격" };
		dtmCalc = new DefaultTableModel(calcColumns, 4);
		
		jbtAddLunch = new JButton("도시락 추가");
		jbtCalcOrder = new JButton("정산");
		
		cbmYear = new DefaultComboBoxModel<Integer>();
		jcbYear = new JComboBox<Integer>(cbmYear);

		cbmMonth = new DefaultComboBoxModel<Integer>();
		jcbMonth = new JComboBox<Integer>(cbmMonth);
		
		cbmDay = new DefaultComboBoxModel<Integer>();
		jcbDay = new JComboBox<Integer>(cbmDay);
		
		
		
		
		LunchMainController lmc = new LunchMainController(this);
		
		addWindowListener(lmc);
		
		setBounds(400, 200, 800, 600);
		setVisible(true);
	}
}
