package date181210;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AutoLayout extends Frame {

	public AutoLayout() {
		super("자동배치");
		// BorderLayout North, Center, South에 쓸 Panel들
		Panel panelNorth = new Panel();
		Panel panelCenter = new Panel();
		Panel panelSouth = new Panel();
		
		// BorderLayout North
		Label lblNorth = new Label("학생관리", Label.CENTER);
		lblNorth.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
		panelNorth.add(lblNorth);
		add(BorderLayout.NORTH, panelNorth);
		
		// BorderLayout South
		Button btnInsert = new Button("추가");
		Button btnUpdate = new Button("변경");
		Button btnDelete = new Button("삭제");
		Button btnClose = new Button("종료");
		
		panelSouth.add(btnInsert);
		panelSouth.add(btnUpdate);
		panelSouth.add(btnDelete);
		panelSouth.add(btnClose);
		add(BorderLayout.SOUTH, panelSouth);
		
		// BorderLayout Center - panelLeftCenter, ta 붙임
		// panelLeftCenter엔 여러 컴포넌트들과 panelGender 붙임
		Label lblName = new Label("이름");
		TextField tfName = new TextField(15);
		Label lblAge = new Label("나이");
		TextField tfAge = new TextField(15);
		Label lblTel = new Label("전화번호");
		TextField tfTel = new TextField(15);
		Label lblGender = new Label("성별");
		CheckboxGroup cgGender = new CheckboxGroup();
		Checkbox cgMale = new Checkbox("남", true, cgGender);
		Checkbox cgFemale = new Checkbox("여", false, cgGender);
		TextArea ta = new TextArea();
		Panel panelLeftCenter = new Panel();
		Panel panelGender = new Panel();
		
		panelCenter.setLayout(new GridLayout(1, 2));
		panelCenter.add(panelLeftCenter);
		panelCenter.add(ta);
		
		panelLeftCenter.setLayout(new GridLayout(4, 2));
		panelLeftCenter.add(lblName);
		panelLeftCenter.add(tfName);
		panelLeftCenter.add(lblAge);
		panelLeftCenter.add(tfAge);
		panelLeftCenter.add(lblTel);
		panelLeftCenter.add(tfTel);
		panelLeftCenter.add(lblGender);
		panelLeftCenter.add(panelGender);
		
		panelGender.setLayout(new GridLayout(1, 2));
		panelGender.add(cgMale);
		panelGender.add(cgFemale);
		
		add(BorderLayout.CENTER, panelCenter);
		
		// 위치, 사이즈, 가시화, 종료처리
		setBounds(400, 200, 320, 240);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
	}
	
	public static void main(String[] args) {
		new AutoLayout();
	}
}
