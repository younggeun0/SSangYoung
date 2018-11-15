/*
	논리연산자 :
	 일반논리 
		&&(AND) : 전항과 후항이 모두 true일 때만 true반환
		||(OR ) : 전항과 후항이 모두 false일 때만 false 반환
	 비트논리
	 	&(AND) : 상위비트와 하위비트가 모두 1일 때만 1내림
		|(OR ) : 상위비트와 하위비트가 모두 0일 때만 0내림
		^(XOR) : 상위비트와 하위비트 둘 중 하나만 1인 경우 1내림
*/
class Operator5{
	public static void main(String[] args){

		boolean flag1 = true, flag2 = false, flag3 = true, flag4 = false;
		
		System.out.println("--------&&---------");
		// 논리연산은 산술연산보다 우선순위가 낮기 때문에 가로로 묶는다
		System.out.println(flag1+"&&"+flag3+" = "+ (flag1&&flag3)); // true
		System.out.println(flag1+"&&"+flag2+" = "+ (flag1&&flag2)); // false
		System.out.println(flag2+"&&"+flag1+" = "+ (flag2&&flag1)); // false
		System.out.println(flag2+"&&"+flag4+" = "+ (flag2&&flag4)); // false
		// 전항이 false면 후항은 계산하지 않고 false인 결과를 만든다

		
		System.out.println("--------||---------");
		System.out.println(flag1+"||"+flag3+" = "+ (flag1||flag3)); // true
		System.out.println(flag1+"||"+flag2+" = "+ (flag1||flag2)); // true
		System.out.println(flag2+"||"+flag1+" = "+ (flag2||flag1)); // true
		System.out.println(flag2+"||"+flag4+" = "+ (flag2||flag4)); // false
		// 전항이 true면 후항은 계산하지 않고 true인 결과를 만든다


		System.out.println("-------------------------");
		flag1 = false;
		flag2 = false;
		flag3 = false;

		flag3 = (flag1=3>4)&&(flag2=5>4);
		// flag1까지만 수행하고 flag2는 수행 안함(false 만나면 빠져나옴)
		System.out.println("전항:"+flag1+", 후항:"+flag2+", 판정:"+flag3);


		System.out.println("-------------------------");
		int i=0, j=0;

		i = 28;	//   0001 1100
		j = 48; // & 0011 0000
				//   0001 0000 16
		System.out.println(i+" & "+j +" = "+(i&j));
		
		i = 16; //   0001 0000
		j = 3;  // | 0000 0011
				//   0001 0011 19
		System.out.println(i+" | "+j +" = "+(i|j));
		
		i = 10; //   0000 1010
		j = 12; // ^ 0000 1100
			    //   0000 0110 6
		System.out.println(i+" ^ "+j +" = "+(i^j));
	}
}
