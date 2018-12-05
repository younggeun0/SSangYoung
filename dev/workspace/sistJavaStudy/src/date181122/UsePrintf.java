package date181122;

/**
 * 출력 method
 *
 * @author owner
 */
public class UsePrintf {

	public static void main(String[] args) {
		
		System.out.printf("정수  [%d][%5d][%-5d]\n",11,22,38);
		System.out.printf("문자  [%c][%5c][%-5c]\n",'A','B','C');
		System.out.printf("문자열[%s][%10s][%-10s]\n","자바","자바","잠와");
		System.out.printf("실수  [%.2f][%5.2f][%-5.2f]\n",1.437,2.567,3.141592);
		
		System.out.printf("오늘은 %d년 %d월 %d일 %c요일, 온도는 %.1f도입니다.\n"
				, 2018, 11, 22, '목', 1.5);
	}
}
