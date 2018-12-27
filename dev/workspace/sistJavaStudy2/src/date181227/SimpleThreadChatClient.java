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
 * Thread�� ����Ͽ� ���ѷ����� �޽����� �о���̴� �ڵ��
 * �޽����� ������ �ڵ带 ���ý����Ų��.
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

	private String serverNick; // ������ ��ȭ��
	private String clientNick; // Ŭ���̾�Ʈ�� ��ȭ��
	
	public SimpleThreadChatClient() {
		super(":::::::ä��Ŭ���̾�Ʈ:::::::");

		jta = new JTextArea();
		jta.setBorder(new TitledBorder("��ȭ����"));
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);

		jsp = new JScrollPane(jta);
		
		jtf = new JTextField();
		jtf.setBorder(new TitledBorder("��ȭ�Է�"));
		
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
					// System.exit(0); // ���� ������ �ν��Ͻ� �ٷ� ���̷���
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
					jta.append("["+serverNick+" �޽���] : " + revMsg + "\n");
					jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				}  catch (IOException ie) {
					JOptionPane.showMessageDialog(this, "\""+serverNick+"\"�Բ��� �������ϴ�.");
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
		clientNick = JOptionPane.showInputDialog("��ȭ�� �Է�");
		
		client = new Socket("211.63.89.149", 65535);
		readStream = new DataInputStream(client.getInputStream());
		writeStream = new DataOutputStream(client.getOutputStream());
		
		// server�� ��ȭ�� ����
		writeStream.writeUTF(clientNick);
		jta.setText("��ȭ�濡 \""+clientNick+"\"���� �����ϼ̽��ϴ�.\n");
		// server�� ��ȭ���� ����
		serverNick = readStream.readUTF();
	}
	
	public void sendMsg() throws IOException {
		String sendMsg = jtf.getText().trim();
		writeStream.writeUTF(sendMsg);
		writeStream.flush();
		jta.append("["+clientNick+" �޽���] : "+sendMsg+"\n");
		jtf.setText("");
		jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
	}
	
	public static void main(String[] args) {
		SimpleThreadChatClient stcc = new SimpleThreadChatClient();
		
		try {
			stcc.connectToServer();
			// �޽����� ���ÿ� �о���ϱ� ������ Thread�� ó��
			Thread th = new Thread(stcc);
			th.start();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}
