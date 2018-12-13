package date181213;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Swing을 사용한 Window Application
 * @author owner
 */
public class HelloSwing extends JFrame implements ActionListener {
	
	private JButton jb;
	private Button btn;

	public HelloSwing() {
		super("스윙 연습");
		
		// 컴포넌트 생성
		jb = new JButton("안녕! 난 스윙이라고 해");
		btn = new Button("AWT버튼");
		
		// 배치관리자 전환
		setLayout(new GridLayout(1, 2));
		
		// 배치
		add(jb);
		add(btn);
		
		jb.addActionListener(this);
		btn.addActionListener(this);
		
		// 크기설정
		setBounds(300, 200, 400, 400);
		// 가시화
		setVisible(true);
		
		// 윈도우 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new HelloSwing();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb) {
			dispose();
		}
		if (e.getSource() == btn) {
			btn.setLabel("AWT라니!!");
		}
	}
}
