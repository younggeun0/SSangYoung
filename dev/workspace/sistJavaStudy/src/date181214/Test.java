package date181214;

public class Test {

	public static void main(String[] args) {
		
		// char[]�� String���� ��ȯ�ϱ�
		// ���1
		char[] c = {'a','b','c'};
		String s = String.valueOf(c);
		System.out.println(s);
		
		// ���2 ����
		String s2 = new String(c);
		System.out.println(s2);
		
		// �����Էµ� ��� ����ó�� �ʿ�
					int input = Integer.parseInt("abc");
					System.out.println(input);
	}
}
