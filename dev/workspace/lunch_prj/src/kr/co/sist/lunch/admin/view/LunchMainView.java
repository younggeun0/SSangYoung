package kr.co.sist.lunch.admin.view;

import java.awt.BorderLayout;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
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
	private Calendar cal;
	
	public static String adminId;

	public LunchMainView(String adminName) {
		super("도시락 관리 [로그인 계정 : "+adminName+"]");
		
		cal = Calendar.getInstance();
		
		jtb = new JTabbedPane();
		// 도시락 
		String[] lunchColumns = { "번호", "도시락 코드", "이미지", "도시락명", "가격" };
		dtmLunch = new DefaultTableModel(lunchColumns, 4) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		jtLunch = new JTable(dtmLunch) {
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
		};
		
		// 컬럼 위치 못 바꾸도록 막음
		jtLunch.getTableHeader().setReorderingAllowed(false);
		
		// 도시락 목록 로우크기 설정
		jtLunch.setRowHeight(110);
		
		// 도시락 목록 컬럼 크기 설정, 전체 사이즈 width 800을 나눈다.
		// 이미지는 w(122) * h(110)
		jtLunch.getColumnModel().getColumn(0).setPreferredWidth(80);
		jtLunch.getColumnModel().getColumn(1).setPreferredWidth(120);
		jtLunch.getColumnModel().getColumn(2).setPreferredWidth(125);
		jtLunch.getColumnModel().getColumn(3).setPreferredWidth(265);
		jtLunch.getColumnModel().getColumn(4).setPreferredWidth(220);
		
		// 주문
		String[] orderColumns = { "번호", "주문번호","도시락 코드",
				"도시락명", "주문자명", "수량", "가격", "주문일",
				"연락처", "주문자 IP", "제작상태" };
		dtmOrder = new DefaultTableModel(orderColumns, 4);
		jtOrder = new JTable(dtmOrder);
		
		// 정산
		String[] calcColumns = { "번호", "도시락명", "수량", "가격" };
		dtmCalc = new DefaultTableModel(calcColumns, 4);
		JTable jtCalc = new JTable(dtmCalc);
		
		jbtAddLunch = new JButton("도시락 추가");
		jbtCalcOrder = new JButton("정산");
		
		cbmYear = new DefaultComboBoxModel<Integer>();
		jcbYear = new JComboBox<Integer>(cbmYear);

		cbmMonth = new DefaultComboBoxModel<Integer>();
		jcbMonth = new JComboBox<Integer>(cbmMonth);
		
		cbmDay = new DefaultComboBoxModel<Integer>();
		jcbDay = new JComboBox<Integer>(cbmDay);
		
		JScrollPane jspLunch = new JScrollPane(jtLunch);
		jspLunch.setBorder(new TitledBorder("도시락 목록"));
		JScrollPane jspOrder = new JScrollPane(jtOrder);
		jspOrder.setBorder(new TitledBorder("주문 목록"));
		JScrollPane jspCalc = new JScrollPane(jtCalc);
		jspCalc.setBorder(new TitledBorder("정산"));
		
		// 첫 탭(도시락)에 들어갈 컴포넌트 배치
		JPanel jpLunch = new JPanel();
		jpLunch.setLayout(new BorderLayout());
		
		JPanel jpLunchNorth = new JPanel();
		jpLunchNorth.add(jbtAddLunch);
		
		jpLunch.add(BorderLayout.CENTER, jspLunch);
		jpLunch.add(BorderLayout.NORTH, jpLunchNorth);
		
		jtb.add("도시락", jpLunch);

		// 두번째 탭에 들어갈 컴포넌트 배치
		JPanel jpOrder = new JPanel();
		jpOrder.setLayout(new BorderLayout());
		jpOrder.add(jspOrder);
		
		jtb.add("주문", jpOrder);
		
		// 두번째 탭에 들어갈 컴포넌트 배치
		JPanel jpCalc = new JPanel();
		jpCalc.setLayout(new BorderLayout());
		
		JPanel jpCalcNorth = new JPanel();
		jpCalcNorth.setBorder(new TitledBorder("정산일자 선택"));
		jpCalcNorth.add(jcbYear);
		jpCalcNorth.add(new JLabel("년"));
		jpCalcNorth.add(jcbMonth);
		jpCalcNorth.add(new JLabel("월"));
		jpCalcNorth.add(jcbDay);
		jpCalcNorth.add(new JLabel("일"));
		jpCalcNorth.add(jbtCalcOrder);
		
		jpCalc.add(BorderLayout.NORTH, jpCalcNorth);
		jpCalc.add(BorderLayout.CENTER, jspCalc);
		
		jtb.add("주문", jpCalc);

		add(jtb);
		
		setYear(); // JCB Year 설정
		setMonth(); // JCB Month 설정
		setDay(); // JCB Day 설정
		
		LunchMainController lmc = new LunchMainController(this);
		
		jbtAddLunch.addActionListener(lmc);
		jbtCalcOrder.addActionListener(lmc);

		jcbMonth.addActionListener(lmc); // 월을 변경하면 일이 바뀌도록 이벤트처리
		
		jtb.addMouseListener(lmc); // 탭에서 이벤트가 발생했을 때
		jtLunch.addMouseListener(lmc);
		jtOrder.addMouseListener(lmc);
		
		addWindowListener(lmc);
		
		setBounds(400, 200, 800, 600);
		setVisible(true);
	}
	
	public void setYear() { // 현재년도부터 4년전까지
		int currYear = cal.get(Calendar.YEAR);
		
		for (int temp = 0; temp<4; temp++) {
			cbmYear.addElement(currYear-temp);
		}
		jcbYear.setSelectedItem(new Integer(currYear));
	}
	
	public void setMonth() { // 월 1~12월
		int currMonth = cal.get(Calendar.DAY_OF_MONTH)+1;
		for(int month=1; month<13; month++) {
			cbmMonth.addElement(month);
		}
		jcbMonth.setSelectedItem(new Integer(currMonth));
	}
	
	public void setDay() { // 그 월의 마지막 날
		
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		int currDay = cal.get(Calendar.DAY_OF_MONTH);
		for(int day = 1; day<lastDay+1; day++) {
			cbmDay.addElement(day);
		}
		jcbDay.setSelectedItem(new Integer(currDay));
	}

	public JTabbedPane getJtb() {
		return jtb;
	}
	public DefaultTableModel getDtmLunch() {
		return dtmLunch;
	}
	public DefaultTableModel getDtmOrder() {
		return dtmOrder;
	}
	public DefaultTableModel getDtmCalc() {
		return dtmCalc;
	}
	public JButton getJbtAddLunch() {
		return jbtAddLunch;
	}
	public JButton getJbtCalcOrder() {
		return jbtCalcOrder;
	}
	public JComboBox<Integer> getJcbYear() {
		return jcbYear;
	}
	public JComboBox<Integer> getJcbMonth() {
		return jcbMonth;
	}
	public JComboBox<Integer> getJcbDay() {
		return jcbDay;
	}
	public DefaultComboBoxModel<Integer> getCbmYear() {
		return cbmYear;
	}
	public DefaultComboBoxModel<Integer> getCbmMonth() {
		return cbmMonth;
	}
	public DefaultComboBoxModel<Integer> getCbmDay() {
		return cbmDay;
	}
	public JTable getJtLunch() {
		return jtLunch;
	}
	public JTable getJtOrder() {
		return jtOrder;
	}
}
