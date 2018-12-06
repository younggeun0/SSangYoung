package date181206;

import java.util.Random;

public class RunProcessor {

	public static void main(String[] args) {
		
		String str = "백인재,이봉현,이재찬,정택성,이재현,김정운";
		
		ScoreProcessor sp = new ScoreProcessor(str);
		int cnt = 0; // 출력할 사람 수 (랜덤하게 2~)
		
		while(true) {
			cnt = (int)(Math.random()*sp.name.size())+1;
			if (cnt > 1) break;
		}
		
		sp.printScore(cnt);
	}
}
