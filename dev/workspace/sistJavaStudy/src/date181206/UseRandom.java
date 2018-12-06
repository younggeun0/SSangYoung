package date181206;

import java.util.Random;

/**
 * Random : 다양한 난수를 얻기위한 객체.
 * @author owner
 */
public class UseRandom {
	public UseRandom() {
		// 1.생성
		Random r = new Random();
		
		// 2.난수얻기
		// 실수난수
		double d = r.nextDouble();
		System.out.println(d);
		System.out.println(d*5);
		System.out.println((int)(d*5));
		
		System.out.println("-----------------------");
		
		// 정수난수
		int i = r.nextInt(); // 음수가 발생하므로 절대값처리
		System.out.println(i);
		System.out.println(i%5);
		System.out.println(Math.abs(i%5)); // 양수처리
		
		System.out.println("-----------------------");
		int j = r.nextInt(5); // 음수가 발생하지 않는다.
		System.out.println(j);
		
		System.out.println("-----------------------");
		
		// 불린난수
		boolean b = r.nextBoolean();
		System.out.println(b);
	}
	public static void main(String[] args) {
		new UseRandom();
	}
}
