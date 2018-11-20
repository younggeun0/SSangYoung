package date181120;

/**
 *  switch~case를 사용한 학점 구하기
 */
public class TestSwitchCase {
	
	public static void main(String[] args) {

        // char는 공백문자(white space)로 초기화
		// 공백문자 unicode \u0000
		// ''는 문자없음, error
		char grade = ' ';
		int score = Integer.parseInt(args[0]);
		

		System.out.println(grade);
		// 자바에선 정수/정수 = 정수
		switch(score/10) {
		case 10 :
		case 9  : grade = 'A'; break;
		case 8  : grade = 'B'; break;
		case 7  : grade = 'C'; break;
		case 6  : grade = 'D'; break;
		default : grade = 'F';
		// default는 아랫줄에 실행될 코드가 없으므로 분기문을 사용하지 않는다.
		}
		
		System.out.println(score+"점은 "+ grade+" 학점");
	}
}
