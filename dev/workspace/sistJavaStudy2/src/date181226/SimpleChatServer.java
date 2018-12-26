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
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SimpleChatServer extends JFrame implements ActionListener {
	
	private JTextArea jta;
	private JTextField jtf;
	
	private ServerSocket server;
	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	
	public SimpleChatServer() {
		super(":::::::ä�ü���:::::::");
		
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
				// ȭ���� ����� �� windowClosed ȣ��
				dispose();
			}

			// closingó�����ϸ� �����⸸ �װ� ���Ͽ����� ��������
			// windowClosed���� ������ ��� ������� �Ѵ�.
			@Override
			public void windowClosed(WindowEvent e) {
				try {
					close(); // Ŭ���̾�Ʈ�� �����ϰ� �ִ� ��Ʈ��, ����, �������� ����	
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		setBounds(400, 200, 300, 400);
		setVisible(true);
		jtf.requestFocus();
		
		try {
			openSever();
			revMsg();
		} catch (SocketException se) {
			System.err.println("�����ڰ� ������ �� ���� "+se.getMessage());
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(this, "���� ���� ����! �޽����� �о���� �� �����ϴ�.");
			ie.printStackTrace();
		}
		
		jtf.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			// �����ڰ� �����Ͽ� ��Ʈ���� ������ ��츸
			if (writeStream != null) { // �޽����� ������.
				sendMsg();
			} else {
				JOptionPane.showMessageDialog(this, "��ȭ��밡 �����ϴ�.");
				jtf.setText("");
			}
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(this, "�޽��� ���� ����!");
			e1.printStackTrace();
		}
	}
	
	/**
	 * 1. ServerSocket ����(PORT ����), 2.������ ������ ������(accept)
	 * ��ȭ�� �ְ� ���� �� �ֵ��� 3.Stream�� ����(DIS, DOS)
	 */
	public void openSever() throws IOException, SocketException {
		// 1.
		server = new ServerSocket(65535);
		jta.setText("�������� ��.... �����ڸ� ��ٸ��ϴ�.");
		// 3.
		client = server.accept();
		jta.append("\n----------- client ���� -----------\n");
		// 4. ��Ʈ�� ����
		readStream = new DataInputStream(client.getInputStream());
		writeStream = new DataOutputStream(client.getOutputStream());
	}
	
	/**
	 * �����ڿ��� �޽����� ������ ��
	 * @throws IOException
	 */
	public void sendMsg() throws IOException {
		// T.F�� ���� �����ͼ�
		String msg = jtf.getText().trim();
		// ��Ʈ���� ����ϰ�
		writeStream.writeUTF(msg);
		// ��Ʈ���� ������ �������� ����
		writeStream.flush();
		jta.append("[server �޽���] : "+msg+"\n");
		// �Է��� ���ϵ��� jtf�� �ʱ�ȭ
		jtf.setText("");
	}
	
	/**
	 * �����ڰ� �������� �޽����� ��� �о� ���� �Ѵ�.
	 * @throws IOException
	 */
	public void revMsg() throws IOException {
		String revMsg = "";
		if (readStream != null) {
			while(true) {
				// �޽����� �о�鿩
				revMsg = readStream.readUTF();
				// ��ȭâ�� ���
				jta.append("[client �޽���] : "+revMsg+"\n");
			}
		}
	}
	
	public void close() throws IOException {
		try {
			if(readStream != null) readStream.close();
			if(writeStream != null) writeStream.close();
			if(client != null) client.close();
		} finally {
			if(server != null) server.close();
		}
	}

	public static void main(String[] args) {
		new SimpleChatServer();
	}
}
