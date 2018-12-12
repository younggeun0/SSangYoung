package date181212;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FriendList extends Frame {
	
	private List listFriend;
	private List listBlocked;
	private Button btnAllUnblock;
	private Button btnAllBlock;
	
	public FriendList() {
		
		Label lblFrined = new Label("ģ�����");
		Label lblBlocked = new Label("���ܵ� ģ��");
		btnAllUnblock = new Button("<<");
		btnAllBlock = new Button(">>");
		
		listFriend = new List();
		listFriend.add("������");
		listFriend.add("������");
		listFriend.add("���ü�");
		
		listBlocked = new List();
		
		setLayout(null);
		
		lblFrined.setBounds(30, 50, 50, 20);
		add(lblFrined);
		lblBlocked.setBounds(200, 50, 80, 20);
		add(lblBlocked);
		listFriend.setBounds(30, 70, 100, 200);
		add(listFriend);
		listBlocked.setBounds(200, 70, 100, 200);
		add(listBlocked);
		btnAllBlock.setBounds(145,120,40,30);
		add(btnAllBlock);
		btnAllUnblock.setBounds(145,180,40,30);
		add(btnAllUnblock);
		
		FriendEventHandler feh = new FriendEventHandler(this);
		listFriend.addItemListener(feh);
		listBlocked.addItemListener(feh);
		btnAllBlock.addActionListener(feh);
		btnAllUnblock.addActionListener(feh);
		addWindowListener(feh);
		
		setBounds(400, 300, 330, 300);
		setResizable(false);
		setVisible(true);
	}
	public List getListFriend() {
		return listFriend;
	}
	public List getListBlocked() {
		return listBlocked;
	}
	public Button getBtnAllUnblock() {
		return btnAllUnblock;
	}
	public Button getBtnAllBlock() {
		return btnAllBlock;
	}
	public static void main(String[] args) {
		new FriendList();
	}
}
