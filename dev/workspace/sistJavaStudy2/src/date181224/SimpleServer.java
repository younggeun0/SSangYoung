package date181224;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * port(1~66535 �� �ϳ�)�� ���� ������ ������ �޴� ��.  
 * @author owner
 */
public class SimpleServer {

	public SimpleServer() throws IOException {
		
		// 1. PORT�� ���� �����ڰ� �����⸦ ��ٸ���.
		ServerSocket server = null;
		// �����ڿ��� ������ �޽���
		String msg = "�� �� * ����\n" + 
				" ��  ��  ��  \n" + 
				"(^^)('')('')\n" + 
				"������������\n" + 
				"�޸�ũ��������\n" + 
				"���Ǵ��̾�~ -������-";
		// �����ڿ��� �޽����� ������ ���� ��Ʈ���� ����
		DataOutputStream dos = null;
		try {
			server = new ServerSocket(3000);
			System.out.println("���� ������ "+server);
			while(true) {
				// 3. �����ڰ� ������ ������ ������ �޴´�.
				Socket client = server.accept();
				System.out.println("������ ���� "+client);
				
				// �����ڿ��� �޽����� ������ ���� ����
				dos = new DataOutputStream(client.getOutputStream());
				// �� ��Ʈ���� ������ ����
				dos.writeUTF(msg);
				// ��Ʈ���� �����͸� ������(����)�� ����
				dos.flush();
			}
			
		} finally {
			if (server != null) server.close();
			if (dos != null) dos.close();
		}
	}
	
	public static void main(String[] args) {
		try {
			new SimpleServer();
		} catch (IOException e) {
			System.out.println("��Ʈ�� �̹� ������Դϴ�.");
			e.printStackTrace();
		}
	}
}
