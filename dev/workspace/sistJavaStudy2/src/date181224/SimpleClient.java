package date181224;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

/**
 * ������ �ּҿ� PORT�� ������ ������ ������ �õ�
 * @author owner
 */
public class SimpleClient {
	
	public SimpleClient() throws UnknownHostException, IOException {
		// 2. ������ ���� : �� ��ǻ�Ϳ� �� ���� localhost �Ǵ� 127.0.0.1(������)
		// �ٸ� ��ǻ�Ϳ� �� ������ ip address
		Socket client = null;
		// 3. �������� �������� �޽����� �б����� ��Ʈ��
		DataInputStream dis = null;
		// ������ �޽����� ������ ���� ��Ʈ��
		DataOutputStream dos = null;
		try {
			String ip = JOptionPane.showInputDialog(""
					+ "���� ip\n130,132.133.134,135,157,146"
					+ ",131,141,142,143,144,155,146,148,149,151,152,153");
			client = new Socket("211.63.89."+ip,65535);
			System.out.println("������ ���� �Ͽ����ϴ�. "+client);
			// 7. ���Ͽ��� ��Ʈ�� ���
			dis = new DataInputStream(client.getInputStream());
			
			// 8. �������� ������ �޽��� �б�
			String revMsg = dis.readUTF();
			JOptionPane.showMessageDialog(null, "������ �޽��� : "+revMsg);
			
			// 9. ������ �����͸� ������ ���� ��Ʈ���� ���Ͽ������� ��´�.
			String sendMsg = "����ü �״���� �� ������ ������ġ������ �ƴϸ� �ް��� �˸���������� �װ� �� ���� ���� ���̾�!";
			dos = new DataOutputStream(client.getOutputStream());
			// 10. �غ�� �޽����� ��Ʈ���� ���
			dos.writeUTF(sendMsg);
			// 11. ��Ʈ���� ��ϵ� �����͸� ������(����)�� ����
			dos.flush();
		} finally {
			if(client != null) client.close();
			if(dis != null) dis.close();
			if(dos != null) dos.close();
		}
	}
	
	public static void main(String[] args) {
		try {
			new SimpleClient();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
