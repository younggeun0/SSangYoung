package kr.co.sist.memo.event;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.memo.view.JavaMemo;
import kr.co.sist.memo.view.MemoFormat;
import kr.co.sist.memo.view.MemoHelp;

public class JavaMemoEvt extends WindowAdapter implements ActionListener {

	private JavaMemo jm;
	
	public JavaMemoEvt(JavaMemo jm) {
		this.jm = jm;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// 새글 메뉴아이템에서 이벤트가 발생했을 때
		if (ae.getSource() == jm.getMiNew()) {
			newMemo();
		}
		// 열기 메뉴아이템에서 이벤트가 발생했을 때
		if (ae.getSource() == jm.getMiOpen()) {
			openMemo();
		}
		// 저장 메뉴아이템에서 이벤트가 발생했을 때
		if (ae.getSource() == jm.getMiSave()) {
			saveMemo();
		}
		// 다른 이름으로 저장 메뉴아이템에서 이벤트가 발생했을 때
		if (ae.getSource() == jm.getMiNewSave()) {
			newSaveMemo();
		}
		// 닫기 메뉴아이템에서 이벤트가 발생했을 때
		if (ae.getSource() == jm.getMiEnd()) {
			jm.dispose();
		}
		// 글꼴 메뉴아이템에서 이벤트가 발생했을 때
		if (ae.getSource() == jm.getMiFormat()) {
			formatDialog();
		}
		// 메모장정보 메뉴아이템에서 이벤트가 발생했을 때
		if (ae.getSource() == jm.getMiHelp()) {
			helpDialog();
		}
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		jm.dispose();
	}
	
	/**
	 * 새글 : TextArea를 초기화
	 */
	public void newMemo() {
		jm.getTaNote().getText();
		jm.getTaNote().setText("");
		
		jm.setTitle("메모장 - 새글");
	}
	
	/**
	 * txt파일 열기
	 */
	public void openMemo() {
		FileDialog fdOpen = new FileDialog(jm, "열기", FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		String fPath = fdOpen.getDirectory();
		String fName = fdOpen.getFile();
		
		if (fPath != null) { // 선택한  파일이 존재
			// 파일의 경로와 이름을 Frame의 TitleBar에 설정
			StringBuilder title = new StringBuilder();
			title.append("메모장 - 열기 ").append(fPath).append(fName);
			
			jm.setTitle(title.toString());
		}
	}
	
	/**
	 * 작성한 메모를 저장 - 기존의 파일명을 그대로 파일명에 반영
	 */
	public void saveMemo() {
		newSaveMemo();
	}
	
	/**
	 * 파일명을 입력받아 새이름으로 저장
	 */
	public void newSaveMemo() {
		FileDialog fdSave = new FileDialog(jm, "저장", FileDialog.SAVE);
		fdSave.setVisible(true);
		
		String fPath = fdSave.getDirectory();
		String fName = fdSave.getFile();
		
		if (fPath != null) { // 선택한  파일이 존재
			// 파일의 경로와 이름을 Frame의 TitleBar에 설정
			StringBuilder title = new StringBuilder();
			title.append("메모장 - 저장 ").append(fPath).append(fName);
			
			jm.setTitle(title.toString());
		}
	}
	
	/**
	 * 글꼴을 설정하는 다이얼로그를 실행
	 */
	public void formatDialog() {
		new MemoFormat(jm);
	}
	
	/**
	 * 메모장 정보를 제공하는 다이얼로그를 실행
	 */
	public void helpDialog() {
		new MemoHelp(jm);
	}
}
