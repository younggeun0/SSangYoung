package kr.co.sist.lunch.user.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.user.controller.LunchClientController;

@SuppressWarnings("serial")
public class LunchClientView extends JFrame {

	private JTabbedPane jtp;
	private DefaultTableModel dtmLunchList, dtmOrderList;
	private JTextField jtfName, jtfTel;
	private JButton jbtSearch;
	private JTable jtLunch, jtOrder;
	
	public LunchClientView() {
		super("쌍용 도시락 주문");
		
		jtp = new JTabbedPane();
		
		// 도시락
		String[] lunchColumns = { "번호", "이미지", "도시락 코드", "도시락명", "설명" };
		dtmLunchList = new DefaultTableModel(lunchColumns, 3) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		jtLunch = new JTable(dtmLunchList) {
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
		};
		// 전체 창 가로길이 800
		jtLunch.getColumnModel().getColumn(0).setPreferredWidth(80);
		jtLunch.getColumnModel().getColumn(1).setPreferredWidth(130);
		jtLunch.getColumnModel().getColumn(2).setPreferredWidth(100);
		jtLunch.getColumnModel().getColumn(3).setPreferredWidth(120);
		jtLunch.getColumnModel().getColumn(4).setPreferredWidth(370);
		jtLunch.setRowHeight(110);
		
		// 주문현황
		String[] orderColumns = { "번호", "도시락명", "수량", "주문일자" };
		dtmOrderList = new DefaultTableModel(orderColumns, 3);
		jtOrder = new JTable(dtmOrderList);
		
		jtfName = new JTextField(10);
		jtfTel = new JTextField(10);
		
		jbtSearch = new JButton("조회");
		
		JScrollPane jspLunch = new JScrollPane(jtLunch);
		jspLunch.setBorder(new TitledBorder("도시락 목록"));

		jtp.add("도시락 목록",jspLunch); 
		
		JPanel panelOrder = new JPanel();
		panelOrder.setLayout(new BorderLayout());

		JPanel panelOrderNorth = new JPanel();
		panelOrderNorth.setBorder(new TitledBorder("주문자 정보"));
		panelOrderNorth.add(new JLabel("주문자명"));
		panelOrderNorth.add(jtfName);
		panelOrderNorth.add(new JLabel("전화번호"));
		panelOrderNorth.add(jtfTel);
		panelOrderNorth.add(jbtSearch);
		
		JScrollPane jspOrder = new JScrollPane(jtOrder);
		jspOrder.setBorder(new TitledBorder("주문 현황"));

		panelOrder.add(BorderLayout.NORTH, panelOrderNorth);
		panelOrder.add(BorderLayout.CENTER, jspOrder);
		
		jtp.addTab("주문 현황", panelOrder);
		
		add(jtp);
		
		LunchClientController lcc = new LunchClientController(this);
		jtLunch.addMouseListener(lcc);
		jbtSearch.addActionListener(lcc);
		addWindowListener(lcc);
		
		setBounds(400, 300, 800, 600);
		setVisible(true);
	}

	public JTabbedPane getJtp() {
		return jtp;
	}
	public DefaultTableModel getDtmLunchList() {
		return dtmLunchList;
	}
	public DefaultTableModel getDtmOrderList() {
		return dtmOrderList;
	}
	public JTextField getJtfName() {
		return jtfName;
	}
	public JTextField getJtfTel() {
		return jtfTel;
	}
	public JButton getJbtSearch() {
		return jbtSearch;
	}
	public JTable getJtLunch() {
		return jtLunch;
	}
	public JTable getJtOrder() {
		return jtOrder;
	}
}
