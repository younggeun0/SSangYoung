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
			broadcast("["+nick+"]���� ä�ù濡 ���� �Ͽ����ϴ�");
			jtaChatDisplay.setText("["+nick+"]���� ä�ù濡 ���� �Ͽ����ϴ�\n");
			jspChatDisplay.getVerticalScrollBar().setValue(jspChatDisplay.getVerticalScrollBar().getMaximum());

		}catch(IOException ie) {
			JOptionPane.showMessageDialog(jf, "������ ���� �� ������ �߻�...");
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
				jtaChatDisplay.append(nick+"���� ���");
				jspChatDisplay.getVerticalScrollBar().setValue(jspChatDisplay.getVerticalScrollBar().getMaximum());
				broadcast("["+nick +"]���� ����Ͽ����ϴ�.");
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
			JOptionPane.showMessageDialog(jf, "[" +nick +"]�Կ��� �޼����� ���� �� �����ϴ�.");
			ie.printStackTrace();
		}//end catch
	}//broadcast
}//class
