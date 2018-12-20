package date181220;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

/**
 * 8bit Stream과 16bit Stream을 사용하여 문자열 데이터를 
 * File에 기록
 * @author owner
 */
public class UseFileOutputStream2 {

	public UseFileOutputStream2() throws IOException {
		String data = "오지고요 지리고요 고요고요 고요한 밤이고요";
		
		// 1. File 객체 생성 : 파일이 존재한다면 덮어 쓸 것인지를 판단하기 위해 만듦.
		File file = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/temp/java_write2.txt");
		
		boolean flag = false; // 파일이 없을 때 
		if (file.exists()) {
			boolean[] flagVal = { false, true, true }; // 예, 아니오, 취소 
			flag = flagVal[JOptionPane.showConfirmDialog(null, "덮어 쓰시겠습니까?")];
		}
		
		// 2. 스트림 생성
		if (!flag) {

			BufferedWriter bw = null;
			
			try {
				// 8bit Stream과 16bitStream을 사용한 것
				/*// 파일을 생성하는 Stream : FileNotFoundException이 발생(폴더가 없을 때)
				FileOutputStream fos = new FileOutputStream(file);
				// 문자열을 쓰기 위한 Stream 연결 : (속도가 느리다)
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				// 느린 속도를 개선하기 위한 Stream 연결 : 
				bw = new BufferedWriter(osw);*/
				
				bw = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(file)));
				
				bw.write(data); // 스트림에 데이터를 기록
				bw.flush();		// 목적지에 파일로 분출
				
				System.out.println("파일에 기록 완료!");
			} finally {
				
				// 스트림 객체가 생성되어 있다면 연결을 끊음
				if(bw!=null) { bw.close(); }
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			new UseFileOutputStream2();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
