package date181204;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class TestAnonymous extends Frame{

	public TestAnonymous() {
		super("Anonymous inner class 연습");
		Button btn = new Button("클릭");
		add(btn);
		setSize(300, 300);
		
		// anonymous inner class로 윈도우 종료 이벤트를 처리
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			};
			
		} );
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestAnonymous();
	}
}
