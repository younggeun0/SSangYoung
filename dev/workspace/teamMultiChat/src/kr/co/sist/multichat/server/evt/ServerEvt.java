package kr.co.sist.multichat.server.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import kr.co.sist.multichat.server.helper.ServerHelper;
import kr.co.sist.multichat.server.view.ServerView;

public class ServerEvt extends WindowAdapter implements ActionListener {

	private ServerView sv;
	private Thread threadServer1, threadServer2, threadServer3, threadServer4;
	private ServerSocket server1, server2, server3, server4;
	private List<ServerHelper> listClient1, listClient2, listClient3, listClient4;

	public ServerEvt(ServerView sv) {
		this.sv = sv;
		listClient1 = new ArrayList<ServerHelper>();
		listClient2 = new ArrayList<ServerHelper>();
		listClient3 = new ArrayList<ServerHelper>();
		listClient4 = new ArrayList<ServerHelper>();
	}// ServerEvt

	@Override
	public void windowClosing(WindowEvent we) {
		sv.dispose();
	}// windowClosing

	@Override
	public void windowClosed(WindowEvent we) {
		try {
			if (server1 != null) {
				server1.close();
			} // end if
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}// windowClosed

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == sv.getJbStart()) {
			if (threadServer1 == null && threadServer2 == null && threadServer3 == null && threadServer4 == null) {

				try {
					server1 = new ServerSocket(7001);
					server2 = new ServerSocket(7002);
					server3 = new ServerSocket(7003);
					server4 = new ServerSocket(7004);

					sv.getJtaChatDisplay1().setText("������ �����մϴ�...\n");

					// anonymous inner class�� 4���� thread ����
					threadServer1 = new Thread() {
						@Override
						public void run() {
							try {
								Socket someClient = null;
								ServerHelper sh = null;
								while (true) {
									someClient = server1.accept();
									sh = new ServerHelper(someClient, sv, listClient1, sv.getJtaChatDisplay1(), sv.getJspChatDisplay1());
									listClient1.add(sh);
									sh.start();
								} // end for
							} catch (IOException e) {
								e.printStackTrace();
							} // end catch
						}
					};
					threadServer1.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(sv, "ä�ü����� �̹� �������Դϴ�.");
			} // end else
		} // end if
		if (ae.getSource() == sv.getJbClose()) {
			switch (JOptionPane.showConfirmDialog(sv, "ä�ü����� �����Ͻðڽ��ϱ�?\n�����Ͻø� ��� �������� ������ �������ϴ�.")) {
			case JOptionPane.OK_OPTION:
				sv.dispose();
			}// end switch
		} // end if

	}// actionPerformed

//�������� ����� �����常��� ( 1�� â�� �켱)
}// class
