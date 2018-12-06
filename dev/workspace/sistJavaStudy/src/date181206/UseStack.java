package date181206;

import java.util.Stack;

/**
 * STACK : LIFO(Last In First Out) 을 구현한 클래스
 * @author owner
 */
public class UseStack {
	
	public UseStack() {

		// 생성
		Stack<String> stk = new Stack<>();
		// 값 할당
		// Stack은 부모클래스가 제공하는 기능은 사용하지 않는다.
		// stk.add("부모"); 
		stk.push("하셨습니다."); // 1
		stk.push("수고를"); // 2
		stk.push("오늘도"); // 3
		
		System.out.println(stk);
		System.out.println("크기 : "+stk.size());
		System.out.println(stk.empty());
		
		// 부모클래스가 제공하는 기능을 사용하면 
		// 스택의 고유기능을 사용할 수 없게된다.(LIFO X)
		for(int i=0; i<stk.size(); i++) {
			System.out.println(stk.get(i));
		}
		
		while(!stk.empty()) {
			// stack에서 데이터를 꺼내면 다음번에는 
			// 그 데이터를 사용할 수 없다.
			System.out.println(stk.pop());
		}
	}

	public static void main(String[] args) {
		new UseStack();
	}
}
