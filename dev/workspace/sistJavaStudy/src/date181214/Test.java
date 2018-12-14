package date181214;

public class Test {

	public static void main(String[] args) {
		
		// char[]를 String으로 변환하기
		// 방법1
		char[] c = {'a','b','c'};
		String s = String.valueOf(c);
		System.out.println(s);
		
		// 방법2 권장
		String s2 = new String(c);
		System.out.println(s2);
		
		// 문자입력된 경우 예외처리 필요
					int input = Integer.parseInt("abc");
					System.out.println(input);
	}
}
