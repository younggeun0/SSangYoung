package kr.co.sist.chat.server.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import kr.co.sist.chat.server.helper.MultiChatServerHelper;
import kr.co.sist.chat.server.view.MultiChatServerView;

public class MultiChatServerEvt extends WindowAdapter 
	implements Runnable, ActionListener {

	private MultiChatServerView mcsv;
	private Thread threadServer; // �����ڿ� ���� ó���� �ϱ����� Thread
	private ServerSocket server; // PORT ����
	private List<MultiChatServerHelper> listClient; // ��� �����ڸ� ������ List
	
	public MultiChatServerEvt(MultiChatServerView mcsv) {
		this.mcsv = mcsv;
		listClient = new ArrayList<MultiChatServerHelper>();
	}
	
	@Override
	public void run() {
		// ���������� ���� ������ ������ �޴´�.
		DataInputStream dis = null;
		try {
			server = new ServerSocket(35000); // 0~65535���� PORT�� ���� �� �ִ�.
			DefaultListModel<String> dlmTemp = mcsv.getDlmChatList();
			dlmTemp.addElement("������ 35000 PORT�� ���� �������Դϴ�...");
			
			Socket someClient = null; // ������ ������ ������ ��ü
			MultiChatServerHelper mcsh = null; // ������ ������ �޾� ��Ʈ���� �����ϰ�
			// ��ȭ�� �аų� ��� �����ڿ��� �����ϴ� ��.
			for(int cnt=1;;cnt++) {
				someClient = server.accept();
				
				// ����, ������ ȭ��, ���� ������ �Ҵ��Ͽ� Helper Ŭ���� ����
				mcsh = new MultiChatServerHelper(someClient, dlmTemp, mcsv, listClient, mcsv.getJspList(),cnt);
				// ������ ���� �̸��� ���ϰ�ü�� ������ �����ϱ� ���� List�� �߰�
				listClient.add(mcsh);
				// �������� �޼����� �о���̱����� Thread ����
				mcsh.start();
			}
			
		} catch (IOException ie) {
			ie.printStackTrace();
		} 
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == mcsv.getBtnOpenServer()) {
			if (threadServer == null) {
				threadServer = new Thread(this);
				threadServer.start();
			} else {
				JOptionPane.showMessageDialog(mcsv, "ä�ü����� �̹� �������Դϴ�.");
			}
		}
		if (ae.getSource() == mcsv.getBtnCloseServer()) {
			switch(JOptionPane.showConfirmDialog(mcsv,"ä�ü����� �����Ͻðڽ��ϱ�?\n"
					+ "�����Ͻø� ��� �������� ������ �������ϴ�.")) {
			case JOptionPane.OK_OPTION : mcsv.dispose();
			}
		}
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		mcsv.dispose();
	}
	@Override
	public void windowClosed(WindowEvent we) {
		try {
			if (server != null) {
				server.close();
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}
