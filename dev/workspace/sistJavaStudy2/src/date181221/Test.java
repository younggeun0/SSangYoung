package date181221;

public class Test {

	public static void main(String[] args) {
		
		String s = "C:/Users/owner/youngRepositories/SSangYoung/dev/temp/java_read.txt";
		StringBuilder sb = new StringBuilder(s);
		
		// ���ϸ� '.'�� ������ ���� �� �����Ƿ� ���� Ȯ���ڴ� ������ .�ڿ� ���ڿ��̴�.
		// ���� lastIndexOf�� ����ؼ� Ȯ���ڸ� �߶󳻾� �Ѵ�.
		// StringBuilder�� �����ϴ� insert method�� .�ִ� �κк��� "_bak"�� �߰���
		System.out.println(sb.insert(s.lastIndexOf("."),"_bak"));
	}
}
