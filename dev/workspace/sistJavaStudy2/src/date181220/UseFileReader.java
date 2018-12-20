package date181220;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 16bit Stream�� ����Ͽ� �����б�
 * 
 * @author owner
 */
public class UseFileReader {

	public void useFileReader() throws IOException {
		BufferedReader br = null;
		
		try {

			File f = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/temp/java_read.txt");
			/*
			// 1. �ٿ��� ���Ͽ� ��Ʈ�� ����
			FileReader fr = new FileReader(f);
			// 2. �ٴ��� �о���̴� ����� ���� ��Ʈ�� ����
			br = new BufferedReader(fr);
			*/
			
			br = new BufferedReader(new FileReader(f));
			
			String temp = "";
			// ���پ� �о�鿩 �о���� ������ �����Ѥ��ٸ�
			while ((temp = br.readLine()) != null) {
				System.out.println(temp); // ���
			}
			
		} finally {
			// ����� ��Ʈ���� ���´�.
			if (br != null) br.close();
		}
	}

	public static void main(String[] args) {
		UseFileReader ufr = new UseFileReader();

		try {
			ufr.useFileReader();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
