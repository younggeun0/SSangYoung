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
		// 1. 주소로 비교하기, 이벤트를 발생한 객체와 컴포넌트 객체를 비교
		if (e.getSource() == design.getBtnA()) {
			System.out.println("ㅋㅋㅋ");
		}
		if (e.getSource() == design.getBtnB()) {
			System.out.println("^0^");
		}
		// 2. 라벨로 비교하기
		// ActionEvent 발생객체의 Label과 컴포넌트의 Lable 비교
		if (e.getActionCommand().equals("A")) {
			System.out.println("ㅋㅋㅋ");
		}
		if (e.getActionCommand().equals("B")) {
			System.out.println("^0^");
		}
	}
}
