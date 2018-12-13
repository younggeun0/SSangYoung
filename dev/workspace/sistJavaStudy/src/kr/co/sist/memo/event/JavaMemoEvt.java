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
		// ���� �޴������ۿ��� �̺�Ʈ�� �߻����� ��
		if (ae.getSource() == jm.getMiNew()) {
			newMemo();
		}
		// ���� �޴������ۿ��� �̺�Ʈ�� �߻����� ��
		if (ae.getSource() == jm.getMiOpen()) {
			openMemo();
		}
		// ���� �޴������ۿ��� �̺�Ʈ�� �߻����� ��
		if (ae.getSource() == jm.getMiSave()) {
			saveMemo();
		}
		// �ٸ� �̸����� ���� �޴������ۿ��� �̺�Ʈ�� �߻����� ��
		if (ae.getSource() == jm.getMiNewSave()) {
			newSaveMemo();
		}
		// �ݱ� �޴������ۿ��� �̺�Ʈ�� �߻����� ��
		if (ae.getSource() == jm.getMiEnd()) {
			jm.dispose();
		}
		// �۲� �޴������ۿ��� �̺�Ʈ�� �߻����� ��
		if (ae.getSource() == jm.getMiFormat()) {
			formatDialog();
		}
		// �޸������� �޴������ۿ��� �̺�Ʈ�� �߻����� ��
		if (ae.getSource() == jm.getMiHelp()) {
			helpDialog();
		}
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		jm.dispose();
	}
	
	/**
	 * ���� : TextArea�� �ʱ�ȭ
	 */
	public void newMemo() {
		jm.getTaNote().getText();
		jm.getTaNote().setText("");
		
		jm.setTitle("�޸��� - ����");
	}
	
	/**
	 * txt���� ����
	 */
	public void openMemo() {
		FileDialog fdOpen = new FileDialog(jm, "����", FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		String fPath = fdOpen.getDirectory();
		String fName = fdOpen.getFile();
		
		if (fPath != null) { // ������  ������ ����
			// ������ ��ο� �̸��� Frame�� TitleBar�� ����
			StringBuilder title = new StringBuilder();
			title.append("�޸��� - ���� ").append(fPath).append(fName);
			
			jm.setTitle(title.toString());
		}
	}
	
	/**
	 * �ۼ��� �޸� ���� - ������ ���ϸ��� �״�� ���ϸ� �ݿ�
	 */
	public void saveMemo() {
		newSaveMemo();
	}
	
	/**
	 * ���ϸ��� �Է¹޾� ���̸����� ����
	 */
	public void newSaveMemo() {
		FileDialog fdSave = new FileDialog(jm, "����", FileDialog.SAVE);
		fdSave.setVisible(true);
		
		String fPath = fdSave.getDirectory();
		String fName = fdSave.getFile();
		
		if (fPath != null) { // ������  ������ ����
			// ������ ��ο� �̸��� Frame�� TitleBar�� ����
			StringBuilder title = new StringBuilder();
			title.append("�޸��� - ���� ").append(fPath).append(fName);
			
			jm.setTitle(title.toString());
		}
	}
	
	/**
	 * �۲��� �����ϴ� ���̾�α׸� ����
	 */
	public void formatDialog() {
		new MemoFormat(jm);
	}
	
	/**
	 * �޸��� ������ �����ϴ� ���̾�α׸� ����
	 */
	public void helpDialog() {
		new MemoHelp(jm);
	}
}
