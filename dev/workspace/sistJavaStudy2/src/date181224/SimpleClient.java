package date181224;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

/**
 * 서버의 주소와 PORT를 가지고 서버에 연결을 시도
 * @author owner
 */
public class SimpleClient {
	
	public SimpleClient() throws UnknownHostException, IOException {
		// 2. 소켓을 생성 : 내 컴퓨터에 들어갈 때는 localhost 또는 127.0.0.1(루프백)
		// 다른 컴퓨터에 들어갈 때에는 ip address
		Socket client = null;
		// 서버에서 보내오는 메시지를 읽기위한 스트림
		DataInputStream dis = null;
		try {
			String ip = JOptionPane.showInputDialog(""
					+ "서버 ip\n130,132.133.134,135,157,146"
					+ ",131,141,142,143,144,155,146,148,149,151,152,153");
			client = new Socket("211.63.89."+ip,3000);
			System.out.println("서버에 접속 하였습니다. "+client);
			// 소켓에서 스트림 얻기
			dis = new DataInputStream(client.getInputStream());
			
			// 서버에서 보내온 메시지 읽기
			String revMsg = dis.readUTF();
			JOptionPane.showMessageDialog(null, "서버의 메시지 : "+revMsg);
		} finally {
			if(client != null) client.close();
			if(dis != null) dis.close();
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
