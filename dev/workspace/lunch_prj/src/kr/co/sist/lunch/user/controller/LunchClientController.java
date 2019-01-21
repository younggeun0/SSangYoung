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
			String[] fileNames = lunchImageList(); // Ŭ���̾�Ʈ�� ���� �̹����� üũ�Ͽ� 
			lunchImageSend(fileNames); // ������ ���� ���� �̹����� ���� ��
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		setLunchList();	// JTable�� �����Ѵ�.
	}
	
	public void msgCenter(Component comp, String msg) {
		JOptionPane.showMessageDialog(comp, msg);
	}
	
	/**
	 * ���ö� ����� ��ȸ�Ͽ� JTable�� �����ϴ� ��
	 * Ư������ 25�� �̻��̶�� 24�ڱ����� ����ϰ�, �������� ...���� �ٿ� ���� 
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
			msgCenter(lcv, "���ö� ����� ��ȸ�ϴ� �� DB���� ������ �߻��Ͽ����ϴ�.");
			e.printStackTrace();
		}
	}
	
	/**
	 * ������ �̹����� ������ ���� �̹����� �޴� ��
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
				dos.writeUTF(fileNames[i]); // ������ ����
			}
			dos.flush();
			
			dis = new DataInputStream(socket.getInputStream());
			// ������ �������� ���� �� ����
			int fileCnt = dis.readInt();
			System.out.println("Ŭ���̾�Ʈ "+fileCnt+"�� ����");

			String fileName = "";
			int fileSize = 0;
			int fileLen = 0;
			FileOutputStream fos = null;
			
			for(int i=0; i<fileCnt; i++) {

				// ���޹��� ��������(����Ʈ�迭)�� ��
				fileSize = dis.readInt();
				
				// ���ϸ� �ޱ�
				fileName = dis.readUTF();
				fos = new FileOutputStream(
						"C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/lunch_prj/src/kr/co/sist/lunch/user/img/"+fileName);
				
				byte[] readData = new byte[512];
				while(fileSize > 0) {
					fileLen = dis.read(readData); // �������� ������ ���������� �о�鿩
					fos.write(readData, 0, fileLen); // ������ ���Ϸ� ���
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
	 * ���ö� �̹��� ����Ʈ
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
		
		// ū �̹���(s_�� ���� ����)�� �迭�� ��������.
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
	 * �ֹ��ڸ�� ��ȭ��ȣ�� ������ ���ö��� ��ȸ
	 */
	private void searchLunchOrder() {
		// �ֹ��� ���ö� ��� ��ȸ
		JTextField jtfName = lcv.getJtfName();
		String orderName = jtfName.getText().trim();

		if (orderName.equals("")) {
			msgCenter(lcv, "�ֹ��ڸ��� �ʼ��Է� �Դϴ�.");
			jtfName.setText("");
			jtfName.requestFocus();
			return;
		}

		JTextField jtfTel = lcv.getJtfTel();
		String tel = lcv.getJtfTel().getText().trim();

		if (tel.equals("")) {
			msgCenter(lcv, "�ֹ��� ��ȭ��ȣ�� �ʼ� �Է��Դϴ�.");
			jtfTel.setText("");
			jtfTel.requestFocus();
			return;
		}

		try {
			// �Է°��� ����Ͽ� DB Table ��ȸ
			List<OrderListVO> list = 
					lc_dao.selectOrder(new OrderInfoVO(orderName, tel));

			// JTable�� ���
			DefaultTableModel dtm = lcv.getDtmOrderList();

			if (!list.isEmpty()) {
				dtm.setRowCount(0);
				lcv.setTitle("�������ö� - ��ȸ ["+orderName+"���� �ֹ���Ȳ]");
			} else {
				msgCenter(lcv, "�ش� �Է°��� �ش��ϴ� �ֹ� ������ �����ϴ�.");
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
			msgCenter(lcv, "DB ���� �߻�, �ֹ��� ��ȸ�� ����");
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
			lcv.setTitle("���� ���ö� �ֹ�");
		} 
		if(lcv.getJtp().getSelectedIndex() == 1) {
			lcv.setTitle("���� ���ö� �ֹ� ��ȸ");
		} 
		if (me.getSource() == lcv.getJtLunch()) {
			switch (me.getClickCount()) {
			case DBL_CLICK :
				JTable jt = lcv.getJtLunch();
				String lunchCode = (String)jt.getValueAt(jt.getSelectedRow(),2);
				
				// ���ö��� ������ ��ȸ
				try {
					LunchDetailVO ldvo = lc_dao.selectDetailLunch(lunchCode);
					
					if (ldvo == null) { // �ڵ�� ��ȸ�� ����� ���� ��
						msgCenter(lcv, lunchCode+"�� ��ȸ�� ���ö��� �����ϴ�.");
					} else { // �ڵ�� ��ȸ�� ����� ���� �� 
						new LunchOrderDetailView(lcv, ldvo, lunchCode);
					}
				} catch (SQLException se) {
					msgCenter(lcv, "������ ��ȸ�� ���� �߻�");
					se.printStackTrace();
				}
			}
		}
	} // mouseClicked

	// ��� ���ϴ� mouse event methods
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
