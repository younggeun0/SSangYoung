package kr.co.sist.lunch.admin.view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.sist.lunch.admin.controller.LunchAddController;
import kr.co.sist.lunch.admin.controller.LunchMainController;

/**
 * ���ö� ���̺� ���ö��� �߰��ϴ� â
 * @author owner
 */
@SuppressWarnings("serial")
public class LunchAddView extends JDialog {

	private JLabel jlLunchImg;
	private JTextField jtfLunchName, jtfLunchPrice;
	private JTextArea jtaLunchSpec;
	private JButton jbImg, jbAdd, jbEnd;
	
	public LunchAddView(LunchMainView lmv, LunchMainController lmc) {
		super(lmv, "���ö� �߰�", true); // ���
		
		// DB���� ��ȸ�� ����� Component���� ä���.
		ImageIcon iiLunch = new ImageIcon("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/no_img.jpg");
		jlLunchImg = new JLabel(iiLunch);
		
		jtfLunchName = new JTextField();
		jtfLunchPrice = new JTextField();
		
		jtaLunchSpec = new JTextArea();
		
		jbImg = new JButton("�̹��� ����");
		jbAdd = new JButton("�߰�");
		jbEnd = new JButton("�ݱ�");
		
		JScrollPane jspTaSpec = new JScrollPane(jtaLunchSpec);
		
		setLayout(null);
		
		JLabel jlDetailTitle = new JLabel("���ö� �߰�");
		jlDetailTitle.setFont(new Font(Font.DIALOG, Font.BOLD, 25));

		JLabel jlLunchName = new JLabel("���ö���");
		JLabel jlLunchPrice = new JLabel("����");
		JLabel jlLunchSpec = new JLabel("Ư����");
		
		jlDetailTitle.setBounds(10, 25, 250, 30);
		jlLunchImg.setBounds(10, 65, 244, 220);
		jbImg.setBounds(80, 300, 120, 25);
		
		jlLunchName.setBounds(270, 65, 100, 25);
		jlLunchPrice.setBounds(270, 95, 60, 25);
		jlLunchSpec.setBounds(270, 125, 80, 25);
		
		jtfLunchName.setBounds(350, 65, 130, 25);
		jtfLunchPrice.setBounds(350, 95, 130, 25);
		jspTaSpec.setBounds(350,125,130,150);
		
		jbAdd.setBounds(270, 300, 100, 25);
		jbEnd.setBounds(380, 300, 100, 25);
		
		add(jlDetailTitle);
		add(jlLunchImg);
		add(jbImg);
		add(jlLunchName);
		add(jlLunchPrice);
		add(jlLunchSpec);
		add(jtfLunchName);
		add(jtfLunchPrice);
		add(jspTaSpec);
		add(jbAdd);
		add(jbEnd);
		
		LunchAddController lac = new LunchAddController(this, lmc);
		jbImg.addActionListener(lac);
		jbAdd.addActionListener(lac);
		jbEnd.addActionListener(lac);
		addWindowListener(lac);
		
		setBounds(lmv.getX()+100, lmv.getY()+50, 515, 390);
		setResizable(false);
		setVisible(true);
	}
	public JLabel getJlLunchImg() {
		return jlLunchImg;
	}
	public JTextField getJtfLunchName() {
		return jtfLunchName;
	}
	public JTextField getJtfLunchPrice() {
		return jtfLunchPrice;
	}
	public JTextArea getJtaLunchSpec() {
		return jtaLunchSpec;
	}
	public JButton getJbImg() {
		return jbImg;
	}
	public JButton getjbAdd() {
		return jbAdd;
	}
	public JButton getJbEnd() {
		return jbEnd;
	}
}
