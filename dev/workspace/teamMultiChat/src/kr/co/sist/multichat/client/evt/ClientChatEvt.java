package kr.co.sist.multichat.client.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import kr.co.sist.multichat.client.view.ClientChatView;
import kr.co.sist.multichat.client.view.ClientSelectUserView;

public class ClientChatEvt extends WindowAdapter implements ActionListener, Runnable {
	private ClientChatView ccv;
	private String nick;
	private int port;
	private Socket client;
	private Thread clientThread;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private boolean serverFlag;

	public ClientChatEvt(ClientChatView ccv, int port) {
		this.ccv = ccv;
		this.port = port;
	}

	@Override
	public void run() {
		System.out.println("스레드 동작시작");
		if (readStream != null) {
			String revMsg = "";
			try {
				while (true) {
					revMsg = readStream.readUTF();
					ccv.getJtaChatDisplay().append(revMsg + "\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == ccv.getJbConnect()) {
			if (!serverFlag) {
				if (!ccv.getJtfNick().getText().isEmpty()) {
					nick = ccv.getJtfNick().getText();
					
					try {
						client = new Socket("localhost", port);
						ccv.getJtaChatDisplay().setText("서버에 접속했습니다.\n");
						
						readStream = new DataInputStream(client.getInputStream());
						writeStream = new DataOutputStream(client.getOutputStream());
						
						writeStream.writeUTF(nick);
						writeStream.flush();
						
						clientThread = new Thread(this);
						clientThread.start();
						
					} catch (UnknownHostException e) {
						e.printStackTrace();
					} catch (IOException e) {
						JOptionPane.showMessageDialog(ccv, "서버에 접속할 수 없습니다.");
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(ccv, "대화명을 입력해주세요");
					ccv.getJtfNick().requestFocus();
				}
			} else {
				JOptionPane.showMessageDialog(ccv, "이미 서버가 구동중입니다.");
			}
		} else if (ae.getSource() == ccv.getJbCapture()) {

		} else if (ae.getSource() == ccv.getJbClose()) {
			ccv.dispose();
		} else if (ae.getSource() == ccv.getJbUser()) {
			new ClientSelectUserView(ccv);
		} else if (ae.getSource() == ccv.getJtfTalk()) {
			JTextField jtf = ccv.getJtfTalk();
			if (!jtf.getText().isEmpty()) {
				try {
					sendMsg("["+nick+"] : "+jtf.getText());
				} catch (IOException e) {
					e.printStackTrace();
				}
				jtf.setText("");
			} else {
				JOptionPane.showMessageDialog(ccv, "대화를 입력해주세요.");
				ccv.getJtfTalk().requestFocus();
			}
		}
	}

	public void sendMsg(String msg) throws IOException {
		if (writeStream != null) {
			writeStream.writeUTF(msg);
			writeStream.flush();
		} else {
			JOptionPane.showMessageDialog(ccv, "서버에 접속할 수 없습니다.");
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		ccv.dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		close();
	}
	
	public void close() {
		try {
			if (writeStream != null) {
				writeStream.close();
			}
			if (readStream != null) {
				readStream.close();
			}
			if (client != null) {
				client.close();
			}
		} catch (IOException e) {
			System.out.println("서버와 접속이 끊겼습니다.");
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
}