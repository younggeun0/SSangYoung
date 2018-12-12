package date181212;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PIManagerEvt extends WindowAdapter implements TextListener, ActionListener, ItemListener {

	private PIManager pim;
	private String name, age, addr;
	
	public PIManagerEvt(PIManager pim) {
		this.pim = pim;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		pim.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pim.getBtnAdd()) {
			add();
		}
		if (e.getSource() == pim.getBtnDel()) {
			delete();
		}
		if (e.getSource() == pim.getBtnEdit()) {
			edit();
		}
		if (e.getSource() == pim.getBtnClose()) {
			pim.dispose();
		}
	}

	@Override
	public void textValueChanged(TextEvent e) {
		if (e.getSource() == pim.getTfName()) {
			name = pim.getTfName().getText();
		}
		if (e.getSource() == pim.getTfAge()) {
			age = pim.getTfAge().getText();
		}
		if (e.getSource() == pim.getTfAddr()) {
			addr = pim.getTfAddr().getText();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		String selectedItem = pim.getListPi().getSelectedItem();
		
		String[] str = selectedItem.split(" / ");
		pim.getTfName().setText(str[0]);
		pim.getTfAge().setText(str[1]);
		pim.getTfAddr().setText(str[2]);
	}
	
	public void add() {
		if (!(name == null || age == null || addr == null)) {
			StringBuilder item = new StringBuilder();
			item.append(name).append(" / ").append(age).append(" / ").append(addr);
			pim.getListPi().add(item.toString());
			
			// 입력 후 TF 초기화
			pim.getTfName().setText("");
			pim.getTfAge().setText("");
			pim.getTfAddr().setText("");
		}
	}
	
	public void edit() {
		List tempList = pim.getListPi();
		if (tempList.getSelectedItem() != null) {
			int selectedIndex = pim.getListPi().getSelectedIndex();
			
			StringBuilder newItem = new StringBuilder();
			newItem.append(name).append(" / ").append(age).append(" / ").append(addr);
			tempList.remove(selectedIndex);
			tempList.add(newItem.toString(), selectedIndex);
		}
	}
	
	public void delete() {
		List tempList = pim.getListPi();
		if (tempList.getSelectedItem() != null) {
			
			int selectedIndex = pim.getListPi().getSelectedIndex();
			
			tempList.remove(selectedIndex);
			pim.getTfName().setText("");
			pim.getTfAge().setText("");
			pim.getTfAddr().setText("");
		}
	}
}
