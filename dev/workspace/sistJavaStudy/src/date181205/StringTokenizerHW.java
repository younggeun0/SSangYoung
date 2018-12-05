package date181205;
/* 2. 아래 제시된 문자열을 구분 문자로 잘라내어 문자열 배열에 저장하고 반환하는 일을 하는 method를 작성하세요.

"이재찬,이재현.공선의,정택성~이재현!최지우.김희철,이재찬,이재찬,정택성.공선의"

출력:
이재찬 이재현 공선의 정택성 이재현 최지우 김희철 이재찬 이재찬 정택성 공선의 */
import java.util.StringTokenizer;

public class StringTokenizerHW {
	
	public String[] getName(String str) {
		
		StringTokenizer stk = new StringTokenizer(str, ",.~!");
		String[] name = new String[stk.countTokens()];
		
		int idx = 0;
		while(stk.hasMoreTokens()) {
			name[idx] = stk.nextToken();
			idx++;
		}
		
		return name;
	}

	public static void main(String[] args) {
		
		String name = "이재찬,이재현.공선의,정택성~이재현!최지우.김희철,이재찬,이재찬,정택성.공선의";
		
		StringTokenizerHW stkHW = new StringTokenizerHW();
		
		String[] names = stkHW.getName(name);
		
		for(int i=0; i<names.length; i++) {
			System.out.print(names[i]+" ");
		}
		
		/*StringTokenizer stk = new StringTokenizer(name, ",.~!");
		
		System.out.println("출력 : ");
		while(stk.hasMoreTokens()) {
			System.out.print(stk.nextToken()+" ");
		}
		System.out.println();*/
	}
}
