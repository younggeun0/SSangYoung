package date181208;

import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HelloAWT extends Frame {

	public HelloAWT() {

		super("AWT ����");
		
		Label lblTitle = new Label("���� ����Ʈ ���ڼ���", Label.CENTER);
		TextArea ta = new TextArea("���ü���\n���α��� �ڶ�");
		
		add("North", lblTitle);
		add("Center", ta);
		
		setSize(400, 270);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		new HelloAWT();
	}
}
