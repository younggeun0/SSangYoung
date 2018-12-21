package date181221;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class FileCopy extends JFrame implements ActionListener{

	private JButton jb;
	private JProgressBar jpb;
	private long fileLen;
	
	public FileCopy() {
		super("���� ����");
		
		jb = new JButton("���� ����");
		jpb = new JProgressBar(0, 100);
		jpb.setString("��ô��");
		jpb.setStringPainted(true);
		jpb.setValue(50);
		
		JPanel jp = new JPanel();
		jp.add(jb);
		
		add("Center",jp);
		add("South",jpb);
		
		jb.addActionListener(this);
		
		setBounds(100, 100, 500, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		FileDialog fd = new FileDialog(this, "����", FileDialog.LOAD);
		fd.setVisible(true);
		
		String path = fd.getDirectory();
		String name = fd.getFile();
		
		if (path != null) { // ���� ���ý�
			File file = new File(path+name);
			
			try {
				copy(file);
				JOptionPane.showMessageDialog(this, file+" ���� ����.");
			} catch (FileNotFoundException fnfe) {
				JOptionPane.showMessageDialog(this, "������ �������� �ʽ��ϴ�.");
				fnfe.printStackTrace();
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(this, "����� �۾��� ������ �߻�.");
				ie.printStackTrace();
			}
		}
	}
	
	
	public void copy(File file) throws FileNotFoundException, IOException {
		int selectValue = JOptionPane.showConfirmDialog(this, "������ �����Ͻðڽ��ϱ�?");
		switch(selectValue) {
		case JOptionPane.OK_OPTION :
			StringBuilder copyFileName = new StringBuilder(file.getAbsolutePath());
			copyFileName.insert(copyFileName.lastIndexOf("."), "_bak");
			
			FileInputStream fis = null;
			FileOutputStream fos = null;
			
			try {
				// ���� ���Ͽ� ��Ʈ�� ����
				fis = new FileInputStream(file);
				fos = new FileOutputStream(copyFileName.toString());
				
				// ���ϰ� ����� ��Ʈ������ ���� ��´�.
				// HDD�� �о���̴� ũ�⸦ �����ϰ� 1byte�� �о�鿩 ���
				int temp = 0;
				int i = 0;
				fileLen = file.length();
				
				while( (temp = fis.read()) != -1 ) {
					// �о� ���� ������ _bak�� ���� ������ �����Ͽ� ���(����)
					fos.write(temp);
					fos.flush();
					// Thread�� ����ؾ� ���α׷����� ��������, ���� ����
					jpb.setValue((int)(i/(double)fileLen*100));
					System.out.println(jpb.getValue());
					i++;
				}
				
				/*// HDD�� �о���̴� ũ�⸦ �״�� ���
				byte[] temp = new byte[512];
				int len = 0;
				while ((len = fis.read(temp)) != -1) {
					
					fos.write(temp,0,len);
					fos.flush();
				}*/
				
			} finally {
				if (fis != null) fis.close();
				if (fos != null) fos.close();
			}
		}
	}
	
	public static void main(String[] args) {
		new FileCopy();
	}
}
