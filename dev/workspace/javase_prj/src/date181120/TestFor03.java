package date181120;

public class TestFor03 {
	
	public static void main(String[] args) {
		
		// 1~100까지 출력하기 3의 배수마다 숫자대신 "짝"을 출력
		for (int i=1; i<101; i++) {
			if (i%3 == 0) {
				System.out.println("짝");
				continue;
			}
			System.out.println(i);
		}
		
	}
}
