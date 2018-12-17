package date181217;

public class Test {

	public static void main(String[] args) {
		
		int[] arr = { 1,2,3,4,5 };
		
		try {
			arr[5] = 10;
		} catch (ArrayIndexOutOfBoundsException e) {
			// 예외가 발생했을 때 처리할 코드
			System.out.println("예외발생!");
		}
	}
}
