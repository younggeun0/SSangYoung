package date181210;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ManualLayout extends Frame {

	public ManualLayout() {
		super("수동배치");
		Label lblFont = new Label("글꼴");
		Label lblFontStyle = new Label("글꼴스타일");
		Label lblSize = new Label("크기");
		Label lblEx = new Label("보기");

		List listFont = new List();
		listFont.add("Dialog");
		listFont.add("Serif");
		listFont.add("SansSerif");
		listFont.add("MonoSpaced");
		listFont.add("DialogInput");
		List listFontStyle = new List();
		listFontStyle.add("일반");
		listFontStyle.add("굵게");
		listFontStyle.add("기울임꼴");
		listFontStyle.add("굵게기울임꼴");
		List listSize = new List();

		// int -> String, 2~10까지는 2씩 증가
		for (int i = 2; i < 11; i += 2) {
			listSize.add(Integer.toString(i));
		}
		// 그 뒤는 1씩증가~80까지
		for (int i = 11; i < 81; i++) {
			listSize.add(Integer.toString(i));
		}
		
		TextField tfFont = new TextField();
		TextField tfFontStyle = new TextField();
		TextField tfSize = new TextField();
		TextField tfEx = new TextField("AaBbYyZz", 15);
		tfEx.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
		Button btnApply = new Button("확인");
		Button btnCancel = new Button("취소");

		// 수동 배치로 변경
		setLayout(null);
		
		// 배치
		lblFont.setBounds(15, 40, 25, 20);
		add(lblFont);
		tfFont.setBounds(15, 60, 100, 20);
		add(tfFont);
		listFont.setBounds(15,80, 100, 100);
		add(listFont);
		
		lblFontStyle.setBounds(120, 40, 25, 20);
		add(lblFontStyle);
		tfFontStyle.setBounds(120, 60, 100, 20);
		add(tfFontStyle);
		listFontStyle.setBounds(120, 80, 100, 100);
		add(listFontStyle);
		
		lblSize.setBounds(225, 40, 25, 20);
		add(lblSize);
		tfSize.setBounds(225, 60, 100, 20);
		add(tfSize);
		listSize.setBounds(225, 80, 100, 100);
		add(listSize);
		
		lblEx.setBounds(110, 200, 25, 20);
		add(lblEx);
		tfEx.setBounds(110, 220, 125, 30);
		add(tfEx);
		
		btnApply.setBounds(200, 265, 60, 25);
		add(btnApply);
		
		btnCancel.setBounds(265, 265, 60, 25);
		add(btnCancel);
		
		setResizable(false);
		setBounds(400, 200, 340, 300);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		new ManualLayout();
	}
}
