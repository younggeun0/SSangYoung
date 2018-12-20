package date181219;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * HDD�� �����ϴ� File�� �����Ͽ� �� ������ �о���϶� ����ϴ�
 * FileInputStream
 * @author owner
 */
public class UseFileInputStream {
	
	public UseFileInputStream() {
		File file = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/temp/java_read.txt");
		
		if (file.exists()) {
			
			try {
				// ��Ʈ���� �����Ͽ� JVM���� HDD�� ���ϰ� ����
				FileInputStream fis = new FileInputStream(file);
				
				int temp = 0;
				
				while((temp = fis.read()) != -1) { // �о���� ������ �����Ѵٸ�
					System.out.print((char)temp);
				}
				
				// ��Ʈ�� ����� �Ϸ��ϸ� ��Ʈ���� ���� �޸� ������ ����
				fis.close();
				
			} catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			} catch (IOException ie) {
				// FileNotFoundException�� IOException �ڽ�Ŭ����
				// ������ FileNotFoundException �ؿ��� ��ƾ� ��������
				ie.printStackTrace();
			} 
			
		} else {
			System.out.println("��γ� ���ϸ��� Ȯ���ϼ���.");
		}
	}
	
	public static void main(String[] args) {
		new UseFileInputStream();
	}
}
