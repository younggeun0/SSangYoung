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
		taEx = new TextArea("������ ȭ����");
		taEx.setBounds(30, 80, 150, 100);
		String[] arrColor = { "������","������","�Ķ���","������","�ʷϻ�","��ȫ��" }; 
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
		
		taEx.setForeground(color);
	}
}
