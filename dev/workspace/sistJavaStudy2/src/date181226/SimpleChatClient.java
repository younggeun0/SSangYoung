package date181226;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SimpleChatClient extends JFrame implements ActionListener {
	
	private JTextArea jta;
	private JTextField jtf;
	
	private Socket client; // 서버와 연결하기 위해
	private DataInputStream readStream; // 서버의 데이터를 읽기위한 스트림
	private DataOutputStream writeStream; // 서버로 데이터를 보내기위한 스트림
	
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
		
		try {
			this.connectToServer();
			this.revMsg();
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
	
	public void close() throws IOException {
		try {
			if (readStream != null) { readStream.close(); }
			if (writeStream != null) { writeStream.close(); }
		} finally {
			if (client != null) { client.close(); }
		}
	}

	/**
	 * 2. 소켓을 생성하여 서버에 연결하고 
	 * 대화를 읽거나 보내기 위해 4.스트림을 연결한다.
	 * @throws IOException
	 */
	public void connectToServer() throws IOException {
		// 2.
		client = new Socket("localhost", 65535);
		// 4.
		readStream = new DataInputStream(client.getInputStream());
		writeStream = new DataOutputStream(client.getOutputStream());
	}
	
	/**
	 * 서버에서 보내오는 메시지를 무한루프로 읽어 들인다.
	 */
	public void revMsg() throws IOException {
		String revMsg = "";
		while(true) {
			revMsg = readStream.readUTF();
			// 대화창에 읽어들인 메시지를 출력
			jta.append("[server 메시지] : "+revMsg+"\n");
		}
	}
	
	/**
	 * 작성된 메시지를 서버로 보내는 일
	 */
	public void sendMsg() throws IOException {
		// 작성된 메시지를 가져와서
		String sendMsg = jtf.getText().trim();
		// 스트림에 기록하고
		writeStream.writeUTF(sendMsg);
		// 스트림의 내용을 목적지로 분출
		writeStream.flush();
		// 작성된 메시지를 채팅창에 올린다.
		jta.append("[client 메시지] : "+sendMsg+"\n");
		// TextField의 내용을 삭제한다.
		jtf.setText("");
	}

	public static void main(String[] args) {
		new SimpleChatClient();
	}
}
