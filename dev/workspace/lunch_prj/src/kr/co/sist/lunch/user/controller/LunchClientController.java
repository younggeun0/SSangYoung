package kr.co.sist.lunch.user.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.lunch.user.view.LunchClientView;

public class LunchClientController extends WindowAdapter implements ActionListener{

	private LunchClientView lcv;
	
	public LunchClientController(LunchClientView lcv) {
		this.lcv = lcv;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		lcv.dispose();
	}
}
