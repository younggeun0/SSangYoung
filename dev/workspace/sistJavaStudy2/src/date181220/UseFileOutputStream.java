package date181220;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * JVM���� �߻��� �����Ͱ� ����, byte[]�� ��쿡 File�� �����ϴ� FileOutputStream���
 * 
 * @author owner
 */
public class UseFileOutputStream {

	public void useFileOutputStream() throws IOException {
		int i = 65;

		// 1. File class ����
		File file = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/temp/java_write.txt");

		// 2. FileOutputStream ���� -> �Էµ� ��ο� ������ �����ȴ�.
		// ������ ���ٸ� �����ϰ�, ������ �ִٸ� ���� ����.
		FileOutputStream fos = null;

		try {
			boolean flag = false;
			if (file.exists()) {
				boolean[] temp = { false, true, true };
				int select = JOptionPane.showConfirmDialog(null, "����ðڽ��ϱ�?");
				flag = temp[select];
			}

			if (!flag) {
				fos = new FileOutputStream(file);
				fos.write(i); // ���� ��Ʈ���� ��� (���� ���� ���ڰ� ��µ�)
				fos.flush();
				System.out.println("���� ��� �Ϸ�");
			}

		} finally {
			// ��Ʈ���� ��ϵ� ������ �ִٸ� �����ϰ� ������ ����� ��
			if (fos != null) {
				fos.close();
			}
		}
	}

	public static void main(String[] args) {
		UseFileOutputStream ufos = new UseFileOutputStream();

		try {
			ufos.useFileOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
