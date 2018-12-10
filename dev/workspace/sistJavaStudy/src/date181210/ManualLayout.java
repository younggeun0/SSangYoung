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
		super("������ġ");
		Label lblFont = new Label("�۲�");
		Label lblFontStyle = new Label("�۲ý�Ÿ��");
		Label lblSize = new Label("ũ��");
		Label lblEx = new Label("����");

		List listFont = new List();
		listFont.add("Dialog");
		listFont.add("Serif");
		listFont.add("SansSerif");
		listFont.add("MonoSpaced");
		listFont.add("DialogInput");
		List listFontStyle = new List();
		listFontStyle.add("�Ϲ�");
		listFontStyle.add("����");
		listFontStyle.add("����Ӳ�");
		listFontStyle.add("���Ա���Ӳ�");
		List listSize = new List();

		// int -> String, 2~10������ 2�� ����
		for (int i = 2; i < 11; i += 2) {
			listSize.add(Integer.toString(i));
		}
		// �� �ڴ� 1������~80����
		for (int i = 11; i < 81; i++) {
			listSize.add(Integer.toString(i));
		}
		
		TextField tfFont = new TextField();
		TextField tfFontStyle = new TextField();
		TextField tfSize = new TextField();
		TextField tfEx = new TextField("AaBbYyZz", 15);
		tfEx.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
		Button btnApply = new Button("Ȯ��");
		Button btnCancel = new Button("���");

		// ���� ��ġ�� ����
		setLayout(null);
		
		// ��ġ
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
