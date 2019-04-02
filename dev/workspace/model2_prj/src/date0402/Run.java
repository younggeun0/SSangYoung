package date0402;

import java.util.HashMap;
import java.util.Map;

public class Run {
	
	/**
	 * Is A ���踦 ������� �� 
	 */
	public void useIsA() {
		Map<String, Person> map = new HashMap<String, Person>();
		
		// �� �Ҵ�
		map.put("gong", new SeonUi());
		map.put("lee", new JaeHyun());
		map.put("jung", new TeackSung());
		
		// Ű
		String key = "lee";
		
		if (map.containsKey(key)) { // NullPointerException ����ó��
			// ��ü �������� ����Ͽ� �θ� �� �ڽ��� ����
			Person person = map.get(key);
			System.out.println(person.execute());
		}
		
	}//useIsA
	
	/**
	 * Is A ���踦 ������� �ʾ��� �� 
	 */
	public void notIsA() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		// �� �Ҵ�
		map.put("gong", new SeonUi());
		map.put("lee", new JaeHyun());
		map.put("jung", new TeackSung());
		
		// �� ���
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
