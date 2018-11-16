package date181115;
class NumberSystem {
	public static void main(String[] args) {
		int deci = 15;		// 10진수
		int octal = 017;	// 8진수
		int hex = 0xF;		// 16진수

		System.out.println(deci+" / "+octal+" / "+hex);

		// 전화번호를 8진수로 인식해서 원하는 값이 안나옴
		// 8진수에 8을 넣어도 에러발생
		int tel = 01012345677;

		
		// 136956863 출력
		System.out.println(tel);

	}
}
