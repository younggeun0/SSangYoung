package kr.co.sist.multichat.server.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import kr.co.sist.multichat.server.evt.ServerEvt;

@SuppressWarnings("serial")
public class ServerView extends JFrame {

	private JTextArea jtaChatDisplay1, jtaChatDisplay2, jtaChatDisplay3, jtaChatDisplay4;
	private JScrollPane jspChatDisplay1, jspChatDisplay2, jspChatDisplay3, jspChatDisplay4;
	private JButton jbStart, jbClose;

	public ServerView() {
		super("채팅 서버");

		Panel center = new Panel();
		Panel soso = new Panel();

		jtaChatDisplay1 = new JTextArea();
		jtaChatDisplay2 = new JTextArea();
		jtaChatDisplay3 = new JTextArea();
		jtaChatDisplay4 = new JTextArea();
		
		jtaChatDisplay1.setEditable(false);
		jtaChatDisplay2.setEditable(false);
		jtaChatDisplay3.setEditable(false);
		jtaChatDisplay4.setEditable(false);

		jspChatDisplay1 = new JScrollPane(jtaChatDisplay1);
		jspChatDisplay2 = new JScrollPane(jtaChatDisplay2);
		jspChatDisplay3 = new JScrollPane(jtaChatDisplay3);
		jspChatDisplay4 = new JScrollPane(jtaChatDisplay4);

		jbStart = new JButton("시작");
		jbClose = new JButton("종료");

		jspChatDisplay1.setBorder(new TitledBorder("1조"));
		jspChatDisplay2.setBorder(new TitledBorder("2조"));
		jspChatDisplay3.setBorder(new TitledBorder("3조"));
		jspChatDisplay4.setBorder(new TitledBorder("4조"));

		center.setLayout(new GridLayout(2, 2));
		center.add(jspChatDisplay1);
		center.add(jspChatDisplay2);
		center.add(jspChatDisplay3);
		center.add(jspChatDisplay4);

		setLayout(new BorderLayout());

		soso.add(jbStart);
		soso.add(jbClose);

		add("Center", center);
		add("South", soso);
		setBounds(100, 100, 500, 500);
		setVisible(true);

		ServerEvt se = new ServerEvt(this);
		jbStart.addActionListener(se);
		jbClose.addActionListener(se);
		addWindowListener(se);

		setResizable(false);
		addWindowListener(se);
	}// hwServer

	public JTextArea getJtaChatDisplay1() {
		return jtaChatDisplay1;
	}
	public void setJtaChatDisplay1(JTextArea jtaChatDisplay1) {
		this.jtaChatDisplay1 = jtaChatDisplay1;
	}
	public JTextArea getJtaChatDisplay2() {
		return jtaChatDisplay2;
	}
	public void setJtaChatDisplay2(JTextArea jtaChatDisplay2) {
		this.jtaChatDisplay2 = jtaChatDisplay2;
	}
	public JTextArea getJtaChatDisplay3() {
		return jtaChatDisplay3;
	}
	public void setJtaChatDisplay3(JTextArea jtaChatDisplay3) {
		this.jtaChatDisplay3 = jtaChatDisplay3;
	}
	public JTextArea getJtaChatDisplay4() {
		return jtaChatDisplay4;
	}
	public void setJtaChatDisplay4(JTextArea jtaChatDisplay4) {
		this.jtaChatDisplay4 = jtaChatDisplay4;
	}
	public JScrollPane getJspChatDisplay1() {
		return jspChatDisplay1;
	}
	public void setJspChatDisplay1(JScrollPane jspChatDisplay1) {
		this.jspChatDisplay1 = jspChatDisplay1;
	}
	public JScrollPane getJspChatDisplay2() {
		return jspChatDisplay2;
	}
	public void setJspChatDisplay2(JScrollPane jspChatDisplay2) {
		this.jspChatDisplay2 = jspChatDisplay2;
	}
	public JScrollPane getJspChatDisplay3() {
		return jspChatDisplay3;
	}
	public void setJspChatDisplay3(JScrollPane jspChatDisplay3) {
		this.jspChatDisplay3 = jspChatDisplay3;
	}
	public JScrollPane getJspChatDisplay4() {
		return jspChatDisplay4;
	}
	public void setJspChatDisplay4(JScrollPane jspChatDisplay4) {
		this.jspChatDisplay4 = jspChatDisplay4;
	}
	public JButton getJbStart() {
		return jbStart;
	}
	public void setJbStart(JButton jbStart) {
		this.jbStart = jbStart;
	}
	public JButton getJbClose() {
		return jbClose;
	}
	public void setJbClose(JButton jbClose) {
		this.jbClose = jbClose;
	}
}
