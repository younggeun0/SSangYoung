package date181210;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * FlowLayout�� Component�� ���
 * @author owner
 */
// 1. Window Component ���
@SuppressWarnings("serial")
public class UseFlowLayout extends Frame {

	public UseFlowLayout() {
		super("FlowLayout ����");
		
		// 2. �Ϲ� ������Ʈ ����
		Label lblName = new Label("�̸�");
		TextField tfName = new TextField(10);
		Button btn = new Button("�Է�");
		List list = new List();
		
		list.add("���ü�");
		list.add("������");
		list.add("������");
		list.add("������");
		list.add("������");
		
		Checkbox cb1 = new Checkbox("���", false);
		Checkbox cb2 = new Checkbox("��", false);
		Checkbox cb3 = new Checkbox("����", false);
		
		// CheckboxGroup�� �����ϸ� Radiobutton�� �����ȴ�.
		CheckboxGroup cg = new CheckboxGroup();
		Checkbox rb1 = new Checkbox("����", true, cg);
		Checkbox rb2 = new Checkbox("����", false, cg);
		
		// 3. Layout ���� : BorderLayout���� 
		setLayout(new FlowLayout());
		
		// 4. �Ϲ� ������Ʈ ��ġ
		add(lblName); add(tfName); add(btn); add(list);
		add(cb1); add(cb2);	add(cb3); add(rb1);	add(rb2);
		
		// 5. ������ ũ�� ����
		setSize(400, 300);
		
		// 6. ����ڿ��� �����ֱ�
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
	}
	
	public static void main(String[] args) {
		new UseFlowLayout();
	}
}
