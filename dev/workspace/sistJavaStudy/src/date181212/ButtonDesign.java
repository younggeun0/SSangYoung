package date181212;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class ButtonDesign extends Frame {

	private Button btnA;
	private Button btnB;
	
	public ButtonDesign() {
		
		btnA = new Button("A");
		btnB = new Button("B");
		
		setLayout(new GridLayout(1, 2));
		add(btnA);
		add(btnB);
		
		ButtonEventHandler beh = new ButtonEventHandler( this );
		btnA.addActionListener(beh);
		btnB.addActionListener(beh);

		setBounds(300,200,300,150);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	public Button getBtnA() {
		return btnA;
	}
	public Button getBtnB() {
		return btnB;
	}
	public static void main(String[] args) {
		new ButtonDesign();
	}
}
