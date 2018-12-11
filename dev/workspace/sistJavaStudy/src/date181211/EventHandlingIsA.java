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
 * ActionEvent�� ����� Is-A ����� �̺�Ʈ�� ó���ϴ� ���<br/>
 * �����ΰ� �̺�Ʈ ó���� �ϳ��� Ŭ�����ȿ��� ó���Ѵ�.
 * (���� ���� ����� ���ϴ�.)
 * @author owner
 */
// 1. ������� Frame�� ó���ϰ�, �������� Event Handling ��ü�� ó��
@SuppressWarnings("serial")
public class EventHandlingIsA extends Frame implements ActionListener {

	
	// 2. �̺�Ʈ ó���� ������ �ִ� Component ����
	private Button btn;
	
	public EventHandlingIsA() {
		super("Is-A ����� �̺�Ʈ ó�����");
		// 3. Component ����
		btn = new Button("Ŭ��");
		
		// 4. ������ ������Ʈ�� �̺�Ʈ�� �߻���ų �� �ֵ����̺�Ʈ�� ���
		btn.addActionListener(this); 
		// Arguments�� �Էµ� ��ü�� Override�� method�� ȣ��ȴ�.
		
		Panel panel = new Panel();
		panel.add(btn);
		
		// 5. ������ ������Ʈ�� ��ġ
		add(BorderLayout.CENTER, panel);
		
		// 6. ������ ������Ʈ�� ũ�⸦ ����
		setBounds(400, 200, 300, 300);
		
		// 7. ����ڿ��� �����ֱ� (����ȭ)
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
	public void actionPerformed(ActionEvent e) {
		System.out.println("��ư�� Ŭ���Ǿ����ϴ�.");
		dispose();
	}
	
	public static void main(String[] args) {
		new EventHandlingIsA();
	}
}
