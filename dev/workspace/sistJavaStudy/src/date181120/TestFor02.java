package date181120;

public class TestFor02 {

	public static void main(String[] args) {
		
		int cnt = 0;
		// 1���� ���� 100���� Ȧ���� ���
		for (int i=1; i<101; i++) {
			cnt++;
			if(i%2 == 1) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
		System.out.println(cnt); // 100
		
		// �����ҽ��� ������ ���� ��ȯ��Ű�� ���� ��ų �� �ִ�
		// ��� �����ڸ� ����� �� �ִ�.
		cnt = 0;
		for (int i=1; i<101; i+=2) {
			cnt++;
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println(cnt); // 50
	}
}
