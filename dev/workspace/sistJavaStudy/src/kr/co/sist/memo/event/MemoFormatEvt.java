package kr.co.sist.memo.event;

import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import kr.co.sist.memo.view.MemoFormat;

public class MemoFormatEvt extends WindowAdapter implements ActionListener, ItemListener {

	private MemoFormat mf;

	public MemoFormatEvt(MemoFormat mf) {
		this.mf = mf;
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
		
		// ���õǴ� �������� ���� ���� �����ϰ�
		// Ŭ���Ǵ� ����Ʈ�� �����ִ� TextField�� �Ҵ����ش�.
		String selectedValue = ((List)ie.getSource()).getSelectedItem();
		Font lblPreviewFont = mf.getLblPreview().getFont();
		String name = lblPreviewFont.getFamily();
		int style = lblPreviewFont.getStyle();
		int size = lblPreviewFont.getSize();
		
		// ������ �������� TextField�� ������ ����
		// �̸����� ���� �����Ŵ
		if (ie.getSource() == mf.getListFont()) { 
			mf.getTfFont().setText(selectedValue);
			name = selectedValue;
		}
		if (ie.getSource() == mf.getListStyle()) {
			mf.getTfStyle().setText(selectedValue);
			style = ((List)ie.getSource()).getSelectedIndex();
		}
		if (ie.getSource() == mf.getListSize()) {
			mf.getTfSize().setText(selectedValue);
			size = Integer.parseInt(selectedValue);
		}
		
		mf.getLblPreview().setFont(new Font(name, style, size));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mf.getBtnApply()) {
			setTaNoteFont();
		}
		if (e.getSource() == mf.getBtnCancel()) {
			mf.dispose();
		}
	}
	
	/**
	 * MemoFormat Ŭ������ �̸����� Label�� Font������ 
	 * JavaMemo Ŭ������ TextArea�� ����
	 */
	public void setTaNoteFont() {
		mf.getJm().getTaNote().setFont(mf.getLblPreview().getFont());
		
		try {
			saveFontConfig(); // ������ �۲û��������� ����
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		mf.dispose();
	}
	
	/**
	 * ������ ��Ʈ�� ���¸� ���Ϸ� ���� - �������� ���α׷��� ����Ǹ�
	 * ���� ����� ��Ʈ���� �����Ͽ� Ta�� �����ϸ� ������°� ������
	 */
	private void saveFontConfig() throws IOException {
		
		BufferedWriter bw = null;
		
		try {
			// �̸����� �󺧿� ������ ��Ʈ������ ����
			Font fontTemp = mf.getLblPreview().getFont();
			StringBuilder fontData = new StringBuilder();
			
			fontData.append(fontTemp.getFamily()).append(",")
			 .append(fontTemp.getStyle()).append(",")
			 .append(fontTemp.getSize());
			
			bw = new BufferedWriter(new FileWriter("C:/Users/owner/youngRepositories/SSangYoung/dev/temp/fontConfig.dat"));
			bw.write(fontData.toString());
			bw.flush();
			
		} finally {
			if (bw != null) bw.close();
		}
	}

	@Override
	public void windowClosing(WindowEvent we) {
		mf.dispose();
	}
}
