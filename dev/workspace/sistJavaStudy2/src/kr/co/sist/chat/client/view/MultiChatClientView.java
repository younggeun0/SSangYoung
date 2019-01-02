package kr.co.sist.chat.client.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import kr.co.sist.chat.client.evt.MultiChatClientEvt;
import kr.co.sist.chat.server.evt.MultiChatServerEvt;

@SuppressWarnings("serial")
public class MultiChatClientView extends JFrame {

	private JTextArea jtaTalkDisplay;
	private JTextField jtfServerIp, jtfNick, jtfTalk;
	private JButton jbtConnect, jbtCapture, jbtClose;
	private JScrollPane jspTalkDisplay;
	
	public MultiChatClientView() {
		super("채팅 클라이언트");
		
		jbtConnect = new JButton("접속");
		jbtCapture = new JButton("저장");
		jbtClose = new JButton("종료");
		jtaTalkDisplay = new JTextArea();
		jspTalkDisplay = new JScrollPane(jtaTalkDisplay);
		jtfServerIp = new JTextField("211.63.89.",10);
		jtfNick = new JTextField(10);
		jtfTalk = new JTextField();
		jtfTalk.setBorder(new TitledBorder("대화"));

		jspTalkDisplay.setBorder(new TitledBorder("대화내용"));
		
		jtaTalkDisplay.setEditable(false);
		
		JPanel jpNorth = new JPanel();
		jpNorth.add(new JLabel("서버주소", JLabel.CENTER));
		jpNorth.add(jtfServerIp);
		jpNorth.add(new JLabel("대화명", JLabel.CENTER));
		jpNorth.add(jtfNick);
		jpNorth.add(jbtConnect);
		jpNorth.add(jbtCapture);
		jpNorth.add(jbtClose);
		
		MultiChatClientEvt mcce = new MultiChatClientEvt(this);
		jbtConnect.addActionListener(mcce);
		jbtCapture.addActionListener(mcce);
		jbtClose.addActionListener(mcce);
		jtfTalk.addActionListener(mcce);
		
		addWindowListener(mcce);
		
		add("North",jpNorth);
		add("Center",jspTalkDisplay);
		add("South",jtfTalk);
		
		setBounds(400, 200, 600, 350);
		setVisible(true);
	}
	public JTextArea getJtaTalkDisplay() {
		return jtaTalkDisplay;
	}
	public JTextField getJtfServerIp() {
		return jtfServerIp;
	}
	public JTextField getJtfNick() {
		return jtfNick;
	}
	public JTextField getJtfTalk() {
		return jtfTalk;
	}
	public JButton getJbtConnect() {
		return jbtConnect;
	}
	public JButton getJbtCapture() {
		return jbtCapture;
	}
	public JButton getJbtClose() {
		return jbtClose;
	}
	public JScrollPane getJspTalkDisplay() {
		return jspTalkDisplay;
	}
}
