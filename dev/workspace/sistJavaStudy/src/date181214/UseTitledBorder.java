package date181214;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import kr.co.sist.memo.view.JavaMemo;

public class UseTitledBorder extends JFrame implements ActionListener {

	private JTextField jtfId;
	private JPasswordField jpfPw;
	private JLabel jlOutput;

	public UseTitledBorder() {
		super("Border ���");

		jtfId = new JTextField();
		jpfPw = new JPasswordField();
		jlOutput = new JLabel();

		jtfId.setBorder(new TitledBorder("���̵�"));
		jpfPw.setBorder(new TitledBorder("��й�ȣ"));
		jlOutput.setBorder(new TitledBorder("���â"));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder("�α���"));
		panel.setLayout(new GridLayout(3, 1));
		panel.add(jtfId);
		panel.add(jpfPw);
		panel.add(jlOutput);

		jtfId.addActionListener(this);
		jpfPw.addActionListener(this);

		add(BorderLayout.CENTER, panel);

		setBounds(100, 100, 250, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		String id = jtfId.getText().trim();
		
		// ���̵𿡼� �̺�Ʈ�� �߻��ϸ�
		if (ae.getSource() == jtfId) {
			// ���̵� ���� ����ִٸ� Ŀ���� ��й�ȣ�� �̵�
			if (!id.equals("")) {
				jpfPw.requestFocus();
			}
		}
		// ��й�ȣ���� �̺�Ʈ�� �߻��ϸ�
		if (ae.getSource() == jpfPw) {
			// ���̵� ���� ���ٸ� Ŀ���� ���̵�� �̵�,
			if (id.equals("")) {
				jtfId.requestFocus();
				jlOutput.setText("���̵� �Է����ּ���.");
				
				// ��ȯ���� void�� �޼ҵ忡�� �ڵ��� ������ ���߰�
				// ȣ���� ������ ���ư���� �ǹ�
				return; 
			}

			String pw = new String(jpfPw.getPassword());

			// ��й�ȣ�� ���� ���ٸ� ���â�� "����Է�"�� �����ְ� Ŀ���� ��й�ȣ�� �̵�
			if(pw.trim().equals("")) {
				jlOutput.setText("��й�ȣ�� �Է����ּ���.");
				return;
			}
			// ��й�ȣ�� ���� �ִٸ� ���̵� admin, ��й�ȣ�� 123�� ������ 
			// ���Ͽ� ���ٸ� �ڹٸ޸��� Ŭ������ ����
			if(id.equals("admin") && pw.equals("123")) {
				new JavaMemo();
				dispose();
			} else {
				jlOutput.setText("���̵� ��й�ȣ�� Ȯ�����ּ���.");
			}
		}
	}

	public static void main(String[] args) {
		new UseTitledBorder();
	}
}
