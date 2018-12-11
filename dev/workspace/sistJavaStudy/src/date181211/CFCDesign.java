package date181211;

import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class CFCDesign extends Frame {

	private TextArea taEx;
	private Choice cColor;
	
	public CFCDesign() {
		
		Label lbl = new Label("Label");
		lbl.setBounds(30, 50, 40, 20);
		taEx = new TextArea("오늘은 화요일");
		taEx.setBounds(30, 80, 150, 100);
		cColor = new Choice();
		String[] arrColor = { "색선택","검은색","파란색","빨간색","초록색","심홍색" }; 
		cColor = new Choice();
		for (int i=0; i<arrColor.length; i++) {
			cColor.add(arrColor[i]);
		}
		cColor.setBounds(200, 80, 80, 20);

		setLayout(null);

		CFCEventHandler eh = new CFCEventHandler(this);
		cColor.addItemListener(eh);

		add(lbl);
		add(taEx);
		add(cColor);

		setBounds(300, 200, 300, 300);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	public TextArea getTaEx() {
		return taEx;
	}
	public Choice getCColor() {
		return cColor;
	}
	public static void main(String[] args) {
		new CFCDesign();
	}
}
