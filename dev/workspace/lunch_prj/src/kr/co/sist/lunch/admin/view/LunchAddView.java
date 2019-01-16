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
 * 도시락 테이블에 도시락을 추가하는 창
 * @author owner
 */
@SuppressWarnings("serial")
public class LunchAddView extends JDialog {

	private JLabel jlLunchImg;
	private JTextField jtfLunchName, jtfLunchPrice;
	private JTextArea jtaLunchSpec;
	private JButton jbImg, jbAdd, jbEnd;
	
	public LunchAddView(LunchMainView lmv, LunchMainController lmc) {
		super(lmv, "도시락 추가", true); // 모달
		
		// DB에서 조회한 결과를 Component에서 채운다.
		ImageIcon iiLunch = new ImageIcon("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/no_img.jpg");
		jlLunchImg = new JLabel(iiLunch);
		
		jtfLunchName = new JTextField();
		jtfLunchPrice = new JTextField();
		
		jtaLunchSpec = new JTextArea();
		
		jbImg = new JButton("이미지 선택");
		jbAdd = new JButton("추가");
		jbEnd = new JButton("닫기");
		
		JScrollPane jspTaSpec = new JScrollPane(jtaLunchSpec);
		
		setLayout(null);
		
		JLabel jlDetailTitle = new JLabel("도시락 추가");
		jlDetailTitle.setFont(new Font(Font.DIALOG, Font.BOLD, 25));

		JLabel jlLunchName = new JLabel("도시락명");
		JLabel jlLunchPrice = new JLabel("가격");
		JLabel jlLunchSpec = new JLabel("특장정");
		
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
