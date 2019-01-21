package kr.co.sist.lunch.admin.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import kr.co.sist.lunch.admin.run.LunchAdminMain;

public class FileServer extends Thread {

	@Override
	public void run() {
		ServerSocket server = null;
		
		try {
			try {
				server = new ServerSocket(25000);
				Socket client = null;
				DataInputStream dis = null;
				DataOutputStream dos = null;
				int cnt = 0;
				String[] fileNames = null;
				String[] serverFileNames = null;
				List<String> tempFileList = null;
				boolean flag = false;
				
				while(true) {
					System.out.println("��������");
					client = server.accept();
					System.out.println("������ ����");
					
					dis = new DataInputStream(client.getInputStream());
					
					cnt = dis.readInt(); // Ŭ���̾�Ʈ�� �������� ���ϸ��� ��
					fileNames = new String[cnt];
					
					for(int i=0; i<cnt; i++) {
						fileNames[i] = dis.readUTF();
						System.out.println(i+"��° ���� "+fileNames[i]);
					}
					
					// ������ �����ϴ� ���ϸ��� �迭�� ����
					serverFileNames = new String[LunchAdminMain.lunchImageList.size()];
					
					LunchAdminMain.lunchImageList.toArray(serverFileNames);
					
					// Ŭ���̾�Ʈ�� ������ ���ϸ�� ������ ���ϸ��� ���Ͽ�
					// Ŭ���̾�Ʈ�� ���� ���ϸ��� ���

					tempFileList = new ArrayList<String>();
					for(String tName : LunchAdminMain.lunchImageList) {
						tempFileList.add(tName);
						tempFileList.add("s_"+tName);
					}
					for(String rmName : fileNames) {
						tempFileList.remove(rmName);
						tempFileList.remove("s_"+rmName);
					}
					
					System.out.println("=="+tempFileList);
					dos = new DataOutputStream(client.getOutputStream());
					dos.writeInt(tempFileList.size()); // ������ ������ ������ ����

					for(String fName : tempFileList) {
						fileSend(fName, dos);
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				} // end while
			} finally {
				if (server != null) { 
					server.close();
				}
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "���� ������ ����");
			e.printStackTrace();
		}
	}
	
	private void fileSend(String fName,	DataOutputStream dos) throws IOException {
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(new File("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+fName));
			
			int fileData = 0; // ������ ũ��(����Ʈ �迭�� ��� ������ �ϴ���)
			int fileLen = 0; // 512����Ʈ�� �о�鿴�� �� ���� 
			byte[] readData = new byte[512];
			while((fileLen = fis.read(readData)) != -1) {
				fileData++;
			}
			
			fis.close();
			
			dos.writeInt(fileData);
			dos.flush();
			
			dos.writeUTF(fName);
			dos.flush();
			
			fis = new FileInputStream(new File("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+fName));
			
			while((fileLen = fis.read(readData)) != -1) {
				dos.write(readData, 0, fileLen);
			}
			dos.flush();
			
		} finally {
			if (fis != null) { fis.close(); }
		}
	}
}
