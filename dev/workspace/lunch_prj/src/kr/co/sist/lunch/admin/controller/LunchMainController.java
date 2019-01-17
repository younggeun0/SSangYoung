package kr.co.sist.lunch.admin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchAddView;
import kr.co.sist.lunch.admin.view.LunchDetailView;
import kr.co.sist.lunch.admin.view.LunchMainView;
import kr.co.sist.lunch.admin.vo.CalcVO;
import kr.co.sist.lunch.admin.vo.LunchDetailVO;
import kr.co.sist.lunch.admin.vo.LunchVO;
import kr.co.sist.lunch.admin.vo.OrderVO;

public class LunchMainController extends WindowAdapter implements ActionListener,MouseListener {

	private LunchMainView lmv;
	private LunchAdminDAO la_dao;
	
	private static final int DOUBLE_CLICK = 2;
	
	private int selectedRow;
	
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

		try {
			List<OrderVO> list = la_dao.selectOrderList();
			
			DefaultTableModel dtmOrder = lmv.getDtmOrder();
			if(!list.isEmpty()) {
				dtmOrder.setRowCount(0); // �ʱ�ȭ
			}

			OrderVO ovo = null;
			Vector<Object> vec = null;
			for(int i=0; i<list.size(); i++) {
				ovo = list.get(i);
				vec = new Vector<Object>();

				vec.add(new Integer(i+1));
				vec.add(ovo.getOrderNum());
				vec.add(ovo.getLunchCode());
				vec.add(ovo.getLunchName());
				vec.add(ovo.getOrderName());
				vec.add(new Integer(ovo.getQuan()));
				vec.add(new Integer(ovo.getPrice()));
				vec.add(ovo.getOrderDate());
				vec.add(ovo.getPhone());
				vec.add(ovo.getIpAddress());
				vec.add(ovo.getStatus());
				
				dtmOrder.addRow(vec);
			}
			
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(lmv, "DB���� �����͸� �޾ƿ��� �� �����߻�...");
			se.printStackTrace();
		}
	}
	
	/**
	 * ��, ��, �� ������ �����ͼ� ����
	 */
	private void searchCalc() {
		DefaultTableModel dtmCalc = lmv.getDtmCalc();
		
		int selectedYear = ((Integer)lmv.getJcbYear().getSelectedItem()).intValue();
		int selectedMonth = ((Integer)lmv.getJcbMonth().getSelectedItem()).intValue();
		int selectedDay = ((Integer)lmv.getJcbDay().getSelectedItem()).intValue();
		
		StringBuilder searchDate = new StringBuilder();
		
		searchDate.append(selectedYear).append("-")
		.append(selectedMonth).append("-")
		.append(selectedDay);
		
		try {
			// ������ ������ ��ȸ����� �޾Ƽ� JTable ��� 
			List<CalcVO> list = la_dao.selectCalc(searchDate.toString());

			if (!list.isEmpty()) {
				dtmCalc.setRowCount(0);
			}
			
			// JTable�� �����͸� �߰��ϴ� �ڵ带 �ۼ��غ�����.
			CalcVO cvo = null;
			Object[] rowData = null;
			for(int i=0; i<list.size(); i++) {
				cvo = list.get(i);
				rowData = new Object[4];
				
				rowData[0] = i+1;
				rowData[1] = cvo.getLunchName()+"("+cvo.getLunchCode()+")";
				rowData[2] = cvo.getTotal();
				rowData[3] = cvo.getPrice();
				
				dtmCalc.addRow(rowData);
			}
			
			if (list.isEmpty()) {
				JOptionPane.showMessageDialog(lmv, 
						searchDate.toString()+"�� ���� �Ǹŵ� ���ö��� �����ϴ�.");
			}
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(lmv, "DB���� �����͸� �޾ƿ��� �� �����߻�...");
			se.printStackTrace();
		}
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
//		lmv.getJcbDay().setSelectedItem(new Integer(currDay)); // ������ ����
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == lmv.getJcbMonth()) { // ���� ������ ���� ����
			setDay();
		}
		
		if (ae.getSource() == lmv.getJbtAddLunch()) { // ���ö� �߰� ��ư
			new LunchAddView(lmv, this);
		}
		
		if (ae.getSource() == lmv.getJbtCalcOrder()) { // ���� ��ư Ŭ��
			searchCalc();
		}
		
		if (ae.getSource() == lmv.getJmOrderRemove()) {
			JOptionPane.showConfirmDialog(lmv, "�ֹ������� �����Ͻðڽ��ϱ�?");
		}
		
		if (ae.getSource() == lmv.getJmOrderStatus()) {
			switch(JOptionPane.showConfirmDialog(lmv, "�ֹ��� �Ϸ�ó�� �Ͻðڽ��ϱ�?")) {
			case JOptionPane.OK_OPTION :
				JTable jt = lmv.getJtOrder();
				jt.setValueAt("Y", selectedRow, 10);
				lmv.getJpOrderMenu().setVisible(false);
				///////////////////////////////////////////////////////////////////////////////////////////////
				///// 2019-01-17 �۾� ��, ���� ���� DB ó������ ����
				///////////////////////////////////////////////////////////////////////////////////////////////
				break;
			}
		}
	}
	
	
	@Override
	public void mouseClicked(MouseEvent me) {
		if (me.getSource() == lmv.getJtb()) { // �ǿ��� Ŭ���� �߻����� ����
			if (lmv.getJtb().getSelectedIndex() == 1) { // ó�� �ǿ��� �̺�Ʈ �߻� 
				// ��������� �ֹ������� ��ȸ
				System.out.println("------");
				searchOrder();
			}
		}
		
		if (me.getSource() == lmv.getJtOrder() && me.getButton() == MouseEvent.BUTTON3) {
			
			JPopupMenu jp = lmv.getJpOrderMenu();
			jp.setLocation(me.getXOnScreen(), me.getYOnScreen());
			jp.setVisible(true);
			
			JTable jt = lmv.getJtOrder();
			
			// ���콺 �����Ͱ� Ŭ���Ǹ� ���̺��� Ŭ���� ���� �������� ��
			int r = jt.rowAtPoint(me.getPoint());
	        if (r >= 0 && r < jt.getRowCount()) {
	        	jt.setRowSelectionInterval(r, r); // ������� ���� ���̿� ���� ����
	        } else {
	        	jt.clearSelection();
	        }
	        selectedRow = r; // ������ ���� �ִ´�.

	        int rowindex = jt.getSelectedRow();
	        if (rowindex < 0)
	            return;
			
			
		} else {
			JPopupMenu jp = lmv.getJpOrderMenu();
			jp.setVisible(false);
		}
		
		// ���� �ð��ȿ� �ι� Ŭ���ϸ� ����Ŭ��
		switch (me.getClickCount()) {
		case DOUBLE_CLICK : 
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
		}
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		lmv.dispose();
	}
	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(0); // JVM�� ��� �ν��Ͻ��� ����
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
