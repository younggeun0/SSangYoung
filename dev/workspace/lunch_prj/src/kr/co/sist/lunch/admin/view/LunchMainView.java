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
	private DefaultTableModel dtmLunch, dtmOrder, dtmCalc; // �޴�, �ֹ�, ����
	private JButton jbtAddLunch, jbtCalcOrder;
	private JComboBox<Integer> jcbYear, jcbMonth, jcbDay;
	private DefaultComboBoxModel<Integer> cbmYear, cbmMonth, cbmDay;
	private JTable jtLunch, jtOrder; // �޴�, �ֹ�
	private Calendar cal;
	
	public static String adminId;

	public LunchMainView(String adminName) {
		super("���ö� ���� [�α��� ���� : "+adminName+"]");
		
		cal = Calendar.getInstance();
		
		jtb = new JTabbedPane();
		// ���ö� 
		String[] lunchColumns = { "��ȣ", "���ö� �ڵ�", "�̹���", "���ö���", "����" };
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
		
		// �÷� ��ġ �� �ٲٵ��� ����
		jtLunch.getTableHeader().setReorderingAllowed(false);
		
		// ���ö� ��� �ο�ũ�� ����
		jtLunch.setRowHeight(110);
		
		// ���ö� ��� �÷� ũ�� ����, ��ü ������ width 800�� ������.
		// �̹����� w(122) * h(110)
		jtLunch.getColumnModel().getColumn(0).setPreferredWidth(80);
		jtLunch.getColumnModel().getColumn(1).setPreferredWidth(120);
		jtLunch.getColumnModel().getColumn(2).setPreferredWidth(125);
		jtLunch.getColumnModel().getColumn(3).setPreferredWidth(265);
		jtLunch.getColumnModel().getColumn(4).setPreferredWidth(220);
		
		// �ֹ�
		String[] orderColumns = { "��ȣ", "�ֹ���ȣ","���ö� �ڵ�",
				"���ö���", "�ֹ��ڸ�", "����", "����", "�ֹ���",
				"����ó", "�ֹ��� IP", "���ۻ���" };
		dtmOrder = new DefaultTableModel(orderColumns, 4);
		jtOrder = new JTable(dtmOrder);
		
		// ����
		String[] calcColumns = { "��ȣ", "���ö���", "����", "����" };
		dtmCalc = new DefaultTableModel(calcColumns, 4);
		JTable jtCalc = new JTable(dtmCalc);
		
		jbtAddLunch = new JButton("���ö� �߰�");
		jbtCalcOrder = new JButton("����");
		
		cbmYear = new DefaultComboBoxModel<Integer>();
		jcbYear = new JComboBox<Integer>(cbmYear);

		cbmMonth = new DefaultComboBoxModel<Integer>();
		jcbMonth = new JComboBox<Integer>(cbmMonth);
		
		cbmDay = new DefaultComboBoxModel<Integer>();
		jcbDay = new JComboBox<Integer>(cbmDay);
		
		JScrollPane jspLunch = new JScrollPane(jtLunch);
		jspLunch.setBorder(new TitledBorder("���ö� ���"));
		JScrollPane jspOrder = new JScrollPane(jtOrder);
		jspOrder.setBorder(new TitledBorder("�ֹ� ���"));
		JScrollPane jspCalc = new JScrollPane(jtCalc);
		jspCalc.setBorder(new TitledBorder("����"));
		
		// ù ��(���ö�)�� �� ������Ʈ ��ġ
		JPanel jpLunch = new JPanel();
		jpLunch.setLayout(new BorderLayout());
		
		JPanel jpLunchNorth = new JPanel();
		jpLunchNorth.add(jbtAddLunch);
		
		jpLunch.add(BorderLayout.CENTER, jspLunch);
		jpLunch.add(BorderLayout.NORTH, jpLunchNorth);
		
		jtb.add("���ö�", jpLunch);

		// �ι�° �ǿ� �� ������Ʈ ��ġ
		JPanel jpOrder = new JPanel();
		jpOrder.setLayout(new BorderLayout());
		jpOrder.add(jspOrder);
		
		jtb.add("�ֹ�", jpOrder);
		
		// �ι�° �ǿ� �� ������Ʈ ��ġ
		JPanel jpCalc = new JPanel();
		jpCalc.setLayout(new BorderLayout());
		
		JPanel jpCalcNorth = new JPanel();
		jpCalcNorth.setBorder(new TitledBorder("�������� ����"));
		jpCalcNorth.add(jcbYear);
		jpCalcNorth.add(new JLabel("��"));
		jpCalcNorth.add(jcbMonth);
		jpCalcNorth.add(new JLabel("��"));
		jpCalcNorth.add(jcbDay);
		jpCalcNorth.add(new JLabel("��"));
		jpCalcNorth.add(jbtCalcOrder);
		
		jpCalc.add(BorderLayout.NORTH, jpCalcNorth);
		jpCalc.add(BorderLayout.CENTER, jspCalc);
		
		jtb.add("�ֹ�", jpCalc);

		add(jtb);
		
		setYear(); // JCB Year ����
		setMonth(); // JCB Month ����
		setDay(); // JCB Day ����
		
		LunchMainController lmc = new LunchMainController(this);
		
		jbtAddLunch.addActionListener(lmc);
		jbtCalcOrder.addActionListener(lmc);

		jcbMonth.addActionListener(lmc); // ���� �����ϸ� ���� �ٲ�� �̺�Ʈó��
		
		jtb.addMouseListener(lmc); // �ǿ��� �̺�Ʈ�� �߻����� ��
		jtLunch.addMouseListener(lmc);
		jtOrder.addMouseListener(lmc);
		
		addWindowListener(lmc);
		
		setBounds(400, 200, 800, 600);
		setVisible(true);
	}
	
	public void setYear() { // ����⵵���� 4��������
		int currYear = cal.get(Calendar.YEAR);
		
		for (int temp = 0; temp<4; temp++) {
			cbmYear.addElement(currYear-temp);
		}
		jcbYear.setSelectedItem(new Integer(currYear));
	}
	
	public void setMonth() { // �� 1~12��
		int currMonth = cal.get(Calendar.DAY_OF_MONTH)+1;
		for(int month=1; month<13; month++) {
			cbmMonth.addElement(month);
		}
		jcbMonth.setSelectedItem(new Integer(currMonth));
	}
	
	public void setDay() { // �� ���� ������ ��
		
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
