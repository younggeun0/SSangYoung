package date181211;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CFCEventHandler implements ItemListener {

	private CFCDesign design;
	
	public CFCEventHandler(CFCDesign design) {
		this.design = design;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		String flag = design.getCColor().getSelectedItem();
		Color color;
		
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
		
		design.getTaEx().setForeground(color);
	}
}
