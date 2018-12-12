package date181212;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Has-A ����� Event ó��
 * @author owner
 */
/**
 * @author owner
 *
 */
@SuppressWarnings("serial")
public class FriendsList extends Frame {
	
	private List listFriend, listBlockedFriend;
	private Button btnAllBlock, btnAllUnblock;
	
	public FriendsList() {
		super("ģ������");

		Label lbl1 = new Label("ģ�� ���");
		Label lbl2 = new Label("���ܵ� ģ��");

		listFriend = new List();
		listBlockedFriend = new List();
		listFriend.add("������");
		listFriend.add("������");
		listFriend.add("���ü�");
		listFriend.add("���ü�");

		btnAllBlock = new Button(">>");
		btnAllUnblock = new Button("<<");

		setLayout(null);
		lbl1.setBounds(80, 100, 150, 50);
		lbl2.setBounds(355, 100, 150, 50);
		listFriend.setBounds(30, 150, 150, 200);
		listBlockedFriend.setBounds(320, 150, 150, 200);
		btnAllBlock.setBounds(225, 200, 50, 30);
		btnAllUnblock.setBounds(225, 250, 50, 30);

		add(lbl1);        add(lbl2);
		add(listFriend);  add(listBlockedFriend);
		add(btnAllBlock); add(btnAllUnblock);

		// �̺�Ʈ ���
		// ������ Ŭ������ �̺�Ʈ ó�� Ŭ������ Has-A ����
		FriendsListEvt fle = new FriendsListEvt(this);
		btnAllBlock.addActionListener(fle);
		btnAllUnblock.addActionListener(fle);
		listFriend.addItemListener(fle);
		listBlockedFriend.addItemListener(fle);
		addWindowListener(fle);
		
		setBounds(200, 200, 500, 400);
		setResizable(false);

		setVisible(true);
	}
	
	public List getListFriend() {
		return listFriend;
	}

	public List getListBlockedFriend() {
		return listBlockedFriend;
	}

	public Button getBtnAllBlock() {
		return btnAllBlock;
	}

	public Button getBtnAllUnblock() {
		return btnAllUnblock;
	}

	public static void main(String[] args) {
		new FriendsList();
	}
}
