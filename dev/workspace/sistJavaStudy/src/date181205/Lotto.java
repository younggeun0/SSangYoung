package date181205;
/* 1~45까지의 사이의 수 중 무작위로 하나를 봅아 6개의 세트를 만들어 배열로 반환하는 
 * method를 만들고 호출하여 출력할 것. 단, 중복된 수는 배열에 입력되지 않아야 한다. 
 * (뽑는걸로 다시 구현해볼 것)*/
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
		
		// 공 초기화 1~45
		for(int i=0; i<ball.length; i++) {
			ball[i] = i+1;
		}
	}
	
	// 공 섞기 영근ver.
	// 이미 있는 공들의 순서만 바꾼 뒤 6개 선택하는 방법
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
		
		// 섞인 공 중 앞 6개를 선택
		for(int i=0; i<picked.length; i++) {
			picked[i] = ball[i];
		}
		
		return picked;
	}
	
	// 재찬이 ver. 문제는 같을 때 랜덤한 값을 다시 입력하나
	// 동일한 공이 또 나올 가능성이 존재
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
	
	// 영민 ver.
	// 공을 하나 택하고 이전부터 뽑은공까지 비교 후 
	// 같은 값의 공이 존재시 다시 뽑기
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
		
		// 버블정렬
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
