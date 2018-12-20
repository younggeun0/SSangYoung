package date181220;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

/**
 * 8bit Stream�� 16bit Stream�� ����Ͽ� ���ڿ� �����͸� 
 * File�� ���
 * @author owner
 */
public class UseFileOutputStream2 {

	public UseFileOutputStream2() throws IOException {
		String data = "������� ������� ����� ����� ���̰��";
		
		// 1. File ��ü ���� : ������ �����Ѵٸ� ���� �� �������� �Ǵ��ϱ� ���� ����.
		File file = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/temp/java_write2.txt");
		
		boolean flag = false; // ������ ���� �� 
		if (file.exists()) {
			boolean[] flagVal = { false, true, true }; // ��, �ƴϿ�, ��� 
			flag = flagVal[JOptionPane.showConfirmDialog(null, "���� ���ðڽ��ϱ�?")];
		}
		
		// 2. ��Ʈ�� ����
		if (!flag) {

			BufferedWriter bw = null;
			
			try {
				// 8bit Stream�� 16bitStream�� ����� ��
				/*// ������ �����ϴ� Stream : FileNotFoundException�� �߻�(������ ���� ��)
				FileOutputStream fos = new FileOutputStream(file);
				// ���ڿ��� ���� ���� Stream ���� : (�ӵ��� ������)
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				// ���� �ӵ��� �����ϱ� ���� Stream ���� : 
				bw = new BufferedWriter(osw);*/
				
				bw = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(file)));
				
				bw.write(data); // ��Ʈ���� �����͸� ���
				bw.flush();		// �������� ���Ϸ� ����
				
				System.out.println("���Ͽ� ��� �Ϸ�!");
			} finally {
				
				// ��Ʈ�� ��ü�� �����Ǿ� �ִٸ� ������ ����
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
