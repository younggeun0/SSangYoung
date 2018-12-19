package date181219;

import java.io.File;

/**
 * 폴더생성, 파일 삭제
 * @author owner
 */
public class UseFile2 {
	
	public void createDirectory() {
		File file = new File("c:/young/oh");
		
		if (file.mkdir()) {
			System.out.println("폴더 생성 성공");
		} else { 
			System.out.println("같은 이름의 폴더가 존재");
		}
	}
	
	public void removeFile() {
		File file = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/temp/a.txt");
		boolean flag = file.delete();
		
		if (flag) {
			System.out.println("파일 삭제 성공");
		} else {
			System.out.println("파일 삭제 실패");
		}
	}
	
	public static void main(String[] args) {
		UseFile2 uf2 = new UseFile2();
		// uf2.createDirectory();
		uf2.removeFile();
	}
}
