package date181213;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Swing�� ����� Window Application
 * @author owner
 */
public class HelloSwing extends JFrame implements ActionListener {
	
	private JButton jb;
	private Button btn;

	public HelloSwing() {
		super("���� ����");
		
		// ������Ʈ ����
		jb = new JButton("�ȳ�! �� �����̶�� ��");
		btn = new Button("AWT��ư");
		
		// ��ġ������ ��ȯ
		setLayout(new GridLayout(1, 2));
		
		// ��ġ
		add(jb);
		add(btn);
		
		jb.addActionListener(this);
		btn.addActionListener(this);
		
		// ũ�⼳��
		setBounds(300, 200, 400, 400);
		// ����ȭ
		setVisible(true);
		
		// ������ ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new HelloSwing();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb) {
			dispose();
		}
		if (e.getSource() == btn) {
			btn.setLabel("AWT���!!");
		}
	}
}
