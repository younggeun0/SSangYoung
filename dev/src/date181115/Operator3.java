/*
	쉬프트연산자
	<<  (left shift)
	 - 비트를 왼쪽으로 밀고 밀어서 생긴 빈칸을 항상 0으로 채움  
	>>  (right shift)
	 - 비트를 오른쪽으로 밀고 밀어서 생긴 빈칸을 
	 - MSB에 따라 양수면 0, 음수면 1을 채움
	>>> (unsigned shift) 
	 - 비트를 오른쪽으로 밀고 밀어서 생긴 빈칸을 항상 0으로 채움
*/
class Operator3 {
	public static void main(String[] args) 	{
	
		// method : static method 사용
		// 클래스명.method명(값)
		int i=11;

		System.out.println("i의 이진수값 : "+Integer.toBinaryString(i)); // 1011
		System.out.println("i의 8진수값 : "+Integer.toOctalString(i));   // 013
		System.out.println("i의 16진수값 : "+Integer.toHexString(i));    // 0xb
		
		i = 9; 
		//     0000 1001
		// <<3 0100 1000 - 72
		// 쉬프트연산자는 산술연산자보다 우선순위가 낮기 때문에 가로 필요
		System.out.println(i+"<<3 = "+ (i<<3));

		i = 36;	
		//     0010 0010
		// >>3 0000 0100 - 4
		System.out.println(i+">>3 = "+ (i>>3));
		

		i = 120;
		//      0111 1000
		// >>>4 0000 0111 - 7
		System.out.println(i+">>>4 = "+ (i>>>4));

		i = 1;
		//      0000 ... 0001
		// <<31 1000 ... 0000
		// MSB가 변경되며 음수의 최대값이 출력됨
		System.out.println(i<<31);	// -2147483648
		
		// literal이 4byte이므로 32칸 밀면 제자리로 돌아옴
		System.out.println(i<<32);  // 1

		i = -1;
		// right shift로 밀어봤자 밀린 공간에 
		// 1이 차기 때문에 값은 유지됨
		System.out.println(i>>100);	// -1

		i = -1;
		// 1111 ... 1111
		// 0111 ... 1111
		// MSB가 0으로 변경, 양수의 최대값 출력
		System.out.println(i>>>1);	// 2147483647
	}
}
