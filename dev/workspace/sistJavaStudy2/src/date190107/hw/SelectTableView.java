package date190107.hw;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SelectTableView extends JFrame {
	
	private JButton jbSelect;
	private JComboBox<String> jcbTab;
	
	public SelectTableView(JComboBox<String> jcbTab) {
		super("테이블 선택");
		
		this.jcbTab = jcbTab; 
		JLabel jl = new JLabel("테이블 선택");
		jbSelect = new JButton("선택");
		
		JPanel panel = new JPanel();
		
		panel.add(jl);
		panel.add(jcbTab);
		panel.add(jbSelect);
		
		add(BorderLayout.CENTER, panel);
		
		SelectTableViewEvt stve = new SelectTableViewEvt(this);
		jbSelect.addActionListener(stve);
		addWindowListener(stve);
		
		setBounds(400, 300, 350, 100);
		setResizable(false);
		setVisible(true);
	}
}
