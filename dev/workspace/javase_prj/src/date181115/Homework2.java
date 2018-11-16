package date181115;
/*
2. 2147483647의 값에서 상위 2byte와 하위 2byte 값을 분리하여 출력해보세요. 
    출력 예) 상위 2byte -> 32767
             하위 2byte -> 65535
*/
class Homework2 {
	public static void main(String[] args) {
		
		int i = Integer.MAX_VALUE;	// 2147483647
		// 2147483647 - 4byte 01111111 11111111 11111111 11111111

		// 상위 2byte를 분리하기 위해 right shift 연산자 사용 >> 16
		// 쉬프트대입연산자로 16칸 오른쪽으로 비트이동한 값을 바로 출력
		System.out.println(i>>16);

		// 하위 2byte를 분리하기 위해 left shift 연산자 사용 << 16
		// 그 후 왼쪽 2byte를 0으로 채우기 위해 unsigned shift 연산자 사용
		
		i<<=16;
		
		System.out.println(i>>>16);
	}
}