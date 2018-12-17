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
 * MVC Pattern�� ����� class 
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJTable extends JFrame implements ActionListener {

	private JTable jt;
	private JButton btnAdd;
	private DefaultTableModel dtm;
	private UseJTable ujt;
	
	public UseJTable() {
		super("JTable ����");
		ujt = this;
		
		// 1. �����͸� �����ϴ� Model Ŭ���� ����
		String[] columnName = {"��ȣ","�̸�","�ּ�","�̸���"};
		String[][] rowData = { 
				{ "1","������","��õ�� �ҷ���","chan@test.com" }, 
				{ "2","���ü�","����� ���ε�","teack@test.co.kr" }, 
				{ "3","������","��⵵ �Ⱦ��","hyun@test.com" } };
		
		// �����Ұ����ϵ��� ����
		dtm = new DefaultTableModel(rowData, columnName) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		
		// 2. �����͸� �����ִ� View Ŭ���� ����
		jt = new JTable(dtm);
		// ���̺� �÷��� ũ�� ���� : �÷��� �ϳ��� �ʵ� ���̸� �����ϸ� 
		// ���� ��� �÷��� ������ ũ�⸦ �������
		// �÷�ũ�⺯�� 1. �÷��� ��´�.
		TableColumn tcNum = jt.getColumnModel().getColumn(0);
		
		// �÷�ũ�⺯�� 2. �÷��� ũ�� ����.
		tcNum.setPreferredWidth(50);
		
		// �̷��� ���ٷ� ó�� ����
		jt.getColumnModel().getColumn(1).setPreferredWidth(100);
		jt.getColumnModel().getColumn(2).setPreferredWidth(200);
		jt.getColumnModel().getColumn(3).setPreferredWidth(150);
		
		// ���� ���� ����
		jt.setRowHeight(29);
		
		btnAdd =  new JButton("������ �߰�");
		JPanel jp = new JPanel();
		jp.add(btnAdd);
		
		// 3. Column�� �̸��� Scrollbar�� ����� �� �ֵ��� JScrollPane�� ��ġ
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
		String inputData = JOptionPane.showInputDialog("�������Է�\n��)��ȣ,�̸�,�ּ�,�̸���");
		
		String[] tempData = inputData.split(",");
		
		if (tempData.length != 4) {
			JOptionPane.showMessageDialog(this, 
					"�Է� �������� ���´� \n ��ȣ,�̸�,�ּ�,�̸����̾�� �մϴ�.", 
					"�Է� ����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		// �Էµ� �����͸� ȭ�鿡 �����ֱ� ���� DefaultTableModel�� �߰�
		// Object�� String�� �θ��̹Ƿ�, String�� Object�� �ڽ��̹Ƿ� �Ű������� �� �� ����
		dtm.addRow(tempData);
	}
	///////////////////////////////// inner class ���� /////////////////////////////////////
	public class TableEvt extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			int selectedRow = jt.getSelectedRow(); 
			
			int flag = JOptionPane.showConfirmDialog(ujt, 
					"���� ������ ��ȸ, �ƴϿ��� ������ ����");
			
			switch(flag) {
			case JOptionPane.OK_OPTION:
				int columnCount = jt.getColumnCount();
				
				// ���õ� ���� ������ �����ͼ� Dialog�� �����ֱ�
				String selectedVal;
				StringBuilder viewData = new StringBuilder();
				for(int i=0; i<columnCount; i++) {
					selectedVal = (String)jt.getValueAt(selectedRow, i);
					viewData.append(selectedVal).append("\n");
				}
				
				JOptionPane.showMessageDialog(ujt, viewData, "�� ���", JOptionPane.PLAIN_MESSAGE);
				break;
			case JOptionPane.NO_OPTION:
				// ������ ���� �����
				switch(JOptionPane.showConfirmDialog(ujt, "���� �����Ͻðڽ��ϱ�?")) {
				case JOptionPane.OK_OPTION:
					dtm.removeRow(selectedRow);
					break;
				}
			}
		}
	}
	///////////////////////////////// inner class �� ///////////////////////////////////////
	public static void main(String[] args) {
		new UseJTable();
	}
}
