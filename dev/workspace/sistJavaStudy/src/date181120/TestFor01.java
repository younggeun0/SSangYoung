package date181120;
/**
 * for : ���۰� ���� �� �� ����ϴ� �ݺ���<br>
 * @author owner
 */
public class TestFor01 {
	
	public static void main(String[] args) {
		
		// 0�������� 10���� ���� ������ �ݺ������ϴ� for
		for (int i=0; i<10; i++) {
			System.out.println(i+"�� �ȳ�");
		}
		
		// 1�������� 100���� 1�������ϸ� �ݺ������ϴ� for
		for (int i=1; i<101; i++) {
			System.out.print(i + " ");
			if (i%5 == 0) {
				System.out.println();
			}
		}
		
		// 1�������� 100���� ¦���� ������ ��� for
		for (int i=1; i<101; i++) {
			if(i%2 == 0) {
				System.out.print(i+" ");
			}
		}
		System.out.println(); // �ٺ���

	}
}
