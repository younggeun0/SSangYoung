package date181211;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Has-A ������ �̺�Ʈ ó��
 * �����ΰ� �̺�Ʈó�� �ڵ带 �и��Ͽ� �ڵ��� ���⵵�� ���� �� �ִ�.
 * @author owner
 */
// 1. ������ ������Ʈ�� ���
@SuppressWarnings("serial")
public class Design extends Frame {

	// 2. �̺�Ʈó���� �����ִ� Component�� ����
	private Button btn;
	
	public Design() {
		super("������");
		// 3. ������Ʈ ����
		btn = new Button("Ŭ��");
		
		// 4. ��ġ
		Panel panel = new Panel();
		panel.add(btn);
		
		add(BorderLayout.CENTER, panel);
		
		// 5. �̺�Ʈ ���
		// �̺�Ʈ ó�� ��ü �����ϰ� Has-A ���輳��
		EventHandlingHasA ehha = new EventHandlingHasA(this);
		System.out.println("������ ������ ��ü "+this);
		
		// ������Ʈ�� �̺�Ʈ�� ���
		// ��ư���� �̺�Ʈ�� �߻��ϸ� ehha��ü�� Override�� method����
		// �̺�Ʈ�� ó��
		btn.addActionListener(ehha);
		
		// 6. ������ ũ�� ����
		setBounds(100,100,400,300);
		
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
	
	public Button getButton() {
		return btn;
	}
	
	public static void main(String[] args) {
		new Design();
	}
}
