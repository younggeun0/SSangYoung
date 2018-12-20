package kr.co.sist.memo.run;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import kr.co.sist.memo.view.JavaMemo;

/**
 * 메모장 클래스를 실행하는 일
 * @author owner
 */
public class RunJavaMemo {
	
	public Font readFontConfig() throws IOException {
		
		BufferedReader br = null;
		Font fontConfig = null;
		
		try {
			br = new BufferedReader(new FileReader("C:/Users/owner/youngRepositories/SSangYoung/dev/temp/fontConfig.dat"));
			String[] data = br.readLine().split(",");
			
			fontConfig = new Font(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
			
		} finally {
			if(br != null) br.close();
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
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		new JavaMemo(fontConfig);
	}
}
