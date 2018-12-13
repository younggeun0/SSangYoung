package kr.co.sist.memo.view;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MemoHelp extends Dialog {

	public MemoHelp(JavaMemo jm) {
		super(jm, "메모장 정보", true);
		
		TextArea taInfo = new TextArea("메모장 정보\n" + 
				"이 메모장은 Java로 만들어졌으며 누구나 코드 수정 및 배포할 수 있습니다.\n" + 
				"단, 이 코드를 사용하여 개선했을 때에는 소스공개를 원칙으로 한다. (GNU)\n" + 
				" \n" + 
				"작성자 : 오영근\n" + 
				"version : 1.0");
		taInfo.setEditable(false);
		Button btnConfirm = new Button("확인");
		
		setLayout(null);
		taInfo.setBounds(20, 40, 440, 100);
		add(taInfo);
		btnConfirm.setBounds(215, 150, 60, 25);
		add(btnConfirm);
		
		setBounds(jm.getX()+80, jm.getY()+80, 480, 200);
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setVisible(true);
	}
}
