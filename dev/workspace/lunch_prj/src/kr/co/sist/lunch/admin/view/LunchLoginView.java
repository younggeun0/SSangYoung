package kr.co.sist.lunch.admin.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import kr.co.sist.lunch.admin.controller.LunchLoginController;

@SuppressWarnings("serial")
public class LunchLoginView extends JFrame {

	private JTextField jtfId;
	private JPasswordField jpfPass;
	private JButton jbtLogin;
	
	public LunchLoginView() {
		super("���ö� ������");
		jtfId = new JTextField();
		jpfPass = new JPasswordField();
		jbtLogin = new JButton("�α���");
		
		JLabel jlLoginTitle = new JLabel("������ �α���");
		jlLoginTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		
		JLabel jlId = new JLabel("���̵�");
		JLabel jlPass = new JLabel("��й�ȣ");
		
		setLayout(null);
		
		jlLoginTitle.setBounds(80, 10, 140, 25);
		add(jlLoginTitle);
		
		jlId.setBounds(10,50,60,25);
		add(jlId);
		jlPass.setBounds(10, 85, 60, 25);
		add(jlPass);
		jtfId.setBounds(75, 50, 100, 25);
		add(jtfId);
		jpfPass.setBounds(75, 85, 100, 25);
		add(jpfPass);
		jbtLogin.setBounds(190, 50, 75, 60);
		add(jbtLogin);

		jtfId.requestFocus();
		
		// �̺�Ʈ ó�� ���
		LunchLoginController llc = new LunchLoginController(this);
		jtfId.addActionListener(llc);
		jpfPass.addActionListener(llc);
		jbtLogin.addActionListener(llc);
		addWindowListener(llc);
		
		setBounds(100, 100, 295, 170);
		setResizable(false);
		setVisible(true);
	}

	public JTextField getJtfId() {
		return jtfId;
	}
	public JPasswordField getJpfPass() {
		return jpfPass;
	}
	public JButton getJbtLogin() {
		return jbtLogin;
	}
}
