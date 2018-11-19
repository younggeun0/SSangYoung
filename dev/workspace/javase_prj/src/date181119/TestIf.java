/*
 * 조건문의 사용
 * 단일 if문 : 조건에 맞는 경우에만 코드를 실행해야 할 때
 * if(조건식) {
 * 	조건에 맞을 때 수행 문장들
 * }
*/
package date181119;

public class TestIf {

	
	public static void main(String[] args) {
		
		// 음수일 때 양수로 만드는 if 조건식
		int i = -10;
		
		if (i < 0) {
			i = -i;
		}
		
		System.out.println("i = " + i);

	}
}
