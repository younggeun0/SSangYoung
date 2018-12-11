package date181211;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Has-A ����� �̺�Ʈ ó��
 * 
 * @author owner
 */
// 1. �̺�Ʈ ó�� ��ü�� ����
public class EventHandlingHasA implements ActionListener {

	// EventHandlingHasA�� Design�� ������ �ִ�.
	// 2. Has-A ����� �����ϰ� ����� ��ü ����
	private Design design;
	
	public EventHandlingHasA(Design design) {
		this.design = design;
	}
	
	@Override
	// 3. abstract method�� Override
	public void actionPerformed(ActionEvent e) {
		// �̺�Ʈ�� �߻����� �� ó���� �ڵ�
		System.out.println("���޹��� Design��ü : "+design);
		design.dispose();
	}
}
