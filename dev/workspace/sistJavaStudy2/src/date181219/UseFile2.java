package date181219;

import java.io.File;

/**
 * ��������, ���� ����
 * @author owner
 */
public class UseFile2 {
	
	public void createDirectory() {
		File file = new File("c:/young/oh");
		
		if (file.mkdir()) {
			System.out.println("���� ���� ����");
		} else { 
			System.out.println("���� �̸��� ������ ����");
		}
	}
	
	public void removeFile() {
		File file = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/temp/a.txt");
		boolean flag = file.delete();
		
		if (flag) {
			System.out.println("���� ���� ����");
		} else {
			System.out.println("���� ���� ����");
		}
	}
	
	public static void main(String[] args) {
		UseFile2 uf2 = new UseFile2();
		// uf2.createDirectory();
		uf2.removeFile();
	}
}
