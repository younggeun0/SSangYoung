package date181120;

public class TestFor04 {
	
	public static void main(String[] args) {
		
		// 1~100까지의 합 출력 : 1에서 100까지의 합은 5050
		int sum = 0;
		for (int i=1; i<101; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}
