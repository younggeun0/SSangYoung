package kr.co.sist.lunch.admin.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchAddView;
import kr.co.sist.lunch.admin.vo.LunchAddVO;

public class LunchAddController extends WindowAdapter implements ActionListener {

	private LunchAddView lav;
	private LunchMainController lmc;
	private String uploadImage;
	
	public LunchAddController(LunchAddView lav, LunchMainController lmc) {
		this.lav = lav;
		this.lmc = lmc;
		uploadImage = "";
	}
	
	/**
	 * ū �̹������� ���� File��ü�� �Է��Ͽ� ���ε� ������ ū �̹���(m1_l1.gif�� ���� ����)�� 
	 * s_�� ���� ���� �̹����� ���ε� �Ѵ�.
	 * @param file
	 * @throws IOException 
	 */
	public void uploadImg(File file) throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			// ū �̹��� ���ε�
			fis = new FileInputStream(file);

			byte[] readData = new byte[512];
			
			int len = 0;
			String uploadPath = "C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/";
			
			fos = new FileOutputStream(new File(uploadPath+file.getName()));
			
			while((len = fis.read(readData)) != -1) {
				fos.write(readData, 0, len);
				fos.flush();
			}
			
			fis.close();
			fos.close(); 
			
			// ���� �̹��� ���ε�
			fis = new FileInputStream(file.getParent()+"/s_"+file.getName());

			len = 0;
			fos = new FileOutputStream(new File(uploadPath+"s_"+file.getName()));
			
			while((len = fis.read(readData)) != -1) {
				fos.write(readData, 0, len);
				fos.flush();
			}
			
		} finally {
			if (fis != null) { fis.close(); }
			if (fos != null) { fos.close(); }
		}
	}
	
	/**
	 * �Է°��� �̹����� ������ �� ��ȿ�� ����
	 * (�̹���, ���ö���, ����, Ư������ �ԷµǾ��ٸ�)
	 */
	private void addLunch(int price) {
		
		File file = new File(uploadImage);
		System.out.println(file.getName());
		
		LunchAddVO lavo = new LunchAddVO(lav.getJtfLunchName().getText().trim(),
				file.getName(), lav.getJtaLunchSpec().getText().trim(),
				price);
		
		try {
			LunchAdminDAO.getInstance().insertLunch(lavo); // DB�� �߰�
			// �̹����� ����ϴ� ������ ����
			uploadImg(file);
			// ����Ʈ ����
			lmc.setLunch();
			JOptionPane.showMessageDialog(lav, "���ö��� �߰��Ǿ����ϴ�.");
			// ���� ���ö��� �Է��� ���ϰ� �ϱ����� �ʱ�ȭ
			lav.getJtfLunchName().setText("");
			lav.getJtfLunchPrice().setText("");
			lav.getJtaLunchSpec().setText("");
			lav.getJlLunchImg().setIcon(new ImageIcon("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/no_img.jpg"));
			lav.getJtfLunchName().requestFocus();
			
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(lav, "DB���� ���� �߻�");
			se.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(lav, "���� ���ε� ����");
			e.printStackTrace();
		}
	}
	
	private void setImg() {
		
		FileDialog fdOpen = new FileDialog(lav, "���ö� �̹��� ����", FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		// Ȯ���� ���� 
		String path = fdOpen.getDirectory();
		String fileName = fdOpen.getFile();
		
		boolean flag = false;
		if(path != null) {
			String[] extFlag = {"jpg", "gif", "jpeg", "png", "bmp"};
			for(String ext : extFlag) {
				if (fileName.toLowerCase().endsWith(ext)) { // ���ε� ���� Ȯ����
					flag = true;
				}
			}

			if (flag) {
				uploadImage = path+fileName;
				lav.getJlLunchImg().setIcon(new ImageIcon(uploadImage));
			} else {
				JOptionPane.showMessageDialog(lav, fileName+"�� �̹����� �ƴմϴ�.");
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == lav.getJbImg()) {
			setImg();
		}

		if (e.getSource() == lav.getjbAdd()) {
			if (uploadImage.equals("")) {
				JOptionPane.showMessageDialog(lav, "���ö� �̹����� �������ּ���.");
				return;
			}
			
			JTextField jtfName = lav.getJtfLunchName();
			JTextField jtfPrice = lav.getJtfLunchPrice();
			JTextArea jtaSpec = lav.getJtaLunchSpec();

			if (jtfName.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(lav, "���ö� �̸��� �ʼ� �Է��Դϴ�.");
				jtfName.setText("");
				jtfName.requestFocus();
				return;
			}
	
			if (jtfPrice.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(lav, "���ö� ������ �ʼ� �Է��Դϴ�.");
				jtfPrice.setText("");
				jtfPrice.requestFocus();
				return;
			}
			
			int price = 0;
			try {
				price = Integer.parseInt(jtfPrice.getText().trim());
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(lav, "���ö� ������ ���ڸ� �Է°����մϴ�.");
				jtfPrice.setText("");
				jtfPrice.requestFocus();
				return;
			}
			
			if (jtaSpec.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(lav, "���ö� �󼼼����� �ʼ� �Է��Դϴ�.");
				jtaSpec.setText("");
				jtaSpec.requestFocus();
				return;
			}
			
			addLunch(price);
		}
		
		if(e.getSource() == lav.getJbEnd()) {
			lav.dispose();
		}
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		lav.dispose();
	}
}
