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
 * �������� �����ϸ� ������ ���Ͽ� ��Ʈ���� ���ͼ� �����ϴ� Ŭ����<br>
 * �����ڰ� �����ϸ� ������ ���Ͽ� �� ��Ʈ������ �޼����� ���ѷ����� �о���̰�
 * ��� �����ڿ��� �޼��� ���
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
	 * ������ ������ �޾Ƽ� ��Ʈ���� ��� �޼����� �аų� ���� �� �ִ� ���·� �����.
	 * @param socket ������ ����
	 * @param dlm ������ ����â�� ����ϱ� ���� Model ��ü
	 * @param cnt ���Ӽ���
	 */
	public MultiChatServerHelper(Socket socket, DefaultListModel<String> dlm,
			JFrame jf, List<MultiChatServerHelper> list, JScrollPane jsp, int cnt) {
		someClient = socket;
		this.dlm = dlm;
		this.jf = jf;
		connectList = list;
		this.jsp = jsp;
		this.cnt = cnt;
		
//		InetAddress ia = null; // �������� IP address�� ������� ��ü
		// ��Ʈ�� ���
		try {
			readStream = new DataInputStream(someClient.getInputStream());
			writeStream = new DataOutputStream(someClient.getOutputStream());
			
			// �����ڰ� �������� nick�� �޴´�.
			nick = readStream.readUTF();
//			ia = someClient.getInetAddress();
			dlm.addElement("["+someClient.getInetAddress()+" / "+nick+"]�� ����.");
			// ������ ������ ��� �����ڿ��� �޼����� ���
			broadcast("["+cnt+"]��° ������ ["+nick+"]���� ä�ù濡 �����Ͽ����ϴ�.");
			jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(jf, "������ ���� �� ���� �߻�...");
			ie.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		if (readStream != null) {
			
			String revMsg = null;
			try {
				while(true) { // �������� �������� ��� �޼����� �о, ��� �����ڿ� �Ѹ���.
					revMsg = readStream.readUTF();
					broadcast(revMsg);
				}
			} catch (IOException e) {
				// �����ڰ� ����ϸ� �ش� �����ڸ� ����Ʈ���� �����Ѵ�.
				connectList.remove(this);
				// �޽����� �о������ ���ϴ� ���¶�� �����ڰ� ������ ������ ����
				dlm.addElement("["+nick+"]�� ���");
				broadcast("["+nick+"]���� ����Ͽ����ϴ�.");
				jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				e.printStackTrace();	
			}
		}
	}
	
	/**
	 * ��� �����ڿ��� �޼����� �ѷ��ִ� method
	 * synchronized : MultiThread���� ����ȣ�� ���� (����ȭ ó��)
	 * @param msg
	 */
	public synchronized void broadcast(String msg) {
		
		MultiChatServerHelper mcsh = null;
		try {
			for(int i=0; i<connectList.size(); i++) {
				mcsh = connectList.get(i); // list���� Helper��ü�� ���
				mcsh.writeStream.writeUTF(msg); // ��½�Ʈ���� ���
				mcsh.writeStream.flush(); // �������� ����
			}
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(jf,
					"["+nick+"]�Կ��� �޼����� ���� �� �����ϴ�.");
			ie.printStackTrace();
		}
	}
}
