package kr.co.sist.memo.view;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.memo.event.MemoFormatEvt;

public class MemoFormat extends Dialog {

	private JavaMemo jm;
	private Button btnApply, btnCancel;
	private List listFont, listStyle, listSize;
	private Label lblPreview;
	private TextField tfFont, tfStyle, tfSize;

	public MemoFormat(JavaMemo jm) {
		super(jm, "�۲�", true);

		this.jm = jm;

		// �θ�â JavaMemo T.A�� �۲� ������ �����ͼ� T.F�� �����Ѵ�.
		Font fontTa = jm.getTaNote().getFont();

		Label lblFont = new Label("�۲�");
		Label lblFontStyle = new Label("�۲ý�Ÿ��");
		Label lblSize = new Label("ũ��");
		Label lblEx = new Label("����");
		lblPreview = new Label("AaBbYyZz");
		// TextArea�� ��Ʈ�� Preview �󺧷� ����
		lblPreview.setFont(fontTa);
		
		listFont = new List();
		listFont.add("Dialog");
		listFont.add("Serif");
		listFont.add("SansSerif");
		listFont.add("MonoSpaced");
		listFont.add("DialogInput");
		listStyle = new List();

		String[] arrStyle = { "�Ϲ�", "����", "����Ӳ�", "���� ����Ӳ�" };
		for (String style : arrStyle) {
			listStyle.add(style);
		}
		listSize = new List();
		for (int i = 2; i < 11; i += 2) {
			listSize.add(Integer.toString(i));
		}
		for (int i = 11; i < 81; i++) {
			listSize.add(Integer.toString(i));
		}

		tfFont = new TextField(fontTa.getFamily());
		tfStyle = new TextField(arrStyle[fontTa.getStyle()]);
		tfSize = new TextField(Integer.toString(fontTa.getSize()));

		btnApply = new Button("Ȯ��");
		btnCancel = new Button("���");

		// ���� ��ġ�� ����
		setLayout(null);

		// ��ġ
		lblFont.setBounds(15, 40, 25, 20);
		add(lblFont);
		tfFont.setBounds(15, 60, 100, 20);
		add(tfFont);
		listFont.setBounds(15, 80, 100, 100);
		add(listFont);

		lblFontStyle.setBounds(120, 40, 25, 20);
		add(lblFontStyle);
		tfStyle.setBounds(120, 60, 100, 20);
		add(tfStyle);
		listStyle.setBounds(120, 80, 100, 100);
		add(listStyle);

		lblSize.setBounds(225, 40, 25, 20);
		add(lblSize);
		tfSize.setBounds(225, 60, 100, 20);
		add(tfSize);
		listSize.setBounds(225, 80, 100, 100);
		add(listSize);

		lblEx.setBounds(110, 200, 25, 20);
		add(lblEx);
		lblPreview.setBounds(110, 220, 125, 30);
		add(lblPreview);

		btnApply.setBounds(200, 265, 60, 25);
		add(btnApply);
		btnCancel.setBounds(265, 265, 60, 25);
		add(btnCancel);

		// �̺�Ʈ ���
		MemoFormatEvt mfe = new MemoFormatEvt(this);
		btnApply.addActionListener(mfe);
		btnCancel.addActionListener(mfe);
		listFont.addItemListener(mfe);
		listStyle.addItemListener(mfe);
		listSize.addItemListener(mfe);
		addWindowListener(mfe);

		setBounds(jm.getX() + 150, jm.getY() + 80, 340, 300);
		setResizable(false);
		setVisible(true);
	}

	public JavaMemo getJm() {
		return jm;
	}

	public Button getBtnApply() {
		return btnApply;
	}

	public Button getBtnCancel() {
		return btnCancel;
	}

	public List getListFont() {
		return listFont;
	}

	public List getListStyle() {
		return listStyle;
	}

	public List getListSize() {
		return listSize;
	}

	public Label getLblPreview() {
		return lblPreview;
	}

	public TextField getTfFont() {
		return tfFont;
	}

	public TextField getTfStyle() {
		return tfStyle;
	}

	public TextField getTfSize() {
		return tfSize;
	}

}
