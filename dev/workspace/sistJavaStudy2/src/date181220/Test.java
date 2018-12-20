package date181220;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Test {

	public Test() throws IOException {
		File file = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/temp/java_write2.txt");
		
		FileOutputStream fos = new FileOutputStream(file);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write("¾È³ç!");
		bw.flush();
		bw.close();
	}
	
	public static void main(String[] args) {
		
		try {
			new Test();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
