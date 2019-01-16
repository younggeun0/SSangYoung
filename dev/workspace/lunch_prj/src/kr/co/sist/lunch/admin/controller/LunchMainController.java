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
		// 도시락 목록을 초기화
		setLunch();
	}
	
	/**
	 * JTable에 DB에서 조회한 도시락 정보를 보여준다.
	 */
	public void setLunch() {
		DefaultTableModel dtmLunch = lmv.getDtmLunch();
		
		dtmLunch.setRowCount(0);
		
		try {
			// DB에서 도시락 정보를 조회
			List<LunchVO> listLunch = la_dao.selectLunch();
			
			LunchVO lv = null;
			String imgPath = "C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/s_";
			Object[] rowData = null;
			// JTable에 조회한 정보를 출력
			for(int i=0; i<listLunch.size(); i++) {
				lv = listLunch.get(i);
				
				// dtmLunch에 데이터를 추가하기위한 일차원배열(Vector)을 생성
				rowData = new Object[5];
				rowData[0] = new Integer(i+1);
				rowData[1] = lv.getLunchCode();
				rowData[2] = new ImageIcon(imgPath+lv.getImg());
				rowData[3] = lv.getLunchName();
			    rowData[4] = lv.getPrice();
				dtmLunch.addRow(rowData);		
			}
			
			if (listLunch.isEmpty()) { // 입력된 도시락이 없을 때 
				JOptionPane.showMessageDialog(lmv, "입력된 제품이 없습니다.");
			}
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(lmv, "DB에서 데이터를 받아오는 중 문제발생...");
			se.printStackTrace();
		}
	}
	
	private void searchOrder() {

	}
	
	private void searchCalc() {

	}
	
	/**
	 * 월이 선택되면 해당년의 해당월의 마지막 날을 설정
	 */
	private void setDay() {
		int selectedYear = ((Integer)lmv.getJcbYear().getSelectedItem()).intValue();
		int selectedMonth = ((Integer)lmv.getJcbMonth().getSelectedItem()).intValue();
		
		// 마지막 날 얻기
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, selectedYear);
		cal.set(Calendar.MONTH, selectedMonth-1); // 자바의 월은 사람이 생각하는 달보다 하나 작음

		int lastDay = cal.getActualMaximum(Calendar.DATE);
		int currDay = cal.get(Calendar.DAY_OF_MONTH);
		
		lmv.getCbmDay().removeAllElements(); // 모델을 초기화하고 선택된 날을 설정
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
		
		// 일정 시간안에 두번 클릭하면 더블클릭
		switch (me.getClickCount()) {
		case DOUBLE_CLICK : 
			if (me.getSource() == lmv.getJtb()) { 
				
			}
			
			if (me.getSource() == lmv.getJtLunch()) { 
				// 도시락 테이블에서 더블클릭이 되면
				// 도시락 코드로 검색을하여 상세정보를 전달한다.
				JTable jt = lmv.getJtLunch();
				String lunchCode = (String)jt.getValueAt(jt.getSelectedRow(), 1);
				try {
					LunchDetailVO ldvo = la_dao.selectDetailLunch(lunchCode);
					new LunchDetailView(lmv, ldvo, this);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(lmv, "DB에서 문제가 발생했습니다.");
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
	// 안쓰는 MouseListener methode들
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
