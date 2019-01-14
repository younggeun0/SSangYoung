package date190114;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 * 선택한 파일을 서버로 전송하는 파일 클라이언트
 * @author owner
 */
@SuppressWarnings("serial")
public class FileClient extends JFrame implements ActionListener {

	private JButton btnSelectFile;
	private DefaultListModel<String> dlmFileList;
	
	public FileClient() {
		super("파일 전송");
		
		btnSelectFile = new JButton("파일 선택");
		dlmFileList = new DefaultListModel<String>();
		JList<String> listFile = new JList<String>(dlmFileList);
		
		JScrollPane jspFileList = new JScrollPane(listFile);
		jspFileList.setBorder(new TitledBorder("전송한 파일"));
		
		JPanel panel = new JPanel();
		panel.add(btnSelectFile);
		
		add(BorderLayout.CENTER, jspFileList);
		add(BorderLayout.SOUTH, panel);
		
		btnSelectFile.addActionListener(this);

		setBounds(300,100,400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void selectFile() {
		FileDialog fdOpen = new FileDialog(this, "파일 선택", FileDialog.LOAD);
		fdOpen.setVisible(true);
	
		String fPath = fdOpen.getDirectory();
		String fName = fdOpen.getFile();

		if (fName != null) {
			// 이미지 파일(.jpg, .jpeg, .gif, .png, .bmp)만 전송
			// 선택한 파일이 위의 파일이 아닌 경우 경고창 출력
			String ext = fName.substring(fName.lastIndexOf(".")+1).toLowerCase();
			String[] arrCompare = { "jpg", "jpeg", "gif", "png", "bmp" };
			
			boolean extFlag = false;
			
			for (String tempExt : arrCompare) {
				if (ext.equals(tempExt)) {
					extFlag = true;
				}
			}
		
			if (!extFlag) {
				JOptionPane.showMessageDialog(this, fName+"은 전송가능한 파일이 아닙니다.\n이미지만 전송가능합니다.");
				return;
			}
			
			// 파일 전송
			try {
				sendFile(new File(fPath+fName));
				JOptionPane.showMessageDialog(this, fName+"파일을 전송하였습니다.");
				dlmFileList.addElement(fName);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(fdOpen.getFile());
	}
	
	private void sendFile(File file) throws UnknownHostException, IOException {
		// 서버에 접속
		Socket socketClient = null;
		DataOutputStream dos = null;
		FileInputStream fis = null;
		
		try {
			String ip = JOptionPane.showInputDialog("서버 ip");
			socketClient = new Socket("211.63.89."+ip, 10000);

			String fName = file.getName();
			
			// 1. 파일명 전송
			dos = new DataOutputStream(socketClient.getOutputStream());
			dos.writeUTF(fName);
			dos.flush();
			
			// 3. 전송할 파일의 byte[]의 개수를 서버에 전송
			int dataCnt = 0;
			
			fis = new FileInputStream(file);
			byte[] tempData = new byte[512];
			int dataLen = 0;
			
			List<byte[]> listArrByte = new ArrayList<byte[]>();
			byte[] arrByte = null;
			while((dataLen = fis.read(tempData)) != -1) {
				arrByte = new byte[dataLen];
				for(int i=0; i<dataLen; i++) {
					arrByte[i] = tempData[i];
				}
				listArrByte.add(arrByte);
				dataCnt++;
			}
			fis.close();
			
			dos.writeInt(dataCnt); // 서버가 읽어들일 배열의 개수
			dos.flush();
			
			// 5. 파일에서 읽어들인 내용을 전송한다.
			fis = new FileInputStream(file);
			int i = 0;
			while(dataCnt > 0) {
				arrByte = listArrByte.get(i);
				
				dos.write(arrByte, 0, arrByte.length);
				dos.flush();
				dataCnt--;
				i++;
			}
			
		} finally {
			if (dos != null) { dos.close(); }
			if (fis != null) { fis.close(); }
			if (socketClient != null) { socketClient.close(); }
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		selectFile();
	}
	
	public static void main(String[] args) {
		new FileClient();
	}
}
