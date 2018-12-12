package date181212;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 같은 종류의 이벤트가 여러개 발생하면,
 * 그 이벤트를 비교하여 처리하는 방법<br>
 * 1. 이벤트를 발생시킨 객체의 주소비교 - 모든 이벤트 사용가능 : getSource() <br>
 * 2. 이벤트 발생시킨 객체의 Label을 비교하는 방법 - ActionEvent만 가능 : 
 * 		getActionCommand() <br>
 * @author owner
 */
@SuppressWarnings("serial")
// 1. Window Component 상속, Event처리 Listener를 구현
public class EventCompare extends Frame implements ActionListener {

	// 2. 이벤트와 관련있는 Component를 선언
	private Button btnOpen;
	private Button btnSave;
	private Label lblOutput;
	
	public EventCompare() {
		super("파일다이얼로그 사용");
		
		// 3. 생성
		btnOpen = new Button("열기모드");
		btnSave = new Button("저장모드");
		lblOutput = new Label("출력창 : ");
		
		// 4. 배치
		Panel panel = new Panel(); // Container Component
		panel.add(btnOpen); panel.add(btnSave);
		add(BorderLayout.CENTER, panel);
		add(BorderLayout.SOUTH, lblOutput);
		
		// 5. 이벤트 등록
		btnOpen.addActionListener(this);
		btnSave.addActionListener(this);
		
		// 6. 윈도우 크기 설정
		setBounds(100, 100, 700, 100);
		// 7. 가시화
		setVisible(true);
		// 종료처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		/////////////////// 주소 비교 //////////////////////
		/*if (e.getSource() == btnOpen) {
			System.out.println("열기");
		}
		if (e.getSource() == btnSave) {
			
			System.out.println("저장");
		}*/
		////////////////////////////////////////////////////
		/////////////////// Label 비교 //////////////////////
		String label = e.getActionCommand();
		if (label.equals("열기모드")) {
			System.out.println("열기");
			FileDialog fdOpen = new FileDialog(this, "파일 열기", FileDialog.LOAD);
			// 가시화
			fdOpen.setVisible(true);
			
			String path = fdOpen.getDirectory();
			String name = fdOpen.getFile();
			
			if (name != null) { // 선택한 파일이 있을 때 
				lblOutput.setText("열기 파일 : "+path+name);
				// 타이틀바의 내용 변경
				setTitle("파일다이얼로그 사용 - 열기 : "+name);
			}
		}
		if (label.equals("저장모드")) {
			System.out.println("저장");
			FileDialog fdSave = new FileDialog(this, "파일 저장", FileDialog.SAVE);
			// 가시화
			fdSave.setVisible(true);
			
			String path = fdSave.getDirectory();
			String name = fdSave.getFile();
			
			if (name != null) {
				lblOutput.setText("열기 파일 : "+path+name);
				// 타이틀바의 내용 변경
				setTitle("파일다이얼로그 사용 - 저장 : "+name);
			}
		}
		////////////////////////////////////////////////////
	}
	public static void main(String[] args) {
		new EventCompare();
	}
}
