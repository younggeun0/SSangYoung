package date181219.hw;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FileHomework2 {

	private String path;
	private int numOfJava;
	private List<Integer> listIdx;
	private File[] files;
	
	public FileHomework2() {
		
		getPath();
		if(checkWord("java")) {
			deleteFiles();
		} else {
			JOptionPane.showMessageDialog(null, "해당 경로에 java 파일이 없습니다.");
		}
	}
	
	public void getPath() {
		path = JOptionPane.showInputDialog("경로를 입력하세요\n예)c:/dev/temp");
	}
	
	public boolean checkWord(String word) {
		
		listIdx = new ArrayList<Integer>();
		files = new File(path).listFiles();
		
		for(int i=0; i<files.length; i++) {
			
			if (files[i].getName().contains(word)){
				listIdx.add(i);
				numOfJava++;
			}
		}
		
		return (numOfJava != 0) ? true : false;
	}
	
	public void deleteFiles() {
		String msg = "java 파일이 "+numOfJava+"개 존재합니다. 삭제하시겠습니까?";
		int select = JOptionPane.showConfirmDialog(null, msg);
		
		switch(select) {
		case JOptionPane.OK_OPTION:
			for(int i=0; i<listIdx.size(); i++) {
				files[listIdx.get(i)].delete();
			}
		}
	}
	
	public static void main(String[] args) {
		new FileHomework2();
	}
}
