package date181120;

/**
 * 다양한 for 형태
 * 
 */
public class TestFor10 {
	
	public static void main(String[] args) {
		
		// 무한루프
		/*for(;;) {
			System.out.println("무한루프");
		}*/
		
		// System.out.println("무한루프 다음코드"); 
		// Unreachable code error발생
		
		// 증가하는 수를 세는 무한 LOOP
		/*for (int i=0;;i++) {
			System.out.println("무한루프" + i);

			// 다중 for의 경우 break는 가장 가까이 있는 for만 나감
			if (i==50)
				break;
		}*/
		
		/*// 여러개의 초기값을 사용하는 for
		for(int i=0, j=10, k=30; i<10; i++, j++, k--) {
			System.out.println(i+" "+j+" "+k);
		}*/
		
		/*// 조건식을 잘못 설정하면 무한루프
		for(int i=0; i < 10; i--) {
			System.out.println("무한루프 " + i);
		}*/
		
		// for문 뒤에 ;가 있는 경우 한번 실행됨
		// for문 수행 후 sysout 한번 수행
		/*int i = 0;
		for(i=0; i< 10; i++); {
			System.out.println("반복문"+i);
		}*/
	}
}
