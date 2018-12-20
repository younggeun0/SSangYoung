package date181220;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class UseFileInputStream {

	public UseFileInputStream() throws IOException {
		File file = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/temp/java_read.txt");

		if (file.exists()) {

			BufferedReader br = null;

			try {
				// 스트림을 생성하여 JVM에서 HDD의 파일과 연결
				// 한글처리를 위해 16bit Stream과 연결

				// FileInputStream : 파일과 연결
				// InputStreamReader : 8bit-16bit 연결
				// BufferedReader : 속도개선, 줄단위 읽기
//				FileInputStream fis = new FileInputStream(file);
//				InputStreamReader isr = new InputStreamReader(fis);
//				br = new BufferedReader(isr);

				br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				
				String temp = "";

				// 줄단위(\n전까지) 읽어서 읽어들인 내용이 있다면
				while ((temp = br.readLine()) != null) {
					System.out.println(temp); // 출력
				}
			} finally {
				if (br != null) br.close();
			}
		} else {
			System.out.println("경로나 파일명을 확인하세요.");
		}
	}

	public static void main(String[] args) {
		try {
			new UseFileInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
