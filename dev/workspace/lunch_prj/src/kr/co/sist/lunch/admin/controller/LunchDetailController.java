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
	 * 도시락 코드, 이미지, 도시락명, 가격, 특장점을 입력받아 코드에 해당하는 도시락의 정보를 변경.
	 * @param luvo
	 * @return
	 */
	public void  modifyLunch() {
		
		// 유효성 검증 : 도시락명, 가격, 특장점이 ""이 아닐 때, 가격은 숫자인지,
		// 이미지가 변경되지 않았는지(변경 안되었다면 다시 올릴 필요가 없음), 
		// 변경되었다면 s_가 붙은 이미지가 존재하는 이미지인지 검증(검증 완료 후 업데이트 처리)
		JTextField tfName = ldv.getJtfLunchName();
		JTextField tfPrice = ldv.getJtfLunchPrice();
		JTextArea taSpec = ldv.getJtaLunchSpec();
		
		if(tfName.getText().trim().equals("")) {
			tfName.setText("");
			JOptionPane.showMessageDialog(ldv, "도시락명을 입력해주세요.");
			tfName.requestFocus();
			return;
		}

		if(tfPrice.getText().trim().equals("")) {
			tfPrice.setText("");
			JOptionPane.showMessageDialog(ldv, "도시락의 가격을 입력해주세요.");
			tfPrice.requestFocus();
			return;
		}

		if(taSpec.getText().trim().equals("")) {
			taSpec.setText("");
			JOptionPane.showMessageDialog(ldv, "도시락의 특장점을 입력해주세요.");
			taSpec.requestFocus();
			return;
		}
		
		int price = 0;
		try {
			price = Integer.parseInt(tfPrice.getText().trim());
		} catch (NumberFormatException nfe) {
			tfPrice.setText("");
			JOptionPane.showMessageDialog(ldv, "도시락 가격은 숫자만 입력가능합니다.");
			tfPrice.requestFocus();
			return;
		}
		
		// 선택한 이미지 파일과 접두사 s_를 가진 동일한 이미지파일이 없는 경우
		// ->이미지 작업이 되어있지 않은 경우. uploadImage를 사용
		if (!uploadImage.equals("")) { // 이미지 변경을 수행한 경우
			File tempFile = new File(uploadImage); // 큰 이미지
			
			File smallFile = new File(tempFile.getParent()+"/s_"+tempFile.getName()); // 작은 이미지
			
			if (!smallFile.exists()) {
				JOptionPane.showMessageDialog(ldv, "선택하신 파일은 작은 이미지가 존재하지 않습니다.");
				uploadImage = "";
				return;
			}
		}
		
		StringBuilder updateMsg = new StringBuilder();
		updateMsg.append("수정정보 \n")
		.append("도시락명 : ").append(tfName.getText().trim())
		.append("\n가격 : ").append(tfPrice.getText().trim())
		.append("\n특장점 : ").append(taSpec.getText().trim())
		.append("\n위의 정보로 도시락의 정보가 변경됩니다. 변경하시겠습니까?");
		
		switch(JOptionPane.showConfirmDialog(ldv, updateMsg.toString())) {
		case JOptionPane.OK_OPTION : 

			// 변경된 값으로 VO를 생성하고 
			File file = new File(uploadImage);
			LunchUpdateVO luvo = new LunchUpdateVO(
				ldv.getJtfLunchCode().getText(), 
				tfName.getText().trim(), 
				taSpec.getText(),
				Integer.parseInt(tfPrice.getText().trim()),
				file.getName());
			
			try {
				if(la_dao.updateLunch(luvo)) { // DB table에서 update를 수행
					JOptionPane.showMessageDialog(ldv, "도시락 정보가 변경되었습니다.");
					
					if (!uploadImage.equals("")) { // 변경한 이미지가 존재하는 경우
						try {
							// 이전 이미지를 삭제한 후
							// 도시락 추가하며 생성된 이미지도 같이 삭제
							File original = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+originalImg);
							System.out.println(original.getPath()+"/s_"+original.getName());
							System.out.println(original.getParent()+"/s_"+original.getName());
							File small = new File(original.getParent()+"/s_"+original.getName()); // 작은 이미지
							
							original.delete();
							small.delete();
							
							uploadImg(file);	// 변경한 이미지를 지정한 폴더에 업로드한다.
						} catch (IOException ie) {
							ie.printStackTrace();
						}
					}
					
					ldv.dispose();
					lmc.setLunch(); // 부모창의 도시락 리스트를 변경한다.
				} else {
					JOptionPane.showMessageDialog(ldv, "도시락 정보가 변경되지 않았습니다.");
					
				}
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(ldv, "DB에서 문제가 발생하였습니다.");
				se.printStackTrace();
			}
			break;
		};
	}
	
	public void uploadImg(File file) throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			// 큰 이미지 업로드
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
			
			// 작은 이미지 업로드
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
			modifyLunch();
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
