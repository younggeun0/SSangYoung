package date181219;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * HDD에 존재하는 File과 연결하여 그 내용을 읽어들일때 사용하는
 * FileInputStream
 * @author owner
 */
public class UseFileInputStream {
	
	public UseFileInputStream() {
		File file = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/temp/java_read.txt");
		
		if (file.exists()) {
			
			try {
				// 스트림을 생성하여 JVM에서 HDD의 파일과 연결
				FileInputStream fis = new FileInputStream(file);
				
				int temp = 0;
				
				while((temp = fis.read()) != -1) { // 읽어들인 내용이 존재한다면
					System.out.print((char)temp);
				}
				
				// 스트림 사용을 완료하면 스트림을 끊어 메모리 누수를 차단
				fis.close();
				
			} catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			} catch (IOException ie) {
				// FileNotFoundException은 IOException 자식클래스
				// 때문에 FileNotFoundException 밑에서 잡아야 에러없음
				ie.printStackTrace();
			} 
			
		} else {
			System.out.println("경로나 파일명을 확인하세요.");
		}
	}
	
	public static void main(String[] args) {
		new UseFileInputStream();
	}
}
