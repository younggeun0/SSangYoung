package date190110.hw;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class CreateTableView extends JFrame {

	JTextField jtfTabName, jtfColName, jtfColSize, jtfConstName, jtfFkTab, jtfFkCol;
	JComboBox<String> jcbColType, jcbConstraint;
	JButton jbAddTab, jbAddCol, jbCreateTab, jbClean;
	JTextArea jtaQueryView;
	JScrollPane jspQueryView;
	
	public CreateTableView() {
		
		jtfTabName = new JTextField();
		jtfColName = new JTextField();
		jtfColSize = new JTextField();
		jtfConstName = new JTextField();
		
		String[] dataType = { "VARCHAR2", "CHAR", "NUMBER", "DATE" };
		jcbColType = new JComboBox<String>(dataType);
		String[] constraintType = { "NULL", "PRIMARY KEY", "FOREIGN KEY", "UNIQUE", "NOT NULL" };
		jcbConstraint = new JComboBox<String>(constraintType);
		
		jbAddTab = new JButton("추가");
		jbAddCol = new JButton("추가");
		jbCreateTab = new JButton("테이블 생성");
		jbClean = new JButton("초기화");
		
		jtaQueryView = new JTextArea();
		jtaQueryView.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		jtaQueryView.setEditable(false);
		jspQueryView = new JScrollPane(jtaQueryView);
		jspQueryView.setBorder(new TitledBorder("Query View"));
		
		JLabel jlTabName = new JLabel("테이블명");
		JLabel jlColName = new JLabel("컬럼명");
		JLabel jlColType = new JLabel("데이터형");
		JLabel jlColSize = new JLabel("크기");
		JLabel jlConstraint = new JLabel("제약사항");
		JLabel jlConstName = new JLabel("제약사항명");

		JLabel jlFkTab = new JLabel("참조 테이블명");
		jtfFkTab = new JTextField();
		JLabel jlFkCol = new JLabel("참조 컬럼명");
		jtfFkCol = new JTextField();
		
		setLayout(null);
		
		// FK 구현 //////////////////////////////
		jlFkTab.setBounds(40, 110, 90, 25);
		add(jlFkTab);
		jtfFkTab.setBounds(130, 110, 100, 25);
		add(jtfFkTab);
		jlFkCol.setBounds(250, 110, 90, 25);
		add(jlFkCol);
		jtfFkCol.setBounds(330, 110, 100, 25);
		add(jtfFkCol);
		/////////////////////////////////////////
		
		jlTabName.setBounds(10, 5, 60, 25);
		add(jlTabName);
		
		jtfTabName.setBounds(80, 5, 100, 25);
		add(jtfTabName);
		
		jbAddTab.setBounds(190, 5, 60, 25);
		add(jbAddTab);
		
		jlColName.setBounds(10, 40, 60, 25);
		add(jlColName);
		
		jtfColName.setBounds(80, 40, 100, 25);
		add(jtfColName);
		
		jlColType.setBounds(190, 40, 60, 25);
		add(jlColType);
		
		jcbColType.setBounds(260, 40, 100, 25);
		add(jcbColType);
		
		jlColSize.setBounds(370, 40, 40, 25);
		add(jlColSize);
		
		jtfColSize.setBounds(420, 40, 100, 25);
		add(jtfColSize);
		
		jlConstraint.setBounds(10, 75, 60, 25);
		add(jlConstraint);
		
		jcbConstraint.setBounds(80, 75, 100, 25);
		add(jcbConstraint);
		
		jlConstName.setBounds(190, 75, 80, 25);
		add(jlConstName);
		
		jtfConstName.setBounds(260, 75, 170, 25);
		add(jtfConstName);
		
		jbAddCol.setBounds(445, 75, 75,25);
		add(jbAddCol);
		
		jspQueryView.setBounds(10, 150, 510, 300);
		add(jspQueryView);
		
		jbCreateTab.setBounds(300, 460, 130, 25);
		add(jbCreateTab);
		
		jbClean.setBounds(440, 460, 80, 25);
		add(jbClean);
		
		CreateTableViewEvt cte = new CreateTableViewEvt(this);
		jbAddTab.addActionListener(cte);
		jbAddCol.addActionListener(cte);
		jbCreateTab.addActionListener(cte);
		jbClean.addActionListener(cte);

		jtfTabName.addActionListener(cte);
		jtfColName.addActionListener(cte);
		jtfColSize.addActionListener(cte);
		jtfConstName.addActionListener(cte);
		jtfFkTab.addActionListener(cte);
		jtfFkCol.addActionListener(cte);
		
		addWindowListener(cte);
		
		setBounds(400, 200, 550, 540);
		setResizable(false);
		setVisible(true);
	}

	public JTextField getJtfTabName() {
		return jtfTabName;
	}
	public JTextField getJtfColName() {
		return jtfColName;
	}
	public JTextField getJtfColSize() {
		return jtfColSize;
	}
	public JTextField getJtfConstName() {
		return jtfConstName;
	}
	public JComboBox<String> getJcbColType() {
		return jcbColType;
	}
	public JComboBox<String> getJcbConstraint() {
		return jcbConstraint;
	}
	public JButton getJbAddTab() {
		return jbAddTab;
	}
	public JButton getJbAddCol() {
		return jbAddCol;
	}
	public JButton getJbCreateTab() {
		return jbCreateTab;
	}
	public JButton getJbClean() {
		return jbClean;
	}
	public JTextArea getJtaQueryView() {
		return jtaQueryView;
	}
	public JScrollPane getJspQueryView() {
		return jspQueryView;
	}
	public void setJtfTabName(JTextField jtfTabName) {
		this.jtfTabName = jtfTabName;
	}
	public void setJtfColName(JTextField jtfColName) {
		this.jtfColName = jtfColName;
	}
	public void setJtfColSize(JTextField jtfColSize) {
		this.jtfColSize = jtfColSize;
	}
	public void setJtfConstName(JTextField jtfConstName) {
		this.jtfConstName = jtfConstName;
	}
	public void setJtaQueryView(JTextArea jtaQueryView) {
		this.jtaQueryView = jtaQueryView;
	}
	public void setJtfFkTab(JTextField jtfFkTab) {
		this.jtfFkTab = jtfFkTab;
	}
	public void setJtfFkCol(JTextField jtfFkCol) {
		this.jtfFkCol = jtfFkCol;
	}
	public JTextField getJtfFkTab() {
		return jtfFkTab;
	}
	public JTextField getJtfFkCol() {
		return jtfFkCol;
	}
}
