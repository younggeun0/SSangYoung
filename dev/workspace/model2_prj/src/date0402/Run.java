package date0402;

import java.util.HashMap;
import java.util.Map;

public class Run {
	
	/**
	 * Is A 관계를 사용했을 때 
	 */
	public void useIsA() {
		Map<String, Person> map = new HashMap<String, Person>();
		
		// 값 할당
		map.put("gong", new SeonUi());
		map.put("lee", new JaeHyun());
		map.put("jung", new TeackSung());
		
		// 키
		String key = "lee";
		
		if (map.containsKey(key)) { // NullPointerException 예외처리
			// 객체 다형성을 사용하여 부모에 얻어낸 자식을 저장
			Person person = map.get(key);
			System.out.println(person.execute());
		}
		
	}//useIsA
	
	/**
	 * Is A 관계를 사용하지 않았을 때 
	 */
	public void notIsA() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 값 할당
		map.put("gong", new SeonUi());
		map.put("lee", new JaeHyun());
		map.put("jung", new TeackSung());
		
		// 값 사용
		String key = "lee";
		
		if("gong".equals(key)) {
			SeonUi su = (SeonUi)map.get(key);
			System.out.println(su.execute());
			
		} else if ("lee".equals(key)) {
			JaeHyun jh = (JaeHyun)map.get(key);
			System.out.println(jh.execute());
			
		} else if ("jung".equals(key)) {
			TeackSung ts = (TeackSung)map.get(key);
			System.out.println(ts.execute());
		}
	}
	
	public static void main(String[] args) {
		Run r = new Run();
		r.useIsA();
		System.out.println("=================================");
		r.notIsA();
	}//main
}
