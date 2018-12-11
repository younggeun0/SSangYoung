package date181211;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * inner class�� ����� �̺�Ʈ ó�� : 
 * �����ο� �ش��ϴ� �̺�Ʈó�� �ڵ� �ڵ尡 �ſ� ���ų� 
 * Ư�������ο� �ش��ϴ� �̺�Ʈ�� ó���� �� 
 * @author owner
 */
// 1. ������ ������Ʈ�� ���
public class EventHandlingInnerClass extends Frame {
	
	// 2. �̺�Ʈó�� ���� ������Ʈ�� ��üȭ
	private Button btn;
	
	public EventHandlingInnerClass() {
		super("Inner class�� �̺�Ʈ ó��");
		
		// 3. ������Ʈ ����
		btn = new Button("Ŭ��");
		
		// 4. ��ġ
		Panel panel = new Panel();
		panel.add(btn);
		add(BorderLayout.CENTER, panel);
		
		// 5. �̺�Ʈ ���
		// inner class ����.
		EventHandlingInnerClass.InnerActionImpl iai = 
				this.new InnerActionImpl();
		
		// ������Ʈ�� �̺�Ʈ�� ���
		btn.addActionListener(iai);
		
		// 6. ������ ũ�� ����
		setBounds(100, 100, 300, 300);
		// 7. ����ȭ
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	
	public Button getBtn() {
		return btn;
	}
	//////////////// inner class ���� //////////////////
	// 5-1. inner class�� �̺�Ʈó�� �����ʸ� ����
	public class InnerActionImpl implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("��ư�� Ŭ���Ͽ����ϴ�. "
					+ "o(>.<)o ��~~~");
			// ����Ŭ���������� �ٱ�Ŭ������ �ڿ��� �� ��ó�� ��밡��
			dispose(); 
		}
	}
	//////////////// inner class �� ////////////////////
	
	public static void main(String[] args) {
		new EventHandlingInnerClass();
	}
}
