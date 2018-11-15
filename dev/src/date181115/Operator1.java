/*
	단항연산자 (Unary)
	~, !, +, -, ++, --
*/
class Operator1 {
	public static void main(String[] args) {
		int i = 11;
		int j = -11;
		
		// ~(tilde) : 1의 보수연산
		// ~양수 : 부호변경 1증가
		System.out.println("~"+i+" = "+ ~i); // -12

		// ~음수 : 부호변경 1감소
		System.out.println("~"+j+"  "+ ~j); // 10

		// !(NOT) : true -> false, false -> true
		boolean b = true;
		boolean c = false;

		System.out.println("!b = "+!b);		// false
		System.out.println("!c = "+!c);		// true
		System.out.println(11>15);			// false
		// !은 boolean에만 사용가능
		System.out.println(!(11>15));		// true

		// + : 형식적 제공
		System.out.println("+"+i+" = "+ +i); // 11
		System.out.println("+"+j+" = "+ +j); // -11

		// - : 2의 보수연산, 부호바꿈연산(값 그대로)
		System.out.println("-"+i+" = "+ -i); // -11
		System.out.println("-"+j+" = "+ -j); // 11

		// ++ : 증가연산(대상체 값을 1씩 증가)
		i=0;
		j=10;

		// 전위연산 : 연산자 대상체
		++i;	// 1
		--j;	// 9

		System.out.println("전위연산 후 i = "+i+", j = "+j);

		// 후위연산 : 대상체 연산자
		i++;	// 2
		j--;	// 8
		
		System.out.println("후위연산 후 i = "+i+", j = "+j);

		// 증가연산자와 감소연산자는 대입연산자와 함께 사용되면
		// 전위 후위가 다른 값을 대입
		
		j = 0;
		// 전위 : 내것 먼저
		j = ++i;	// 3
		System.out.println("전위연산 후 i = "+i+", 대입된 값 j = "+j);
		
		// 후위 : 남의 것 먼저
		j = 0;
		j = i++;	// i는 4, j는 3
		System.out.println("후위연산 후 i = "+i+", 대입된 값 j = "+j);
	}
}
