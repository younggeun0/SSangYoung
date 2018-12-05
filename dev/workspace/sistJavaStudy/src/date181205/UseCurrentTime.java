package date181205;

/**
 * 1970년 01월 01일 00:00:00 부터 현재 날짜의 시간을 ms로 얻어내는 System.currentTimeMillis() 사용
 * 
 * @author owner
 */
public class UseCurrentTime {

    public void test() {
        
        long st = System.currentTimeMillis();
        long sum = 0;
        
        for(int i=0; i<10000; i++) {
            sum = sum + i;
            // System.out.println(); 출력하면  처리속도가 엄청 느려진다.
            // 테스트 때를 제외하면  System.out.println은 거의 안쓴다
            System.out.println(i);
        }
        
        long et = System.currentTimeMillis();
        // 코드 수행 시간
        System.out.println((et-st)+"ms");
   }

	public static void main(String[] args) {

		UseCurrentTime uct = new UseCurrentTime();
		// 프로그램 평균시간 구하기
		long[] avgTime = new long[17];
		long st=0,et = 0; 
		
		for(int i=0; i<avgTime.length; i++) {
			st=System.currentTimeMillis();
			uct.test();
			et=System.currentTimeMillis();
			avgTime[i] = (et-st);
		}
		
		System.out.println(System.nanoTime());
	}
}
