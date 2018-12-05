/*
	2. 2147483647의 값에서 상위 2byte와 하위 2byte 값을 분리하여 출력해보세요. 
	    출력 예) 상위 2byte -> 32767
	             하위 2byte -> 65535
 */
package date181116;

public class Homework2Review {
	public static void main(String[] args) {

		int i = Integer.MAX_VALUE; // 2147483647
		// 2147483647 - 4byte 01111111 11111111 11111111 11111111

		// 하위 2byte를 분리 풀이<<

		// &로 mask 연산
		// 01111111 11111111 11111111 11111111
		// 00000000 00000000 11111111 11111111 = 0x0000FFFF
		System.out.println(i & 0x0000FFFF);

	}
}
