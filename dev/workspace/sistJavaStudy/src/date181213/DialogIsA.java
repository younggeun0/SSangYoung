package date181213;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
// 1. Dialog 상속
public class DialogIsA extends Dialog implements ActionListener {
	
	private Button btn;
	
	// 현재 다이얼로그의 부모가 될 객체와 has-a 관계 
	public DialogIsA(UseDialogIsA uda) { 
		super(uda, "다이얼로그", true);

		btn = new Button("닫기");
		// 컴포넌트 생생
		Label lbl = new Label("오늘은 목요일입니다.");
		
		add(BorderLayout.CENTER, lbl);
		add(BorderLayout.SOUTH, btn);
		
		btn.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		// 다이얼로그 위치를 부모프레임 안쪽에서 띄우기
		System.out.println("부모의 x :"+uda.getX()+", 부모의 y :"+uda.getY());
		setBounds(uda.getX()+80, uda.getY()+80, 300, 300);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
}
