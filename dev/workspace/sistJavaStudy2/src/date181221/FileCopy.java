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
		super("파일 복사");
		
		jb = new JButton("파일 선택");
		jpb = new JProgressBar(0, 100);
		jpb.setString("진척도");
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
		FileDialog fd = new FileDialog(this, "선택", FileDialog.LOAD);
		fd.setVisible(true);
		
		String path = fd.getDirectory();
		String name = fd.getFile();
		
		if (path != null) { // 파일 선택시
			File file = new File(path+name);
			
			try {
				copy(file);
				JOptionPane.showMessageDialog(this, file+" 복사 성공.");
			} catch (FileNotFoundException fnfe) {
				JOptionPane.showMessageDialog(this, "파일이 존재하지 않습니다.");
				fnfe.printStackTrace();
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(this, "입출력 작업에 문제가 발생.");
				ie.printStackTrace();
			}
		}
	}
	
	
	public void copy(File file) throws FileNotFoundException, IOException {
		int selectValue = JOptionPane.showConfirmDialog(this, "파일을 복사하시겠습니까?");
		switch(selectValue) {
		case JOptionPane.OK_OPTION :
			StringBuilder copyFileName = new StringBuilder(file.getAbsolutePath());
			copyFileName.insert(copyFileName.lastIndexOf("."), "_bak");
			
			FileInputStream fis = null;
			FileOutputStream fos = null;
			
			try {
				// 원본 파일에 스트림 연결
				fis = new FileInputStream(file);
				fos = new FileOutputStream(copyFileName.toString());
				
				// 파일과 연결된 스트림에서 값을 얻는다.
				// HDD가 읽어들이는 크기를 무시하고 1byte씩 읽어들여 사용
				int temp = 0;
				int i = 0;
				fileLen = file.length();
				
				while( (temp = fis.read()) != -1 ) {
					// 읽어 들인 내용을 _bak가 붙은 파일을 생성하여 출력(복사)
					fos.write(temp);
					fos.flush();
					// Thread를 사용해야 프로그레스바 구현가능, 값은 찍힘
					jpb.setValue((int)(i/(double)fileLen*100));
					System.out.println(jpb.getValue());
					i++;
				}
				
				/*// HDD가 읽어들이는 크기를 그대로 사용
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
