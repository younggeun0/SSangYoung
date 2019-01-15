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
	private DefaultTableModel dtmLunch, dtmOrder, dtmCalc; // �޴�, �ֹ�, ����
	private JButton jbtAddLunch, jbtCalcOrder;
	private JComboBox<Integer> jcbYear, jcbMonth, jcbDay;
	private DefaultComboBoxModel<Integer> cbmYear, cbmMonth, cbmDay;
	private JTable jtLunch, jtOrder; // �޴�, �ֹ�

	public LunchMainView(String adminName) {
		super("���ö� ���� [�α��� ���� : "+adminName+"]");
		
		jtb = new JTabbedPane();
		// ���ö� 
		String[] lunchColumns = { "��ȣ", "���ö� �ڵ�", "�̹���", "���ö���", "����" };
		dtmLunch = new DefaultTableModel(lunchColumns, 4);
		
		// �ֹ�
		String[] orderColumns = { "��ȣ", "�ֹ���ȣ","���ö� �ڵ�",
				"���ö���", "�ֹ��ڸ�", "����", "����", "�ֹ���",
				"����ó", "�ֹ��� IP", "���ۻ���" };
		dtmOrder = new DefaultTableModel(orderColumns, 4);
		
		// ����
		String[] calcColumns = { "��ȣ", "���ö���", "����", "����" };
		dtmCalc = new DefaultTableModel(calcColumns, 4);
		
		jbtAddLunch = new JButton("���ö� �߰�");
		jbtCalcOrder = new JButton("����");
		
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
