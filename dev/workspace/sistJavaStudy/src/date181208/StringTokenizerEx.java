package date181208;

import java.util.StringTokenizer;

/* 2. 아래 제시된 문자열을 구분 문자로 잘라내어 문자열 배열에 저장하고 반환하는 일을 하는 method를 작성하세요.

"이재찬,이재현.공선의,정택성~이재현!최지우.김희철,이재찬,이재찬,정택성.공선의"

출력:
이재찬 이재현 공선의 정택성 이재현 최지우 김희철 이재찬 이재찬 정택성 공선의 */
public class StringTokenizerEx {

	public static void main(String[] args) {
		
		String str = "이재찬,이재현.공선의,정택성~이재현!최지우.김희철,이재찬,이재찬,정택성.공선의";
		StringTokenizer stk = new StringTokenizer(str, ",.~!");
		
		while(stk.hasMoreTokens()) {
			System.out.print(stk.nextToken()+" ");
		}
		System.out.println();
	}
}
