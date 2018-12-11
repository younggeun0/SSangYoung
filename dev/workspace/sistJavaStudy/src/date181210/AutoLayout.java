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
		super("�ڵ���ġ");
		// BorderLayout North, Center, South�� �� Panel��
		Panel panelNorth = new Panel();
		Panel panelCenter = new Panel();
		Panel panelSouth = new Panel();
		
		// BorderLayout North
		Label lblNorth = new Label("�л�����", Label.CENTER);
		lblNorth.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
		panelNorth.add(lblNorth);
		add(BorderLayout.NORTH, panelNorth);
		
		// BorderLayout South
		Button btnInsert = new Button("�߰�");
		Button btnUpdate = new Button("����");
		Button btnDelete = new Button("����");
		Button btnClose = new Button("����");
		
		panelSouth.add(btnInsert);
		panelSouth.add(btnUpdate);
		panelSouth.add(btnDelete);
		panelSouth.add(btnClose);
		add(BorderLayout.SOUTH, panelSouth);
		
		// BorderLayout Center - panelLeftCenter, ta ����
		// panelLeftCenter�� ���� ������Ʈ��� panelGender ����
		Label lblName = new Label("�̸�");
		TextField tfName = new TextField(15);
		Label lblAge = new Label("����");
		TextField tfAge = new TextField(15);
		Label lblTel = new Label("��ȭ��ȣ");
		TextField tfTel = new TextField(15);
		Label lblGender = new Label("����");
		CheckboxGroup cgGender = new CheckboxGroup();
		Checkbox cgMale = new Checkbox("��", true, cgGender);
		Checkbox cgFemale = new Checkbox("��", false, cgGender);
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
		
		// ��ġ, ������, ����ȭ, ����ó��
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
