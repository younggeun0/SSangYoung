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
 * Thread�� �����Ͽ� �޽����� �о� ȭ�鿡 ����ϴ� �ϰ�
 * �޽����� ������ ���� ���ÿ� ó��
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

	private String serverNick; // ������ ��ȭ��
	private String clientNick; // Ŭ���̾�Ʈ�� ��ȭ��
	
	public SimpleThreadChatServer() {
		super(":::::::ä�ü���:::::::");

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
				JOptionPane.showMessageDialog(this, "��ȭ��밡 �����ϴ�.");
				jtf.setText("");
			}
		} catch (IOException e2) {
			JOptionPane.showMessageDialog(this, "�޽��� ���� ����!");
			e2.printStackTrace();
		}
	}
	
	// Override�ϱ����ؼ� �θ� run()�� �Ȱ��ƾ� �ϱ� ������ throws�� ��� ����
	@Override
	public void run() {
		String revMsg = "";
		if (readStream != null) {
			while (true) {
				try {
					revMsg = readStream.readUTF();
					jta.append("["+clientNick+" �޽���] : " + revMsg + "\n");
					// �޽����� T.A�� �߰��Ǹ� JScrollPane�� ��ũ�ѹ��� ����
					// jsp�� �ְ����� ����
					jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				} catch (IOException ie) {
					// �о���� �� ���°� Socket�� ���� ��
					JOptionPane.showMessageDialog(this, "\""+clientNick+"\"�Բ��� �������ϴ�.");
					ie.printStackTrace();
					break;
				}
			}
		}
	}
	
	public void openServer() throws IOException, SocketException {
		serverNick = JOptionPane.showInputDialog("��ȭ�� �Է�");
		
		server = new ServerSocket(65535);
		jta.setText("�������� ��.... �����ڸ� ��ٸ��ϴ�.");
		client = server.accept();
		jta.append("\n----------- client ���� -----------\n");
		readStream = new DataInputStream(client.getInputStream());
		writeStream = new DataOutputStream(client.getOutputStream());
		
		clientNick = readStream.readUTF();
		writeStream.writeUTF(serverNick);
//		jta.append("��ȭ�濡 \""+serverNick+"\"���� �����ϼ̽��ϴ�.\n");
	}
	
	public void sendMsg() throws IOException {
		String sendMsg = jtf.getText().trim();
		writeStream.writeUTF(sendMsg);
		writeStream.flush();
		jta.append("["+serverNick+" �޽���] : "+sendMsg+"\n");
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
			// Thread�� stcs ��ü�� has-a ����� ����
			Thread th = new Thread(stcs);
			th.start();
		} catch (SocketException se) {
			System.err.println("�����ڰ� ������ �� ���� "+se.getMessage());
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(stcs, "���� ���� ����! �޽����� �о���� �� �����ϴ�.");
			ie.printStackTrace();
		}
	}
}
