package kr.co.sist.memo.view;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;

import kr.co.sist.memo.event.JavaMemoEvt;

/**
 * 사용자가 간단한 메모를 작성, 파일로 저장, 
 * 읽어들이는 기능이 구현된 메모장  
 * @author owner
 */
@SuppressWarnings("serial")
public class JavaMemo extends Frame {

	private Menu menuFile, menuEdit, menuHelp;
	private MenuItem miNew, miOpen, miSave, miNewSave, miEnd, miFormat, miHelp;
	private TextArea taNote;
	
	public JavaMemo() {
		
		JavaMemoEvt jme = new JavaMemoEvt(this);
		addWindowListener(jme);
		
		setBounds(400,250,500,500);
		setVisible(true);
	}

	public Menu getMenuFile() {
		return menuFile;
	}
	public Menu getMenuEdit() {
		return menuEdit;
	}
	public Menu getMenuHelp() {
		return menuHelp;
	}
	public MenuItem getMiNew() {
		return miNew;
	}
	public MenuItem getMiOpen() {
		return miOpen;
	}
	public MenuItem getMiSave() {
		return miSave;
	}
	public MenuItem getMiNewSave() {
		return miNewSave;
	}
	public MenuItem getMiEnd() {
		return miEnd;
	}
	public MenuItem getMiFormat() {
		return miFormat;
	}
	public MenuItem getMiHelp() {
		return miHelp;
	}
}
