package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import view.WordCounter;

public class WordCounterController extends WindowAdapter implements ActionListener {

	private WordCounter wc;
	
	public WordCounterController(WordCounter wc) {
		this.wc = wc;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		wc.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == wc.getJbShowResult()) {
			showResult();
		}
	}
	
	public void showResult() {
		int wordNum = wc.getJta().getText().length();
		
		if(wordNum == 0) {
			JOptionPane.showMessageDialog(wc, "���ڴ� �Է��� �����...");
			return;
		}
		
		JComboBox<String> jcb = wc.getJcbCnt();
		StringBuilder msg = new StringBuilder();
		
		int over = 0;
		int under = 0;
		if (jcb.getSelectedIndex() == 1) { // 500
			msg.append("�Է��Ͻ� ������ ���ڼ��� ").append(wordNum).append("/500 �Դϴ�.");
			if (wordNum > 500) {
				over = wordNum - 500;
				msg.append("\n").append(over).append("�� �� �ʰ��߽��ϴ�. ���̼���.");
			} else {
				under = 500 - wordNum;
				msg.append("\n").append(under).append("�� �� ���ּ���. �й��ϼ���.");
			}
		} else if (jcb.getSelectedIndex() == 2) { // 700
			msg.append("�Է��Ͻ� ������ ���ڼ��� ").append(wordNum).append("/700 �Դϴ�.");
			if (wordNum > 700) {
				over = wordNum - 700;
				msg.append("\n").append(over).append("�� �� �ʰ��߽��ϴ�. ���̼���.");
			} else {
				under = 700 - wordNum;
				msg.append("\n").append(under).append("�� �� ���ּ���. �й��ϼ���.");
			}
		} else if (jcb.getSelectedIndex() == 3) { // 1000
			msg.append("�Է��Ͻ� ������ ���ڼ��� ").append(wordNum).append("/1000 �Դϴ�.");
			if (wordNum > 1000) {
				over = wordNum - 1000;
				msg.append("\n").append(over).append("�� �� �ʰ��߽��ϴ�. ���̼���.");
			} else {
				under = 1000 - wordNum;
				msg.append("\n").append(under).append("�� �� ���ּ���. �й��ϼ���.");
			}
		} else if (jcb.getSelectedIndex() == 4) { // 1500
			msg.append("�Է��Ͻ� ������ ���ڼ��� ").append(wordNum).append("/1500 �Դϴ�.");
			if (wordNum > 1500) {
				over = wordNum - 1500;
				msg.append("\n").append(over).append("�� �� �ʰ��߽��ϴ�. ���̼���.");
			} else {
				under = 1500 - wordNum;
				msg.append("\n").append(under).append("�� �� ���ּ���. �й��ϼ���.");
			}
		} else {	
			msg.append("�Է��Ͻ� ������ ���ڼ��� ").append(wordNum).append(" �Դϴ�.");
		}
		
		JOptionPane.showMessageDialog(wc, msg.toString());
	}
}
