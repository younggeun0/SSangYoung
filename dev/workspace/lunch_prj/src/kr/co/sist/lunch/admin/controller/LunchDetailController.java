package kr.co.sist.lunch.admin.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

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
		la_dao = LunchAdminDAO.getInstance();
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	//// 2019-01-16 �۾� ����!! ���ö��� �����ϴ� �κк���.
	//////////////////////////////////////////////////////////////////////////////////////
	public boolean modifyLunch(LunchUpdateVO luvo) {
		boolean flag = false;
		
		lmc.setLunch();
		
		return flag;
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
			
			LunchUpdateVO luvo = new LunchUpdateVO(ldv.getJtfLunchCode().getText(),
					ldv.getJtfLunchName().getText(), ldv.getJtaLunchSpec().getText(), 
					Integer.parseInt(ldv.getJtfLunchPrice().getText()),
					ldv.getJlLunchImg().getIcon().toString()); 
			
			modifyLunch(luvo);
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
