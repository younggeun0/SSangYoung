package date181210;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * GridLayout<br/>
 * ��� ���� �����Ǹ� ��� ������Ʈ�� ũ�Ⱑ �����ؾ��� ��.
 * @author owner
 */
// 1. ������ ������Ʈ ���
@SuppressWarnings("serial")
public class UseGridLayout extends Frame {

	public UseGridLayout() {
		super("GridLayout ����");
		
		// 2. ������Ʈ ����
		Button btn1 = new Button("btn1");
		Button btn2 = new Button("btn2");
		Button btn3 = new Button("btn3");
		Button btn4 = new Button("btn4");
		Button btn5 = new Button("btn5");
		Button btn6 = new Button("btn6");
		Button btn7 = new Button("btn7");
		Button btn8 = new Button("btn8");
		Button btn9 = new Button("btn9");
		
		// 3. ��ġ������ ���� : BorderLayout -> GridLayout
		setLayout(new GridLayout(4, 2));

		// 4. ��ġ
		add(btn1); add(btn2); add(btn3); add(btn4);
		add(btn5); add(btn6); add(btn7); add(btn8); add(btn9);
		
		// 5. ������ ũ�� ����
		setSize(300, 400);
		
		// 6. ����ڿ��� �����ֱ�
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		new UseGridLayout();
	}
}
