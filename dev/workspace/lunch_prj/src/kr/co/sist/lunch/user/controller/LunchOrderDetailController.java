package kr.co.sist.lunch.user.controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import static javax.swing.JOptionPane.showMessageDialog;

import kr.co.sist.lunch.user.model.LunchClientDAO;
import kr.co.sist.lunch.user.view.LunchOrderDetailView;
import kr.co.sist.lunch.user.vo.OrderAddVO;

public class LunchOrderDetailController extends WindowAdapter implements ActionListener {

	private LunchOrderDetailView lodv;
	private String lunchCode;
	
	public LunchOrderDetailController(LunchOrderDetailView lodv, String lunchCode) {
		this.lodv = lodv;
		this.lunchCode = lunchCode;
	}
	
	public void lunchOrder() {
		JTextField jtfOrderName = lodv.getJtfOrderName();
		String name = jtfOrderName.getText().trim();
		
		if (name.equals("")) {
			showMessageDialog(lodv, "�ֹ��ڸ� �Է��� �ʼ��Դϴ�.");
			lodv.getJtfOrderName().requestFocus();
			return;
		}
		
		JTextField jtfPhone = lodv.getJtfPhone();
		String tel = jtfPhone.getText().trim();
		
		if (tel.equals("")) {
			showMessageDialog(lodv, "�ֹ��� ����ó �Է��� �ʼ��Դϴ�.");
			lodv.getJtfPhone().requestFocus();
			return;
		}
		/*
		// ��ȭ��ȣ�� 3-4����-4���� �� 13�ڸ� ����
		String telNumbers = tel.replaceAll("-", "");
		try {
			Integer.parseInt(telNumbers);
		} catch (NumberFormatException nfe) {

			if (telNumbers.length() > 10) {
				showMessageDialog(lodv, "����ó�� �ʹ� ��ϴ�.");
				return;
			}
			System.out.println(nfe.getMessage());
			showMessageDialog(lodv, "����ó�� ���ڸ� �Է°����մϴ�.");

			return;
		}
		if (telNumbers.length() < 10) {
			showMessageDialog(lodv, "����ó�� �ʹ� ª���ϴ�.");
			return;
		}*/
		String[] separatedTel = tel.split("-");
		
		try {
			if (separatedTel.length == 3) { // ����ε� ��ȭ��ȣ
				if (separatedTel[0].length() != 3 || !(separatedTel[1].length() > 2 && separatedTel[1].length()<5)
						|| separatedTel[2].length() != 4) {
					showMessageDialog(lodv, "��ȭ��ȣ�� �ڸ����� �߸��Ǿ����ϴ�.");
					return;
				}
				
				for(int i=0; i<separatedTel.length; i++) {
					Integer.parseInt(separatedTel[i]);
				}
			} else {
				showMessageDialog(lodv, "��ȭ��ȣ�� ������ �ùٸ��� �ʽ��ϴ�.");
				return;
			}
		} catch (NumberFormatException e) {
			showMessageDialog(lodv, "��ȭ��ȣ�� ���ڰ� ����ֽ��ϴ�.");
		}
		
		// �ֹ� ����
		printOrder();
	}
	
	/**
	 * �ֹ������� �����ְ� �ֹ��� �� ������ ó��.
	 */
	public void printOrder() {

		JTextArea jtaReceipt = new JTextArea(20, 23);
		jtaReceipt.setEditable(false);
		JScrollPane jsp = new JScrollPane(jtaReceipt);
		StringBuilder data = new StringBuilder();
		
		try {
			data
			.append("=================================\n")
			.append("                            ���� ���ö�\n")
			.append("----------------------------------------------------------\n")
			.append("   ����(�ҵ����)\n")
			.append("   �ҷ�������(����)\n")
			.append("   ��ǥ : ������ 201-11-11212\n")
			.append("-----------------------------------------------------------\n")
			.append("   �ֹ��ڸ� : ").append(lodv.getJtfOrderName().getText().trim()).append("\n")
			.append("   �ֹ��� ����ó : ").append(lodv.getJtfPhone().getText().trim()).append("\n")
			.append("   �ֹ��� IP �ּ� : ").append(InetAddress.getLocalHost().getHostAddress()).append("\n")
			.append("-----------------------------------------------------------\n")
			.append("   ���ö��� : ").append(lodv.getJtfLunchName().getText().trim()).append("(").append(lunchCode).append(")\n")
			.append("   ���� : ").append(lodv.getJcbQuan().getSelectedItem().toString()).append("��\n")
			.append("   �ܰ� : ").append(lodv.getJtfLunchPrice().getText().trim()).append("��\n")
			.append("-----------------------------------------------------------\n")
			.append("   �Ѿ� : ").append(lodv.getJtfTotalPrice().getText().trim()).append("��\n")
			.append("-----------------------------------------------------------\n")
			.append("   ���� ������ ���ö��� �ֹ��Ͻðڽ��ϱ�?\n")
			.append("==================================\n");
			
		} catch (UnknownHostException e) {
			showMessageDialog(lodv, "�ֹ��� IP �ּҸ� ���� �� �����ϴ�.");
			return;
		}
		
		jtaReceipt.setText(data.toString());
		
		
		switch(JOptionPane.showConfirmDialog(lodv, jsp)) {
		case JOptionPane.OK_OPTION :
		
			try {
				OrderAddVO oavo = new OrderAddVO(lodv.getJtfOrderName().getText().trim(),
						lodv.getJtfPhone().getText().trim(), InetAddress.getLocalHost().getHostAddress(), 
						lunchCode, lodv.getJcbQuan().getSelectedIndex()+1);
				
				LunchClientDAO.getInstance().insertOrder(oavo);
				showMessageDialog(lodv, "���ö� �ֹ��� �Ϸ�Ǿ����ϴ�.\n�׻� �ּ��� ���ϴ� ���� ���ö�");
				lodv.dispose(); // �ֹ��� �Ϸ�Ǿ����Ƿ� �ֹ�â�� �ݴ´�.
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				showMessageDialog(lodv, "DB�� ������ �߻��߽��ϴ�.");
				e.printStackTrace();
			}
			
			break;
		}		
	} // printOrder
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == lodv.getJbEnd()) { // ����
			lodv.dispose();
		}
		
		if (ae.getSource() == lodv.getJbOrder()) { // �ֹ�
			lunchOrder();
		}
		
		if (ae.getSource() == lodv.getJcbQuan()) { // ���� ���� �� �Ѿ��� ������
			int selectedQuan = ((Integer)lodv.getJcbQuan().getSelectedItem()).intValue();
			int newTotalPrice = 0;
			try {
				newTotalPrice = Integer.parseInt(lodv.getJtfLunchPrice().getText())*selectedQuan;
				lodv.getJtfTotalPrice().setText(String.valueOf(newTotalPrice));
			} catch (NumberFormatException e) {
				showMessageDialog(lodv, "������ �����̾�� �մϴ�.");
			}
		}
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		lodv.dispose();
	}
}
