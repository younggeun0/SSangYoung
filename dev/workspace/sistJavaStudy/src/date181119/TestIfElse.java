package date181119;

public class TestIfElse {

	public static void main(String[] args) {
		
		int i = -23;
		
		// 변수값이 음수인지 양수인지 판단
		System.out.println(i + " 는(은) ");
		
		if (i < 0) {
			System.out.println("음수");
		} else {
			System.out.println("양수");
		}
		
		// 변수값이 홀수인지 짝수인지 판단
		// 수행하는 행이 한 행이라면 {}는 생략가능
		if (i%2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		
		// 입력하는 수가 3의 배수라면 "3의 배수"을 출력
		// 그렇지 않다면 입력한 수를 출력
		
		if (i%3 == 0) {
			System.out.println("3의 배수");
		} else {
			System.out.println(i);
		}
	}
}
