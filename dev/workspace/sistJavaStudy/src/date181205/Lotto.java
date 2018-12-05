package date181205;
/* 1~45������ ������ �� �� �������� �ϳ��� ���� 6���� ��Ʈ�� ����� �迭�� ��ȯ�ϴ� 
 * method�� ����� ȣ���Ͽ� ����� ��. ��, �ߺ��� ���� �迭�� �Էµ��� �ʾƾ� �Ѵ�. 
 * (�̴°ɷ� �ٽ� �����غ� ��)*/
public class Lotto {

	private int[] ball = new int[45];
	
	public int[] getBall() {
		int[] tmpBall = new int[ball.length]; 
		for(int i=0; i<tmpBall.length; i++) {
			tmpBall[i] = ball[i];
		}
		return tmpBall;
	}
	
	public Lotto() {
		
		// �� �ʱ�ȭ 1~45
		for(int i=0; i<ball.length; i++) {
			ball[i] = i+1;
		}
	}
	
	// �� ���� ����ver.
	// �̹� �ִ� ������ ������ �ٲ� �� 6�� �����ϴ� ���
	public int[] pickBall(int[] ball) {
		int[] picked = new int[6];
		int idx = 0;
		int tmp = 0;
		
		for(int i=0; i<1000; i++) {
			idx = (int)(Math.random()*45);
			tmp = ball[idx];
			ball[idx] = ball[0];
			ball[0] = tmp;
		}
		
		// ���� �� �� �� 6���� ����
		for(int i=0; i<picked.length; i++) {
			picked[i] = ball[i];
		}
		
		return picked;
	}
	
	// ������ ver. ������ ���� �� ������ ���� �ٽ� �Է��ϳ�
	// ������ ���� �� ���� ���ɼ��� ����
	public int[] pickBall2(int[] ball) {
		int[] picked = new int[6];
		
		for(int i=0; i<picked.length; i++) {
			picked[i] = ball[(int)(Math.random()*45)];
			for(int j=0; j<i; j++) {
				if(picked[i] == picked[j]) { 
					picked[i] = ball[(int)(Math.random()*45)];
				}
			}
		}
		return picked;
	}
	
	// ���� ver.
	// ���� �ϳ� ���ϰ� �������� ���������� �� �� 
	// ���� ���� ���� ����� �ٽ� �̱�
	public int[] pickBall3(int[] ball) {
		int[] picked = new int[6];
		
		for(int i=0; i<picked.length; i++) {
			picked[i] = ball[(int)(Math.random()*45)];
			for(int j=0; j<i; j++) {
				if(picked[i] == picked[j]) {
					i--;
					break;
				}
			}
		}
		return picked;
	}
	
	public int[] sortBall(int[] picked) {
		int tmp = 0;
		
		// ��������
		for(int i=0; i<picked.length-1; i++) {
			for(int j=0; j<picked.length-1-i; j++) {
				if (picked[j] > picked[j+1]) {
					tmp = picked[j];
					picked[j] = picked[j+1];
					picked[j+1] = tmp;
				}
			}
		}
		return picked;
	}
	
	public void printBall(int[] sortedBall) {
		
		for(int i=0; i<sortedBall.length; i++) {
			System.out.print(sortedBall[i]+" ");
		}
		System.out.println();
	}
}
