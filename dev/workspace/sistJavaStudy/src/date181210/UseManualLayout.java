package date181210;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ������ġ
 * �����ڰ� ������Ʈ�� ��ġ ��ġ�� ũ�⸦ �����ϴ� ��ġ���
 * @author owner
 */
// 1. Window Component ���
@SuppressWarnings("serial")
public class UseManualLayout extends Frame {

	public UseManualLayout() {
		super("������ġ");
		
		// 2. ������Ʈ ����
		Label lbl = new Label();
		lbl.setText("��");
		TextField tf = new TextField();
		Button btn = new Button("Ŭ��");		
		
		// 3. ��ġ������ ����(����) : BorderLayout -> null
		setLayout(null);
		
		// 4. ��ġ
		lbl.setLocation(10, 35); // ��ġ ��ǥ
		lbl.setSize(80,20);	// ��ġ ũ��
		// setLocation+setSize = setBounds
		tf.setBounds(50,100,120,25); // x, y, w, h
		btn.setBounds(250,200,120,23);
		
		add(lbl);
		add(tf);
		add(btn);
		
		/*
		// 5. ������ ��ǥ ����
		setLocation(100, 200);
		// 6. ������ ũ�� ����
		setSize(500, 600);
		*/
		
		// 5,6�� ���ÿ�, ��ǥ, ũ�⸦ ���ü����ϴ� setBounds
		setBounds(200, 100, 400, 250);
		
		// 7. ����ڿ��� �����ֱ�(����ȭ)
		setVisible(true);
		
		// ����ó��
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		// ũ�⸦ �ø��ų� ���� �� �ִ� �� �����ϴ� �޼ҵ�
		setResizable(false);
	}
	
	public static void main(String[] args) {
		
		new UseManualLayout();
	}
}
