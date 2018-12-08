package date181208;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/* 1~45������ ������ �� �� �������� �ϳ��� ���� 6���� ��Ʈ�� ����� �迭�� ��ȯ�ϴ� method�� ����� ȣ���Ͽ� ����� ��. 
 * ��, �ߺ��� ���� �迭�� �Էµ��� �ʾƾ� �Ѵ�. (�̴°ɷ� �ٽ� �����غ� ��)*/
public class Lotto {

	public Integer[] getBall() {
		
		Set<Integer> ball = new HashSet<>();
		Random r = new Random();

		// set�� �̿��Ͽ� �ߺ��� ���� �� 6���� ����
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
		
		// ��������
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
