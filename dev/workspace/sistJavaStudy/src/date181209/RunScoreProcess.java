package date181209;
/*
1. 아래의 데이터를 처리하는 프로그램을 작성하세요.
백인재,이봉현,이재찬,정택성,이재현,김정운 의 데이터가 존재하고,
점수는 0~100점 사이로 발생할수있습니다.

프로그램이 실행되면 위의 사람중에 2명이상 성적처리 대상자 이고
n명의 이름과 점수를 저장하여 출력하는 일을 하는 프로그램 작성.
중복이름은 들어갈 수 없다.

출력 예 )
이재찬 89
정택성 77
김정운 90
총점   xx점
*/
public class RunScoreProcess {

	public static void main(String[] args) {
		String str = "백인재,이봉현,이재찬,정택성,이재현,김정운";
		ScoreProcess sp = new ScoreProcess();
		
		sp.printNameAndScore(sp.getName(str));
	}
}
