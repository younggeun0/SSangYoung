package date181207;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Hashtable;

/**
 * Map : KVP로 되어있는 자료구조, 키를 사용하여 값을 얻는 일을 함
 * 
 * @author owner
 */
public class UseMap {

	public UseMap() {
		// jdk 1.5이전인 경우 Generic 사용불가
		// 1.생성
		Map<String, String> map = new HashMap<String, String>();

		// 2.값할당 - 키는 유일, 값은 중복 가능
		// 입력되는 순서대로 저장되지 않음
		map.put("Oracle", "대용량 데이터베이스");
		map.put("Java", "프로그래밍 언어");
		map.put("Python", "프로그래밍 언어"); // 값은 중복 가능
		// 키가 존재한다면 해당 키에 덮어 쓴다.
		map.put("Java", "완벽한 객체지향 언어"); // upsert
		map.put("HTML", "Hyper Text Markup Language");
		System.out.println(map.size() + " " + map);

		// 3.값얻기 - 키를 사용하여 값을 얻는다.
		// 키에 해당하는 값이 없다면 null
		System.out.println(map.get("Oracle"));
		System.out.println(map.get("JS"));

		String val = map.get("Java");
		System.out.println(val);

		// 4.키가 존재하는지?
		String key = "Java";
		boolean flag = map.containsKey(key);
		System.out.println(key + "가 존재하나? : " + flag);

		// 5.값삭제
		map.remove("Java");
		System.out.println("삭제 후 : " + map);

		// 6.모든 키를 얻기
		Set<String> allKeys = map.keySet();
		System.out.println("맵이 가진 모든 키 : " + allKeys);

		// 7.모든 값 얻기
		Iterator<String> ita = allKeys.iterator();
		String value = "";
		while (ita.hasNext()) {
			// 얻어낸 키를 가지고 값을 얻는다.
			value = map.get(ita.next());
			System.out.println(value);
		}

		// 8.모두 삭제
		map.clear();
		System.out.println("모두 삭제 : " + map.size() + " / " + map);
	}
	
	/**
	 * 기본생성자를 사용하면 11개의 행이 자동생성
	 * MultiThread에서 동시접근 불가능
	 * 데이터가 전체 행의 개수의 약 75% 채워있을 때 가장 빠른검색을 한다.
	 */
	public void Hashtable(String key) {
		// 1.생성
		Map<String,String> bloodMap = new Hashtable<String,String>();
		
		// 2.값할당
		bloodMap.put("A", "세심하다, 친절하다. ^o^b");
		bloodMap.put("B", "성질드럽다 ㅡ,.ㅡ");
		bloodMap.put("AB", "싸이코 @,.@");
		bloodMap.put("O", "우유부단하다 ~(^^~)(~^^)~");
		bloodMap.put("A", "소심하다. ☞^.^☜");
		
		// 값 얻기
		String value = bloodMap.get(key);
		
		if (!bloodMap.containsKey(key)) { // 키가 존재하는지에 대해서
			System.out.println(key+" 혈액형은 사람의 것이 아닙니다.");
		} else {
			System.out.println(key+"의 특징은 "+value);
		}
	}
	
	/**
	 * 기본생성자를 사용하면 16의 행이 자동생성
	 * MultiThread에서 동시접근 가능
	 * 데이터가 전체 행의 개수의 약 75% 채워있을 때 가장 빠른검색을 한다.
	 */
	public void HashMap(String key) {
		// 1.생성)
		Map<String, String> map = new HashMap<String, String>();
		
		// 2.값 할당)
		map.put("결초보은", "풀을 묶어 은혜를 갚는다.");
		map.put("역지사지", "처지를 바꾸어 생각하여 봄.");
		map.put("무념무상", "아무것도 하지 않지만 더 격렬하게 아무것도 하지 않겠다.");
		map.put("내로남불", "내가하면 로맨스 니가하면 불륜");
		map.put("이부망천", "서울살다 이혼하면 부천가고 망하면 인천간다");
		map.put("낄낄빠빠", "낄 때 보고 끼어라");
		map.put("순망치한", "입술이 없으면 징그러워요");
		map.put("정택성씨", "구로구에 자랑");
		
		// 3.값 얻기)
		if(map.containsKey(key)) { // 맵에 키가 존재한다면
			String value = map.get(key); // 값 얻기
			System.out.println(key+"의 뜻은 "+value);
		} else {
			System.out.println(key+"란 사자성어는 준비되지 않았습니다.");
		}
	}

	public static void main(String[] args) {
		UseMap um = new UseMap();
		
		System.out.println("-------------Hashtable사용----------------");
		um.Hashtable("B".toUpperCase());
		System.out.println("-------------HashMap사용------------------");
		um.HashMap("이재현씨");
	}
}
