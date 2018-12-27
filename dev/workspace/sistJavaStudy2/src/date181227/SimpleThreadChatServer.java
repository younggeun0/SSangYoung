package date181227;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
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

/**
 * Thread를 도입하여 메시지를 읽어 화면에 출력하는 일과
 * 메시지를 보내는 일을 동시에 처리
 * @author owner
 */
@SuppressWarnings("serial")
public class SimpleThreadChatServer extends JFrame implements ActionListener, Runnable {
	
	private JTextArea jta;
	private JTextField jtf;
	private JScrollPane jsp;
	
	private ServerSocket server;
	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;

	private String serverNick; // 서버의 대화명
	private String clientNick; // 클라이언트의 대화명
	
	public SimpleThreadChatServer() {
		super(":::::::채팅서버:::::::");

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
	
	// Override하기위해선 부모 run()과 똑같아야 하기 때문에 throws를 사용 못함
	@Override
	public void run() {
		String revMsg = "";
		if (readStream != null) {
			while (true) {
				try {
					revMsg = readStream.readUTF();
					jta.append("["+clientNick+" 메시지] : " + revMsg + "\n");
					// 메시지가 T.A에 추가되면 JScrollPane의 스크롤바의 값을
					// jsp의 최고값으로 변경
					jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				} catch (IOException ie) {
					// 읽어들일 수 없는건 Socket이 끊긴 것
					JOptionPane.showMessageDialog(this, "\""+clientNick+"\"님께서 나갔습니다.");
					ie.printStackTrace();
					break;
				}
			}
		}
	}
	
	public void openServer() throws IOException, SocketException {
		serverNick = JOptionPane.showInputDialog("대화명 입력");
		
		server = new ServerSocket(65535);
		jta.setText("서버가동 중.... 접속자를 기다립니다.");
		client = server.accept();
		jta.append("\n----------- client 접속 -----------\n");
		readStream = new DataInputStream(client.getInputStream());
		writeStream = new DataOutputStream(client.getOutputStream());
		
		clientNick = readStream.readUTF();
		writeStream.writeUTF(serverNick);
//		jta.append("대화방에 \""+serverNick+"\"으로 입장하셨습니다.\n");
	}
	
	public void sendMsg() throws IOException {
		String sendMsg = jtf.getText().trim();
		writeStream.writeUTF(sendMsg);
		writeStream.flush();
		jta.append("["+serverNick+" 메시지] : "+sendMsg+"\n");
		jtf.setText("");
		jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
	}
	
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
		SimpleThreadChatServer stcs = new SimpleThreadChatServer();
		
		try {
			stcs.openServer();
			// Thread와 stcs 객체를 has-a 관계로 설정
			Thread th = new Thread(stcs);
			th.start();
		} catch (SocketException se) {
			System.err.println("접속자가 들어오기 전 종료 "+se.getMessage());
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(stcs, "서버 가동 실패! 메시지를 읽어들일 수 없습니다.");
			ie.printStackTrace();
		}
	}
}
