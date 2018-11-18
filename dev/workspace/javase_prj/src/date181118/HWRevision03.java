/*
1. 변수에 할당된 값이 양수일때만 2진수로 출력하고 음수라면 ~를 사용하여
    양수로 변경하고 입력된 그대로의 10진수로 출력.
    출력 예)  "양수 인경우"   10은  1010
          "음수 인경우"  -10은  10	
*/
package date181118;

public class HWRevision03 {

	public static void main(String[] args) {
		
		int i = -10;
		
		// ~는 1의 보수화, -10을 일단 양수 2진수로 표현 ... 0000 1010
		// 1의 보수화로 ... 0000 0101이 됨
		// +1로 2의 보수화 => ... 1111 0110이 2진수로 표현된 -10
		
		System.out.println(~10);
		System.out.println(i>=0 ? Integer.toBinaryString(i) : ~i+1);
	}
}
