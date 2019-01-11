package date190111;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class SimpleMsgButtonsEvt extends WindowAdapter implements ActionListener {

	private SimpleMsgButtonsView smbv;
	private String[] msg;
	
	public SimpleMsgButtonsEvt(SimpleMsgButtonsView smbv) {
		this.smbv = smbv;
		msg = new String[] {
				"서울은 춥다.", "각자 해보세요.", "담배피러 가자",
				"집에 가고 싶다.", "재찬이가 좋아요", "조퇴하고 싶다",
				"형 제가 캐리할게요", "수영하고 싶다", "점심 먹으러 가자",
				"주말에 공부해라"
		};
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<smbv.getJbtName().length; i++) {
			if (e.getSource() == smbv.getJbtName()[i]) {
				JOptionPane.showMessageDialog(smbv, msg[i]);
				break;
			}
		}
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		smbv.dispose();
	}
}
