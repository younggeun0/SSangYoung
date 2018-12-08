package date181208;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/* 1~45까지의 사이의 수 중 무작위로 하나를 봅아 6개의 세트를 만들어 배열로 반환하는 method를 만들고 호출하여 출력할 것. 
 * 단, 중복된 수는 배열에 입력되지 않아야 한다. (뽑는걸로 다시 구현해볼 것)*/
public class Lotto {

	public Integer[] getBall() {
		
		Set<Integer> ball = new HashSet<>();
		Random r = new Random();

		// set을 이용하여 중복값 없이 공 6개를 뽑음
		while(true) {
			ball.add(r.nextInt(45)+1);
			if (ball.size() == 6) break;
		}
		
		Integer[] arrBall = new Integer[ball.size()];
		ball.toArray(arrBall);
		
		return arrBall;
	}
	
	public void printBall(Integer[] ball) {
		
		int tmp = 0;
		
		// 선택정렬
		for(int i=0; i<ball.length-1; i++) {
			for(int j=i+1; j<ball.length; j++) {
				if(ball[i] > ball[j]) {
					tmp = ball[i];
					ball[i] = ball[j];
					ball[j] = tmp;
				}
			}
		}
		
		for(int i=0; i<ball.length; i++) {
			System.out.print(ball[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		lotto.printBall(lotto.getBall());
	}
}
