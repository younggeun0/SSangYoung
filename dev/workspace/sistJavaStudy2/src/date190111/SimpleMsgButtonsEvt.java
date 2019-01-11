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
				"������ ���.", "���� �غ�����.", "����Ƿ� ����",
				"���� ���� �ʹ�.", "�����̰� ���ƿ�", "�����ϰ� �ʹ�",
				"�� ���� ĳ���ҰԿ�", "�����ϰ� �ʹ�", "���� ������ ����",
				"�ָ��� �����ض�"
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
