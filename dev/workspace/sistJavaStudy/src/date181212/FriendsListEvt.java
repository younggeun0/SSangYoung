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
 * Design class�� Has-A ����� ������ �̺�Ʈ ó�� Ŭ����
 * @author owner
 */
public class FriendsListEvt extends WindowAdapter implements ActionListener, ItemListener {

	// �̺�Ʈ�� ó���ϴ� ��ü��
	private FriendsList fl;
	public FriendsListEvt(FriendsList fl) {
		this.fl = fl;
	}

	@Override
	// List �̺�Ʈ ó��
	public void itemStateChanged(ItemEvent e) {
		// ģ�� ����Ʈ���� Ŭ���Ǹ� �ش� �������� ���ܵ� ģ���� ������.
		if (e.getSource() == fl.getListFriend()) {
			System.out.println("ģ��");
			blockFirend();
		}
		// ���ܵ� ģ�� ����Ʈ���� Ŭ���� �ش� �������� ģ������Ʈ�� ������.
		if (e.getSource() == fl.getListBlockedFriend()) {
			System.out.println("ģ�����ƴ�");
			unblockFriend();
		}
	}
	@Override
	// Button �̺�Ʈ ó��
	public void actionPerformed(ActionEvent e) {
		// >> : ��� ģ���� ���ܸ������ �̵���Ŵ
		if (e.getSource() == fl.getBtnAllBlock()) {
			allBlock();
		}
		// << : ��� ���ܵ� ģ���� ģ��������� �̵���Ŵ
		if (e.getSource() == fl.getBtnAllUnblock()) {
			allUnblock();
		}
	}
	@Override
	public void windowClosing(WindowEvent e) {
		fl.dispose();
	}
	
	/**
	 * ģ������Ʈ���� ������ ģ���� ���ܸ���Ʈ�� �̵� 
	 */
	private void blockFirend() {
		List tempFriend = fl.getListFriend();
		// ������ ģ���� ���ͼ�
		String name = tempFriend.getSelectedItem();
		// �������� ������.
		fl.getListBlockedFriend().add(name);
		tempFriend.remove(name);
	}
	
	/**
	 * ������ ģ������Ʈ���� ������ ģ���� ģ������Ʈ�� �̵�
	 */
	private void unblockFriend() {
		// ���ܵ� ģ�� ����Ʈ���� ������ �̸��� �޾ƿͼ� 
		List tempList = fl.getListBlockedFriend(); 
		// ģ������Ʈ�� �߰��ϰ� ���ܵ� ģ������Ʈ���� �����Ѵ�.
		int selectedIndex = tempList.getSelectedIndex();
		fl.getListFriend().add(tempList.getItem(selectedIndex));
		fl.getListBlockedFriend().remove(selectedIndex);
	}
	
	/**
	 * &gt;&gt; ��ư�� Ŭ���ϸ� ��� ģ������ 
	 */
	private void allBlock() {
		// ģ�� ����Ʈ�� ��� �������� �޾ƿͼ�
		String[] arrFriend = fl.getListFriend().getItems();
		
		// ���� ����Ʈ�� ������.
		for(int i=0; i<arrFriend.length; i++) {
			fl.getListBlockedFriend().add(arrFriend[i]);
		}
		fl.getListFriend().removeAll();
	}
	
	/**
	 * &gt;&gt; ��ư�� Ŭ���ϸ� ���ܵ� ��� ģ���� ģ������Ʈ�� �̵� 
	 */
	private void allUnblock() {
		// ���ܵ� ��� ģ������� �޾ƿͼ�
		String[] arrBlockedFriend = fl.getListBlockedFriend().getItems();
		// ģ����Ͽ� �߰��ϰ�
		for(String blockedFriend : arrBlockedFriend) {
			fl.getListFriend().add(blockedFriend);
		}
		// ���ܵ� ��� ģ������� ����
		fl.getListBlockedFriend().removeAll();
	}
}
