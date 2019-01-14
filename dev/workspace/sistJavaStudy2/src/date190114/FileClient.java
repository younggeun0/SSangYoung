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
 * ������ ������ ������ �����ϴ� ���� Ŭ���̾�Ʈ
 * @author owner
 */
@SuppressWarnings("serial")
public class FileClient extends JFrame implements ActionListener {

	private JButton btnSelectFile;
	private DefaultListModel<String> dlmFileList;
	
	public FileClient() {
		super("���� ����");
		
		btnSelectFile = new JButton("���� ����");
		dlmFileList = new DefaultListModel<String>();
		JList<String> listFile = new JList<String>(dlmFileList);
		
		JScrollPane jspFileList = new JScrollPane(listFile);
		jspFileList.setBorder(new TitledBorder("������ ����"));
		
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
		FileDialog fdOpen = new FileDialog(this, "���� ����", FileDialog.LOAD);
		fdOpen.setVisible(true);
	
		String fPath = fdOpen.getDirectory();
		String fName = fdOpen.getFile();

		if (fName != null) {
			// �̹��� ����(.jpg, .jpeg, .gif, .png, .bmp)�� ����
			// ������ ������ ���� ������ �ƴ� ��� ���â ���
			String ext = fName.substring(fName.lastIndexOf(".")+1).toLowerCase();
			String[] arrCompare = { "jpg", "jpeg", "gif", "png", "bmp" };
			
			boolean extFlag = false;
			
			for (String tempExt : arrCompare) {
				if (ext.equals(tempExt)) {
					extFlag = true;
				}
			}
		
			if (!extFlag) {
				JOptionPane.showMessageDialog(this, fName+"�� ���۰����� ������ �ƴմϴ�.\n�̹����� ���۰����մϴ�.");
				return;
			}
			
			// ���� ����
			try {
				sendFile(new File(fPath+fName));
				JOptionPane.showMessageDialog(this, fName+"������ �����Ͽ����ϴ�.");
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
		// ������ ����
		Socket socketClient = null;
		DataOutputStream dos = null;
		FileInputStream fis = null;
		
		try {
			String ip = JOptionPane.showInputDialog("���� ip");
			socketClient = new Socket("211.63.89."+ip, 10000);

			String fName = file.getName();
			
			// 1. ���ϸ� ����
			dos = new DataOutputStream(socketClient.getOutputStream());
			dos.writeUTF(fName);
			dos.flush();
			
			// 3. ������ ������ byte[]�� ������ ������ ����
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
			
			dos.writeInt(dataCnt); // ������ �о���� �迭�� ����
			dos.flush();
			
			// 5. ���Ͽ��� �о���� ������ �����Ѵ�.
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
