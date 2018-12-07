package date181207;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set : 검색의 기능이 없으며(get이 없음) 중복값을 저장할 수 없다. 
 * @author owner
 */
public class UseSet {
	
	public UseSet() {

		// jdk 1.5이전엔 Generic이 지원되지 않고 객체만 저장.
		// 1.생성)
		Set<String> set = new HashSet<String>();
		
		// 2.값 할당) 중복값 없고 값이 순서대로 들어가지 않는다.
		set.add("정택성"); set.add("이재현");
		set.add("공선의"); set.add("김정운");
		set.add("노진경"); set.add("최지우");
		set.add("이봉현"); set.add("김정운");  // 중복값 저장 X
		
		System.out.println("크기 : "+set.size()+" / "+set);
		
		set.remove("김정운"); // 가변길이형
		System.out.println("크기 : "+set.size()+" / "+set);
		
		// 배열로 복사
		String[] names = new String[set.size()];
		set.toArray(names);
		
		System.out.println("-------복사된 배열값 출력-------");
		for(String name : names) {
			System.out.print(name+" ");
		}
		System.out.println();
		
		// set의 모든 방(Elements)의 값 출력
		// Set 자체는 검색기능이 없음
		Iterator<String> ita = set.iterator();
		
		String name = ""; // "" - empty
		while(ita.hasNext()) { // iterator가 참조하는 Set의 요소가 존재한다면
			name = ita.next(); // 해당요소의 값을 얻고 다음 포인터로 이동
			System.out.print(name+" ");
		}
		System.out.println();
		
		// 속도는 Iterator 사용하는게 더 빠름
		System.out.println("------------향상된 for----------------");
		for(String temp: set) {
			System.out.print(temp+" ");
		}
		System.out.println();
		
		// 모든 방의 값 삭제
		set.clear();
		System.out.println("clear 후 : "+set.size()+"/"+set);
	}
	
	public static void main(String[] args) {
		new UseSet();
	}
}
