package kr.co.sist.lunch.user.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.admin.controller.LunchLoginController;
import kr.co.sist.lunch.user.model.LunchClientDAO;
import kr.co.sist.lunch.user.view.LunchClientView;
import kr.co.sist.lunch.user.view.LunchOrderDetailView;
import kr.co.sist.lunch.user.vo.LunchDetailVO;
import kr.co.sist.lunch.user.vo.LunchListVO;
import kr.co.sist.lunch.user.vo.OrderInfoVO;
import kr.co.sist.lunch.user.vo.OrderListVO;

public class LunchClientController extends WindowAdapter implements ActionListener, MouseListener{

	private LunchClientView lcv;
	private LunchClientDAO lc_dao;
	private static final int DBL_CLICK = 2;
	
	public LunchClientController(LunchClientView lcv) {
		this.lcv = lcv;
		lc_dao = LunchClientDAO.getInstance();
		
		try {
			String[] fileNames = lunchImageList(); // 클라이언트가 가진 이미지를 체크하여 
			lunchImageSend(fileNames); // 서버로 보내 없는 이미지를 받은 후
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		setLunchList();	// JTable을 갱신한다.
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
	
	/**
	 * 서버로 이미지를 보내고 없는 이미지를 받는 일
	 * @param fileName
	 */
	private void lunchImageSend(String[] fileNames) throws IOException {
		
		Socket socket = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		
		try {
			socket = new Socket("211.63.89.144", 25000);
			dos = new DataOutputStream(socket.getOutputStream());
			
			dos.writeInt(fileNames.length);
			
			for(int i=0; i<fileNames.length; i++) {
				dos.writeUTF(fileNames[i]); // 서버로 전송
			}
			dos.flush();
			
			dis = new DataInputStream(socket.getInputStream());
			// 서버가 보내오는 파일 수 저장
			int fileCnt = dis.readInt();
			System.out.println("클라이언트 "+fileCnt+"개 받음");

			String fileName = "";
			int fileSize = 0;
			int fileLen = 0;
			FileOutputStream fos = null;
			
			for(int i=0; i<fileCnt; i++) {

				// 전달받을 파일조각(바이트배열)의 수
				fileSize = dis.readInt();
				
				// 파일명 받기
				fileName = dis.readUTF();
				fos = new FileOutputStream(
						"C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/lunch_prj/src/kr/co/sist/lunch/user/img/"+fileName);
				
				byte[] readData = new byte[512];
				while(fileSize > 0) {
					fileLen = dis.read(readData); // 서버에서 전송한 파일조각을 읽어들여
					fos.write(readData, 0, fileLen); // 생성한 파일로 기록
					fos.flush();
					fileSize--;
				}
			}
			
		} finally {
			if (dis != null) { dis.close(); }
			if (dos != null) { dos.close(); }
			if (socket != null) { socket.close(); }
		}
	}
	
	/**
	 * 도시락 이미지 리스트
	 */
	private String[] lunchImageList() {
		String[] fileList = null;
		String path = "C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/lunch_prj/src/kr/co/sist/lunch/user/img/";

		File dir = new File(path);
		
		List<String> listFileName = new ArrayList<String>();

		for(String f_name : dir.list()) {
			if (!f_name.startsWith("s_")) {
				listFileName.add(f_name);
			}
		}
		
		fileList = new String[listFileName.size()];
		
		listFileName.toArray(fileList);
		
		// 큰 이미지(s_가 붙지 않은)만 배열에 넣으세요.
		System.out.println(Arrays.toString(fileList));
		return fileList;
	}
	
	/*public LunchClientController() {
		
	}
	
	public static void main(String[] args) {
		new LunchClientController().lunchImageList();
	}
	*/
	
	/**
	 * 주문자명과 전화번호를 가지고 도시락을 조회
	 */
	private void searchLunchOrder() {
		// 주문한 도시락 목록 조회
		JTextField jtfName = lcv.getJtfName();
		String orderName = jtfName.getText().trim();

		if (orderName.equals("")) {
			msgCenter(lcv, "주문자명은 필수입력 입니다.");
			jtfName.setText("");
			jtfName.requestFocus();
			return;
		}

		JTextField jtfTel = lcv.getJtfTel();
		String tel = lcv.getJtfTel().getText().trim();

		if (tel.equals("")) {
			msgCenter(lcv, "주문자 전화번호는 필수 입력입니다.");
			jtfTel.setText("");
			jtfTel.requestFocus();
			return;
		}

		try {
			// 입력값을 사용하여 DB Table 조회
			List<OrderListVO> list = 
					lc_dao.selectOrder(new OrderInfoVO(orderName, tel));

			// JTable에 출력
			DefaultTableModel dtm = lcv.getDtmOrderList();

			if (!list.isEmpty()) {
				dtm.setRowCount(0);
				lcv.setTitle("재찬도시락 - 조회 ["+orderName+"님의 주문현황]");
			} else {
				msgCenter(lcv, "해당 입력값에 해당하는 주문 정보가 없습니다.");
				jtfName.setText("");
				jtfTel.setText("");
				jtfName.requestFocus();
				return;
			}

			OrderListVO olvo = null;
			Object[] rowData = null;
			for (int i = 0; i < list.size(); i++) {
				olvo = list.get(i);

				rowData = new Object[4];
				rowData[0] = i + 1;
				rowData[1] = olvo.getLunchName();
				rowData[2] = olvo.getQuantity();
				rowData[3] = olvo.getOrder_date();

				dtm.addRow(rowData);
			}
			jtfName.setText("");
			jtfTel.setText("");
			jtfName.requestFocus();
			
		} catch (SQLException e1) {
			msgCenter(lcv, "DB 문제 발생, 주문자 조회에 실패");
			e1.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == lcv.getJtfName()) {
			lcv.getJtfTel().requestFocus();
		}
		
		if (e.getSource() == lcv.getJtfTel() || e.getSource() == lcv.getJbtSearch()) {
			searchLunchOrder();
		}
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
		if(lcv.getJtp().getSelectedIndex() == 0) {
			lcv.setTitle("재찬 도시락 주문");
		} 
		if(lcv.getJtp().getSelectedIndex() == 1) {
			lcv.setTitle("재찬 도시락 주문 조회");
		} 
		if (me.getSource() == lcv.getJtLunch()) {
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
