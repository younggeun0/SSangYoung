package kr.co.sist.chat.server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import kr.co.sist.chat.server.view.MultiChatServerView;

public class MultiChatServerEvt extends WindowAdapter implements Runnable, ActionListener {

	private MultiChatServerView mcsv;
	
	public MultiChatServerEvt(MultiChatServerView mcsv) {
		this.mcsv = mcsv;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mcsv.getBtnOpenServer()) {
			
		}
		if (e.getSource() == mcsv.getBtnCloseServer()) {
			
		}
	}

	@Override
	public void run() {
		
	}
}
