package date181207;

import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Window Application 작성
 * @author owner
 */
// 1. Window Component 상속
@SuppressWarnings("serial")
public class HelloAwt extends Frame {

	public HelloAwt() {
		super("Awt 연습"); // Frame 인자생성자 호출(타이틀설정)
		// 2. 사용할 일반컴포넌트 생성.
		Label lblTitle = new Label("오늘 베스트 사자성어", Label.CENTER);
		TextArea ta = new TextArea("정택성씨\n구로1동의 자랑");
		
		// 3. 배치관리자를 사용하여 컴포넌트를 배치
		add("North",lblTitle);
		add("Center",ta);
		
		// 4. 윈도우의 크기를 설정
		setSize(400, 270);
		
		// 5. 사용자에게 보여주기
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				// 현재 윈도우인스턴스만 종료
				dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		new HelloAwt();
	}
}
