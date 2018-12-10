package date181210;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Menu : MenuBar, Menu, MenuItem���� ����
 * @author owner
 */
// Window Component ���
public class UseMenuBar extends Frame {

	public UseMenuBar() {

		super("�޴��� ���");
		
		// 1. MenuBar ����
		MenuBar mb = new MenuBar();
		
		// 2. Menu ����
		Menu m1 = new Menu("1��");
		Menu m2 = new Menu("2��");
		Menu m3 = new Menu("3��");
		Menu m3_1 = new Menu("3�� group1");
		Menu m4 = new Menu("4��");
		
		// 3. MenuItem ����
		MenuItem mi1_1 = new MenuItem("������");
		MenuItem mi1_2 = new MenuItem("�̺���");
		MenuItem mi1_3 = new MenuItem("������");

		MenuItem mi2_1 = new MenuItem("�ڿ���");
		MenuItem mi2_2 = new MenuItem("������");
		
		MenuItem mi3_1 = new MenuItem("������");
		MenuItem mi3_2 = new MenuItem("������");
		MenuItem mi3_3 = new MenuItem("������");
		MenuItem mi3_4 = new MenuItem("������");
		MenuItem mi3_5 = new MenuItem("������");
		
		MenuItem mi4_1 = new MenuItem("������");
		MenuItem mi4_2 = new MenuItem("�����");
		MenuItem mi4_3 = new MenuItem("������");
		MenuItem mi4_4 = new MenuItem("������");
		MenuItem mi4_5 = new MenuItem("������");
		
		// MenuItem�� Menu�� ��ġ
		m1.add(mi1_1); m1.add(mi1_2); m1.addSeparator(); m1.add(mi1_3);
		m2.add(mi2_1); m2.add(mi2_2);
		
		// m3_1�� ���� �޴� ��ġ
		m3_1.add(mi3_2);
		m3_1.add(mi3_3);
		m3_1.add(mi3_4);
		m3_1.add(mi3_5);
		
		// �޴�(m3)�� �޴�(m3_1)�� ������ ���� �޴��� ������ �� �ִ�.
		m3.add(mi3_1); m3.add(m3_1);
		m4.add(mi4_1); m4.add(mi4_2); m4.add(mi4_3); m4.addSeparator();
		m4.add(mi4_4); m4.add(mi4_5);
		
		// Menu�� MenuBar�� ��ġ
		mb.add(m1); mb.add(m2); mb.add(m3); mb.add(m4);
		
		// MenuBar�� Frame�� ��ġ
		setMenuBar(mb);
		
		setBounds(200, 100, 800, 600);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		new UseMenuBar();
	}
}
