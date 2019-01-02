package kr.co.sist.chat.client.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import kr.co.sist.chat.client.view.MultiChatClientView;

public class MultiChatClientEvt extends WindowAdapter 
	implements ActionListener, Runnable {

	private MultiChatClientView mccv;
	private Socket client;
	private Thread threadMsg;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private String nick;
	
	public MultiChatClientEvt(MultiChatClientView mccv) {
		this.mccv = mccv;
	}
	
	public void connectToServer() throws IOException, UnknownHostException {
		if (client == null) {
			nick = mccv.getJtfNick().getText().trim();
			
			if (nick.equals("")) {
				JOptionPane.showMessageDialog(mccv, "��ȭ���� �Է����ּ���.");
				mccv.getJtfNick().requestFocus();
				return;
			}
			
			String serverIp = mccv.getJtfServerIp().getText().trim();
			client = new Socket(serverIp, 35000); // �Է��� ip address�� ��ǻ�Ϳ� ����
			// ��Ʈ��
			readStream = new DataInputStream(client.getInputStream());
			writeStream = new DataOutputStream(client.getOutputStream());
			
			writeStream.writeUTF(nick);
			writeStream.flush();
			
			mccv.getJtaTalkDisplay().setText("������ �����Ͽ����ϴ�.\n��ſ� ä�� �Ǽ���.\n");
			// �޼��� �б�
			threadMsg = new Thread(this);
			threadMsg.start();
			
		} else {
			JOptionPane.showMessageDialog(mccv, client.getInetAddress().getHostName()
					+" ������ �̹� ������ �������Դϴ�.");
		}
	}
	
	/**
	 * ������ �޼����� ������ �� 
	 * @throws IOException 
	 */
	public void sendMsg() throws IOException {
		if (writeStream != null) {
			JTextField jtf = mccv.getJtfTalk();
			String msg = jtf.getText().trim();
			// JTF�� �Է��� �޼����� �о���δ�.
			if (!msg.isEmpty()) {
				// ��Ʈ���� ����
				writeStream.writeUTF("["+nick+"] : "+msg);
				// �������� ����
				writeStream.flush();
			}
			jtf.setText("");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == mccv.getJbtConnect()) {
			try {
				connectToServer();
			} catch (UnknownHostException uhe) {
				JOptionPane.showMessageDialog(mccv, "������ �� �� �����ϴ�.");
				uhe.printStackTrace();
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(mccv, "���� ����.");
				ie.printStackTrace();
			}
		}
		if (ae.getSource() == mccv.getJbtCapture()) {
			try {
				if (!mccv.getJtaTalkDisplay().getText().equals("")) {
					capture();
				} else {
					JOptionPane.showMessageDialog(mccv, "������ ��ȭ ������ �����ϴ�.");
				}
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(mccv, 
						"���Ϸ� �����ϴ� �� ������ �߻��Ͽ����ϴ�.");
				ie.printStackTrace();
			}
		}
		if (ae.getSource() == mccv.getJbtClose()) {
			mccv.dispose();
		}
		if (ae.getSource() == mccv.getJtfTalk()) {
			try {
				sendMsg();
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(mccv, 
						"������ ����Ǿ� �޼����� ������ �� �����ϴ�.");
				ie.printStackTrace();
			}
		}
	}
	
	public void capture() throws IOException {
		
		switch(JOptionPane.showConfirmDialog(mccv, "��ȭ ������ �����Ͻðڽ��ϱ�?")) {
		case JOptionPane.OK_OPTION :
			
			// ��Ʈ���� ����Ͽ� ����
			File saveDir = new File("C:/dev/chat");
			saveDir.mkdirs();
			File saveFile = new File(saveDir.getAbsolutePath()+"/java_chat["
					+System.currentTimeMillis()+"].dat");
			
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(saveFile));
				bw.write(mccv.getJtaTalkDisplay().getText()); // ��Ʈ���� ��ȭ���� ���
				bw.flush(); // ��Ʈ���� ��ϵ� ������ ����
				JOptionPane.showMessageDialog(mccv, saveDir+"�� ��ȭ������ ��ϵǾ����ϴ�.");
			} finally {
				if(bw != null) {
					try {
						bw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	@Override
	public void run() {
		if (readStream != null) {
			try {  
				String revMsg = "";
				JScrollPane jsp = mccv.getJspTalkDisplay();
				while (true) { // �������� �������� �޼����� �о� �鿩
					revMsg = readStream.readUTF();
					// ä��â�� �Ѹ���.
					mccv.getJtaTalkDisplay().append(revMsg + "\n");
					// ��ũ�ѹٸ� ���� �Ʒ��� �̵���Ų��.
					jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(mccv, "������ ����Ǿ����ϴ�.");
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		mccv.dispose();
	}
	@Override
	public void windowClosed(WindowEvent e) {
		try {
			if (readStream != null) { readStream.close(); }
			if (writeStream != null) { writeStream.close(); }
			if (client != null) { client.close(); }
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
}

