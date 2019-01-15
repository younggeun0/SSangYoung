package kr.co.sist.lunch.admin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.lunch.admin.view.LunchMainView;

public class LunchMainController extends WindowAdapter implements ActionListener {

	private LunchMainView lmv;
	
	public LunchMainController(LunchMainView lmv) {
		this.lmv =lmv;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		lmv.dispose();
	}
}
