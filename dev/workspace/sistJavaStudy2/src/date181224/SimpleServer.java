package date181224;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * port(1~66535 중 하나)를 열고 접속자 소켓을 받는 일.  
 * @author owner
 */
public class SimpleServer {

	public SimpleServer() throws IOException {
		
		// 1. PORT를 열고 접속자가 들어오기를 기다린다.
		ServerSocket server = null;
		// 접속자에게 보내줄 메시지
		String msg = "☆ ˚ * ˚★\n" + 
				" ▲  △  ▲  \n" + 
				"(^^)('')('')\n" + 
				"▶◀▶◀▶◀\n" + 
				"메리크리스마스\n" + 
				"해피뉴이어~ -오영근-";
		// 접속자에게 메시지를 보내기 위한 스트림을 선언
		DataOutputStream dos = null;
		try {
			server = new ServerSocket(3000);
			System.out.println("서버 가동중 "+server);
			while(true) {
				// 3. 접속자가 들어오면 접속자 소켓을 받는다.
				Socket client = server.accept();
				System.out.println("접속자 있음 "+client);
				
				// 접속자에게 메시지를 보내기 위한 연결
				dos = new DataOutputStream(client.getOutputStream());
				// 얻어낸 스트림에 데이터 쓰기
				dos.writeUTF(msg);
				// 스트림의 데이터를 목적지(소켓)로 분출
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
			System.out.println("포트가 이미 사용중입니다.");
			e.printStackTrace();
		}
	}
}
