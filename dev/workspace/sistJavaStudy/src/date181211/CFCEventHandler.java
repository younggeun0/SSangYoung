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
		case "�Ķ���":
			color = Color.BLUE;
			break;
		case "������":
			color = Color.RED;
			break;
		case "�ʷϻ�":
			color = Color.GREEN;
			break;
		case "��ȫ��":
			color = Color.MAGENTA;
			break;
		default:
			color = Color.BLACK;
			break;
		}
		
		design.getTaEx().setForeground(color);
	}
}
