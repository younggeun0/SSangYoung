package date181120;

public class EnhancedFor01 {

	public static void main(String[] args) {
		
		int[] arr = {10, 20, 300, 15};
		
		System.out.println("���� for");
		// i�� ����� �ε���
		for(int i=0; i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("���� for");
		
		// ���� for���� i�� ����� ���� ���� ��
		for(int i:arr) {
			System.out.println(i);
		}
	}
}
