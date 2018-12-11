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
 * inner class를 사용한 이벤트 처리 : 
 * 디자인에 해당하는 이벤트처리 코드 코드가 매우 적거나 
 * 특정디자인에 해당하는 이벤트만 처리할 때 
 * @author owner
 */
// 1. 윈도우 컴포넌트를 상속
public class EventHandlingInnerClass extends Frame {
	
	// 2. 이벤트처리 관련 컴포넌트를 객체화
	private Button btn;
	
	public EventHandlingInnerClass() {
		super("Inner class로 이벤트 처리");
		
		// 3. 컴포넌트 생성
		btn = new Button("클릭");
		
		// 4. 배치
		Panel panel = new Panel();
		panel.add(btn);
		add(BorderLayout.CENTER, panel);
		
		// 5. 이벤트 등록
		// inner class 생성.
		EventHandlingInnerClass.InnerActionImpl iai = 
				this.new InnerActionImpl();
		
		// 컴포넌트에 이벤트에 등록
		btn.addActionListener(iai);
		
		// 6. 윈도우 크기 설정
		setBounds(100, 100, 300, 300);
		// 7. 가시화
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
	//////////////// inner class 시작 //////////////////
	// 5-1. inner class로 이벤트처리 리스너를 구현
	public class InnerActionImpl implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("버튼을 클릭하였습니다. "
					+ "o(>.<)o 꺄~~~");
			// 안쪽클래스에서는 바깥클래스의 자원을 내 것처럼 사용가능
			dispose(); 
		}
	}
	//////////////// inner class 끝 ////////////////////
	
	public static void main(String[] args) {
		new EventHandlingInnerClass();
	}
}
