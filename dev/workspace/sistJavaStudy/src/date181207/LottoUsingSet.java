package date181207;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoUsingSet {

	public int[] lotto() {
		int[] tempLotto = new int[6];
		
		Random random = new Random();
		for(int i=0; i<tempLotto.length; i++) {
			// ���� ���� �߻�����
			tempLotto[i] = random.nextInt(45)+1;
			for(int j=0; j<i; j++) {
				if(tempLotto[i] == tempLotto[j]) {
					// �ߺ��߻��� ��ȣ�� �ε��� ��ȣ�� 
					// �ٽ� �߻���Ű�� ���� �ε��� ��ȣ�� �ϳ� ���δ�.
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
			// �������� �߰����� ����
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
