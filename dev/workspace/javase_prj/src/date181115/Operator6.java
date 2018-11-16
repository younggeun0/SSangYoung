package date181115;
/*
	삼항(조건)연산자
*/
class Operator6 {
	public static void main(String[] args) {
	
		int i = 9;

		// 연산자 우선순위 때문에 가로로 묶는다
		System.out.println(i+"는(은) "+ (i>=0?"양수":"음수")); 
	
		// 절대값
		System.out.println(i+"의 절대값 "+ (i>=0?i:-i) );
		
		// 변수의 값이 짝수인지 홀수인지 판단하는 삼항연산자를 만드세요
		System.out.println(i+"는 "+(i%2==0? "짝수입니다.":"홀수입니다."));
	}
}
