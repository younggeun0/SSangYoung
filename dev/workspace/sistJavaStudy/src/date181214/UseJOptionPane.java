package date181214;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseJOptionPane extends JFrame implements ActionListener {

	private JButton btn1, btn2, btn3;
	private JLabel jlOutput;
	
	public UseJOptionPane() {
		super("jOptionPane ���");
		
		btn1 = new JButton("Input Dialog");
		btn2 = new JButton("Message Dialog");
		btn3 = new JButton("Confirm Dialog");
		
		jlOutput = new JLabel("���");
		jlOutput.setBorder(new TitledBorder("���â"));
		
		JPanel panel = new JPanel();
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		
		add(BorderLayout.CENTER, panel);
		add(BorderLayout.SOUTH, jlOutput);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		setBounds(300, 200, 600, 180);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btn1) {
			String name = JOptionPane.showInputDialog("�̸��� �Է��ϼ���.", "ȫ�浿");
			jlOutput.setText(name+"�� �ȳ��ϼ���.");
		}
		if (ae.getSource() == btn2 ) {
			JOptionPane.showMessageDialog(this, "������ �ݿ����Դϴ�.","���Ͼȳ�",JOptionPane.INFORMATION_MESSAGE);
		}
		if (ae.getSource() == btn3) {
			int flag = JOptionPane.showConfirmDialog(this, "���� ���ְ� ��̾��?");
			switch (flag) {
			case JOptionPane.OK_OPTION:
				JOptionPane.showMessageDialog(this, "�ູ�� ���� �Ǽ���!", "�ູ�����", JOptionPane.PLAIN_MESSAGE);
				break;
			case JOptionPane.NO_OPTION:
				String menu = JOptionPane.showInputDialog("� ���� �޴������?");
				if(menu != null)
					JOptionPane.showMessageDialog(this, menu+"�� �� �׷��� ��!");
				break;
			case JOptionPane.CANCEL_OPTION:
				JOptionPane.showMessageDialog(this, "�ϱ������?");
				break;
			}
		}
	}

	public static void main(String[] args) {
		new UseJOptionPane();
	}
}
