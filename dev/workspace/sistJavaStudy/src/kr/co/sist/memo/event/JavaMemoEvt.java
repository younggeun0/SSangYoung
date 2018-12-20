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
	private String taNoteData; // TextArea�� ������ ������ ����
	private String openPath;   // ������ ���ϸ��� ����
	
	public JavaMemoEvt(JavaMemo jm) {
		this.jm = jm;
		taNoteData = "";
		openPath = "";
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// ���� �޴������ۿ��� �̺�Ʈ�� �߻����� ��
		if (ae.getSource() == jm.getMiNew()) {
			newMemo();
		}
		// ���� �޴������ۿ��� �̺�Ʈ�� �߻����� ��
		if (ae.getSource() == jm.getMiOpen()) {
			try {
				openMemo();
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(jm, "������ ������ ���� �� �����ϴ�.",
						"���Ͽ��� ����", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jm, "������ ������ �о���̴� �� ������ �߻��߽��ϴ�.",
						"���Ͽ��� ����", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
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
			closeMemo();
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
		closeMemo();
	}
	
	public void closeMemo() {
		boolean flag = false; // �ݱ�
		if (!taNoteData.equals(jm.getTaNote().getText())) {
			
			int select = JOptionPane.showConfirmDialog(jm, 
					"��������� �ֽ��ϴ�. �����ϰ� �����Ͻðڽ��ϱ�?");
			switch(select) {
			case JOptionPane.OK_OPTION :
				saveMemo();
				break;
			case JOptionPane.NO_OPTION :
				break;
			case JOptionPane.CANCEL_OPTION :
				flag = true; // �ݱ� ���
			}
		}
		
		if(!flag) {
			jm.dispose();
		}
	}
	
	/**
	 * ���� : TextArea�� �ʱ�ȭ
	 */
	public void newMemo() {
		
		TextArea tempTa = jm.getTaNote();
		boolean flagNew = false;
		
		// ������ �������� �Ǵ�
		if (!taNoteData.equals(tempTa.getText())) {
			int flag = JOptionPane.showConfirmDialog(jm, "�ٸ� �̸����� ���� �Ͻðڽ��ϱ�?");
			
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
			
			// ������ �� ���Ŀ��� �б��� ������ �ִٸ� �ʱ�ȭ
			taNoteData = tempTa.getText();
			openPath = ""; // �о���� ������ ��� �ʱ�
			jm.setTitle("�޸��� - ����");
		}
	}
	
	/**
	 * txt���� ����
	 */
	public void openMemo() throws IOException, FileNotFoundException {
		// TextArea�� ����� �о�鿴�� ������ �ٸ��ٸ� ���忩�θ� ����
		// �۾��� �����Ѵ�.
		TextArea tempTa = jm.getTaNote();
		boolean flagOpen = false;
		
		if (!taNoteData.equals(tempTa.getText())) {
			int flag = JOptionPane.showConfirmDialog(jm, "\n�����Ͻðڽ��ϱ�?");
			switch(flag) {
			case JOptionPane.OK_OPTION :
				if (!openPath.equals("")) { // �ѹ��̶� ��������
					// ���� �̸��� ������ ������ 
					saveMemo();
				} else {
					// �ٸ� �̸����� ����
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
			FileDialog fdOpen = new FileDialog(jm, "����", FileDialog.LOAD);
			fdOpen.setVisible(true);
			
			String fPath = fdOpen.getDirectory();
			String fName = fdOpen.getFile();
			
			if (fPath != null) { // ������  ������ ����
				/////////////// 12-20-2018 ��Ʈ������ ������ ������ �д� �ڵ��߰� ���� /////////////////////////////
				
				// ������ ���Ϸ� ���ϰ�ü ����
				File file = new File(fPath+fName);
				// 16bit Stream ���
				BufferedReader br = null;
				
				try {
					br = new BufferedReader(new FileReader(file));
					
					String temp = "";
					// TA�� �ʱ�ȭ �� ��
					tempTa.setText(temp);
					
					while((temp = br.readLine()) != null) {
						// ���Ͽ��� �о���� ������ �����Ѵ�.
						tempTa.append(temp+"\n");
					}
					// ������ �о���� ������ ����
					taNoteData = tempTa.getText();
					// ������ ���ϸ��� ����
					openPath = file.getAbsolutePath();
				} finally {
					if(br != null) br.close();
				}
				/////////////// 12-20-2018 ��Ʈ������ ������ ������ �д� �ڵ��߰� �� /////////////////////////////
				
				// ������ ��ο� �̸��� Frame�� TitleBar�� ����
				StringBuilder title = new StringBuilder();
				title.append("�޸��� - ���� ").append(fPath).append(fName);
				
				jm.setTitle(title.toString());
			}
		}
	}
	
	/**
	 * �ۼ��� �޸� ���� - ������ ���ϸ��� �״�� ���ϸ� �ݿ�
	 * @throws IOException 
	 */
	public void saveMemo() {
		// ������ ������ �̸��� ���Ͽ� ���� ���� ��
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
			// ����ڰ� ���丮���� ������� ������ �� ���� ������ 
			// File Ŭ������ ����� �ʿ䰡 ����.
			bw = new BufferedWriter(new FileWriter(pathName));
			
			bw.write(jm.getTaNote().getText()); // TextArea�� ������ ��Ʈ���� ���
			bw.flush(); // ��Ʈ���� ��ϵ�  ������ �������� ����
			openPath = pathName;
			taNoteData = jm.getTaNote().getText();
		} finally {
			if(bw != null) { bw.close(); }
		}
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
			
			try {
				createFile(fPath+fName);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jm, "������ ���� �߻�"
						,"�����߻�",JOptionPane.ERROR_MESSAGE);
			}
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
