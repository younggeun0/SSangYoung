package date181212;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * KeyEvent Handling
 * @author owner
 */
@SuppressWarnings("serial")
// 1.������ ������Ʈ ���, �̺�Ʈ ó�� ������ ����
public class UseKeyListener extends Frame implements KeyListener {

	// 2. �̺�Ʈ�� �����ִ� ������Ʈ ����
	TextField tf;
	Label lbl;

	public UseKeyListener() {
		super("Ű���� �̺�Ʈ ����");
		
		// 3. ������Ʈ ����
		tf = new TextField();
		lbl = new Label("���â",Label.CENTER);
		// 4. ��ġ
		add(BorderLayout.NORTH, tf);
		add(BorderLayout.CENTER, lbl);
		
		// 5. ������Ʈ�� �̺�Ʈ�� ���
		tf.addKeyListener( this );
		
		// 6. �������� ũ�� ����
		setBounds(300, 200, 300, 300);
		// 7. ����ȭ
		setVisible(true);
		// 8. ����ó��
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// 2. Ű�� ���� ������ ���޵Ǵ� ����. ���� Ű�� ������ ���ڸ� �� �� �ִ�.
		// Ű�ڵ带 �� �� ����. (Ű�ڵ� != �����ڵ�)
		System.out.println("keyTyped");
	}
	@Override
	public void keyPressed(KeyEvent e) { 
		// 1. Ű������ Ű�� ������ ����, Ű�� ������ �� �� �ִ�.
		System.out.println("keyPressed");
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// 3. ���� Ű�� ������ �����ϰ� �ٽ� �ö���� ����. ����Ű�� ������ �� �� �ִ�.
		System.out.println("keyReleased");
		// ���� Ű�� ���ڿ� �ڵ尪�� ��� ��� Label�� �Ѹ���.
		char inputKey = e.getKeyChar();
		// keyCode�� Ű���� Ű�� ������. unicode�� �ٸ��� ���� ���� ���´�.
		int inputCode = e.getKeyCode();  
		StringBuilder output = new StringBuilder();
		
		output.append("����Ű ���� : ").append(Character.toString(inputKey))
			.append(", �����ڵ� : ").append(Integer.toString(inputCode));
		
		lbl.setText(output.toString());
		
		switch(inputCode) {
		case KeyEvent.VK_ENTER : // EnterŰ �Է� �� tf �ʱ�ȭ
			// jdk 1.6?7? ���� �߻��� ����, TextField, TextArea��
			// setText("")�� �ٷ� ����ϸ� �ʱ�ȭ���� �ʴ´�.
			// ���� �ѹ� ���� �ʱ�ȭ�ϸ� �� ��, �Ǵ� " "���ڿ� �ϳ��� ��ġ�ϸ� �ȴ�.
			tf.getText();
			tf.setText("");
			break;
		case KeyEvent.VK_ESCAPE : // EscŰ �Է� �� ����
			dispose();
			break;
		}
	}
	public static void main(String[] args) {
		new UseKeyListener();
	}
}