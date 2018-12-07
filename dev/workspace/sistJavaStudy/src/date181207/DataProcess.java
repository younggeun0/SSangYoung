package date181207;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class DataProcess {

	public DataProcess() { }

	public List getData() {
		String str = "백인재,이봉현,이재찬,정택성,이재현,김정운";
		String[] name = str.split(",");
		
		List<DataVO> data = new ArrayList<>();
		Random r = new Random();
		
		for(int i=0; i<name.length; i++) {
			data.add(new DataVO(name[i],r.nextInt(101)));
		}
		
		return data;
	}
	
	public void printData(List<DataVO> data) {
		int sumOfScore = 0;
		Integer[] idx = new Integer[data.size()];
		Set<Integer> set = new HashSet<>();
		Random r = new Random();
		
		// 더 짧게 2이상의 수를 획득
		int cnt = r.nextInt(data.size()-2)+2;
		
		// Set을 이용한 중복제거
		while(true) {
			set.add(r.nextInt(data.size()));
			if(set.size() == data.size()) break;
		}
		
		set.toArray(idx);
		
		for(int i=0; i<cnt; i++) {
			System.out.println(data.get(idx[i]).getName()+" "+data.get(idx[i]).getScore());
			sumOfScore += data.get(idx[i]).getScore();
		}
		System.out.println(" 총점 : "+sumOfScore);
	}
}