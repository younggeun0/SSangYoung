package date181120;

public class TestSwitchCase2 {
	
	public static final int GRADE_A_PLUS = 10;
	public static final int GRADE_A = 9;
	public static final int GRADE_B = 8;
	public static final int GRADE_C = 7;
	public static final int GRADE_D = 6;
	
	public static void main(String[] args) {

		int score = 191;
		char grade = 64;
        // ASCII
        // 65-A, 66-B, 67-C, 68-D, 69-E, 70-F
        
		// if문으로 유효성 검사
		if (score <= 100 && score >= 0) {
			
	        // case의 상수는 가독성이 떨어지기 때문에
	        // 읽기 편하도록 Constant를 사용
			switch(score/10) {
			case TestSwitchCase2.GRADE_D: grade++; // 68
			case TestSwitchCase2.GRADE_C: grade++; // 67
			case TestSwitchCase2.GRADE_B: grade++; // 66
			case TestSwitchCase2.GRADE_A: 
			case TestSwitchCase2.GRADE_A_PLUS: grade++; break; // 65 - A
			default: grade+=6;	// 70 - F
			}
			System.out.println(score + "점은 " + grade + " 학점");
		} else {
			System.out.println("점수는 0~100점 사이만 입력 가능");
		}
	}
}
