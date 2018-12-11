package date181211;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * OOOAdapter class가 사용되어야 하는 이유
 * @author owner
 */
@SuppressWarnings("serial")
public class UseWindowEvent extends Frame {

	public UseWindowEvent() {
		super("윈도우 이벤트 연습");
		
		setBounds(100, 100, 400, 400);
		setVisible(true);
	
		UseWindowEvent.WindowImpl wi = this.new WindowImpl();
		addWindowListener(wi);
	}
	
	public static void main(String[] args) {
		new UseWindowEvent();
	}

	public class WindowImpl implements WindowListener {
		
		@Override
		public void windowOpened(WindowEvent e) {
			System.out.println("windowOpened");
		}
		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("windowClosing");
			dispose();
		}
		@Override
		public void windowClosed(WindowEvent e) {
			// windowClosing에서 dispose()가 호출되면 그때 windowClosed가 호출
			System.out.println("windowClosed");
		}
		@Override
		public void windowIconified(WindowEvent e) {
			System.out.println("windowIconified");
		}
		@Override
		public void windowDeiconified(WindowEvent e) {
			System.out.println("windowDeiconified");
		}
		@Override
		public void windowActivated(WindowEvent e) {
			System.out.println("windowActivated");
		}
		@Override
		public void windowDeactivated(WindowEvent e) {
			System.out.println("windowDeactivated");
		}
	}
}
