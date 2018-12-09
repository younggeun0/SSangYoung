package date181209;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DayCheck {

	public Map<Integer, Integer> setDay(String[] str) {

		Set<Integer> day = new HashSet<>();
		Map<Integer, Integer> dayAndDayOfWeek = new HashMap<>();
		Calendar cal = Calendar.getInstance();

		int tmp;
		for (int i = 0; i < str.length; i++) {
			tmp = Integer.parseInt(str[i]);
			if (tmp > 0 && tmp < 32) {
				day.add(tmp);
				cal.set(Calendar.DAY_OF_MONTH, tmp);
				dayAndDayOfWeek.put(tmp, cal.get(Calendar.DAY_OF_WEEK));
			}
		}
		System.out.println(dayAndDayOfWeek);

		return dayAndDayOfWeek;
	}
	
	public void printDayAndDayOfWeek(Map<Integer, Integer> dayAndDayOfWeek) {
		
		Set<Integer> setDay = dayAndDayOfWeek.keySet();
		Integer[] arrDay = new Integer[setDay.size()];
		String[] dayOfWeek = { "일","월","화","수","목","금","토" };
		setDay.toArray(arrDay);
		
		int tmp = 0;
		for(int i=0; i<arrDay.length-1; i++) {
			for(int j=0; j<arrDay.length-1-i; j++) {
				if(arrDay[j] > arrDay[j+1]) {
					tmp = arrDay[j];
					arrDay[j] = arrDay[j+1];
					arrDay[j+1] = tmp;
				}
			}
		}
		
		for(int i=0; i<arrDay.length; i++) {
			System.out.println(arrDay[i] +" "+dayOfWeek[dayAndDayOfWeek.get(arrDay[i])-1]);
		}
	}
}
