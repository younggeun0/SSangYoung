package date181205;

import java.util.StringTokenizer;

public class UseStringTokenizer {

	public UseStringTokenizer() {
		String msg = "오늘은 수요일 입니다. 날씨는 -5입니다.";
		
		// 공백으로 구분 : 매개변수 하나인 생성자 사용
		StringTokenizer stk = new StringTokenizer(msg);
		
		System.out.println(stk.countTokens()+"개");
		
		while(stk.hasMoreTokens()) {
			System.out.println(stk.nextToken());
		}
	}
	
	public static void main(String[] args) {
		
		new UseStringTokenizer();
	}
}
