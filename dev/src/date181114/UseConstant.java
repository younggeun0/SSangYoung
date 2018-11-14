/*
	다른 클래스에 있는 상수를 사용해보기위한 클래스
*/
class UseConstant{

	public static void main(String[] args){

		// 다른클래스에 존재하는 상수를 참조할 땐 클래스명.상수명 의 형식을 가진다
		// System.out.println(MAX_SCORE);
		System.out.println(Constant.MAX_SCORE+" / "+Constant.MIN_SCORE);
	}
}