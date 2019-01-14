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
 * �����ڰ� �������� ������ �����ϴ� ����
 * @author owner
 */
@SuppressWarnings("serial")
public class FileServer extends JFrame implements Runnable, ActionListener {

	private DefaultListModel<String> dlmFileList;
	private JButton btnStartServer;
	private Thread threadServer;
	private ServerSocket socketServerFile;
	
	public FileServer() {
		super("���� ����");
		
		dlmFileList = new DefaultListModel<String>();
		JList<String> listFile = new JList<String>(dlmFileList);
		
		btnStartServer = new JButton("���� ����");
		
		JScrollPane jsp = new JScrollPane(listFile);
		jsp.setBorder(new TitledBorder("���� ���"));
		
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
					// ������ ������ ������ �� 
					socketClient = socketServerFile.accept();
					
					// 2. Ŭ���̾�Ʈ�� �����ϴ� ���ϸ��� ����
					dis = new DataInputStream(socketClient.getInputStream());

					fName.delete(0, fName.length());
					fName.append(dis.readUTF());
					// ���ϸ��� ��ġ�� �ʵ��� ����
					fName.insert(fName.lastIndexOf("."), "_".concat(String.valueOf(System.currentTimeMillis())));
					dlmFileList.addElement(fName.toString()+" "+socketClient.getInetAddress());
					
					// 4. Ŭ���̾�Ʈ�� �����ϴ� �迭�� ����(�о���� Ƚ��)�� �޴´�. 
					dataCnt = dis.readInt();
					
					// 6. ���۹޴� �迭�� ������ŭ ������ �о� �鿩 ���Ϸ� ��������.
					file = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/sistJavaStudy2/src/date190114/images/"+fName);
					fos = new FileOutputStream(file);

					readData = new byte[512];
					while(dataCnt > 0) {
						dataLen = dis.read(readData); // Ŭ���̾�Ʈ�� �����ϴ� �迭�� ũ�⸸ŭ�� �޾Ƽ�
						fos.write(readData, 0, dataLen); // ���Ͽ� ���
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
				dlmFileList.addElement("������ 10000�� ��Ʈ�� ����Ǿ����ϴ�.");
	
				threadServer = new Thread(this);
				threadServer.start();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(this, "PORT�� �̹� ������Դϴ�.");
				e1.printStackTrace();
			}
				
		} else {
			JOptionPane.showMessageDialog(this, "������ �̹� �������Դϴ�.");
		}
		
	}

	public static void main(String[] args) {
		new FileServer();
	}
}
