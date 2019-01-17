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

		try {
			List<OrderVO> list = la_dao.selectOrderList();
			
			DefaultTableModel dtmOrder = lmv.getDtmOrder();
			if(!list.isEmpty()) {
				dtmOrder.setRowCount(0); // 초기화
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
			JOptionPane.showMessageDialog(lmv, "DB에서 데이터를 받아오는 중 문제발생...");
			se.printStackTrace();
		}
	}
	
	/**
	 * 년, 월, 일 정보를 가져와서 정산
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
			// 선택한 일자의 조회결과를 받아서 JTable 출력 
			List<CalcVO> list = la_dao.selectCalc(searchDate.toString());

			if (!list.isEmpty()) {
				dtmCalc.setRowCount(0);
			}
			
			// JTable에 데이터를 추가하는 코드를 작성해보세요.
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
						searchDate.toString()+"일 에는 판매된 도시락이 없습니다.");
			}
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(lmv, "DB에서 데이터를 받아오는 중 문제발생...");
			se.printStackTrace();
		}
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
//		lmv.getJcbDay().setSelectedItem(new Integer(currDay)); // 오늘을 선택
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == lmv.getJcbMonth()) { // 월별 마지막 일자 변경
			setDay();
		}
		
		if (ae.getSource() == lmv.getJbtAddLunch()) { // 도시락 추가 버튼
			new LunchAddView(lmv, this);
		}
		
		if (ae.getSource() == lmv.getJbtCalcOrder()) { // 정산 버튼 클릭
			searchCalc();
		}
		
		if (ae.getSource() == lmv.getJmOrderRemove()) {
			JOptionPane.showConfirmDialog(lmv, "주문정보를 삭제하시겠습니까?");
		}
		
		if (ae.getSource() == lmv.getJmOrderStatus()) {
			switch(JOptionPane.showConfirmDialog(lmv, "주문을 완료처리 하시겠습니까?")) {
			case JOptionPane.OK_OPTION :
				JTable jt = lmv.getJtOrder();
				jt.setValueAt("Y", selectedRow, 10);
				lmv.getJpOrderMenu().setVisible(false);
				///////////////////////////////////////////////////////////////////////////////////////////////
				///// 2019-01-17 작업 끝, 변경 내용 DB 처리부터 시작
				///////////////////////////////////////////////////////////////////////////////////////////////
				break;
			}
		}
	}
	
	
	@Override
	public void mouseClicked(MouseEvent me) {
		if (me.getSource() == lmv.getJtb()) { // 탭에서 클릭이 발생했을 때만
			if (lmv.getJtb().getSelectedIndex() == 1) { // 처음 탭에서 이벤트 발생 
				// 현재까지의 주문사항을 조회
				System.out.println("------");
				searchOrder();
			}
		}
		
		if (me.getSource() == lmv.getJtOrder() && me.getButton() == MouseEvent.BUTTON3) {
			
			JPopupMenu jp = lmv.getJpOrderMenu();
			jp.setLocation(me.getXOnScreen(), me.getYOnScreen());
			jp.setVisible(true);
			
			JTable jt = lmv.getJtOrder();
			
			// 마우스 포인터가 클릭되면 테이블에서 클릭한 행을 가져오는 일
			int r = jt.rowAtPoint(me.getPoint());
	        if (r >= 0 && r < jt.getRowCount()) {
	        	jt.setRowSelectionInterval(r, r); // 시작행과 끝행 사이에 행을 선택
	        } else {
	        	jt.clearSelection();
	        }
	        selectedRow = r; // 선택한 행을 넣는다.

	        int rowindex = jt.getSelectedRow();
	        if (rowindex < 0)
	            return;
			
			
		} else {
			JPopupMenu jp = lmv.getJpOrderMenu();
			jp.setVisible(false);
		}
		
		// 일정 시간안에 두번 클릭하면 더블클릭
		switch (me.getClickCount()) {
		case DOUBLE_CLICK : 
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
		}
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		lmv.dispose();
	}
	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(0); // JVM의 모든 인스턴스를 종료
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
