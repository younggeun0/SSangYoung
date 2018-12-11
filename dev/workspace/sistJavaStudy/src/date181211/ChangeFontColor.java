package date181211;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChangeFontColor extends Frame implements ItemListener{

	private TextArea taEx;
	private Choice cColor;
	
	public ChangeFontColor() {
		Label lbl = new Label("Label");
		lbl.setBounds(30, 50, 40, 20);
		taEx = new TextArea("오늘은 화요일");
		taEx.setBounds(30, 80, 150, 100);
		String[] arrColor = { "색선택","검은색","파란색","빨간색","초록색","심홍색" }; 
		cColor = new Choice();
		for (int i=0; i<arrColor.length; i++) {
			cColor.add(arrColor[i]);
		}
		cColor.setBounds(200, 80, 80, 20);
		
		setLayout(null);
		
		cColor.addItemListener(this);

		add(lbl);
		add(taEx);
		add(cColor);
		
		setBounds(400, 300, 300, 300);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		
		new ChangeFontColor();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		String flag = cColor.getSelectedItem();
		Color color = null;
		
		switch (flag) {
		case "파란색":
			color = Color.BLUE;
			break;
		case "빨간색":
			color = Color.RED;
			break;
		case "초록색":
			color = Color.GREEN;
			break;
		case "심홍색":
			color = Color.MAGENTA;
			break;
		default:
			color = Color.BLACK;
			break;
		}
		
		taEx.setForeground(color);
	}
}
