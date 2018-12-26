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
	
	private Socket client; // ������ �����ϱ� ����
	private DataInputStream readStream; // ������ �����͸� �б����� ��Ʈ��
	private DataOutputStream writeStream; // ������ �����͸� ���������� ��Ʈ��
	
	public SimpleChatClient() {
		super(":::::::ä��Ŭ���̾�Ʈ:::::::");
		
		jta = new JTextArea();
		jta.setBorder(new TitledBorder("��ȭ����"));
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		
		JScrollPane jsp = new JScrollPane(jta);
		
		jtf = new JTextField();
		jtf.setBorder(new TitledBorder("��ȭ�Է�"));
		
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
	 * 2. ������ �����Ͽ� ������ �����ϰ� 
	 * ��ȭ�� �аų� ������ ���� 4.��Ʈ���� �����Ѵ�.
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
	 * �������� �������� �޽����� ���ѷ����� �о� ���δ�.
	 */
	public void revMsg() throws IOException {
		String revMsg = "";
		while(true) {
			revMsg = readStream.readUTF();
			// ��ȭâ�� �о���� �޽����� ���
			jta.append("[server �޽���] : "+revMsg+"\n");
		}
	}
	
	/**
	 * �ۼ��� �޽����� ������ ������ ��
	 */
	public void sendMsg() throws IOException {
		// �ۼ��� �޽����� �����ͼ�
		String sendMsg = jtf.getText().trim();
		// ��Ʈ���� ����ϰ�
		writeStream.writeUTF(sendMsg);
		// ��Ʈ���� ������ �������� ����
		writeStream.flush();
		// �ۼ��� �޽����� ä��â�� �ø���.
		jta.append("[client �޽���] : "+sendMsg+"\n");
		// TextField�� ������ �����Ѵ�.
		jtf.setText("");
	}

	public static void main(String[] args) {
		new SimpleChatClient();
	}
}
