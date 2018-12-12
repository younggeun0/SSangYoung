package date181212;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEventHandler implements ActionListener {

	private ButtonDesign design;
	
	public ButtonEventHandler(ButtonDesign design) {
		this.design = design;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 1. �ּҷ� ���ϱ�, �̺�Ʈ�� �߻��� ��ü�� ������Ʈ ��ü�� ��
		if (e.getSource() == design.getBtnA()) {
			System.out.println("������");
		}
		if (e.getSource() == design.getBtnB()) {
			System.out.println("^0^");
		}
		// 2. �󺧷� ���ϱ�
		// ActionEvent �߻���ü�� Label�� ������Ʈ�� Lable ��
		if (e.getActionCommand().equals("A")) {
			System.out.println("������");
		}
		if (e.getActionCommand().equals("B")) {
			System.out.println("^0^");
		}
	}
}
