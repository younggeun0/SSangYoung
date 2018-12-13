package date181213;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Frame Ŭ�������� Dialog Ŭ������ has-a ��� 
 * @author owner
 */
public class UseDialogHasA extends Frame implements ActionListener {
	
	private Button btn1/* Frame�� ��ġ */, btn2/* Dialog */;
	private Dialog d;
	
	public UseDialogHasA() {
		super("���̾�α� ���");
		
		btn1 = new Button("���̾�α� ���");
		Panel panel = new Panel();
		panel.add(btn1);
		
		add(BorderLayout.CENTER, panel);
		
		btn1.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setBounds(100, 100, 300, 400);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btn1) {
			createDialog();
		}
		if (ae.getSource() == btn2) {
			d.dispose();
		}
	}
	
	public void createDialog() {
		// 1. ����
		d = new Dialog(this, "���̾�α�", false); 
		// true - ���
		// false - ����
		
		// 2. Dialog�� ��ġ�� ������Ʈ ����
		Label lbl = new Label("������ ������ ������Դϴ�. (^.~)");
		btn2 = new Button("�ݱ�");
		
		d.add(BorderLayout.CENTER, lbl);
		d.add(BorderLayout.SOUTH, btn2);
		
		btn2.addActionListener(this);
		
		// ũ�� ����
		d.setBounds(200, 200, 300, 300);
		
		// dialog�� �����̺�Ʈ�� setVisible ���� ���ƾ� �ȴ�!
		d.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				d.dispose();
			}
		});
		
		// ����ȭ
		d.setVisible(true);
	}
	
	public static void main(String[] args) {
		new UseDialogHasA();
	}
}
