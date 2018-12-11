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
 * ActionEvent를 사용한 Is-A 관계로 이벤트를 처리하는 방법<br/>
 * 디자인과 이벤트 처리를 하나의 클래스안에서 처리한다.
 * (값에 대한 사용이 편하다.)
 * @author owner
 */
// 1. 상속으로 Frame을 처리하고, 구현으로 Event Handling 객체를 처리
@SuppressWarnings("serial")
public class EventHandlingIsA extends Frame implements ActionListener {

	
	// 2. 이벤트 처리와 관련이 있는 Component 선언
	private Button btn;
	
	public EventHandlingIsA() {
		super("Is-A 관계로 이벤트 처리방법");
		// 3. Component 생성
		btn = new Button("클릭");
		
		// 4. 생성된 컴포넌트가 이벤트를 발생시킬 수 있도록이벤트에 등록
		btn.addActionListener(this); 
		// Arguments로 입력된 객체의 Override된 method가 호출된다.
		
		Panel panel = new Panel();
		panel.add(btn);
		
		// 5. 생성된 컴포넌트를 배치
		add(BorderLayout.CENTER, panel);
		
		// 6. 윈도우 컴포넌트의 크기를 설정
		setBounds(400, 200, 300, 300);
		
		// 7. 사용자에게 보여주기 (가시화)
		setVisible(true);
		
		// 8. 종료처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼이 클릭되었습니다.");
		dispose();
	}
	
	public static void main(String[] args) {
		new EventHandlingIsA();
	}
}
