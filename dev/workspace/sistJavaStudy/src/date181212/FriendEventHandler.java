package date181212;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FriendEventHandler extends WindowAdapter implements ItemListener, ActionListener {

	private FriendList fl;
	
	public FriendEventHandler(FriendList fl) {
		this.fl = fl;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == fl.getBtnAllBlock()) {
			allBlock();
		}
		if (e.getSource() == fl.getBtnAllUnblock()) {
			allUnblock();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == fl.getListFriend()) {
			blockFriend();
		}
		if (e.getSource() == fl.getListBlocked()) {
			unblockFriend();
		}
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		fl.dispose();
	}
	
	public void blockFriend() {
		String selectedPerson = fl.getListFriend().getSelectedItem();
		
		fl.getListFriend().remove(selectedPerson);
		fl.getListBlocked().add(selectedPerson);
	}
	
	public void unblockFriend() {
		String selectedPerson = fl.getListBlocked().getSelectedItem();
		
		fl.getListBlocked().remove(selectedPerson);
		fl.getListFriend().add(selectedPerson);
	}
	
	public void allBlock() {
		String[] name = fl.getListFriend().getItems();
		for(int i=0; i<name.length; i++) {
			name[i] = fl.getListFriend().getItem(i);
		}
		fl.getListFriend().removeAll();
		for(int i=0; i<name.length; i++) {
			fl.getListBlocked().add(name[i]);
		}
	}
	
	public void allUnblock() {
		int itemCnt = fl.getListBlocked().getItemCount();
		String[] name = new String[itemCnt];
		for(int i=0; i<itemCnt; i++) {
			name[i] = fl.getListBlocked().getItem(i);
		}
		fl.getListBlocked().removeAll();
		for(int i=0; i<itemCnt; i++) {
			fl.getListFriend().add(name[i]);
		}
	}
}
