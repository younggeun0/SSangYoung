package date181210;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 수동배치
 * 개발자가 컴포넌트의 배치 위치와 크기를 설정하는 배치방법
 * @author owner
 */
// 1. Window Component 상속
@SuppressWarnings("serial")
public class UseManualLayout extends Frame {

	public UseManualLayout() {
		super("수동배치");
		
		// 2. 컴포넌트 생성
		Label lbl = new Label();
		lbl.setText("라벨");
		TextField tf = new TextField();
		Button btn = new Button("클릭");		
		
		// 3. 배치관리자 설정(해제) : BorderLayout -> null
		setLayout(null);
		
		// 4. 배치
		lbl.setLocation(10, 35); // 배치 좌표
		lbl.setSize(80,20);	// 배치 크기
		// setLocation+setSize = setBounds
		tf.setBounds(50,100,120,25); // x, y, w, h
		btn.setBounds(250,200,120,23);
		
		add(lbl);
		add(tf);
		add(btn);
		
		/*
		// 5. 윈도우 좌표 설정
		setLocation(100, 200);
		// 6. 윈도우 크기 설정
		setSize(500, 600);
		*/
		
		// 5,6을 동시에, 좌표, 크기를 동시설정하는 setBounds
		setBounds(200, 100, 400, 250);
		
		// 7. 사용자에게 보여주기(가시화)
		setVisible(true);
		
		// 종료처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		// 크기를 늘리거나 줄일 수 있는 걸 선택하는 메소드
		setResizable(false);
	}
	
	public static void main(String[] args) {
		
		new UseManualLayout();
	}
}
