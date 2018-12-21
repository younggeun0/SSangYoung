package kr.co.sist.memo.run;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;

import kr.co.sist.memo.view.JavaMemo;

/**
 * 메모장 클래스를 실행하는 일
 * @author owner
 */
public class RunJavaMemo {
	
	public Font readFontConfig() throws IOException, ClassNotFoundException {
		
//		BufferedReader br = null;
		Font fontConfig = null;
		ObjectInputStream ois = null;
		
		try {
//			br = new BufferedReader(new FileReader("C:/Users/owner/youngRepositories/SSangYoung/dev/temp/fontConfig.dat"));
//			String[] data = br.readLine().split(",");
//			fontConfig = new Font(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
			
			ois = new ObjectInputStream(new FileInputStream(
					"C:/Users/owner/youngRepositories/SSangYoung/dev/temp/fontConfig.dat"));
			fontConfig = (Font)ois.readObject();
			
		} finally {
//			if(br != null) br.close();
			if (ois != null) ois.close();
		}
		
		return fontConfig;
	}

	/**
	 * 자바클래스를 실행하는 일 : Java Application
	 * @param args
	 */
	public static void main(String[] args) {

		RunJavaMemo rjm = new RunJavaMemo();
		Font fontConfig = null;
		
		try {
			if (rjm.readFontConfig() != null) {
				fontConfig = rjm.readFontConfig();
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		new JavaMemo(fontConfig);
	}
}
