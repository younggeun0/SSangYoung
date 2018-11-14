/*
	기본형 데이터형(Primitive DataType)
	정수형 : byte, short, int, long
	실수형 : float, double
	문자형 : char
	논리형 : boolean
*/
class PrimitiveDataType {
	
	public static void main(String[] args) {
		// 정수형
		byte b = 10;
		short s = 20;
		int i = 30;
		// 할당되는 값이 4byte내 이므로 literal을 변환할 필요가 없다.
		long l = 40;
		
		b = -128; // byte : -128 ~ +127
		
		// 정수 literal은 4byte
		// 저장하려는 값은 8byte가 필요한 값이므로 
		// literal의 크기를 변경(형명시), 정수상수 뒤에 l이나 L을 붙인다
		long l2 = 2147483648L;
		
		System.out.println("byte : " + b + ", short : " + s + ", int : " + i 
			+ ", long : " + l + ", long2 : " + l2);

		/*
		  0  - 정수상수
		 '0' - 문자상수
		 "0" - 문자열상수
		*/

		// 문자형 : unicode 값 : \u0000
		// 할당은 unicode가 됨
		// char c = 'A';
		// char c2 = '0';
		// char c3 = '가';

		// 유니코드값을 바로 할당해도 같은 결과 출력
		char c = 65;
		char c2 = 48;
		char c3 = 44032;

		// 출력은 unicode에 대한 문자가 출력됨
		System.out.println("char : " + c +", " + c2 + ", " + c3);

		// 실수형 
		// float형은 4byte, 3.14란 실수 리터럴은 8byte
		// float형에 8byte 실수 리터럴을 담기위해
		// f 또는 F를 실수리터럴 뒤에 붙여 형명시
		float f = 3.14F;

		// double은 literal과 datatype의 크기가 같으므로
		// 형명시를 생략할 수 있다. (d, D)
		double d = 3.14;
		double d2 = 3.14D;

		System.out.println("float : " + f + ", double : "
			+ d + ", double2 : " + d2);

		// 불린형 
		boolean tu = true;
		boolean fa = false;

		// tu = 0; boolean은 true, false만 담을 수 있다. 
		// c처럼 1, 0을 사용하지 않는다.

		System.out.println("boolean : " + tu + ", boolean : " + fa);

		byte b1 = 10, b2 = 20, result = 0;
		
		// error 발생
		result = b1 + b2; 

		System.out.println(result);
	}// main 
}// class
