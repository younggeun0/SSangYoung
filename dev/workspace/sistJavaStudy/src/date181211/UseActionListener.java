package date181211;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ActionListener를 사용한 이벤트 처리<br>
 * is-a 관계로 이벤트를 처리
 * @author owner
 */
@SuppressWarnings("serial")
public class UseActionListener extends Frame implements ActionListener {

	// 다른 메소드에서 사용해야 하므로 지역변수에서 인스턴스변수로 옮김
	private TextField tfName;
	private TextArea taDisplay;
	
	public UseActionListener() {

		super("ActionEvent 사용");
		
		Label lblName = new Label("이름");
		Button btnAdd = new Button("추가");
		Button btnClose = new Button("종료");
		Panel panelNorth = new Panel();
		tfName = new TextField(20);
		taDisplay = new TextArea();
		
		panelNorth.add(lblName);
		panelNorth.add(tfName);
		panelNorth.add(btnAdd);
		panelNorth.add(btnClose);
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, panelNorth);
		add(BorderLayout.CENTER, taDisplay);
		
		// 이벤트 등록
		btnAdd.addActionListener(this); // 버튼에서 이벤트가 등록(클릭)
		tfName.addActionListener(this); // 텍스트필드에서 이벤트가 등록(엔터)
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		setBounds(200, 150, 400, 250);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		new UseActionListener();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TextField의 값을 받아와서, TextArea에 추가
		String name = tfName.getText();
		if (!name.isEmpty()) { // 입력문자열이 비어있지 않다면
			taDisplay.append(name+"\n");
			
			// TextField의 값을 초기화
			tfName.setText("");
		}
		// 커서를 TextField에 재설정
		tfName.requestFocus();
	}
}
