package kr.co.sist.chat.server.helper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 * 서버에서 생성하며 접속자 소켓에 스트림을 얻어와서 관리하는 클래스<br>
 * 접속자가 존재하면 접속자 소켓에 얻어낸 스트림에서 메세지를 무한루프로 읽어들이고
 * 모든 접속자에게 메세지 출력
 * @author owner
 */
public class MultiChatServerHelper extends Thread {
	
	private Socket someClient;
	private DefaultListModel<String> dlm;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private List<MultiChatServerHelper> connectList;
	private JFrame jf;
	private JScrollPane jsp;
	private String nick;
	private int cnt;
	
	/**
	 * 접속자 소켓을 받아서 스트림을 얻어 메세지를 읽거나 보낼 수 있는 상태로 만든다.
	 * @param socket 접속자 소켓
	 * @param dlm 접속자 관리창을 사용하기 위한 Model 객체
	 * @param cnt 접속순서
	 */
	public MultiChatServerHelper(Socket socket, DefaultListModel<String> dlm,
			JFrame jf, List<MultiChatServerHelper> list, JScrollPane jsp, int cnt) {
		someClient = socket;
		this.dlm = dlm;
		this.jf = jf;
		connectList = list;
		this.jsp = jsp;
		this.cnt = cnt;
		
//		InetAddress ia = null; // 접속자의 IP address를 얻기위한 객체
		// 스트림 얻기
		try {
			readStream = new DataInputStream(someClient.getInputStream());
			writeStream = new DataOutputStream(someClient.getOutputStream());
			
			// 접속자가 보내오는 nick을 받는다.
			nick = readStream.readUTF();
//			ia = someClient.getInetAddress();
			dlm.addElement("["+someClient.getInetAddress()+" / "+nick+"]님 접속.");
			// 서버에 접속한 모든 접속자에게 메세지를 출력
			broadcast("["+cnt+"]번째 접속자 ["+nick+"]님이 채팅방에 접속하였습니다.");
			jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(jf, "접속자 연결 중 문제 발생...");
			ie.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		if (readStream != null) {
			
			String revMsg = null;
			try {
				while(true) { // 서버에서 보내오는 모든 메세지를 읽어서, 모든 접속자에 뿌린다.
					revMsg = readStream.readUTF();
					broadcast(revMsg);
				}
			} catch (IOException e) {
				// 접속자가 퇴실하면 해당 접속자를 리스트에서 삭제한다.
				connectList.remove(this);
				// 메시지를 읽어들이지 못하는 상태라면 접속자가 연결을 종료한 상태
				dlm.addElement("["+nick+"]님 퇴실");
				broadcast("["+nick+"]님이 퇴실하였습니다.");
				jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				e.printStackTrace();	
			}
		}
	}
	
	/**
	 * 모든 접속자에게 메세지를 뿌려주는 method
	 * synchronized : MultiThread에서 동시호출 막기 (동기화 처리)
	 * @param msg
	 */
	public synchronized void broadcast(String msg) {
		
		MultiChatServerHelper mcsh = null;
		try {
			for(int i=0; i<connectList.size(); i++) {
				mcsh = connectList.get(i); // list에서 Helper객체를 얻고
				mcsh.writeStream.writeUTF(msg); // 출력스트림에 출력
				mcsh.writeStream.flush(); // 목적지로 분출
			}
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(jf,
					"["+nick+"]님에게 메세지를 보낼 수 없습니다.");
			ie.printStackTrace();
		}
	}
}
