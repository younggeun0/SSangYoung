package kr.co.sist.lunch.user.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.user.model.LunchClientDAO;
import kr.co.sist.lunch.user.view.LunchClientView;
import kr.co.sist.lunch.user.view.LunchOrderDetailView;
import kr.co.sist.lunch.user.vo.LunchDetailVO;
import kr.co.sist.lunch.user.vo.LunchListVO;

public class LunchClientController extends WindowAdapter implements ActionListener, MouseListener{

	private LunchClientView lcv;
	private LunchClientDAO lc_dao;
	private static final int DBL_CLICK = 2;
	
	public LunchClientController(LunchClientView lcv) {
		this.lcv = lcv;
		lc_dao = LunchClientDAO.getInstance();
		
		setLunchList();
	}
	
	public void msgCenter(Component comp, String msg) {
		JOptionPane.showMessageDialog(comp, msg);
	}
	
	/**
	 * 도시락 목록을 조회하여 JTable에 설정하는 일
	 * 특장점은 25자 이상이라면 24자까지만 출력하고, 나머지는 ...으로 붙여 설정 
	 */
	public void setLunchList() {
		try {
			List<LunchListVO> list = lc_dao.selectLunchList();
			
			DefaultTableModel dtm = lcv.getDtmLunchList();
			dtm.setRowCount(0);
			
			LunchListVO llvo;
			Object[] rowData = null;
			for(int i=0; i<list.size(); i++) {
				llvo = list.get(i);
				
				rowData = new Object[5];
				rowData[0] = new Integer(i+1);
				rowData[1] = new ImageIcon("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/lunch_prj/src/kr/co/sist/lunch/user/img/s_"+llvo.getImg());
				rowData[2] = llvo.getLunchCode();
				rowData[3] = llvo.getLunchName();
				rowData[4] = llvo.getLunchSpec();
				
				if (rowData[4].toString().length() > 24) {
					rowData[4] = rowData[4].toString().substring(0, 24)+"...";
				}
				
				dtm.addRow(rowData);
			}
			
			
		} catch (SQLException e) {
			msgCenter(lcv, "도시락 목록을 조회하는 중 DB에서 문제가 발생하였습니다.");
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	} // actionPerformed
	
	@Override
	public void windowClosing(WindowEvent e) {
		lcv.dispose();
	} // windowClosing
	
	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(JFrame.ABORT);
	} // windowClosed

	@Override
	public void mouseClicked(MouseEvent me) {
		
		switch (me.getClickCount()) {
		case DBL_CLICK :
			JTable jt = lcv.getJtLunch();
			String lunchCode = (String)jt.getValueAt(jt.getSelectedRow(),2);

			// 도시락의 상세정보 조회
			try {
				LunchDetailVO ldvo = lc_dao.selectDetailLunch(lunchCode);

				if (ldvo == null) { // 코드로 조회된 결과가 없을 때
					msgCenter(lcv, lunchCode+"로 조회된 도시락이 없습니다.");
				} else { // 코드로 조회된 결과가 있을 때 
					new LunchOrderDetailView(lcv, ldvo, lunchCode);
				}
			} catch (SQLException se) {
				msgCenter(lcv, "상세정보 조회시 문제 발생");
				se.printStackTrace();
			}
		}
	} // mouseClicked

	// 사용 안하는 mouse event methods
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
