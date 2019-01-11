package date190111.namecard;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class NamecardView extends JFrame {
	
	private JButton btnImg, btnAdd;
	private DefaultTableModel dtmNamecard;
	private JLabel jlPreview;
	private JTextField jtfName, jtfAddr; 

	public NamecardView() {
		super("명함관리");
		
		JLabel jlName = new JLabel("성명");
		JLabel jlAddr = new JLabel("주소");
		JLabel jlImg = new JLabel("이미지");
		
		btnImg = new JButton("이미지 선택");
		btnAdd = new JButton("명함 추가");
		
		jtfName = new JTextField();
		jtfAddr = new JTextField();
		
		jlPreview = new JLabel(new ImageIcon(
				"C:/Users/owner/youngRepositories/SSangYoung"
				+ "/dev/workspace/sistJavaStudy2/src/date190111"
				+ "/upload/no_image.png")); // 이미지 프리뷰
		
		String[] columnNames = new String[] { "번호", "이미지", "성명", "주소" };
		
		dtmNamecard = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		JTable jtNamecard = new JTable(dtmNamecard) {
			
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
		};
		
		jtNamecard.setRowHeight(180);
		jtNamecard.getTableHeader().setReorderingAllowed(false);
		jtNamecard.getColumnModel().getColumn(0).setPreferredWidth(30);
		jtNamecard.getColumnModel().getColumn(1).setPreferredWidth(140);
		jtNamecard.getColumnModel().getColumn(2).setPreferredWidth(60);
		jtNamecard.getColumnModel().getColumn(3).setPreferredWidth(200);
		
		JScrollPane jspNamecard = new JScrollPane(jtNamecard);
		jspNamecard.setBorder(new TitledBorder("명함 목록"));
		
		JLabel jlAddNamecard = new JLabel("명함 추가");
		jlAddNamecard.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		
		setLayout(null);

		jlAddNamecard.setBounds(10, 20, 100, 20);
		add(jlAddNamecard);
		jlName.setBounds(10, 55, 60, 25);
		add(jlName);
		jtfName.setBounds(80, 55, 120, 25);
		add(jtfName);
		jlAddr.setBounds(10, 90, 60, 25);
		add(jlAddr);
		jtfAddr.setBounds(80, 90, 120, 25);
		add(jtfAddr);
		jlImg.setBounds(10, 125, 80, 25);
		add(jlImg);
		jlPreview.setBounds(80, 125, 140, 180);
		add(jlPreview);
		btnImg.setBounds(80, 320, 120, 25);
		add(btnImg);
		btnAdd.setBounds(80, 360, 120, 25);
		add(btnAdd);
 		jspNamecard.setBounds(240, 5, 600, 550);
 		add(jspNamecard);
 		
		NamecardController nc = new NamecardController(this);
		
		btnImg.addActionListener(nc);
		btnAdd.addActionListener(nc);

		addWindowListener(nc);

		setBounds(400, 300, 870, 610);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NamecardView();
	}
	public DefaultTableModel getDtmNamecard() {
		return dtmNamecard;
	}
	public void setDtmNamecard(DefaultTableModel dtmNamecard) {
		this.dtmNamecard = dtmNamecard;
	}
	public JLabel getJlPreview() {
		return jlPreview;
	}
	public void setJlPreview(JLabel jlPreview) {
		this.jlPreview = jlPreview;
	}
	public JTextField getJtfName() {
		return jtfName;
	}
	public void setJtfName(JTextField jtfName) {
		this.jtfName = jtfName;
	}
	public JTextField getJtfAddr() {
		return jtfAddr;
	}
	public void setJtfAddr(JTextField jtfAddr) {
		this.jtfAddr = jtfAddr;
	}
	public JButton getBtnImg() {
		return btnImg;
	}
	public JButton getBtnAdd() {
		return btnAdd;
	}
}
