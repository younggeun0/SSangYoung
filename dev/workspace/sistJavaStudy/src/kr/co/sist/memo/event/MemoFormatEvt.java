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
		
		// 선택되는 아이템의 값을 먼저 저장하고
		// 클릭되는 리스트와 관련있는 TextField에 할당해준다.
		String selectedValue = ((List)ie.getSource()).getSelectedItem();
		Font lblPreviewFont = mf.getLblPreview().getFont();
		String name = lblPreviewFont.getFamily();
		int style = lblPreviewFont.getStyle();
		int size = lblPreviewFont.getSize();
		
		// 선택한 아이템을 TextField의 값으로 설정
		// 미리보기 라벨을 변경시킴
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
	 * MemoFormat 클래스의 미리보기 Label의 Font정보를 
	 * JavaMemo 클래스의 TextArea에 설정
	 */
	public void setTaNoteFont() {
		mf.getJm().getTaNote().setFont(mf.getLblPreview().getFont());
		
		try {
			saveFontConfig(); // 설정한 글꼴상태정보를 저장
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		mf.dispose();
	}
	
	/**
	 * 설정한 폰트의 상태를 파일로 저장 - 다음번에 프로그램이 실행되면
	 * 현재 저장된 폰트값을 적용하여 Ta를 설정하면 변경상태가 유지됨
	 */
	private void saveFontConfig() throws IOException {
		
		BufferedWriter bw = null;
		
		try {
			// 미리보기 라벨에 설정된 폰트정보를 얻음
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
