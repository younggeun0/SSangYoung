package kr.co.sist.chat.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.chat.client.view.MultiChatClientView;

public class MultiChatClientEvt extends WindowAdapter implements ActionListener, Runnable {

	private MultiChatClientView mccv;
	
	public MultiChatClientEvt(MultiChatClientView mccv) {
		this.mccv = mccv;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		mccv.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mccv.getJbtConnect()) {
			
		}
		if (e.getSource() == mccv.getJbtCapture()) {
			
		}
		if (e.getSource() == mccv.getJbtClose()) {
			mccv.dispose();
		}
	}
	
	@Override
	public void run() {
		
	}
}
