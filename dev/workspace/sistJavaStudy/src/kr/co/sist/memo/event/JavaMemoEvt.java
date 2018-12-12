package kr.co.sist.memo.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.memo.view.JavaMemo;

public class JavaMemoEvt extends WindowAdapter implements ActionListener {

	private JavaMemo jm;
	
	public JavaMemoEvt(JavaMemo jm) {
		this.jm = jm;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		jm.dispose();
	}
	
	/**
	 * ����
	 */
	public void newMemo() {
		
	}
	
	/**
	 * txt���� ����
	 */
	public void openMemo() {
		
	}
	
	/**
	 * �ۼ��� �޸� ���� - ������ ���ϸ��� �״�� ���ϸ� �ݿ�
	 */
	public void saveMemo() {
		
	}
	
	/**
	 * ���ϸ��� �Է¹޾� ���̸����� ����
	 */
	public void newSaveMemo() {
		
	}
	
	/**
	 * �۲��� �����ϴ� ���̾�α׸� ����
	 */
	public void formatDialog() {
		
	}
	
	/**
	 * �޸��� ������ �����ϴ� ���̾�α׸� ����
	 */
	public void helpDialog() {
		
	}
}
