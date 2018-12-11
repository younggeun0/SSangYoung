package date181211;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * OOOAdapter class�� ���Ǿ�� �ϴ� ����
 * @author owner
 */
@SuppressWarnings("serial")
public class UseWindowAdapter extends Frame {

	public UseWindowAdapter() {
		super("������ �̺�Ʈ ����");
		
		setBounds(100, 100, 400, 400);
		setVisible(true);
	
		UseWindowAdapter.WindowImpl wi = this.new WindowImpl();
		addWindowListener(wi);
	}
	
	public static void main(String[] args) {
		new UseWindowAdapter();
	}

	// WindowAdapter class�� ��ӹ����� �ʿ��� method�� Override�ϸ� �ȴ�.
	public class WindowImpl extends WindowAdapter {
		
		@Override
		public void windowClosing(WindowEvent e) {
			dispose();
		}
	}
}
