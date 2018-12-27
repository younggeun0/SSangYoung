package date181226.revision;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SimpleChatServer extends JFrame implements ActionListener, Runnable {
	
	private JTextArea jta;
	private JTextField jtf;
	
	private ServerSocket server;
	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private Thread th;

	public SimpleChatServer() {
		super(":::::::채팅서버:::::::");

		jta = new JTextArea();
		jta.setBorder(new TitledBorder("대화내용"));
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);

		JScrollPane jsp = new JScrollPane(jta);

		jtf = new JTextField();
		jtf.setBorder(new TitledBorder("대화입력"));

		add("Center", jsp);
		add("South", jtf);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				try {
					close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});
		
		
		setBounds(400, 200, 300, 400);
		setVisible(true);
		jtf.requestFocus();
		
		th = new Thread(this);
		try {
			openServer();
			th.start();
		} catch (SocketException se) {
			System.err.println("접속자가 들어오기 전 종료 "+se.getMessage());
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(this, "서버 가동 실패! 메시지를 읽어들일 수 없습니다.");
			ie.printStackTrace();
		}
		
		setBounds(400, 200, 300, 400);
		setVisible(true);
		jtf.requestFocus();
		
		jtf.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (writeStream != null) {
				sendMsg();
			} else {
				JOptionPane.showMessageDialog(this, "대화상대가 없습니다.");
				jtf.setText("");
			}
		} catch (IOException e2) {
			JOptionPane.showMessageDialog(this, "메시지 전송 실패!");
			e2.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		String revMsg = "";
		if (readStream != null) {
			while(true) {
				try {
					revMsg = readStream.readUTF();
				} catch (IOException e) {
					e.printStackTrace();
				}
				jta.append("[client 메시지] : "+revMsg+"\n");
			}
		}
	}
	
	public void openServer() throws IOException, SocketException {
		server = new ServerSocket(65535);
		jta.setText("서버가동 중.... 접속자를 기다립니다.");
		client = server.accept();
		jta.append("\n----------- client 접속 -----------\n");
		readStream = new DataInputStream(client.getInputStream());
		writeStream = new DataOutputStream(client.getOutputStream());
	}
	
	public void sendMsg() throws IOException {
		String sendMsg = jtf.getText().trim();
		writeStream.writeUTF(sendMsg);
		writeStream.flush();
		jta.append("[server 메시지] : "+sendMsg+"\n");
		jtf.setText("");
	}
	
	/*public void revMsg() throws IOException {
		String revMsg = "";
		if (readStream != null) {
			while(true) {
				revMsg = readStream.readUTF();
				jta.append("[client 메시지] : "+revMsg+"\n");
			}
		}
	}*/
	
	public void close() throws IOException {
		try {
			if (readStream != null) readStream.close();
			if (writeStream != null ) writeStream.close();
			if (client != null) client.close();
		} finally {
			if (server != null) server.close();
		}
	}
	
	public static void main(String[] args) {
		new SimpleChatServer();
	}
}
