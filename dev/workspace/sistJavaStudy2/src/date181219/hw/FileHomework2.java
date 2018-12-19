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
			JOptionPane.showMessageDialog(null, "�ش� ��ο� java ������ �����ϴ�.");
		}
	}
	
	public void getPath() {
		path = JOptionPane.showInputDialog("��θ� �Է��ϼ���\n��)c:/dev/temp");
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
		String msg = "java ������ "+numOfJava+"�� �����մϴ�. �����Ͻðڽ��ϱ�?";
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
