package date181120;

public class TestFor03 {
	
	public static void main(String[] args) {
		
		// 1~100���� ����ϱ� 3�� ������� ���ڴ�� "¦"�� ���
		for (int i=1; i<101; i++) {
			if (i%3 == 0) {
				System.out.println("¦");
				continue;
			}
			System.out.println(i);
		}
		
	}
}
