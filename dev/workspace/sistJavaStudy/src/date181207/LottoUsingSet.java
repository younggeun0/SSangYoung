package date181207;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoUsingSet {

	public int[] lotto() {
		int[] tempLotto = new int[6];
		
		Random random = new Random();
		for(int i=0; i<tempLotto.length; i++) {
			// 같은 수가 발생가능
			tempLotto[i] = random.nextInt(45)+1;
			for(int j=0; j<i; j++) {
				if(tempLotto[i] == tempLotto[j]) {
					// 중복발생된 번호의 인덱스 번호를 
					// 다시 발생시키기 위해 인덱스 번호를 하나 줄인다.
					i--; 
					break;
				}
			}
		}
		return tempLotto;
	}
	
	public Integer[] lottoUsingSet() {
		Integer[] tempLotto = new Integer[6];
		
		Set<Integer> set = new HashSet<Integer>();
		
		Random random = new Random();
		while(true) {
			// 같은수가 추가되지 않음
			set.add(random.nextInt(45)+1);
			
			if(set.size() == 6) break;
		}
		
		set.toArray(tempLotto);
		return tempLotto;
	}
	
	public static void main(String[] args) {
		
		LottoUsingSet lus = new LottoUsingSet();
		
		int[] temp = lus.lotto();
	
		for(int i=0; i<temp.length; i++) {
			System.out.print(temp[i]+" ");
		}
		
		System.out.println("\n------------------");
		
		Integer[] temp1 = lus.lottoUsingSet();
		for(int i=0; i<temp1.length; i++) {
			System.out.print(temp1[i]+" ");
		}
	}
}
