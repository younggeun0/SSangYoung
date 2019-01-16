package kr.co.sist.lunch.admin.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.sist.lunch.admin.controller.LunchDetailController;
import kr.co.sist.lunch.admin.controller.LunchMainController;
import kr.co.sist.lunch.admin.vo.LunchDetailVO;

/**
 * ���ö� ���̺��� ���õ� ���ö��� ������ ����ϰ� ����, ������ �� �� �ִ� â
 * @author owner
 */
@SuppressWarnings("serial")
public class LunchDetailView extends JDialog {

	private JLabel jlLunchImg;
	private JTextField jtfLunchCode, jtfLunchName, jtfLunchDate, jtfLunchPrice;
	private JTextArea jtaLunchSpec;
	private JButton jbImg, jbUpdate, jbDelete, jbEnd;
	
	public LunchDetailView(LunchMainView lmv, LunchDetailVO ldvo,LunchMainController lmc) {
		super(lmv, "���ö� ������", true); // ���
		
		// DB���� ��ȸ�� ����� Component���� ä���.
		ImageIcon iiLunch = new ImageIcon("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+ldvo.getImg());
		jlLunchImg = new JLabel(iiLunch);
		
		jtfLunchCode = new JTextField();
		jtfLunchName = new JTextField();
		jtfLunchDate = new JTextField();
		jtfLunchPrice = new JTextField();
		
		jtaLunchSpec = new JTextArea();
		
		// DB���� ��ȸ�� �� ����
		jtfLunchCode.setText(ldvo.getLunchCode());
		jtfLunchName.setText(ldvo.getLunchName());
		jtfLunchDate.setText(ldvo.getInput_date());
		jtfLunchPrice.setText(String.valueOf(ldvo.getPrice()));
		jtaLunchSpec.setText(ldvo.getSpec());
		
		jbImg = new JButton("�̹��� ����");
		jbUpdate = new JButton("����");
		jbDelete = new JButton("����");
		jbEnd = new JButton("�ݱ�");
		
		JScrollPane jspTaSpec = new JScrollPane(jtaLunchSpec);
		
		setLayout(null);
		
		JLabel jlDetailTitle = new JLabel("���ö� ������");
		jlDetailTitle.setFont(new Font(Font.DIALOG, Font.BOLD, 25));

		JLabel jlLunchCode = new JLabel("�ڵ�");
		JLabel jlLunchName = new JLabel("���ö���");
		JLabel jlLunchPrice = new JLabel("����");
		JLabel jlLunchDate = new JLabel("�Է���");
		JLabel jlLunchSpec = new JLabel("Ư����");
		
		jlDetailTitle.setBounds(10, 25, 250, 30);
		jlLunchImg.setBounds(10, 65, 244, 220);
		jbImg.setBounds(80, 300, 120, 25);
		
		jlLunchCode.setBounds(270, 65, 80, 25);
		jlLunchName.setBounds(270, 100, 100, 25);
		jlLunchPrice.setBounds(270, 135, 60, 25);
		jlLunchDate.setBounds(270, 170, 80, 25);
		jlLunchSpec.setBounds(270, 205, 80, 25);
		
		jtfLunchCode.setBounds(350, 65, 130, 25); // �ڵ�� ������� ����Ұ�
		jtfLunchCode.setEditable(false);
		jtfLunchCode.setBackground(Color.WHITE);
		jtfLunchName.setBounds(350, 100, 130, 25);
		jtfLunchPrice.setBounds(350, 135, 130, 25);
		jtfLunchDate.setBounds(350, 170, 130, 25);
		jtfLunchDate.setEditable(false);
		jtfLunchDate.setBackground(Color.WHITE);
		jspTaSpec.setBounds(350,205,130,150);
		
		jbUpdate.setBounds(160, 370, 100, 25);
		jbDelete.setBounds(270, 370, 100, 25);
		jbEnd.setBounds(380, 370, 100, 25);
		
		add(jlDetailTitle);
		add(jlLunchImg);
		add(jbImg);
		add(jlLunchCode);
		add(jlLunchName);
		add(jlLunchPrice);
		add(jlLunchDate);
		add(jlLunchSpec);
		add(jtfLunchCode);
		add(jtfLunchName);
		add(jtfLunchPrice);
		add(jtfLunchDate);
		add(jspTaSpec);
		add(jbUpdate);
		add(jbDelete);
		add(jbEnd);
		
		LunchDetailController ldc = new LunchDetailController(this, lmc, ldvo.getImg());
		jbImg.addActionListener(ldc);
		jbUpdate.addActionListener(ldc);
		jbDelete.addActionListener(ldc);
		jbEnd.addActionListener(ldc);
		addWindowListener(ldc);
		
		setBounds(lmv.getX()+100, lmv.getY()+50, 510, 450);
		setResizable(false);
		setVisible(true);
	}
	public JLabel getJlLunchImg() {
		return jlLunchImg;
	}
	public JTextField getJtfLunchCode() {
		return jtfLunchCode;
	}
	public JTextField getJtfLunchName() {
		return jtfLunchName;
	}
	public JTextField getJtfLunchDate() {
		return jtfLunchDate;
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
	public JButton getJbUpdate() {
		return jbUpdate;
	}
	public JButton getJbDelete() {
		return jbDelete;
	}
	public JButton getJbEnd() {
		return jbEnd;
	}
}
