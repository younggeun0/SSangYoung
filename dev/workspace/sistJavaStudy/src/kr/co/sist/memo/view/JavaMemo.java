package kr.co.sist.memo.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;

import kr.co.sist.memo.event.JavaMemoEvt;

/**
 * ����ڰ� ������ �޸� �ۼ�, ���Ϸ� ����, 
 * �о���̴� ����� ������ �޸���  
 * @author owner
 */
@SuppressWarnings("serial")
public class JavaMemo extends Frame {

	private Menu menuFile, menuEdit, menuHelp;
	private MenuItem miNew, miOpen, miSave, miNewSave, miEnd, miFormat, miHelp;
	private TextArea taNote;
	
	public JavaMemo(Font fontConfig) {
		super("�޸��� - �������");
		
		// �޴� ����
		menuFile = new Menu("����");
		menuEdit = new Menu("����");
		menuHelp = new Menu("����");
		
		// �޴� ������
		miNew = new MenuItem("����");
		miOpen = new MenuItem("����");
		miSave = new MenuItem("����");
		miNewSave = new MenuItem("�ٸ� �̸����� ����");
		miEnd = new MenuItem("�ݱ�");
		miFormat = new MenuItem("�۲�");
		miHelp = new MenuItem("�޸�������");

		// TextArea ����
		taNote = new TextArea();
		
		// �Ű������� ������ fontConfig�� ����Ͽ� TextArea�� font����
		if (fontConfig != null) {
			taNote.setFont(fontConfig);
		}
		
		// ��ġ
		// �޴������� -> �޴�
		menuFile.add(miNew); menuFile.addSeparator();
		menuFile.add(miOpen); menuFile.add(miSave);
		menuFile.add(miNewSave); menuFile.addSeparator();
		menuFile.add(miEnd);
		
		menuEdit.add(miFormat);
		
		menuHelp.add(miHelp);

		// �޴��� �޴��ٿ� ��ġ
		MenuBar mb = new MenuBar();
		mb.add(menuFile); mb.add(menuEdit); mb.add(menuHelp);
		
		// �޴��� -> Frame ��ġ
		setMenuBar(mb);
		// T.A�� BorderLayout�� Center�� ��ġ
		add(BorderLayout.CENTER, taNote);
		
		JavaMemoEvt jme = new JavaMemoEvt(this);
		// ������ �����̺�Ʈ ���
		addWindowListener(jme);
		// �޴������� �̺�Ʈ ���
		miNew.addActionListener(jme);
		miOpen.addActionListener(jme);
		miSave.addActionListener(jme);
		miNewSave.addActionListener(jme);
		miEnd.addActionListener(jme);
		miFormat.addActionListener(jme);
		miHelp.addActionListener(jme);
		
		// ������ ũ�⼳��
		setBounds(400,250,900,600);
		setVisible(true);
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
	public TextArea getTaNote() {
		return taNote;
	}
}
