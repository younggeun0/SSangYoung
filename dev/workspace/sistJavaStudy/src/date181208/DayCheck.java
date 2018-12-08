package date181208;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DayCheck {

	public Map<Integer,String> getDay(String[] day) {
		int tmp = 0;

		//String[] dayOfWeek = { "일","월","화","수","목","금","토" };
		Set<Integer> set = new HashSet<>();
		Map<Integer, String> map = new HashMap<>();
		Calendar c = Calendar.getInstance();
		
		for(int i=0; i<day.length; i++) {
			tmp = Integer.parseInt(day[i]);
			if (tmp > 0 && tmp < 32) {
				set.add(tmp);
			}
		}
		
		Integer[] arrDay = new Integer[set.size()];
		set.toArray(arrDay);
		
		for(int i=0; i<arrDay.length; i++) {
			c.set(Calendar.DAY_OF_MONTH, arrDay[i]);
			map.put(arrDay[i], 
					"일,월,화,수,목,금,토".split(",")[c.get(Calendar.DAY_OF_WEEK)-1]);
		}
		
		return map;
	}
	
	public void printDay(Map<Integer,String> map) {
		
		int tmp = 0;

		Set<Integer> key = map.keySet();
		Integer[] arrKey = new Integer[map.size()];
		key.toArray(arrKey);
		
		for(int i=0; i<arrKey.length-1; i++) {
			for(int j=0; j<arrKey.length-1-i; j++) {
				if(arrKey[j] > arrKey[j+1]) {
					tmp = arrKey[j];
					arrKey[j] = arrKey[j+1];
					arrKey[j+1] = tmp;
				}
			}
		}
		
		for(int i=0; i<map.size(); i++) {
			System.out.println(arrKey[i]+" "+map.get(arrKey[i]));
		}
	}
}
