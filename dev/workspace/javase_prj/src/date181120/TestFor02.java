package date181120;

public class TestFor02 {

	public static void main(String[] args) {
		
		int cnt = 0;
		// 1에서 부터 100까지 홀수만 출력
		for (int i=1; i<101; i++) {
			cnt++;
			if(i%2 == 1) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
		System.out.println(cnt); // 100
		
		// 증감소식은 변수에 값을 변환시키고 유지 시킬 수 있는
		// 모든 연산자를 사용할 수 있다.
		cnt = 0;
		for (int i=1; i<101; i+=2) {
			cnt++;
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println(cnt); // 50
	}
}
