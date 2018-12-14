package date181214;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * JScrollPane ���
 * @author owner
 */
@SuppressWarnings("serial")
public class UseScrollPane extends JFrame {

	public UseScrollPane() {
		super("��ũ�� �ٰ� ���� ��ü");
		
		JTextArea jta = new JTextArea();
		// JTextArea�� �ۼ��� ���� J.T.A�� ���� �����ϸ� �� ����
		jta.setLineWrap(true);
		
		// ���� ����Ǹ� �ܾ ��ȣ�ϸ鼭 ���� ����.(�ѱ��� �ȵ�)
		jta.setWrapStyleWord(true);
		
		// JTextArea�� ScrollBar ����
		// 1. JScrollPane ����
		JScrollPane jsp = new JScrollPane(jta);
		
		// 2. ��ġ
		add(BorderLayout.CENTER, jsp);
		
		setBounds(100, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new UseScrollPane();
	}
}
