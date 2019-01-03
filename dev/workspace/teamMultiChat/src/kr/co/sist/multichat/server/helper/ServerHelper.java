package kr.co.sist.multichat.server.helper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ServerHelper extends Thread {
	private String nick;
	private Socket someClient;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private List<ServerHelper> connectList;
	private JFrame jf;
	private JScrollPane jspChatDisplay;
	private JTextArea jtaChatDisplay;
	
	public ServerHelper(Socket socket, JFrame jf,
		List<ServerHelper> list, JTextArea jtaChatDisplay, JScrollPane jspChatDisplay) {
		someClient = socket;
		this.jf = jf;
		connectList =list;
		this.jtaChatDisplay = jtaChatDisplay;
		this.jspChatDisplay = jspChatDisplay;
		
		try {
			readStream = new DataInputStream(someClient.getInputStream());
			writeStream = new DataOutputStream(someClient.getOutputStream());
			
			nick = readStream.readUTF();
			broadcast("["+nick+"]님이 채팅방에 접속 하였습니다");
			jtaChatDisplay.setText("["+nick+"]님이 채팅방에 접속 하였습니다\n");
			jspChatDisplay.getVerticalScrollBar().setValue(jspChatDisplay.getVerticalScrollBar().getMaximum());

		}catch(IOException ie) {
			JOptionPane.showMessageDialog(jf, "접속자 연결 중 문제가 발생...");
			ie.printStackTrace();
		}//end catch
	}//ServerHelper
	
	@Override
	public void run() {
		if(readStream !=null) {
			try {
				String revMsg = "";
				while (true) {
					revMsg = readStream.readUTF();
					broadcast(revMsg);
					jtaChatDisplay.append(revMsg+"\n");
					jspChatDisplay.getVerticalScrollBar().setValue(jspChatDisplay.getVerticalScrollBar().getMaximum());
				}//end while
			}catch (IOException ie) {
				connectList.remove(this);
				jtaChatDisplay.append(nick+"님이 퇴실");
				jspChatDisplay.getVerticalScrollBar().setValue(jspChatDisplay.getVerticalScrollBar().getMaximum());
				broadcast("["+nick +"]님이 퇴실하였습니다.");
				ie.printStackTrace();
			}//catch
		}//end if
	}//run
	
	public synchronized void broadcast(String msg) {
		ServerHelper sh = null;
		try {
			for (int i = 0; i < connectList.size(); i++) {
				sh = connectList.get(i);
				sh.writeStream.writeUTF(msg);
				sh.writeStream.flush();
			} // end for
		}catch(IOException ie) {
			JOptionPane.showMessageDialog(jf, "[" +nick +"]님에게 메세지를 보낼 수 없습니다.");
			ie.printStackTrace();
		}//end catch
	}//broadcast
}//class
