package date181207;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CheckDayOfWeek {

	Set<Integer> set = new HashSet<>();
	Map<Integer, Integer> map = new HashMap<>();

	public void setDate(String[] input) {
		System.out.println("setDate");
		Calendar c = Calendar.getInstance();

		int tmp;
		for (int i = 0; i < input.length; i++) {
			tmp = Integer.parseInt(input[i]);
			if (tmp > 0 && tmp < 32) {
				set.add(tmp);
			}
		}
		System.out.println(set);

		Iterator<Integer> ita = set.iterator();

		while (ita.hasNext()) {
			tmp = ita.next();
			c.set(Calendar.DAY_OF_MONTH, tmp);
			map.put(tmp, c.get(Calendar.DAY_OF_WEEK));
		}

		System.out.println(map);
	}

	public void printDate(Map<Integer, Integer> map) {

		String[] dayOfWeek = { "일", "월", "화", "수", "목", "금", "토" };
		Integer[] day = new Integer[set.size()];

		Set<Integer> set = map.keySet();
		set.toArray(day);

		// 선택정렬
		int tmp = 0;
		for (int i = 0; i < day.length - 1; i++) {
			for (int j = i + 1; j < day.length; j++) {
				if (day[i] > day[j]) {
					tmp = day[i];
					day[i] = day[j];
					day[j] = tmp;
				}
			}
		}
		
		for (int i = 0; i < map.size(); i++) {
			System.out.println(day[i]+" "+dayOfWeek[map.get(day[i])-1]);
		}
	}
}
