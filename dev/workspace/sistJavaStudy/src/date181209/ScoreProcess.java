package date181209;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

public class ScoreProcess {
	
	
	public Map<String,Integer> getName(String str) {
		Map<String, Integer> nameAndScore = new HashMap<>();
		Random r = new Random();
		StringTokenizer stk = new StringTokenizer(str, ",");
		
		while(stk.hasMoreTokens()) {
			nameAndScore.put(stk.nextToken(), r.nextInt(101));
		}
		return nameAndScore;
	}
	
	public void printNameAndScore(Map<String,Integer> nameAndScore) {

		Random r = new Random();
		int sumOfScore = 0;
		int ppl = r.nextInt(nameAndScore.size()-1)+2;
		// size는 6명이고, 2명이상 처리대상이므로 
		// 랜덤 호출 시 0~5값이 나올테니까 6명까지 처리가 되도록 하려면 -1하고 +2를 하면
		// 2~6의 값을 얻을 수 있음
		
		Set<String> name = nameAndScore.keySet();
		String[] randomName = new String[name.size()];
		name.toArray(randomName);
		Set<String> chosenName = new HashSet<>();
		
		while(true) {
			chosenName.add(randomName[r.nextInt(name.size())]);
			if (chosenName.size() == ppl) break;
		}
		
		Iterator<String> ita = chosenName.iterator();
		
		String tmp = "";
		while(ita.hasNext()) {
			tmp = ita.next();
			System.out.println(tmp+" "+nameAndScore.get(tmp));
			sumOfScore += nameAndScore.get(tmp);
		}
		System.out.println("총합 : "+sumOfScore);
	}
}
