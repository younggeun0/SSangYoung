package date181120;

public class TestFor05 {
	
	public static void main(String[] args) {
		
		// A~Z까지 출력 65~90
		// ASCII casting 사용하는 방법
		for (int i=65; i<91; i++) {
			System.out.print((char)i+" ");
		}
		System.out.println();
		
		// char로 바로 하는 방법
		for (char c='A'; c<='Z'; c++) {
			System.out.print(c + " ");
		}
		System.out.println();
	}
}
