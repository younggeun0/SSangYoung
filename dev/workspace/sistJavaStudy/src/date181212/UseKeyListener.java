package date181212;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * KeyEvent Handling
 * @author owner
 */
@SuppressWarnings("serial")
// 1.윈도우 컴포넌트 상속, 이벤트 처리 리스너 구현
public class UseKeyListener extends Frame implements KeyListener {

	// 2. 이벤트와 관련있는 컴포넌트 선언
	TextField tf;
	Label lbl;

	public UseKeyListener() {
		super("키보드 이벤트 연습");
		
		// 3. 컴포넌트 생성
		tf = new TextField();
		lbl = new Label("출력창",Label.CENTER);
		// 4. 배치
		add(BorderLayout.NORTH, tf);
		add(BorderLayout.CENTER, lbl);
		
		// 5. 컴포넌트를 이벤트에 등록
		tf.addKeyListener( this );
		
		// 6. 윈도우의 크기 설정
		setBounds(300, 200, 300, 300);
		// 7. 가시화
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
	public void keyTyped(KeyEvent e) {
		// 2. 키가 눌려 정보가 전달되는 순간. 눌린 키의 정보중 문자만 알 수 있다.
		// 키코드를 알 순 없다. (키코드 != 유니코드)
		System.out.println("keyTyped");
	}
	@Override
	public void keyPressed(KeyEvent e) { 
		// 1. 키보드의 키가 눌리는 순간, 키의 정보를 알 수 있다.
		System.out.println("keyPressed");
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// 3. 눌린 키가 정보를 전달하고 다시 올라오는 순간. 눌린키의 정보를 알 수 있다.
		System.out.println("keyReleased");
		// 눌린 키의 문자와 코드값을 얻어 출력 Label에 뿌린다.
		char inputKey = e.getKeyChar();
		// keyCode는 키보드 키의 고유값. unicode와 다르게 같은 값이 나온다.
		int inputCode = e.getKeyCode();  
		StringBuilder output = new StringBuilder();
		
		output.append("눌린키 문자 : ").append(Character.toString(inputKey))
			.append(", 유니코드 : ").append(Integer.toString(inputCode));
		
		lbl.setText(output.toString());
		
		switch(inputCode) {
		case KeyEvent.VK_ENTER : // Enter키 입력 시 tf 초기화
			// jdk 1.6?7? 에서 발생한 버그, TextField, TextArea는
			// setText("")를 바로 사용하면 초기화되지 않는다.
			// 값을 한번 얻어내고 초기화하면 잘 됨, 또는 " "빈문자열 하나로 대치하면 된다.
			tf.getText();
			tf.setText("");
			break;
		case KeyEvent.VK_ESCAPE : // Esc키 입력 시 종료
			dispose();
			break;
		}
	}
	public static void main(String[] args) {
		new UseKeyListener();
	}
}