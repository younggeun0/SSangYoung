package date181224;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * port(1~66535 �� �ϳ�)�� ���� ������ ������ �޴� ��.  
 * @author owner
 */
public class SimpleServer {

	public SimpleServer() throws IOException {
		
		// 1. PORT�� ���� �����ڰ� �����⸦ ��ٸ���.
		ServerSocket server = null;
		// �����ڿ��� ������ �޽���
		String msg = "���� ��ħ�Ҹ��� �����°�";
		// �����ڿ��� �޽����� ������ ���� ��Ʈ���� ����
		DataOutputStream dos = null;
		// �����ڰ� �������� �޽����� �б����� ��Ʈ��
		DataInputStream dis = null;
		String revMsg = ""; // �����ڰ� ������ �޽����� ������ ����
		try {
			server = new ServerSocket(3000);
			System.out.println("���� ������ "+server);
			while(true) {
				// 3. �����ڰ� ������ ������ ������ �޴´�.
				Socket client = server.accept();
				System.out.println("������ ���� "+client);
				
				// 4. �����ڿ��� �޽����� ������ ���� ����
				dos = new DataOutputStream(client.getOutputStream());
				// 5. �� ��Ʈ���� ������ ����
				dos.writeUTF(msg);
				// 6. ��Ʈ���� �����͸� ������(����)�� ����
				dos.flush();
				// 12. Ŭ���̾�Ʈ�� �������� �޽����� �ϱ����� ��Ʈ�� ����
				dis = new DataInputStream(client.getInputStream());
				// 13. ��Ʈ������ �޽��� �б�
				revMsg = dis.readUTF();
				JOptionPane.showMessageDialog(null, "Ŭ���̾�Ʈ�� �޽���\n"+revMsg);
			}
		} finally {
			if (server != null) server.close();
			if (dos != null) dos.close();
			if (dis != null) dis.close();
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
