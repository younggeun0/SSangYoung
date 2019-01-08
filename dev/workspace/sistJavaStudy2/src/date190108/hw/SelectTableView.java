package date190108.hw;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class SelectTableView extends JFrame {
	
	private JButton jbSelect;
	private JComboBox<String> jcbTab;
	private DefaultTableModel dtm;
	private JScrollPane jspTab;
	
	public SelectTableView(JComboBox<String> jcbTab) {
		super("테이블 선택");
		
		this.jcbTab = jcbTab; 
		JLabel jl = new JLabel("테이블 선택");
		jbSelect = new JButton("선택");
		
		String[] columnNames = { "컬럼명", "데이터형", "크기", "제약사항" };
		
		dtm = new DefaultTableModel(columnNames, 3) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		JTable tab = new JTable(dtm);
		tab.getTableHeader().setReorderingAllowed(false);
		jspTab = new JScrollPane(tab);
		
		JPanel panel = new JPanel();
		
		panel.add(jl);
		panel.add(jcbTab);
		panel.add(jbSelect);
		
		add(BorderLayout.NORTH, panel);
		add(BorderLayout.CENTER, jspTab);
		
		SelectTableViewEvt stve = new SelectTableViewEvt(this);
		jbSelect.addActionListener(stve);
		addWindowListener(stve);
		
		setBounds(400, 300, 400, 300);
		setResizable(false);
		setVisible(true);
	}

	public JButton getJbSelect() {
		return jbSelect;
	}
	public JComboBox<String> getJcbTab() {
		return jcbTab;
	}
	public DefaultTableModel getDtm() {
		return dtm;
	}
}
