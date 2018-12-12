package date181212;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Has-A 관계로 Event 처리
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
		super("친구관리");

		Label lbl1 = new Label("친구 목록");
		Label lbl2 = new Label("차단된 친구");

		listFriend = new List();
		listBlockedFriend = new List();
		listFriend.add("이재찬");
		listFriend.add("이재현");
		listFriend.add("정택성");
		listFriend.add("정택성");

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

		// 이벤트 등록
		// 디자인 클래스와 이벤트 처리 클래스는 Has-A 관계
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
