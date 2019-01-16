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
	//// 2019-01-16 작업 종료!! 도시락을 수정하는 부분부터.
	//////////////////////////////////////////////////////////////////////////////////////
	public boolean modifyLunch(LunchUpdateVO luvo) {
		boolean flag = false;
		
		lmc.setLunch();
		
		return flag;
	}
	
	public void removeLunch(String lunchCode) {
		
		try {
			if(la_dao.deleteLunch(lunchCode)) { // 도시락 삭제
				lmc.setLunch(); // 도시락 리스트를 갱신
				
				// 도시락 추가하며 생성된 이미지도 같이 삭제
				File file = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+originalImg);
				File rmFile = new File(file.getAbsolutePath()); // 큰 이미지
				File rmFile2 = new File(file.getParent()+"/s_"+file.getName()); // 작은 이미지
				
				rmFile.delete();
				rmFile2.delete();
				
				JOptionPane.showMessageDialog(ldv, "도시락이 삭제되었습니다.");
				ldv.dispose(); // 도시락 디테일 창 닫기
			} else {
				JOptionPane.showMessageDialog(ldv, "도시락이 존재하지 않습니다.");
			}
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(ldv, "DB에서 문제 발생했습니다.");
			se.printStackTrace();
		};
		
	}
	
	public void changeImg() {
		FileDialog fdOpen = new FileDialog(ldv, "도시락 이미지 선택", FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		// 확장자 설정 
		String path = fdOpen.getDirectory();
		String fileName = fdOpen.getFile();
		
		boolean flag = false;
		if(path != null) {
			String[] extFlag = {"jpg", "gif", "jpeg", "png", "bmp"};
			for(String ext : extFlag) {
				if (fileName.toLowerCase().endsWith(ext)) { // 업로드 가능 확장자
					flag = true;
				}
			}

			if (flag) {
				uploadImage = path+fileName;
				ldv.getJlLunchImg().setIcon(new ImageIcon(uploadImage));
			} else {
				JOptionPane.showMessageDialog(ldv, fileName+"은 이미지가 아닙니다.");
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ldv.getJbImg()) { // 이미지 변경
			changeImg();
		}
		
		if (e.getSource() == ldv.getJbUpdate()) { // 수정
			
			LunchUpdateVO luvo = new LunchUpdateVO(ldv.getJtfLunchCode().getText(),
					ldv.getJtfLunchName().getText(), ldv.getJtaLunchSpec().getText(), 
					Integer.parseInt(ldv.getJtfLunchPrice().getText()),
					ldv.getJlLunchImg().getIcon().toString()); 
			
			modifyLunch(luvo);
		}
		
		if (e.getSource() == ldv.getJbDelete()) { // 삭제
			StringBuilder deleteMsg = new StringBuilder();
			deleteMsg.append(ldv.getJtfLunchName().getText()).append("(")
			.append(ldv.getJtfLunchCode().getText()).append(")을(를) 삭제하시겠습니까?");
			
			switch(JOptionPane.showConfirmDialog(ldv, deleteMsg.toString())) {
			case JOptionPane.OK_OPTION :
				removeLunch(ldv.getJtfLunchCode().getText());
			};		
		}
		
		if (e.getSource() == ldv.getJbEnd()) { // 종료
			ldv.dispose();
		}
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		ldv.dispose();
	}
}
