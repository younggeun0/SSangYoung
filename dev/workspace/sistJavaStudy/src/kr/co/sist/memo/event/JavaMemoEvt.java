package kr.co.sist.memo.event;

import java.awt.FileDialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import kr.co.sist.memo.view.JavaMemo;
import kr.co.sist.memo.view.MemoFormat;
import kr.co.sist.memo.view.MemoHelp;

public class JavaMemoEvt extends WindowAdapter implements ActionListener {

	private JavaMemo jm;
	private String taNoteData; // TextArea의 내용을 저장할 변수
	private String openPath;   // 열었던 파일명을 저장
	
	public JavaMemoEvt(JavaMemo jm) {
		this.jm = jm;
		taNoteData = "";
		openPath = "";
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// 새글 메뉴아이템에서 이벤트가 발생했을 때
		if (ae.getSource() == jm.getMiNew()) {
			newMemo();
		}
		// 열기 메뉴아이템에서 이벤트가 발생했을 때
		if (ae.getSource() == jm.getMiOpen()) {
			try {
				openMemo();
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(jm, "선택한 파일을 읽을 수 없습니다.",
						"파일열기 에러", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jm, "선택한 파일을 읽어들이는 중 문제가 발생했습니다.",
						"파일열기 에러", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
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
			closeMemo();
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
		closeMemo();
	}
	
	public void closeMemo() {
		boolean flag = false; // 닫기
		if (!taNoteData.equals(jm.getTaNote().getText())) {
			
			int select = JOptionPane.showConfirmDialog(jm, 
					"변경사항이 있습니다. 저장하고 종료하시겠습니까?");
			switch(select) {
			case JOptionPane.OK_OPTION :
				saveMemo();
				break;
			case JOptionPane.NO_OPTION :
				break;
			case JOptionPane.CANCEL_OPTION :
				flag = true; // 닫기 취소
			}
		}
		
		if(!flag) {
			jm.dispose();
		}
	}
	
	/**
	 * 새글 : TextArea를 초기화
	 */
	public void newMemo() {
		
		TextArea tempTa = jm.getTaNote();
		boolean flagNew = false;
		
		// 저장할 것인지를 판단
		if (!taNoteData.equals(tempTa.getText())) {
			int flag = JOptionPane.showConfirmDialog(jm, "다른 이름으로 저장 하시겠습니까?");
			
			switch(flag) { 
			case JOptionPane.OK_OPTION :
				newSaveMemo();
				break;
			case JOptionPane.NO_OPTION :
				flagNew = false;
				break;
			default:
				flagNew = true;
			}
		}
		
		if (!flagNew) {
			tempTa.getText();
			tempTa.setText("");
			
			// 새글이 된 이후에는 읽기한 내용이 있다면 초기화
			taNoteData = tempTa.getText();
			openPath = ""; // 읽어들인 파일의 경로 초기
			jm.setTitle("메모장 - 새글");
		}
	}
	
	/**
	 * txt파일 열기
	 */
	public void openMemo() throws IOException, FileNotFoundException {
		// TextArea의 내용과 읽어들였던 내용이 다르다면 저장여부를 묻고
		// 작업을 진행한다.
		TextArea tempTa = jm.getTaNote();
		boolean flagOpen = false;
		
		if (!taNoteData.equals(tempTa.getText())) {
			int flag = JOptionPane.showConfirmDialog(jm, "\n저장하시겠습니까?");
			switch(flag) {
			case JOptionPane.OK_OPTION :
				if (!openPath.equals("")) { // 한번이라도 열었는지
					// 기존 이름에 저장할 것인지 
					saveMemo();
				} else {
					// 다른 이름으로 저장
					newSaveMemo();
				}
				break;
			case JOptionPane.CANCEL_OPTION :
				flagOpen=false;
				break;
			case JOptionPane.NO_OPTION :
				flagOpen=false;
			}
		} 
		
		if ( !flagOpen ) {
			FileDialog fdOpen = new FileDialog(jm, "열기", FileDialog.LOAD);
			fdOpen.setVisible(true);
			
			String fPath = fdOpen.getDirectory();
			String fName = fdOpen.getFile();
			
			if (fPath != null) { // 선택한  파일이 존재
				/////////////// 12-20-2018 스트림으로 파일의 내용을 읽는 코드추가 시작 /////////////////////////////
				
				// 선택한 파일로 파일객체 생성
				File file = new File(fPath+fName);
				// 16bit Stream 사용
				BufferedReader br = null;
				
				try {
					br = new BufferedReader(new FileReader(file));
					
					String temp = "";
					// TA를 초기화 한 후
					tempTa.setText(temp);
					
					while((temp = br.readLine()) != null) {
						// 파일에서 읽어들인 내용을 설정한다.
						tempTa.append(temp+"\n");
					}
					// 변수에 읽어들인 내용을 저장
					taNoteData = tempTa.getText();
					// 열었던 파일명을 저장
					openPath = file.getAbsolutePath();
				} finally {
					if(br != null) br.close();
				}
				/////////////// 12-20-2018 스트림으로 파일의 내용을 읽는 코드추가 끝 /////////////////////////////
				
				// 파일의 경로와 이름을 Frame의 TitleBar에 설정
				StringBuilder title = new StringBuilder();
				title.append("메모장 - 열기 ").append(fPath).append(fName);
				
				jm.setTitle(title.toString());
			}
		}
	}
	
	/**
	 * 작성한 메모를 저장 - 기존의 파일명을 그대로 파일명에 반영
	 * @throws IOException 
	 */
	public void saveMemo() {
		// 기존에 열었던 이름의 파일에 덮어 쓰는 일
		if (!openPath.equals("")) {
			try {
				createFile(openPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			newSaveMemo();
		}
	
	}
	
	private void createFile(String pathName) throws IOException {
		BufferedWriter bw = null;
		
		try {
			// 사용자가 디렉토리명을 마음대로 변경할 수 없기 때문에 
			// File 클래스를 사용할 필요가 없다.
			bw = new BufferedWriter(new FileWriter(pathName));
			
			bw.write(jm.getTaNote().getText()); // TextArea의 내용을 스트림에 기록
			bw.flush(); // 스트림에 기록된  내용을 목적지로 분출
			openPath = pathName;
			taNoteData = jm.getTaNote().getText();
		} finally {
			if(bw != null) { bw.close(); }
		}
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
			
			try {
				createFile(fPath+fName);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jm, "저장중 문제 발생"
						,"문제발생",JOptionPane.ERROR_MESSAGE);
			}
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
