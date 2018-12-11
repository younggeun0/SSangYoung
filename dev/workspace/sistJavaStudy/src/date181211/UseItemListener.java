package date181211;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ItemEvent�� ó���ϴ� ItemListener�� ���
 * @author owner
 */
@SuppressWarnings("serial")
// 1. Frame ���, �̺�Ʈ�� ó���� �� �ִ� itemListener�� ����
public class UseItemListener extends Frame implements ItemListener {

	private List list;
	private Label lbl;

	public UseItemListener() {
		
		list = new List();
		list.add("������/27");
		list.add("���ü�/26");
		list.add("������/27");
		lbl = new Label("�̸� :                           ���� : ");
		
		add(BorderLayout.CENTER, list);
		add(BorderLayout.SOUTH, lbl);
		
		list.addItemListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setBounds(300, 200, 300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new UseItemListener();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// ����Ʈ�� �������� ���õǸ� ������ �������� �����ͼ�
		// ���� �� ����
		String[] nameAndAge = list.getSelectedItem().split("/");
		String name = nameAndAge[0];
		String age = nameAndAge[1];
		// �� ���ڿ��̱� ������ StringBuilder�� ó��
		StringBuilder viewData = new StringBuilder();
		viewData.append("�̸� : ").append(name).append("              ���� : ").append(age);
		lbl.setText(viewData.toString());
	}
}
