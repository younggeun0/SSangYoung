package kr.co.sist.multichat.client.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

import kr.co.sist.multichat.client.view.ClientChatView;
import kr.co.sist.multichat.client.view.ClientSelectTeamView;

public class ClientSelectTeamEvt implements ActionListener {
	private String selectTeam;
	private ClientSelectTeamView cstv;

	public ClientSelectTeamEvt(ClientSelectTeamView cstv) {
		this.cstv = cstv;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		int port = 0;
		if (cstv.getJrTeam1().isSelected()) {
			port = 7001;
		} else if (cstv.getJrTeam2().isSelected()) {
			port = 7002;
		} else if (cstv.getJrTeam3().isSelected()) {
			port = 7003;
		} else if (cstv.getJrTeam4().isSelected()) {
			port = 7004;
		}
		
		new ClientChatView(port);
		cstv.dispose();
	}
}