/*
2. 2147483647의 값에서 상위 2byte와 하위 2byte 값을 분리하여 출력해보세요. 
    출력 예) 상위 2byte -> 32767
             하위 2byte -> 65535
*/
package date181118;

public class HWRevision04 {

	public static void main(String[] args) {
		
		int i = Integer.MAX_VALUE; // 2147483647
		// 01111111 11111111 11111111 11111111
		
		// 상위 2바이트 >>16
		System.out.println(i>>16);
		
		// 하위 2바이트
		// mask 처리
		// 00000000 00000000 11111111 11111111
		// 16진수는 4자리씩 끊어서 만듦 = 0x0000FFFF
		
		System.out.println(i & 0x0000FFFF);
	}
}
