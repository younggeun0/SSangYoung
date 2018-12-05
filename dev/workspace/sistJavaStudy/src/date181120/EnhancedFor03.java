package date181120;

import java.util.ArrayList;
import java.util.List;

public class EnhancedFor03 {
	
	public static void main(String[] args) {
		
		// Collection
		List<Integer> list = new ArrayList<>();
		
		list.add(10);
		list.add(20);
		list.add(110);
		list.add(1);
		
		System.out.println("---------List 이전 for----------");
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("---------List 개선된 for----------");
		for(int i : list) {
			System.out.println(i);
		}
	}
}
