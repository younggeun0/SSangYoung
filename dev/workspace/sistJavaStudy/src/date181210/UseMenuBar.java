package date181210;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Menu : MenuBar, Menu, MenuItem으로 구성
 * @author owner
 */
// Window Component 상속
public class UseMenuBar extends Frame {

	public UseMenuBar() {

		super("메뉴바 사용");
		
		// 1. MenuBar 생성
		MenuBar mb = new MenuBar();
		
		// 2. Menu 생성
		Menu m1 = new Menu("1조");
		Menu m2 = new Menu("2조");
		Menu m3 = new Menu("3조");
		Menu m3_1 = new Menu("3조 group1");
		Menu m4 = new Menu("4조");
		
		// 3. MenuItem 생성
		MenuItem mi1_1 = new MenuItem("이재찬");
		MenuItem mi1_2 = new MenuItem("이봉현");
		MenuItem mi1_3 = new MenuItem("박은영");

		MenuItem mi2_1 = new MenuItem("박영민");
		MenuItem mi2_2 = new MenuItem("김정윤");
		
		MenuItem mi3_1 = new MenuItem("김정운");
		MenuItem mi3_2 = new MenuItem("이재현");
		MenuItem mi3_3 = new MenuItem("노진경");
		MenuItem mi3_4 = new MenuItem("최지우");
		MenuItem mi3_5 = new MenuItem("노진경");
		
		MenuItem mi4_1 = new MenuItem("오영근");
		MenuItem mi4_2 = new MenuItem("김건하");
		MenuItem mi4_3 = new MenuItem("공선의");
		MenuItem mi4_4 = new MenuItem("박정미");
		MenuItem mi4_5 = new MenuItem("최혜원");
		
		// MenuItem을 Menu에 배치
		m1.add(mi1_1); m1.add(mi1_2); m1.addSeparator(); m1.add(mi1_3);
		m2.add(mi2_1); m2.add(mi2_2);
		
		// m3_1에 하위 메뉴 배치
		m3_1.add(mi3_2);
		m3_1.add(mi3_3);
		m3_1.add(mi3_4);
		m3_1.add(mi3_5);
		
		// 메뉴(m3)가 메뉴(m3_1)을 가지면 하위 메뉴를 설정할 수 있다.
		m3.add(mi3_1); m3.add(m3_1);
		m4.add(mi4_1); m4.add(mi4_2); m4.add(mi4_3); m4.addSeparator();
		m4.add(mi4_4); m4.add(mi4_5);
		
		// Menu를 MenuBar에 배치
		mb.add(m1); mb.add(m2); mb.add(m3); mb.add(m4);
		
		// MenuBar를 Frame에 배치
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
