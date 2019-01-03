package kr.co.sist.multichat.client.view;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.sist.multichat.client.evt.ClientChatEvt;

public class ClientChatView extends JFrame {
    
    private JTextArea jtaChatDisplay;
    private JTextField jtfTalk,jtfNick;
    private JButton jbConnect, jbCapture, jbClose, jbUser;
    private JScrollPane jsp;
    
    public ClientChatView (int port) {
        super("채팅 클라이언트");    
        
        JLabel jlNick =new JLabel("대화명");
        
        jtfNick=new JTextField();
        jtfTalk=new JTextField();
        
        jbConnect=new JButton("접속");
        jbCapture=new JButton("갈무리");
        jbClose=new JButton("종료");
        jbUser=new JButton("접속자");
        
        jtaChatDisplay=new JTextArea();
        jtaChatDisplay.setEditable(false);
        jsp=new JScrollPane(jtaChatDisplay);
        
        
        Panel panelNorth=new Panel();
        panelNorth.setLayout(new GridLayout(1, 6));
        panelNorth.add(jlNick);
        panelNorth.add(jtfNick);
        panelNorth.add(jbConnect);
        panelNorth.add(jbCapture);
        panelNorth.add(jbClose);
        panelNorth.add(jbUser);
        
        setLayout(new BorderLayout());
        add("North",panelNorth);
        add("Center", jsp);
        add("South", jtfTalk);
        
        ClientChatEvt cce=new ClientChatEvt(this, port);
        jbConnect.addActionListener(cce);
        jbCapture.addActionListener(cce);
        jbClose.addActionListener(cce);
        jbUser.addActionListener(cce);
        jtfTalk.addActionListener(cce);
        addWindowListener(cce);
        
        setResizable(false);
        setBounds(300, 300, 500 ,250);
        setVisible(true);
    }

	public JTextArea getJtaChatDisplay() {
		return jtaChatDisplay;
	}

	public void setJtaChatDisplay(JTextArea jtaChatDisplay) {
		this.jtaChatDisplay = jtaChatDisplay;
	}

	public JTextField getJtfTalk() {
		return jtfTalk;
	}

	public void setJtfTalk(JTextField jtfTalk) {
		this.jtfTalk = jtfTalk;
	}

	public JTextField getJtfNick() {
		return jtfNick;
	}

	public void setJtfNick(JTextField jtfNick) {
		this.jtfNick = jtfNick;
	}

	public JButton getJbConnect() {
		return jbConnect;
	}

	public void setJbConnect(JButton jbConnect) {
		this.jbConnect = jbConnect;
	}

	public JButton getJbCapture() {
		return jbCapture;
	}

	public void setJbCapture(JButton jbCapture) {
		this.jbCapture = jbCapture;
	}

	public JButton getJbClose() {
		return jbClose;
	}

	public void setJbClose(JButton jbClose) {
		this.jbClose = jbClose;
	}

	public JButton getJbUser() {
		return jbUser;
	}

	public void setJbUser(JButton jbUser) {
		this.jbUser = jbUser;
	}

	public JScrollPane getJsp() {
		return jsp;
	}

	public void setJsp(JScrollPane jsp) {
		this.jsp = jsp;
	}
    
}