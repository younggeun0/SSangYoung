package date181212;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.management.ListenerNotFoundException;

/**
 * Design class와 Has-A 관계로 설정된 이벤트 처리 클래스
 * @author owner
 */
public class FriendsListEvt extends WindowAdapter implements ActionListener, ItemListener {

	// 이베트를 처리하는 객체ㅏ
	private FriendsList fl;
	public FriendsListEvt(FriendsList fl) {
		this.fl = fl;
	}

	@Override
	// List 이벤트 처리
	public void itemStateChanged(ItemEvent e) {
		// 친구 리스트에서 클릭되면 해당 아이템을 차단된 친구로 보낸다.
		if (e.getSource() == fl.getListFriend()) {
			System.out.println("친구");
			blockFirend();
		}
		// 차단된 친구 리스트에서 클릭된 해당 아이템을 친구리스트로 보낸다.
		if (e.getSource() == fl.getListBlockedFriend()) {
			System.out.println("친구도아님");
			unblockFriend();
		}
	}
	@Override
	// Button 이벤트 처리
	public void actionPerformed(ActionEvent e) {
		// >> : 모든 친구를 차단목록으로 이동시킴
		if (e.getSource() == fl.getBtnAllBlock()) {
			allBlock();
		}
		// << : 모든 차단된 친구를 친구목록으로 이동시킴
		if (e.getSource() == fl.getBtnAllUnblock()) {
			allUnblock();
		}
	}
	@Override
	public void windowClosing(WindowEvent e) {
		fl.dispose();
	}
	
	/**
	 * 친구리스트에서 선택한 친구를 차단리스트로 이동 
	 */
	private void blockFirend() {
		List tempFriend = fl.getListFriend();
		// 선택한 친구를 얻어와서
		String name = tempFriend.getSelectedItem();
		// 차단으로 보낸다.
		fl.getListBlockedFriend().add(name);
		tempFriend.remove(name);
	}
	
	/**
	 * 차단한 친구리스트에서 선택한 친구를 친구리스트로 이동
	 */
	private void unblockFriend() {
		// 차단된 친구 리스트에서 선택한 이름을 받아와서 
		List tempList = fl.getListBlockedFriend(); 
		// 친구리스트에 추가하고 차단된 친구리스트에서 삭제한다.
		int selectedIndex = tempList.getSelectedIndex();
		fl.getListFriend().add(tempList.getItem(selectedIndex));
		fl.getListBlockedFriend().remove(selectedIndex);
	}
	
	/**
	 * &gt;&gt; 버튼을 클릭하면 모든 친구차단 
	 */
	private void allBlock() {
		// 친구 리스트의 모든 아이템을 받아와서
		String[] arrFriend = fl.getListFriend().getItems();
		
		// 차단 리스트로 보낸다.
		for(int i=0; i<arrFriend.length; i++) {
			fl.getListBlockedFriend().add(arrFriend[i]);
		}
		fl.getListFriend().removeAll();
	}
	
	/**
	 * &gt;&gt; 버튼을 클릭하면 차단된 모든 친구가 친구리스트로 이동 
	 */
	private void allUnblock() {
		// 차단된 모든 친구목록을 받아와서
		String[] arrBlockedFriend = fl.getListBlockedFriend().getItems();
		// 친구목록에 추가하고
		for(String blockedFriend : arrBlockedFriend) {
			fl.getListFriend().add(blockedFriend);
		}
		// 차단된 모든 친구목록을 삭제
		fl.getListBlockedFriend().removeAll();
	}
}
