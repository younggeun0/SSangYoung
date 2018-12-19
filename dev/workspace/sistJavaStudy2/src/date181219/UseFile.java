package date181219;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * FileŬ����
 * - ������ �������
 * - ���丮 ����
 * - ���� ����
 * @author owner
 */
public class UseFile {

	public UseFile() {
		String path = "c:/Users/owner/youngRepositories/SSangYoung/dev/temp/java_read.txt";
		
		// 1. ����
		File file = new File(path);
		System.out.println(file);
		
		if (file.exists()) { // ������ ������ ��
			System.out.println("���� ��� : "+file.getAbsolutePath());
			try {
				System.out.println("�Թ� ��� : "+file.getCanonicalPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("��� : "+file.getPath());
			System.out.println("������ : "+file.getParent());
			System.out.println("���ϸ� : "+file.getName());
			
			System.out.println(file.isFile()?"����":"���丮");
			System.out.println(file.isDirectory()?"���丮":"����");
			
			System.out.println("���� ���� : "+file.length()+" byte");
			System.out.println("���� "+(file.canExecute()?"����":"�Ұ�"));
			System.out.println("�б� "+(file.canRead()?"����":"�Ұ�"));
			System.out.println("���� "+(file.canWrite()?"����":"�Ұ�"));
			System.out.println(file.isHidden()?"��������":"�Ϲ�����");
			
			Date d = new Date(file.lastModified());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
			System.out.println("������ ������ : "+sdf.format(d));
			
		} else {
			System.out.println("��θ� Ȯ�����ּ���.");
		}
	}
	public static void main(String[] args) {
		new UseFile();
	}
}
