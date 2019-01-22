package kr.co.sist.lunch.user.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import kr.co.sist.lunch.user.controller.LunchOrderDetailController;
import kr.co.sist.lunch.user.vo.LunchDetailVO;

@SuppressWarnings("serial")
public class LunchOrderDetailView extends JDialog {
	
	private JLabel jlLunchImg;
	private JTextField jtfLunchName, jtfLunchPrice, jtfOrderName, jtfPhone, jtfTotalPrice;
	private JTextArea jtaLunchSpec;
	private JButton jbOrder, jbEnd;
	private JComboBox<Integer> jcbQuan;
	private JTextArea jtaRequest;
	
	public LunchOrderDetailView(LunchClientView lcv, LunchDetailVO ldvo, String lunchCode) {
		super(lcv, ldvo.getLunchName()+" 상세정보", true);
		
		// DB에서 조회한 결과를 Component에서 채운다.
		ImageIcon iiLunch = new ImageIcon("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/lunch_prj/src/kr/co/sist/lunch/user/img/"+ldvo.getImg());
		jlLunchImg = new JLabel(iiLunch);
		
		jtfLunchName = new JTextField(ldvo.getLunchName());
		jtfLunchPrice = new JTextField(String.valueOf(ldvo.getPrice()));
		jtfOrderName = new JTextField();
		jtfPhone = new JTextField();
		jtfTotalPrice = new JTextField(String.valueOf(ldvo.getPrice()));
		jtaLunchSpec = new JTextArea(ldvo.getSpec());
		
		jtaRequest = new JTextArea();
		JScrollPane jspRequest = new JScrollPane(jtaRequest); 
		jspRequest.setBorder(new TitledBorder("주문 요청사항"));
		
		// DB에서 조회한 값 설정
		jbOrder = new JButton("주문");
		jbEnd = new JButton("닫기");
		
		JScrollPane jspTaSpec = new JScrollPane(jtaLunchSpec);
		
		setLayout(null);
		
		JLabel jlDetailTitle = new JLabel("도시락 상세정보");
		jlDetailTitle.setFont(new Font(Font.DIALOG, Font.BOLD, 25));

		JLabel jlLunchName = new JLabel("도시락명");
		JLabel jlLunchPrice = new JLabel("가격");
		JLabel jlOrderName = new JLabel("주문자명");
		JLabel jlLunchQuan = new JLabel("수량");
		JLabel jlTotalPrice = new JLabel("총가격");
		JLabel jlPhone = new JLabel("연락처");
		JLabel jlLunchSpec = new JLabel("특장점");
		
		DefaultComboBoxModel<Integer> dcbmQuan = new DefaultComboBoxModel<Integer>();

		for(int i=1; i<11; i++) {
			dcbmQuan.addElement(new Integer(i));
		}
		jcbQuan = new JComboBox<>();
		jcbQuan.setModel(dcbmQuan);
		
		jlDetailTitle.setBounds(10, 25, 250, 30);
		jlLunchImg.setBounds(10, 65, 244, 220);
		
		jlLunchName.setBounds(270, 65, 80, 25);
		jlLunchPrice.setBounds(270, 100, 100, 25);
		jlLunchSpec.setBounds(270, 135, 80, 25);
		jlOrderName.setBounds(270, 245, 60, 25);
		jlPhone.setBounds(270, 280, 80, 25);
		jlLunchQuan.setBounds(270, 315, 80, 25);
		jlTotalPrice.setBounds(270, 350, 80, 25);
		
		jtfLunchName.setBounds(350, 65, 130, 25);
		jtfLunchName.setEditable(false);
		jtfLunchName.setBackground(Color.WHITE);
		jtfLunchPrice.setBounds(350, 100, 130, 25);
		jtfLunchPrice.setEditable(false);
		jtfLunchPrice.setBackground(Color.WHITE);
		jspTaSpec.setBounds(350,135,130,100);
		jtaLunchSpec.setEditable(false);
		jtaLunchSpec.setBackground(Color.WHITE);
		jtfOrderName.setBounds(350, 245, 130, 25);
		jtfPhone.setBounds(350, 280, 130, 25);
		jcbQuan.setBounds(350, 315, 130, 25);
		jtfTotalPrice.setBounds(350, 350, 130, 25);
		jtfTotalPrice.setEditable(false);
		jtfTotalPrice.setBackground(Color.WHITE);
		
		jbOrder.setBounds(270, 420, 100, 25);
		jbEnd.setBounds(380, 420, 100, 25);
		
		jspRequest.setBounds(10, 300, 244, 120);
		
		add(jspRequest);
		add(jlDetailTitle);
		add(jlLunchImg);
		add(jlLunchName);
		add(jlLunchPrice);
		add(jlOrderName);
		add(jlPhone);
		add(jlLunchQuan);
		add(jlTotalPrice);
		add(jlLunchSpec);
		add(jtfLunchName);
		add(jtfLunchPrice);
		add(jtfOrderName);
		add(jtfPhone);
		add(jspTaSpec);
		add(jbOrder);
		add(jbEnd);
		add(jcbQuan);
		add(jtfTotalPrice);
		
		LunchOrderDetailController lodc = new LunchOrderDetailController(this, lunchCode);
		jcbQuan.addActionListener(lodc);
		jbEnd.addActionListener(lodc);
		jbOrder.addActionListener(lodc);
		addWindowListener(lodc);
		
		setBounds(lcv.getX()+100, lcv.getY()+50, 510, 500);
		setResizable(false);
		setVisible(true);
	}
	
	public JTextArea getJtaRequest() {
		return jtaRequest;
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
	public JTextField getJtfOrderName() {
		return jtfOrderName;
	}
	public JTextField getJtfPhone() {
		return jtfPhone;
	}
	public JTextField getJtfTotalPrice() {
		return jtfTotalPrice;
	}
	public JTextArea getJtaLunchSpec() {
		return jtaLunchSpec;
	}
	public JButton getJbOrder() {
		return jbOrder;
	}
	public JButton getJbEnd() {
		return jbEnd;
	}
	public JComboBox<Integer> getJcbQuan() {
		return jcbQuan;
	}
}
