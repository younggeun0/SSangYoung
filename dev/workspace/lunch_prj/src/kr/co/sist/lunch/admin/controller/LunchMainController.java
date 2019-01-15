package kr.co.sist.lunch.admin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import javax.swing.JComboBox;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchMainView;

public class LunchMainController extends WindowAdapter implements ActionListener,MouseListener {

	private LunchMainView lmv;
	private LunchAdminDAO la_dao;
	
	public LunchMainController(LunchMainView lmv) {
		this.lmv =lmv;
		la_dao = LunchAdminDAO.getInstance();
	}
	
	private void setLunch() {

	}
	
	private void searchOrder() {

	}
	
	private void searchCalc() {

	}
	
	/**
	 * ���� ���õǸ� �ش���� �ش���� ������ ���� ����
	 */
	private void setDay() {
		int selectedYear = ((Integer)lmv.getJcbYear().getSelectedItem()).intValue();
		int selectedMonth = ((Integer)lmv.getJcbMonth().getSelectedItem()).intValue();
		
		// ������ �� ���
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, selectedYear);
		cal.set(Calendar.MONTH, selectedMonth-1); // �ڹ��� ���� ����� �����ϴ� �޺��� �ϳ� ����

		int lastDay = cal.getActualMaximum(Calendar.DATE);
		int currDay = cal.get(Calendar.DAY_OF_MONTH);
		
		lmv.getCbmDay().removeAllElements(); // ���� �ʱ�ȭ�ϰ� ���õ� ���� ����
		for(int day = 1; day<lastDay+1; day++) {
			lmv.getCbmDay().addElement(day);
		}
		lmv.getJcbDay().setSelectedItem(new Integer(currDay));
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == lmv.getJcbMonth()) {
			setDay();
		}
		
		if (ae.getSource() == lmv.getJbtAddLunch()) {
			
		}
		
		if (ae.getSource() == lmv.getJbtCalcOrder()) {
			
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent me) {
		if (me.getSource() == lmv.getJtb()) {
			
		}
		
		if (me.getSource() == lmv.getJtLunch()) {
			
		}
		
		if (me.getSource() == lmv.getJtOrder()) {
			
		}
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		lmv.dispose();
	}
	// �Ⱦ��� MouseListener methode��
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
