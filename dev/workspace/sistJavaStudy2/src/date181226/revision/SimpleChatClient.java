package date181226.revision;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SimpleChatClient extends JFrame implements ActionListener, Runnable {
	private JTextArea jta;
	private JTextField jtf;
	
	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	
	private Thread th;

	public SimpleChatClient() {
		super(":::::::채팅클라이언트:::::::");

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
		});
		
		setBounds(400, 200, 300, 400);
		setVisible(true);
		jtf.requestFocus();
		
		th = new Thread(this);
		try {
			this.connectToServer();
			th.start();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		jtf.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			sendMsg();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		String revMsg = "";
		while(true) {
			try {
				revMsg = readStream.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
			}
			jta.append("[server 메시지] : "+revMsg+"\n");
		}
	}
	
	public void close() throws IOException {
		try {
			if (readStream != null) { readStream.close(); }
			if (writeStream != null) { writeStream.close(); }
		} finally {
			if (client != null) { client.close(); }
		}
	}
	
	public void connectToServer() throws IOException {
		client = new Socket("localhost", 65535);
		readStream = new DataInputStream(client.getInputStream());
		writeStream = new DataOutputStream(client.getOutputStream());
	}
	
	/*public void revMsg() throws IOException {
		String revMsg = "";
		while(true) {
			revMsg = readStream.readUTF();
			jta.append("[server 메시지] : "+revMsg+"\n");
		}
	}*/
	
	public void sendMsg() throws IOException {
		String sendMsg = jtf.getText().trim();
		writeStream.writeUTF(sendMsg);
		writeStream.flush();
		jta.append("[client 메시지] : "+sendMsg+"\n");
		jtf.setText("");
	}
	
	public static void main(String[] args) {
		new SimpleChatClient();
	}
}
