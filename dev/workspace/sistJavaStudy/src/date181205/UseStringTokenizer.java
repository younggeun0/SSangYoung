package date181205;

import java.util.StringTokenizer;

public class UseStringTokenizer {

	public UseStringTokenizer() {
		String msg = "오늘은 수요일 입니다. 날씨는 -5입니다.";
		
		// 공백으로 구분 : 매개변수 하나인 생성자 사용
		StringTokenizer stk = new StringTokenizer(msg);
		
		System.out.println(stk.countTokens()+"개");
		
		while(stk.hasMoreTokens()) { // 토큰이 존재하는지?
			// 토큰을 얻고 포인터를 다음으로 이동시킴
			System.out.println(stk.nextToken());
		}
		
		String names = "이재현,이재찬~정택성,김희철.김정운~김정윤,공선의";
		
		// 특정문자로 토큰을 구분
		// ','로 구분
		StringTokenizer stk1 = new StringTokenizer(names, ",");
		System.out.println("토큰의 수 : "+stk1.countTokens());
		while(stk1.hasMoreTokens()) {
			System.out.println(stk1.nextToken());
		}
		
		// '~'로 구분
		StringTokenizer stk2 = new StringTokenizer(names, "~");
		System.out.println("토큰의 수 : "+stk2.countTokens());
		while(stk2.hasMoreTokens()) {
			System.out.println(stk2.nextToken());
		}
		
		// '.'로 구분
		StringTokenizer stk3 = new StringTokenizer(names, ".");
		System.out.println("토큰의 수 : "+stk3.countTokens());
		while(stk3.hasMoreTokens()) {
			System.out.println(stk3.nextToken());
		}
		
		// ',~.'로 구분
		StringTokenizer stk4 = new StringTokenizer(names, ",~.");
		System.out.println("토큰의 수 : "+stk4.countTokens());
		while(stk4.hasMoreTokens()) {
			System.out.println(stk4.nextToken());
		}
		
		// 특정문자로 토큰 구분, 구분된 문자열도 토큰으로 취급
		// 매개변수 3개짜리 
		StringTokenizer stk5 = new StringTokenizer(names, ",~.", true);
		System.out.println("토큰의 수 : "+stk5.countTokens());
		while(stk5.hasMoreTokens()) {
			System.out.println(stk5.nextToken());
		}
	}
	
	public static void main(String[] args) {
		
		new UseStringTokenizer();
	}
}










