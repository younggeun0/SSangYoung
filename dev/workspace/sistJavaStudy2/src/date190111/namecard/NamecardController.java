package date190111.namecard;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class NamecardController extends WindowAdapter implements ActionListener {

	private NamecardView nv;
	private NamecardDAO n_dao;
	private String imagePath;
	
	public NamecardController(NamecardView nv) {
		this.nv = nv;
		n_dao = NamecardDAO.getInstance();
		setAllNamecard(); // 테이블에 데이터를 추가한다.
		imagePath = "";
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nv.getBtnImg()) {
			selectFile();
		}
		
		if (e.getSource() == nv.getBtnAdd()) {
			// 생성자에서만 DAO 객체를 얻으면 중간에 인스턴스가 죽는다면 문제가 발생
			// 추가 버튼을 누를 때마다 DAO를 얻어와서 살리도록 한다.
			n_dao = NamecardDAO.getInstance();
			addNamecard();
		}
	}
	
	private void selectFile() {
		FileDialog fdOpen = new FileDialog(nv, "이미지 선택", FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		System.out.println(fdOpen.getDirectory());
		System.out.println(fdOpen.getFile());
		
		String path = fdOpen.getDirectory();
		String fileName = fdOpen.getFile();
		System.out.println(path+fileName);
		
		if (path != null) {
			imagePath = path + fileName;
			
			JLabel jl = nv.getJlPreview();
			jl.setIcon(new ImageIcon(imagePath));
		}
	}
	
	private void addNamecard() {
		JTextField jtfName = nv.getJtfName();
		JTextField jtfAddr = nv.getJtfAddr();
		
		String name = jtfName.getText().trim();
		String addr = jtfAddr.getText().trim();
		
		if (name.equals("")) {
			JOptionPane.showMessageDialog(nv, "이름은 필수 입력");
			nv.getJtfName().requestFocus();
			return;
		}
		if (addr.equals("")) {
			JOptionPane.showMessageDialog(nv, "주소는 필수 입력");
			nv.getJtfAddr().requestFocus();
			return;
		}
		
		boolean insertFlag = false;
		if (imagePath.isEmpty()) {
			insertFlag =  
				JOptionPane.showConfirmDialog(nv, "기본 이미지로 하시겠습니까?") 
				== JOptionPane.OK_OPTION;
			if (insertFlag) { // 이미지를 선택하지 않고 기본이미지 선택했을 때 
				imagePath = "no_image.png";
			}
		} else { // 이미지를 선택했을 때
			insertFlag = true;
		}

		if (insertFlag) {
			// DB에 추가
				// 변경된 파일명으로 지정한 위치에 업로드를 수행한 후 DB에 추가
				
			StringBuilder filePath = new StringBuilder();
			filePath
			.append(String.valueOf(System.currentTimeMillis()))
			.append(imagePath.substring(imagePath.lastIndexOf(".")));
			
			try {
				// 기본 이미지가 아니라면 업로드 수행
				if(!imagePath.equals("no_image.png")) {
					uploadImage(filePath.toString());
				}
				
				// DB에 추가한다.
				NamecardVO nvo = new NamecardVO(name, addr, 
					!imagePath.equals("no_image.png")? filePath.toString() : "no_image.png");
				n_dao.insertNamecard(nvo);				
				JOptionPane.showMessageDialog(nv, "명함이 추가되었습니다.");
				
				// 추가 후 초기화
				jtfName.setText("");
				jtfAddr.setText("");
				nv.getJlPreview().setIcon(new ImageIcon(
						"C:/Users/owner/youngRepositories/SSangYoung"
							+ "/dev/workspace/sistJavaStudy2/src/date190111"
							+ "/upload/no_image.png"));
				jtfName.requestFocus();
				
				setAllNamecard();
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(nv, "이미지 업로드 중 문제 발생");
				ie.printStackTrace();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(nv, "명함 추가 중 문제 발생");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 조회된 명함 정보를 JTable에 추가하는 일을 한다.
	 */
	private void setAllNamecard() {
		try {
			List<NamecardVO> list = n_dao.selectAllNamecard();
			
			nv.getDtmNamecard().setRowCount(0); // 데이터를 출력하기 전 초기화

			Object[] rowData = null;
			NamecardVO tempVO = null;
			for(int i=0; i<list.size(); i++) { // 조회된 레코드 수만큼 반복
				tempVO = list.get(i);
				rowData = new Object[]
					{ new Integer(i+1), 
					  new ImageIcon("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/sistJavaStudy2/src/date190111/upload/"
							+tempVO.getImg()), 
					  tempVO.getName(), 
					  tempVO.getAddr() };
				nv.getDtmNamecard().addRow(rowData);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(nv, "ㅈㅅ!");
			e.printStackTrace();
		}
	}
	
	/**
	 * 원본 파일을 복사하여 지정한 위치에 생성한다.
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	private boolean uploadImage(String filePath) throws IOException {
		boolean flag = false;
		
		FileInputStream fis = new FileInputStream(imagePath);
		FileOutputStream fos = 
			new FileOutputStream(
				"C:/Users/owner/youngRepositories/SSangYoung"
					+ "/dev/workspace/sistJavaStudy2/src/date190111/upload/"+filePath);
		
		try {
			// 파일 읽어들이기
			byte[] readData = new byte[512];
			int byteSize = 0;
			
			while ((byteSize = fis.read(readData)) != -1) {
				fos.write(readData, 0, byteSize);
				fos.flush();
			}
			
		} finally {
			if (fos != null) { fos.close(); }
			if (fis != null) { fis.close(); }
		}
		
		return flag;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		nv.dispose();
	}
}
