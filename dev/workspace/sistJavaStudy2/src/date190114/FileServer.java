package date190114;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 * 접속자가 보내오는 파일을 저장하는 서버
 * @author owner
 */
@SuppressWarnings("serial")
public class FileServer extends JFrame implements Runnable, ActionListener {

	private DefaultListModel<String> dlmFileList;
	private JButton btnStartServer;
	private Thread threadServer;
	private ServerSocket socketServerFile;
	
	public FileServer() {
		super("파일 서버");
		
		dlmFileList = new DefaultListModel<String>();
		JList<String> listFile = new JList<String>(dlmFileList);
		
		btnStartServer = new JButton("서버 가동");
		
		JScrollPane jsp = new JScrollPane(listFile);
		jsp.setBorder(new TitledBorder("파일 목록"));
		
		JPanel panel = new JPanel();
		panel.add(btnStartServer);
		
		add(BorderLayout.CENTER, jsp);
		add(BorderLayout.SOUTH, panel);
		
		btnStartServer.addActionListener(this);
		
		setBounds(900, 100, 400, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void run() {
		try {
			Socket socketClient = null;
			DataInputStream dis = null;
			StringBuilder fName = new StringBuilder();
			int dataCnt = 0;
			FileOutputStream fos = null;
			File file = null;
			byte[] readData = null;
			int dataLen = 0;
			try {
				while(true) {
					// 접속자 소켓이 존재할 때 
					socketClient = socketServerFile.accept();
					
					// 2. 클라이언트가 전송하는 파일명을 저장
					dis = new DataInputStream(socketClient.getInputStream());

					fName.delete(0, fName.length());
					fName.append(dis.readUTF());
					// 파일명을 겹치지 않도록 변경
					fName.insert(fName.lastIndexOf("."), "_".concat(String.valueOf(System.currentTimeMillis())));
					dlmFileList.addElement(fName.toString()+" "+socketClient.getInetAddress());
					
					// 4. 클라이언트가 전송하는 배열의 개수(읽어들일 횟수)를 받는다. 
					dataCnt = dis.readInt();
					
					// 6. 전송받는 배열의 개수만큼 파일을 읽어 들여 파일로 내보낸다.
					file = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/sistJavaStudy2/src/date190114/images/"+fName);
					fos = new FileOutputStream(file);

					readData = new byte[512];
					while(dataCnt > 0) {
						dataLen = dis.read(readData); // 클라이언트가 전송하는 배열의 크기만큼을 받아서
						fos.write(readData, 0, dataLen); // 파일에 기록
						fos.flush();
						dataCnt--;  //  
					}
				}
			} finally {
				if (fos != null) { fos.close(); }
				if (dis != null) { dis.close(); }
				if (socketClient != null) { socketClient.close(); }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (threadServer == null) {
			try {
				socketServerFile = new ServerSocket(10000);
				dlmFileList.addElement("서버가 10000번 포트로 실행되었습니다.");
	
				threadServer = new Thread(this);
				threadServer.start();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(this, "PORT가 이미 사용중입니다.");
				e1.printStackTrace();
			}
				
		} else {
			JOptionPane.showMessageDialog(this, "서버가 이미 동작중입니다.");
		}
		
	}

	public static void main(String[] args) {
		new FileServer();
	}
}
