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
		setAllNamecard(); // ���̺� �����͸� �߰��Ѵ�.
		imagePath = "";
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nv.getBtnImg()) {
			selectFile();
		}
		
		if (e.getSource() == nv.getBtnAdd()) {
			// �����ڿ����� DAO ��ü�� ������ �߰��� �ν��Ͻ��� �״´ٸ� ������ �߻�
			// �߰� ��ư�� ���� ������ DAO�� ���ͼ� �츮���� �Ѵ�.
			n_dao = NamecardDAO.getInstance();
			addNamecard();
		}
	}
	
	private void selectFile() {
		FileDialog fdOpen = new FileDialog(nv, "�̹��� ����", FileDialog.LOAD);
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
			JOptionPane.showMessageDialog(nv, "�̸��� �ʼ� �Է�");
			nv.getJtfName().requestFocus();
			return;
		}
		if (addr.equals("")) {
			JOptionPane.showMessageDialog(nv, "�ּҴ� �ʼ� �Է�");
			nv.getJtfAddr().requestFocus();
			return;
		}
		
		boolean insertFlag = false;
		if (imagePath.isEmpty()) {
			insertFlag =  
				JOptionPane.showConfirmDialog(nv, "�⺻ �̹����� �Ͻðڽ��ϱ�?") 
				== JOptionPane.OK_OPTION;
			if (insertFlag) { // �̹����� �������� �ʰ� �⺻�̹��� �������� �� 
				imagePath = "no_image.png";
			}
		} else { // �̹����� �������� ��
			insertFlag = true;
		}

		if (insertFlag) {
			// DB�� �߰�
				// ����� ���ϸ����� ������ ��ġ�� ���ε带 ������ �� DB�� �߰�
				
			StringBuilder filePath = new StringBuilder();
			filePath
			.append(String.valueOf(System.currentTimeMillis()))
			.append(imagePath.substring(imagePath.lastIndexOf(".")));
			
			try {
				// �⺻ �̹����� �ƴ϶�� ���ε� ����
				if(!imagePath.equals("no_image.png")) {
					uploadImage(filePath.toString());
				}
				
				// DB�� �߰��Ѵ�.
				NamecardVO nvo = new NamecardVO(name, addr, 
					!imagePath.equals("no_image.png")? filePath.toString() : "no_image.png");
				n_dao.insertNamecard(nvo);				
				JOptionPane.showMessageDialog(nv, "������ �߰��Ǿ����ϴ�.");
				
				// �߰� �� �ʱ�ȭ
				jtfName.setText("");
				jtfAddr.setText("");
				nv.getJlPreview().setIcon(new ImageIcon(
						"C:/Users/owner/youngRepositories/SSangYoung"
							+ "/dev/workspace/sistJavaStudy2/src/date190111"
							+ "/upload/no_image.png"));
				jtfName.requestFocus();
				
				setAllNamecard();
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(nv, "�̹��� ���ε� �� ���� �߻�");
				ie.printStackTrace();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(nv, "���� �߰� �� ���� �߻�");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ��ȸ�� ���� ������ JTable�� �߰��ϴ� ���� �Ѵ�.
	 */
	private void setAllNamecard() {
		try {
			List<NamecardVO> list = n_dao.selectAllNamecard();
			
			nv.getDtmNamecard().setRowCount(0); // �����͸� ����ϱ� �� �ʱ�ȭ

			Object[] rowData = null;
			NamecardVO tempVO = null;
			for(int i=0; i<list.size(); i++) { // ��ȸ�� ���ڵ� ����ŭ �ݺ�
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
			JOptionPane.showMessageDialog(nv, "����!");
			e.printStackTrace();
		}
	}
	
	/**
	 * ���� ������ �����Ͽ� ������ ��ġ�� �����Ѵ�.
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
			// ���� �о���̱�
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
