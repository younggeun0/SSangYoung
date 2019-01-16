package kr.co.sist.lunch.admin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchAddView;
import kr.co.sist.lunch.admin.view.LunchDetailView;
import kr.co.sist.lunch.admin.view.LunchMainView;
import kr.co.sist.lunch.admin.vo.LunchDetailVO;
import kr.co.sist.lunch.admin.vo.LunchVO;

public class LunchMainController extends WindowAdapter implements ActionListener,MouseListener {

	private LunchMainView lmv;
	private LunchAdminDAO la_dao;
	
	private static final int DOUBLE_CLICK = 2;
	
	public LunchMainController(LunchMainView lmv) {
		this.lmv =lmv;
		la_dao = LunchAdminDAO.getInstance();
		// ���ö� ����� �ʱ�ȭ
		setLunch();
	}
	
	/**
	 * JTable�� DB���� ��ȸ�� ���ö� ������ �����ش�.
	 */
	public void setLunch() {
		DefaultTableModel dtmLunch = lmv.getDtmLunch();
		
		dtmLunch.setRowCount(0);
		
		try {
			// DB���� ���ö� ������ ��ȸ
			List<LunchVO> listLunch = la_dao.selectLunch();
			
			LunchVO lv = null;
			String imgPath = "C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/s_";
			Object[] rowData = null;
			// JTable�� ��ȸ�� ������ ���
			for(int i=0; i<listLunch.size(); i++) {
				lv = listLunch.get(i);
				
				// dtmLunch�� �����͸� �߰��ϱ����� �������迭(Vector)�� ����
				rowData = new Object[5];
				rowData[0] = new Integer(i+1);
				rowData[1] = lv.getLunchCode();
				rowData[2] = new ImageIcon(imgPath+lv.getImg());
				rowData[3] = lv.getLunchName();
			    rowData[4] = lv.getPrice();
				dtmLunch.addRow(rowData);		
			}
			
			if (listLunch.isEmpty()) { // �Էµ� ���ö��� ���� �� 
				JOptionPane.showMessageDialog(lmv, "�Էµ� ��ǰ�� �����ϴ�.");
			}
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(lmv, "DB���� �����͸� �޾ƿ��� �� �����߻�...");
			se.printStackTrace();
		}
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
			new LunchAddView(lmv, this);
		}
		
		if (ae.getSource() == lmv.getJbtCalcOrder()) {
			
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent me) {
		
		// ���� �ð��ȿ� �ι� Ŭ���ϸ� ����Ŭ��
		switch (me.getClickCount()) {
		case DOUBLE_CLICK : 
			if (me.getSource() == lmv.getJtb()) { 
				
			}
			
			if (me.getSource() == lmv.getJtLunch()) { 
				// ���ö� ���̺��� ����Ŭ���� �Ǹ�
				// ���ö� �ڵ�� �˻����Ͽ� �������� �����Ѵ�.
				JTable jt = lmv.getJtLunch();
				String lunchCode = (String)jt.getValueAt(jt.getSelectedRow(), 1);
				try {
					LunchDetailVO ldvo = la_dao.selectDetailLunch(lunchCode);
					new LunchDetailView(lmv, ldvo, this);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(lmv, "DB���� ������ �߻��߽��ϴ�.");
					e.printStackTrace();
				}
				
			}
			
			if (me.getSource() == lmv.getJtOrder()) {
				
			}
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
