package date181220;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

public class UseFileOutputStream3 {

	public UseFileOutputStream3() throws IOException {
		String data = "오지고요 지리고요 고요고요 고요한 밤이고요";
		
		File file = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/temp/java_write2.txt");
		
		boolean flag = false; 
		if (file.exists()) {
			boolean[] flagVal = { false, true, true }; 
			flag = flagVal[JOptionPane.showConfirmDialog(null, "덮어 쓰시겠습니까?")];
		}
		
		if (!flag) {

			// 16bit Stream만 사용
			BufferedWriter bw = null;
			
			try {
				bw = new BufferedWriter(new FileWriter(file));
				
				bw.write(data); 
				bw.flush();		
				
				System.out.println("파일에 기록 완료!");
			} finally {
				if(bw!=null) { bw.close(); }
			}
		}
	}
	public static void main(String[] args) {
		try {
			new UseFileOutputStream3();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
