package date181206;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ScoreProcessor {
	
	List<String> name = new ArrayList<>();
	List<Integer> score = new ArrayList<>();

	// 생성자로 이름과 점수 초기화
	public ScoreProcessor(String str) {
		
		String[] name = str.split(",");
		Random r = new Random();
		
		for(int i=0; i<name.length; i++) {
			this.name.add(name[i]);
			score.add(r.nextInt(101));
		}
	}
	
	// 출력할 사람의 수를 입력받아서 출력
	public void printScore(int cnt) {
		int sumOfScore = 0;
		Random r = new Random();
		int[] tmpIdx = new int[name.size()];
		
		// 같은사람이 중복출력됨, 랜덤값을 뽑는데 중복된 idx가 나옴
		for(int i=0; i<tmpIdx.length; i++) {
			tmpIdx[i] = r.nextInt(name.size());
			for(int j=0; j<i; j++) {
				if (tmpIdx[i] == tmpIdx[j]) {
					i--;
					break;
				}
			}
		}
		
		for(int i=0; i<cnt;i++) {
			System.out.println(name.get(tmpIdx[i])+" "+score.get(tmpIdx[i]));
			sumOfScore += score.get(tmpIdx[i]);
		}
		System.out.println("  총점 "+sumOfScore);
	}
	
}
