package date181217;

public class Test {

	public static void main(String[] args) {
		
		int[] arr = { 1,2,3,4,5 };
		
		try {
			arr[5] = 10;
		} catch (ArrayIndexOutOfBoundsException e) {
			// ���ܰ� �߻����� �� ó���� �ڵ�
			System.out.println("���ܹ߻�!");
		}
	}
}
