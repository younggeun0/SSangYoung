package date190107.hw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SelectTableViewEvt extends WindowAdapter implements ActionListener {

	private SelectTableView stv;
	
	
	public SelectTableViewEvt(SelectTableView stv) {
		this.stv = stv;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 선택했을 때 이벤트 처리
	}

	@Override
	public void windowClosing(WindowEvent e) {
		stv.dispose();
	}
}
