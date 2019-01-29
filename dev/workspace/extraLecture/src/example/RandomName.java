package example;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomName {
	
	public static void main(String[] args) {
		
		String[] name1 = { "young", "geun", "gong", "sun", "jae", "hyun" };
		String[] name2 = { "12", "23", "22", "44", "123", " 77", "666" };
		
		Random r = new Random();
		String id = "";
		
		Set<String> ids = new HashSet<String>();
		
		while(true) {
			id = name1[r.nextInt(name1.length)]+name2[r.nextInt(name2.length)];

			ids.add(id);
			
			if (ids.size() == 20) {
				break;
			}
		}
		System.out.println(ids);
	}
}
