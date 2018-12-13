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

public class PIManagerEvt extends WindowAdapter implements ActionListener, ItemListener {

	private PIManager pim;
	private String name, age, addr;
	
	public PIManagerEvt() { }
	
	public PIManagerEvt(PIManager pim) {
		this.pim = pim;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		pim.dispose();
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		name = pim.getTfName().getText();
		age = pim.getTfAge().getText();
		addr = pim.getTfAddr().getText();
		
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
	public void itemStateChanged(ItemEvent e) {
		String selectedItem = pim.getListPi().getSelectedItem();
		
		String[] str = selectedItem.split(" / ");
		pim.getTfName().setText(str[0]);
		pim.getTfAge().setText(str[1]);
		pim.getTfAddr().setText(str[2]);
	}
	
	public void add() {
		if (!(name.isEmpty() || age.isEmpty() || addr.isEmpty())) {
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
		if (tempList.getSelectedIndex() != -1) {
			int selectedIndex = pim.getListPi().getSelectedIndex();
			
			StringBuilder newItem = new StringBuilder();
			newItem.append(name).append(" / ").append(age).append(" / ").append(addr);
			tempList.remove(selectedIndex);
			tempList.add(newItem.toString(), selectedIndex);
		}
	}
	
	public void delete() {
		List tempList = pim.getListPi();
		if (!(name.isEmpty() || age.isEmpty() || addr.isEmpty())) {
			StringBuilder item = new StringBuilder();
			item.append(name).append(" / ").append(age).append(" / ").append(addr);
			
			String[] arrItem = tempList.getItems();
			for(int i=0; i<arrItem.length; i++) {
				if (item.toString().equals(arrItem[i])) {
					tempList.remove(i);
					
					pim.getTfName().setText("");
					pim.getTfAge().setText("");
					pim.getTfAddr().setText("");
				}
			}
		} else if (tempList.getSelectedIndex() != -1) {
			
			int selectedIndex = pim.getListPi().getSelectedIndex();
			
			tempList.remove(selectedIndex);
			pim.getTfName().setText("");
			pim.getTfAge().setText("");
			pim.getTfAddr().setText("");
		}
	}
}
