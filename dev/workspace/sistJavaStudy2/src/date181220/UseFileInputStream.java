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
				// ��Ʈ���� �����Ͽ� JVM���� HDD�� ���ϰ� ����
				// �ѱ�ó���� ���� 16bit Stream�� ����

				// FileInputStream : ���ϰ� ����
				// InputStreamReader : 8bit-16bit ����
				// BufferedReader : �ӵ�����, �ٴ��� �б�
//				FileInputStream fis = new FileInputStream(file);
//				InputStreamReader isr = new InputStreamReader(fis);
//				br = new BufferedReader(isr);

				br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				
				String temp = "";

				// �ٴ���(\n������) �о �о���� ������ �ִٸ�
				while ((temp = br.readLine()) != null) {
					System.out.println(temp); // ���
				}
			} finally {
				if (br != null) br.close();
			}
		} else {
			System.out.println("��γ� ���ϸ��� Ȯ���ϼ���.");
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
