package kr.co.sist.chat.server.view;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import kr.co.sist.chat.server.evt.MultiChatServerEvt;

/**
 * ä�ù� ������ ȭ��
 * @author owner
 */
@SuppressWarnings("serial")
public class MultiChatServerView extends JFrame {
	private JList<String> jlChatList;
	private JScrollPane jspList;
	private DefaultListModel<String> dlmChatList;
	private JButton btnOpenServer, btnCloseServer;

	public MultiChatServerView() {
		super(":::::::::::: ä�ù� ������ ::::::::::::");

		dlmChatList = new DefaultListModel<String>();
		jlChatList = new JList<String>(dlmChatList);
		jspList = new JScrollPane(jlChatList);
		btnOpenServer = new JButton("��������");
		btnCloseServer = new JButton("��������");
		
		JPanel btnPanel = new JPanel();
		btnPanel.add(btnOpenServer);
		btnPanel.add(btnCloseServer);
		
		jspList.setBorder(new TitledBorder("������ ����"));
		
		add("Center", jspList);
		add("South", btnPanel);
		
		MultiChatServerEvt mcse = new MultiChatServerEvt(this);
		btnOpenServer.addActionListener(mcse);
		btnCloseServer.addActionListener(mcse);
		
		addWindowListener(mcse);
		
		setBounds(400, 200, 400, 650);
		setVisible(true);
	}

	public JList<String> getJlChatList() {
		return jlChatList;
	}
	public DefaultListModel<String> getDlmChatList() {
		return dlmChatList;
	}
	public JScrollPane getJspList() {
		return jspList;
	}
	public JButton getBtnOpenServer() {
		return btnOpenServer;
	}
	public JButton getBtnCloseServer() {
		return btnCloseServer;
	}
}
