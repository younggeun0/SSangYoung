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
		super(jm, "�޸��� ����", true);
		
		TextArea taInfo = new TextArea("�޸��� ����\n" + 
				"�� �޸����� Java�� ����������� ������ �ڵ� ���� �� ������ �� �ֽ��ϴ�.\n" + 
				"��, �� �ڵ带 ����Ͽ� �������� ������ �ҽ������� ��Ģ���� �Ѵ�. (GNU)\n" + 
				" \n" + 
				"�ۼ��� : ������\n" + 
				"version : 1.0");
		taInfo.setEditable(false);
		Button btnConfirm = new Button("Ȯ��");
		
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
