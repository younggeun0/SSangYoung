package date181120;

public class TestFor05 {
	
	public static void main(String[] args) {
		
		// A~Z���� ��� 65~90
		// ASCII casting ����ϴ� ���
		for (int i=65; i<91; i++) {
			System.out.print((char)i+" ");
		}
		System.out.println();
		
		// char�� �ٷ� �ϴ� ���
		for (char c='A'; c<='Z'; c++) {
			System.out.print(c + " ");
		}
		System.out.println();
	}
}
