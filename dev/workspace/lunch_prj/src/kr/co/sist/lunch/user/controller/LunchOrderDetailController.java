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
			showMessageDialog(lodv, "주문자명 입력은 필수입니다.");
			lodv.getJtfOrderName().requestFocus();
			return;
		}
		
		JTextField jtfPhone = lodv.getJtfPhone();
		String tel = jtfPhone.getText().trim();
		
		if (tel.equals("")) {
			showMessageDialog(lodv, "주문자 연락처 입력은 필수입니다.");
			lodv.getJtfPhone().requestFocus();
			return;
		}
		/*
		// 전화번호는 3-4이하-4이하 총 13자리 이하
		String telNumbers = tel.replaceAll("-", "");
		try {
			Integer.parseInt(telNumbers);
		} catch (NumberFormatException nfe) {

			if (telNumbers.length() > 10) {
				showMessageDialog(lodv, "연락처가 너무 깁니다.");
				return;
			}
			System.out.println(nfe.getMessage());
			showMessageDialog(lodv, "연락처는 숫자만 입력가능합니다.");

			return;
		}
		if (telNumbers.length() < 10) {
			showMessageDialog(lodv, "연락처가 너무 짧습니다.");
			return;
		}*/
		String[] separatedTel = tel.split("-");
		
		try {
			if (separatedTel.length == 3) { // 제대로된 전화번호
				if (separatedTel[0].length() != 3 || !(separatedTel[1].length() > 2 && separatedTel[1].length()<5)
						|| separatedTel[2].length() != 4) {
					showMessageDialog(lodv, "전화번호의 자리수가 잘못되었습니다.");
					return;
				}
				
				for(int i=0; i<separatedTel.length; i++) {
					Integer.parseInt(separatedTel[i]);
				}
			} else {
				showMessageDialog(lodv, "전화번호의 형식이 올바르지 않습니다.");
				return;
			}
		} catch (NumberFormatException e) {
			showMessageDialog(lodv, "전화번호에 문자가 들어있습니다.");
		}
		
		// 주문 수행
		printOrder();
	}
	
	/**
	 * 주문사항을 보여주고 주문을 할 것인지 처리.
	 */
	public void printOrder() {

		JTextArea jtaReceipt = new JTextArea(20, 23);
		jtaReceipt.setEditable(false);
		JScrollPane jsp = new JScrollPane(jtaReceipt);
		StringBuilder data = new StringBuilder();
		
		try {
			data
			.append("=================================\n")
			.append("                            재찬 도시락\n")
			.append("----------------------------------------------------------\n")
			.append("   현금(소득공제)\n")
			.append("   소래포구점(본점)\n")
			.append("   대표 : 이재찬 201-11-11212\n")
			.append("-----------------------------------------------------------\n")
			.append("   주문자명 : ").append(lodv.getJtfOrderName().getText().trim()).append("\n")
			.append("   주문자 연락처 : ").append(lodv.getJtfPhone().getText().trim()).append("\n")
			.append("   주문자 IP 주소 : ").append(InetAddress.getLocalHost().getHostAddress()).append("\n")
			.append("-----------------------------------------------------------\n")
			.append("   도시락명 : ").append(lodv.getJtfLunchName().getText().trim()).append("(").append(lunchCode).append(")\n")
			.append("   수량 : ").append(lodv.getJcbQuan().getSelectedItem().toString()).append("개\n")
			.append("   단가 : ").append(lodv.getJtfLunchPrice().getText().trim()).append("원\n")
			.append("-----------------------------------------------------------\n")
			.append("   총액 : ").append(lodv.getJtfTotalPrice().getText().trim()).append("원\n")
			.append("-----------------------------------------------------------\n")
			.append("   위의 정보로 도시락을 주문하시겠습니까?\n")
			.append("==================================\n");
			
		} catch (UnknownHostException e) {
			showMessageDialog(lodv, "주문자 IP 주소를 얻을 수 없습니다.");
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
				showMessageDialog(lodv, "도시락 주문이 완료되었습니다.\n항상 최선을 다하는 재찬 도시락");
				lodv.dispose(); // 주문이 완료되었으므로 주문창을 닫는다.
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				showMessageDialog(lodv, "DB에 문제가 발생했습니다.");
				e.printStackTrace();
			}
			
			break;
		}		
	} // printOrder
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == lodv.getJbEnd()) { // 종료
			lodv.dispose();
		}
		
		if (ae.getSource() == lodv.getJbOrder()) { // 주문
			lunchOrder();
		}
		
		if (ae.getSource() == lodv.getJcbQuan()) { // 수량 선택 시 총액을 보여줌
			int selectedQuan = ((Integer)lodv.getJcbQuan().getSelectedItem()).intValue();
			int newTotalPrice = 0;
			try {
				newTotalPrice = Integer.parseInt(lodv.getJtfLunchPrice().getText())*selectedQuan;
				lodv.getJtfTotalPrice().setText(String.valueOf(newTotalPrice));
			} catch (NumberFormatException e) {
				showMessageDialog(lodv, "가격은 정수이어야 합니다.");
			}
		}
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		lodv.dispose();
	}
}
