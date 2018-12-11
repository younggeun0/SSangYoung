package date181211;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * OOOAdapter class가 사용되어야 하는 이유
 * @author owner
 */
@SuppressWarnings("serial")
public class UseWindowAdapter extends Frame {

	public UseWindowAdapter() {
		super("윈도우 이벤트 연습");
		
		setBounds(100, 100, 400, 400);
		setVisible(true);
	
		UseWindowAdapter.WindowImpl wi = this.new WindowImpl();
		addWindowListener(wi);
	}
	
	public static void main(String[] args) {
		new UseWindowAdapter();
	}

	// WindowAdapter class를 상속받으면 필요한 method만 Override하면 된다.
	public class WindowImpl extends WindowAdapter {
		
		@Override
		public void windowClosing(WindowEvent e) {
			dispose();
		}
	}
}
