package date181210;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 일반 컴포넌트와 Container 컴포넌트를 저장할 수 있는
 * @author owner
 */
// 1. Window Component 상속 
public class UsePanel extends Frame {

	public UsePanel() {

		super("Container Component 사용");
		
		// 2. 컴포넌트 생성
		// 이름부여방식 - 헝가리안 표기법(Hungarian notation)
		Label lblName = new Label("이름");
		
		// 색설정 : field
		lblName.setForeground(new Color(0x61AFEF));
		lblName.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		
		TextField tfName = new TextField(20);
		
		tfName.setBackground(Color.BLACK);
		tfName.setForeground(Color.GREEN);
		
		Button btnAdd = new Button("추가");
		Color back = new Color(0xFF5E00);
		Color fore = new Color(0x6BEC62);
		btnAdd.setBackground(back);
		btnAdd.setForeground(fore);
		
		Button btnClose = new Button("종료");
		btnClose.setBackground(Color.DARK_GRAY);
		btnClose.setForeground(Color.GREEN);
		
		TextArea taDisplay = new TextArea();
		// 색설정 : RGB를 사용한 생성자 사용. -> 다양한 색을 사용할 수 있다.
		taDisplay.setBackground(Color.DARK_GRAY);
		taDisplay.setForeground(Color.GREEN);
		taDisplay.setFont(new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 20));
		
		
		// 일반컴포넌트를 배치할 수 있는 컨테이너 컴포넌트 생성
		Panel panelNorth = new Panel();
		
		panelNorth.setBackground(new Color(0x282C34));
		
		// 생성된 컨테이너 컴포넌트에 일반 컴포넌트를 배치
		panelNorth.add(lblName);
		panelNorth.add(tfName);
		panelNorth.add(btnAdd);
		panelNorth.add(btnClose);
		
		// 3. 배치관리자 설정
		setLayout(new BorderLayout());
		
		// 4. 배치 BorderLayout의 특징
		// 하나의 영역에는 하나의 컴포넌트만 저장가능
		
		add(BorderLayout.NORTH, panelNorth);
		add(BorderLayout.CENTER, taDisplay);
		
		// 5. Window 위치,크기 설정
		setBounds(200, 150, 400, 250);
		
		// 6. 가시화
		setVisible(true);
		
		// 7. 종료처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		
	}
	
	public static void main(String[] args) {
		new UsePanel();
	}
}
