package date181213;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
// 1. Dialog ���
public class DialogIsA extends Dialog implements ActionListener {
	
	private Button btn;
	
	// ���� ���̾�α��� �θ� �� ��ü�� has-a ���� 
	public DialogIsA(UseDialogIsA uda) { 
		super(uda, "���̾�α�", true);

		btn = new Button("�ݱ�");
		// ������Ʈ ����
		Label lbl = new Label("������ ������Դϴ�.");
		
		add(BorderLayout.CENTER, lbl);
		add(BorderLayout.SOUTH, btn);
		
		btn.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		// ���̾�α� ��ġ�� �θ������� ���ʿ��� ����
		System.out.println("�θ��� x :"+uda.getX()+", �θ��� y :"+uda.getY());
		setBounds(uda.getX()+80, uda.getY()+80, 300, 300);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
}
