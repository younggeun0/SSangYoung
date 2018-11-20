package date181120;

/**
 * 반복문내의 반복실행코드 수행을 건너 뛰는 continue<br>
 * @author owner
 */
public class TestContinue {
	
	public static void main(String[] args) {
		
		// 0~100까지 홀수만 출력
		for(int i=0; i<100; i++) {
			
			if (i%2 == 0) {
				continue;
			}
			System.out.println("i = " + i);
		}
	}
}
