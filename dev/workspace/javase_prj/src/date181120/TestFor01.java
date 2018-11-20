package date181120;
/**
 * for : 시작과 끝을 알 때 사용하는 반복문<br>
 * @author owner
 */
public class TestFor01 {
	
	public static void main(String[] args) {
		
		// 0에서부터 10보다 작을 때까지 반복수행하는 for
		for (int i=0; i<10; i++) {
			System.out.println(i+"번 안녕");
		}
		
		// 1에서부터 100까지 1씩증가하며 반복수행하는 for
		for (int i=1; i<101; i++) {
			System.out.print(i + " ");
			if (i%5 == 0) {
				System.out.println();
			}
		}
		
		// 1에서부터 100까지 짝수만 옆으로 출력 for
		for (int i=1; i<101; i++) {
			if(i%2 == 0) {
				System.out.print(i+" ");
			}
		}
		System.out.println(); // 줄변경

	}
}
