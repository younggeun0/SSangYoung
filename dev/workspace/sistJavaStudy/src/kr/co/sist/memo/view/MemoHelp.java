package kr.co.sist.memo.view;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.TextArea;

import kr.co.sist.memo.event.MemoHelpEvt;

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
		
		MemoHelpEvt mhe = new MemoHelpEvt(this);
		btnConfirm.addActionListener(mhe);
		addWindowListener(mhe);
		
		setVisible(true);
	}
}
