/*
	강제형변환 (Casting)
	- 변수의 데이터형을 일시적으로 변환하여 사용하는 것
*/

class UseCasting{

	public static void main(String[] args) {

		byte b1=10, b2=20;		// 자동형변환
		
		// 연산의 결과를 int로 자동형변환, error! 
		// byte result = b1+b2;	

		// 강제형변환!
		// 가로는 +보다 연산의 우선순위가 빠름
		// 때문에 연산을 먼저 묶음
		byte result = (byte)(b1+b2);

		System.out.println(b1 + " + " + b2 + " = " + result);

		double d = 11.14;
		float f = (float)d;

		System.out.println("double : " + d + ", float : " + f);

		// 상수에 사용가능, literal 자체는 바뀌지 않음
		float f1 = (float)2018.11; 
		System.out.println("float : " + f1);

		// error!
		// 상수값이 literal보다 크면 casting을 실행하기 전에 error 발생
		// long l = (long)2147483648;

		// int와 float은 byte 수는 같아도 값을 담는 형태가 달라 할당 안됨
		// 값손실 발생(실수부의 값이 모두 사라져 할당)
		int i = (int)f1;

		System.out.println("int : " + i + ", float : " + f1);
		
		char c = 'A';
		System.out.println(c + "의 unicode(ASCII code)값 " + (int)c);

		// 형이(기본형 <-> 참조형) 다르면 강제형변환이 되지 않는다.
		// error!
		// String str = "11";	// String은 참조형 데이터타입
		// int i2 = (int)str;		// int는 기본형 데이터타입

		// boolean형은 boolean형 끼리만 변환가능
		// error!
		// boolean b=true;
		// int i3=(int)b;

		boolean b = true;
		boolean b3 = (boolean)b; // 의미없는 강제형변환..

		System.out.println("boolean : " + b3);

	}// main
}// class