package kr.co.sist.lunch.admin.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchDetailView;
import kr.co.sist.lunch.admin.vo.LunchDetailVO;
import kr.co.sist.lunch.admin.vo.LunchUpdateVO;

public class LunchDetailController extends WindowAdapter implements ActionListener {

	private LunchDetailView ldv;
	private LunchMainController lmc;
	private LunchAdminDAO la_dao;
	private String originalImg;
	private String uploadImage;
	
	public LunchDetailController(LunchDetailView ldv, LunchMainController lmc, String originalImg) {
		this.ldv = ldv;
		this.lmc = lmc;
		this.originalImg = originalImg;
		uploadImage = "";
		la_dao = LunchAdminDAO.getInstance();
	}
	
	/**
	 * ���ö� �ڵ�, �̹���, ���ö���, ����, Ư������ �Է¹޾� �ڵ忡 �ش��ϴ� ���ö��� ������ ����.
	 * @param luvo
	 * @return
	 */
	public void  modifyLunch() {
		
		// ��ȿ�� ���� : ���ö���, ����, Ư������ ""�� �ƴ� ��, ������ ��������,
		// �̹����� ������� �ʾҴ���(���� �ȵǾ��ٸ� �ٽ� �ø� �ʿ䰡 ����), 
		// ����Ǿ��ٸ� s_�� ���� �̹����� �����ϴ� �̹������� ����(���� �Ϸ� �� ������Ʈ ó��)
		JTextField tfName = ldv.getJtfLunchName();
		JTextField tfPrice = ldv.getJtfLunchPrice();
		JTextArea taSpec = ldv.getJtaLunchSpec();
		
		if(tfName.getText().trim().equals("")) {
			tfName.setText("");
			JOptionPane.showMessageDialog(ldv, "���ö����� �Է����ּ���.");
			tfName.requestFocus();
			return;
		}

		if(tfPrice.getText().trim().equals("")) {
			tfPrice.setText("");
			JOptionPane.showMessageDialog(ldv, "���ö��� ������ �Է����ּ���.");
			tfPrice.requestFocus();
			return;
		}

		if(taSpec.getText().trim().equals("")) {
			taSpec.setText("");
			JOptionPane.showMessageDialog(ldv, "���ö��� Ư������ �Է����ּ���.");
			taSpec.requestFocus();
			return;
		}
		
		int price = 0;
		try {
			price = Integer.parseInt(tfPrice.getText().trim());
		} catch (NumberFormatException nfe) {
			tfPrice.setText("");
			JOptionPane.showMessageDialog(ldv, "���ö� ������ ���ڸ� �Է°����մϴ�.");
			tfPrice.requestFocus();
			return;
		}
		
		// ������ �̹��� ���ϰ� ���λ� s_�� ���� ������ �̹��������� ���� ���
		// ->�̹��� �۾��� �Ǿ����� ���� ���. uploadImage�� ���
		if (!uploadImage.equals("")) { // �̹��� ������ ������ ���
			File tempFile = new File(uploadImage); // ū �̹���
			
			File smallFile = new File(tempFile.getParent()+"/s_"+tempFile.getName()); // ���� �̹���
			
			if (!smallFile.exists()) {
				JOptionPane.showMessageDialog(ldv, "�����Ͻ� ������ ���� �̹����� �������� �ʽ��ϴ�.");
				uploadImage = "";
				return;
			}
		}
		
		StringBuilder updateMsg = new StringBuilder();
		updateMsg.append("�������� \n")
		.append("���ö��� : ").append(tfName.getText().trim())
		.append("\n���� : ").append(tfPrice.getText().trim())
		.append("\nƯ���� : ").append(taSpec.getText().trim())
		.append("\n���� ������ ���ö��� ������ ����˴ϴ�. �����Ͻðڽ��ϱ�?");
		
		switch(JOptionPane.showConfirmDialog(ldv, updateMsg.toString())) {
		case JOptionPane.OK_OPTION : 

			// ����� ������ VO�� �����ϰ� 
			File file = new File(uploadImage);
			LunchUpdateVO luvo = new LunchUpdateVO(
				ldv.getJtfLunchCode().getText(), 
				tfName.getText().trim(), 
				taSpec.getText(),
				Integer.parseInt(tfPrice.getText().trim()),
				file.getName());
			
			try {
				if(la_dao.updateLunch(luvo)) { // DB table���� update�� ����
					JOptionPane.showMessageDialog(ldv, "���ö� ������ ����Ǿ����ϴ�.");
					
					if (!uploadImage.equals("")) { // ������ �̹����� �����ϴ� ���
						try {
							// ���� �̹����� ������ ��
							// ���ö� �߰��ϸ� ������ �̹����� ���� ����
							File original = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+originalImg);
							System.out.println(original.getPath()+"/s_"+original.getName());
							System.out.println(original.getParent()+"/s_"+original.getName());
							File small = new File(original.getParent()+"/s_"+original.getName()); // ���� �̹���
							
							original.delete();
							small.delete();
							
							uploadImg(file);	// ������ �̹����� ������ ������ ���ε��Ѵ�.
						} catch (IOException ie) {
							ie.printStackTrace();
						}
					}
					
					ldv.dispose();
					lmc.setLunch(); // �θ�â�� ���ö� ����Ʈ�� �����Ѵ�.
				} else {
					JOptionPane.showMessageDialog(ldv, "���ö� ������ ������� �ʾҽ��ϴ�.");
					
				}
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(ldv, "DB���� ������ �߻��Ͽ����ϴ�.");
				se.printStackTrace();
			}
			break;
		};
	}
	
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
	
	public void removeLunch(String lunchCode) {
		try {
			if(la_dao.deleteLunch(lunchCode)) { // ���ö� ����
				lmc.setLunch(); // ���ö� ����Ʈ�� ����
				
				// ���ö� �߰��ϸ� ������ �̹����� ���� ����
				File file = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+originalImg);
				File rmFile = new File(file.getAbsolutePath()); // ū �̹���
				File rmFile2 = new File(file.getParent()+"/s_"+file.getName()); // ���� �̹���
				
				rmFile.delete();
				rmFile2.delete();
				
				JOptionPane.showMessageDialog(ldv, "���ö��� �����Ǿ����ϴ�.");
				ldv.dispose(); // ���ö� ������ â �ݱ�
			} else {
				JOptionPane.showMessageDialog(ldv, "���ö��� �������� �ʽ��ϴ�.");
			}
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(ldv, "DB���� ���� �߻��߽��ϴ�.");
			se.printStackTrace();
		};
	}
	
	public void changeImg() {
		FileDialog fdOpen = new FileDialog(ldv, "���ö� �̹��� ����", FileDialog.LOAD);
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
				ldv.getJlLunchImg().setIcon(new ImageIcon(uploadImage));
			} else {
				JOptionPane.showMessageDialog(ldv, fileName+"�� �̹����� �ƴմϴ�.");
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ldv.getJbImg()) { // �̹��� ����
			changeImg();
		}
		
		if (e.getSource() == ldv.getJbUpdate()) { // ����
			modifyLunch();
		}
		
		if (e.getSource() == ldv.getJbDelete()) { // ����
			StringBuilder deleteMsg = new StringBuilder();
			deleteMsg.append(ldv.getJtfLunchName().getText()).append("(")
			.append(ldv.getJtfLunchCode().getText()).append(")��(��) �����Ͻðڽ��ϱ�?");
			
			switch(JOptionPane.showConfirmDialog(ldv, deleteMsg.toString())) {
			case JOptionPane.OK_OPTION :
				removeLunch(ldv.getJtfLunchCode().getText());
			};		
		}
		
		if (e.getSource() == ldv.getJbEnd()) { // ����
			ldv.dispose();
		}
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		ldv.dispose();
	}
}
