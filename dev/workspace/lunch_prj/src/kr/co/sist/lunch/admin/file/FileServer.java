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
					System.out.println("서버가동");
					client = server.accept();
					System.out.println("접속자 있음");
					
					dis = new DataInputStream(client.getInputStream());
					
					cnt = dis.readInt(); // 클라이언트가 보내오는 파일명의 수
					fileNames = new String[cnt];
					
					for(int i=0; i<cnt; i++) {
						fileNames[i] = dis.readUTF();
						System.out.println(i+"번째 파일 "+fileNames[i]);
					}
					
					// 서버에 존재하는 파일명을 배열로 복사
					serverFileNames = new String[LunchAdminMain.lunchImageList.size()];
					
					LunchAdminMain.lunchImageList.toArray(serverFileNames);
					
					// 클라이언트가 보내온 파일명과 서버의 파일명을 비교하여
					// 클라이언트가 없는 파일명을 출력

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
					dos.writeInt(tempFileList.size()); // 전송할 파일의 개수를 보냄

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
			JOptionPane.showMessageDialog(null, "파일 보내기 실패");
			e.printStackTrace();
		}
	}
	
	private void fileSend(String fName,	DataOutputStream dos) throws IOException {
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(new File("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+fName));
			
			int fileData = 0; // 파일의 크기(바이트 배열을 몇번 보내야 하는지)
			int fileLen = 0; // 512바이트로 읽어들였을 때 길이 
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
