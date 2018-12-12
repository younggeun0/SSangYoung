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
	 * 새글
	 */
	public void newMemo() {
		
	}
	
	/**
	 * txt파일 열기
	 */
	public void openMemo() {
		
	}
	
	/**
	 * 작성한 메모를 저장 - 기존의 파일명을 그대로 파일명에 반영
	 */
	public void saveMemo() {
		
	}
	
	/**
	 * 파일명을 입력받아 새이름으로 저장
	 */
	public void newSaveMemo() {
		
	}
	
	/**
	 * 글꼴을 설정하는 다이얼로그를 실행
	 */
	public void formatDialog() {
		
	}
	
	/**
	 * 메모장 정보를 제공하는 다이얼로그를 실행
	 */
	public void helpDialog() {
		
	}
}
