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
	 * 큰 이미지명을 가진 File객체를 입력하여 업로드 폴더에 큰 이미지(m1_l1.gif와 같은 형태)와 
	 * s_가 붙은 작은 이미지를 업로드 한다.
	 * @param file
	 * @throws IOException 
	 */
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
	
	/**
	 * 입력값과 이미지를 선택한 후 유효성 검증
	 * (이미지, 도시락명, 가격, 특장점이 입력되었다면)
	 */
	private void addLunch(int price) {
		
		File file = new File(uploadImage);
		System.out.println(file.getName());
		
		LunchAddVO lavo = new LunchAddVO(lav.getJtfLunchName().getText().trim(),
				file.getName(), lav.getJtaLunchSpec().getText().trim(),
				price);
		
		try {
			LunchAdminDAO.getInstance().insertLunch(lavo); // DB에 추가
			// 이미지를 사용하는 폴더로 복사
			uploadImg(file);
			// 리스트 갱신
			lmc.setLunch();
			JOptionPane.showMessageDialog(lav, "도시락이 추가되었습니다.");
			// 다음 도시락의 입력을 편하게 하기위해 초기화
			lav.getJtfLunchName().setText("");
			lav.getJtfLunchPrice().setText("");
			lav.getJtaLunchSpec().setText("");
			lav.getJlLunchImg().setIcon(new ImageIcon("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/no_img.jpg"));
			lav.getJtfLunchName().requestFocus();
			
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(lav, "DB에서 문제 발생");
			se.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(lav, "파일 업로드 실패");
			e.printStackTrace();
		}
	}
	
	private void setImg() {
		
		FileDialog fdOpen = new FileDialog(lav, "도시락 이미지 선택", FileDialog.LOAD);
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
				lav.getJlLunchImg().setIcon(new ImageIcon(uploadImage));
			} else {
				JOptionPane.showMessageDialog(lav, fileName+"은 이미지가 아닙니다.");
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
				JOptionPane.showMessageDialog(lav, "도시락 이미지를 선택해주세요.");
				return;
			}
			
			JTextField jtfName = lav.getJtfLunchName();
			JTextField jtfPrice = lav.getJtfLunchPrice();
			JTextArea jtaSpec = lav.getJtaLunchSpec();

			if (jtfName.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(lav, "도시락 이름은 필수 입력입니다.");
				jtfName.setText("");
				jtfName.requestFocus();
				return;
			}
	
			if (jtfPrice.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(lav, "도시락 가격은 필수 입력입니다.");
				jtfPrice.setText("");
				jtfPrice.requestFocus();
				return;
			}
			
			int price = 0;
			try {
				price = Integer.parseInt(jtfPrice.getText().trim());
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(lav, "도시락 가격은 숫자만 입력가능합니다.");
				jtfPrice.setText("");
				jtfPrice.requestFocus();
				return;
			}
			
			if (jtaSpec.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(lav, "도시락 상세설명은 필수 입력입니다.");
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
