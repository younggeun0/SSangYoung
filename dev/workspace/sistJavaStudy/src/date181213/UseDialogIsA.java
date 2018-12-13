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
 * Frame 클래스에서 is-a로 생성된 Dialog클래스 사용
 * 
 * @author owner
 */
public class UseDialogIsA extends Frame implements ActionListener {

	private Button btn1;
	private Dialog d;

	public UseDialogIsA() {
		super("다이얼로그 사용");

		btn1 = new Button("다이얼로그 사용");
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
		createDialog();
	}

	public void createDialog() {
		new DialogIsA(this);
	}

	public static void main(String[] args) {
		new UseDialogIsA();
	}
}
