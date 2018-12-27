package date181227;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Thread를 사용하여 무한루프로 메시지를 읽어들이는 코드와
 * 메시지를 보내는 코드를 동시실행시킨다.
 * @author owner
 */
@SuppressWarnings("serial")
public class SimpleThreadChatClient extends JFrame implements ActionListener, Runnable {
	private JTextArea jta;
	private JTextField jtf;
	private JScrollPane jsp;
	
	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;

	private String serverNick; // 서버의 대화명
	private String clientNick; // 클라이언트의 대화명
	
	public SimpleThreadChatClient() {
		super(":::::::채팅클라이언트:::::::");

		jta = new JTextArea();
		jta.setBorder(new TitledBorder("대화내용"));
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);

		jsp = new JScrollPane(jta);
		
		jtf = new JTextField();
		jtf.setBorder(new TitledBorder("대화입력"));
		
		add("Center", jsp);
		add("South", jtf);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
			@Override
			public void windowClosed(WindowEvent we) {
				try {
					close();
					// System.exit(0); // 연결 끝나고 인스턴스 바로 죽이려면
				} catch (IOException ie) {
					ie.printStackTrace();
				}
			}
		});
		
		setBounds(800, 200, 300, 400);
		setVisible(true);
		jtf.requestFocus();
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
		if (readStream != null) {
			while(true) {
				try {
					revMsg = readStream.readUTF();
					jta.append("["+serverNick+" 메시지] : " + revMsg + "\n");
					jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				}  catch (IOException ie) {
					JOptionPane.showMessageDialog(this, "\""+serverNick+"\"님께서 나갔습니다.");
					ie.printStackTrace();
					break;
				}
			}
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
		clientNick = JOptionPane.showInputDialog("대화명 입력");
		
		client = new Socket("211.63.89.149", 65535);
		readStream = new DataInputStream(client.getInputStream());
		writeStream = new DataOutputStream(client.getOutputStream());
		
		// server로 대화명 전달
		writeStream.writeUTF(clientNick);
		jta.setText("대화방에 \""+clientNick+"\"으로 입장하셨습니다.\n");
		// server의 대화명을 저장
		serverNick = readStream.readUTF();
	}
	
	public void sendMsg() throws IOException {
		String sendMsg = jtf.getText().trim();
		writeStream.writeUTF(sendMsg);
		writeStream.flush();
		jta.append("["+clientNick+" 메시지] : "+sendMsg+"\n");
		jtf.setText("");
		jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
	}
	
	public static void main(String[] args) {
		SimpleThreadChatClient stcc = new SimpleThreadChatClient();
		
		try {
			stcc.connectToServer();
			// 메시지를 동시에 읽어야하기 때문에 Thread로 처리
			Thread th = new Thread(stcc);
			th.start();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}
