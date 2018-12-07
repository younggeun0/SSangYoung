package date181206;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.LinkedList;

/**
 * List<br>
 * 중복값 허용하며 검색의 기능이 있고, 순서대로 값을 입력하는 가변길이형
 * 
 * @author owner
 */
public class UseList {
	
	public UseList() {
		// jdk 1.4에서는 Generic이 제공되지 않고 객체만 저장됨
		List list = new ArrayList();
		// 값 추가
		// jdk 1.5이하에서는 객체로만 값을 넣을 수 있음
		list.add(new Integer(10));
		list.add(new Short((short)10));
		list.add(new String("공선의"));
		
		System.out.println("크기 "+list.size());
		System.out.println(((Integer)list.get(0)).intValue()+10);
		
		// jdk 1.5+ 사용 : Generic, autoboxing, unboxing 사용가능
		// Generic을 권장
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(10); // autoboxing 
		list1.add(20);
		list1.add(new Integer(30));
		// Generic으로 설정된 형이 아닌 데이터형은 추가할 수 없다.
		// list1.add("김건하"); 
		
		System.out.println("크기 "+list1.size());
		for(int i=0; i<list1.size(); i++) {
			System.out.print(list1.get(i)+" ");
		}
		System.out.println();
	}
	
	/**
	 * ArrayList 사용 : Multi Thread환경에서 동시 접근 가능(동기화 X)
	 * 
	 */
	public void useArrayList() {
		// 1. 생성
		ArrayList<String> al = new ArrayList<String>(); // capacity X(방 0개)
		List<String> al1 = new ArrayList<String>(100); // capacity O(방 100개)
		
		System.out.println(al+" / "+al1);
		
		// 값 추가
		// 값은 순서대로 추가됨, 중복값 허용
		al.add("이재현"); al.add("이재현"); al.add("김정윤"); al.add("노진경");
		al.add("김정윤"); al.add("김정운");	al.add("공선의"); al.add("정택성");
		System.out.println(al+" / "+al1);

		/*
		// size() : 데이터의 크기(size != capacity )
		System.out.println("al 크기 : "+al.size()+" / al1 크기 : "+al1.size());
		
		// 배열에 복사
		String[] names = new String[al.size()];
		al.toArray(names);
		
		// 복사된 배열 출력
		System.out.println("---------- 복사된 배열 출력 ----------");
		for(int i=0; i<names.length; i++) {
			System.out.printf("%s\t",names[i]);
		}
		System.out.println();
		System.out.println("--------------------------------------");
		
		// 방의 값 삭제
		// -인덱스로 삭제
		al.remove(5); 
		System.out.println(al+" / "+al1);
		// -값으로 삭제
		// 중복된 값이 존재 시 L->R로 진행하면서 
		// 일치하는 첫방의 값만 삭제
		al.remove("김정윤"); 
		System.out.println(al+" / "+al1);

		// 향상된 for문 출력
		for(String name : al) {
			System.out.print(name+" ");
		}
		System.out.println();*/
		
		// iterator를 이용한 출력
		Iterator<String> ita = al.iterator();
		
		while(ita.hasNext()) {
			System.out.println(ita.next());
		}
		
		// 모두 삭제
		al.clear();
		System.out.println("전체 삭제 후 size : "+al.size()+" / "+al);
	}
	
	public void useVector() {
		// 1. 생성
		Vector<String> vec = new Vector<String>(); // capacity X(방 0개)
		List<String> vec1 = new Vector<String>(100); // capacity O(방 100개)
		
		System.out.println(vec+" / "+vec1);
		
		// 값 추가
		// 값은 순서대로 추가됨, 중복값 허용
		vec.add("이재현"); vec.add("이재현"); vec.add("김정윤"); vec.add("노진경");
		vec.add("김정윤"); vec.add("김정운");	vec.add("공선의"); vec.add("정택성");
		System.out.println(vec+" / "+vec1);

		// size() : 데이터의 크기(size != capacity )
		System.out.println("vec 크기 : "+vec.size()+" / vec1 크기 : "+vec1.size());
		
		// 배열에 복사
		String[] names = new String[vec.size()];
		vec.toArray(names);
		
		// 복사된 배열 출력
		System.out.println("---------- 복사된 배열 출력 ----------");
		for(int i=0; i<names.length; i++) {
			System.out.printf("%s\t",names[i]);
		}
		System.out.println();
		System.out.println("--------------------------------------");
		
		// 방의 값 삭제
		// -인덱스로 삭제
		vec.remove(5); 
		System.out.println(vec+" / "+vec1);
		// -값으로 삭제
		// 중복된 값이 존재 시 L->R로 진행하면서 
		// 일치하는 첫방의 값만 삭제
		vec.remove("김정윤"); 
		System.out.println(vec+" / "+vec1);

		// 향상된 for문 출력
		for(String name : vec) {
			System.out.print(name+" ");
		}
		System.out.println();
		
		// 모두 삭제
		vec.clear();
		System.out.println("전체 삭제 후 size : "+vec.size()+" / "+vec);
	}
	
	public void useLinkedList() {
		// 1. 생성	
		LinkedList<String> ll = new LinkedList<String>(); 
		List<String> ll1 = new LinkedList<String>(); 
		
		System.out.println(ll+" / "+ll1);
		
		// 값 추가
		// 값은 순서대로 추가됨, 중복값 허용
		ll.add("이재현"); ll.add("이재현"); ll.add("김정윤"); ll.add("노진경");
		ll.add("김정윤"); ll.add("김정운");	ll.add("공선의"); ll.add("정택성");
		System.out.println(ll+" / "+ll1);

		// size() : 데이터의 크기(size != capacity )
		System.out.println("ll 크기 : "+ll.size()+" / ll1 크기 : "+ll1.size());
		
		// 배열에 복사
		String[] names = new String[ll.size()];
		ll.toArray(names);
		
		// 복사된 배열 출력
		System.out.println("---------- 복사된 배열 출력 ----------");
		for(int i=0; i<names.length; i++) {
			System.out.printf("%s\t",names[i]);
		}
		System.out.println();
		System.out.println("--------------------------------------");
		
		// 방의 값 삭제
		// -인덱스로 삭제
		ll.remove(5); 
		System.out.println(ll+" / "+ll1);
		// -값으로 삭제
		// 중복된 값이 존재 시 L->R로 진행하면서 
		// 일치하는 첫방의 값만 삭제
		ll.remove("김정윤"); 
		System.out.println(ll+" / "+ll1);

		// 향상된 for문 출력
		for(String name : ll) {
			System.out.print(name+" ");
		}
		System.out.println();
		
		// 모두 삭제
		ll.clear();
		System.out.println("전체 삭제 후 size : "+ll.size()+" / "+ll);
	}
	
	public static void main(String[] args) {
		UseList ul = new UseList();
		
		System.out.println("************************ArrayList*************************");
		ul.useArrayList();
		//System.out.println("************************Vector****************************");
		//ul.useVector();
		//System.out.println("************************LinkedList************************");
		//ul.useLinkedList();
	}
}
