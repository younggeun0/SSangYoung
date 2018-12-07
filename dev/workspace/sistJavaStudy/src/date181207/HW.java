package date181207;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/*
���� 1.
main method�� arguments�� ��¥�� ������ �Է� �޾� �Է¹��� ��¥��
������ �����ϰ� ����ϴ� method �� �ۼ��ϼ���.

��) java Test 4 12 30 32 35 15 4   

���) 4 ȭ
     12 ��
     15 ��
     30 ��  
  
*/
public class HW {
	
	public HW(String[] args) {
	
		Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		
		Calendar cal = Calendar.getInstance();
		
		int tmp = 0;
		for(int i=0; i<args.length; i++) {
			tmp = Integer.parseInt(args[i]);
			if (tmp > 1 && tmp < 31) {
				set.add(Integer.parseInt(args[i]));
			}
		}
		System.out.println(set);
		
		Iterator<Integer> ita = set.iterator();
		
		while(ita.hasNext()) {
			tmp = ita.next();
			cal.set(Calendar.DAY_OF_MONTH, tmp);
			map.put(tmp, cal.get(Calendar.DAY_OF_WEEK));
		}
		System.out.println(map);
		
		printDay(map);
	}
	
	public void printDay(Map<Integer, Integer> map) {

		String[] dayOfWeek = { "��","��","ȭ","��","��","��","��" };
		Set<Integer> set = map.keySet();
		Iterator<Integer> ita = set.iterator();
		
		/*
		int tmp = 0;
		while(ita.hasNext()) {
			tmp = ita.next();
			System.out.println(tmp+" "+dayOfWeek[map.get(tmp)-1]);
		}
		*/
		
		// �����ϱ����� �迭�� map������ ����
		int[] key = new int[map.size()];
		int[] val = new int[map.size()];
		
		int idx = 0;
		while(ita.hasNext()) {
			key[idx] = ita.next();
			val[idx] = map.get(key[idx]);
			idx++;
		}
		
		int tmp = 0, flag = 0;
		for(int i=0; i<key.length-1; i++) {
			for(int j=0; j<key.length-1-i; j++) {
				if (key[j] > key[j+1]) {
					tmp = key[j];
					key[j] = key[j+1];
					key[j+1] = tmp;
					
					tmp = val[j];
					val[j] = val[j+1];
					val[j+1] = tmp;
					
					flag = 1;
				}
			}
			if(flag == 0) break;
		}
		
		for(int i=0; i<key.length; i++) {
			System.out.println(key[i]+" "+dayOfWeek[val[i]-1]);
		}
	}

	public static void main(String[] args) {
		new HW(args);
	}
}
