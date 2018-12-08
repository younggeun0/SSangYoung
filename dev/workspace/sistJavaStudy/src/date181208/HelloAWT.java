package date181208;

import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HelloAWT extends Frame {

	public HelloAWT() {

		super("AWT 연습");
		
		Label lblTitle = new Label("오늘 베스트 사자성어", Label.CENTER);
		TextArea ta = new TextArea("정택성씨\n구로구의 자랑");
		
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
