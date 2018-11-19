package date181119;

public class TestIf3 {

	//Constant : 변수를 상수처럼 사용할 때 (값을 변경하지 못하는 변수)
	public static final int FLAG_VALUE = 1250;
	public static final int FLAG_CNT = 20;
	
	public static void main(String[] args) {
	
		// args[0]를 입력받아 그 수가 
		// 20보다 작으면 1250과 입력값을 곱하여 출력
		// 20보다 크다면 1250과 1250의 10%를 더한 값과 입력값을 곱하여 출력
		
		int input = Integer.parseInt(args[0]);
		int some_value = TestIf3.FLAG_VALUE;
		
		if (input > TestIf3.FLAG_CNT) {
			some_value = (int)(TestIf3.FLAG_VALUE 
								+ TestIf3.FLAG_VALUE*0.1);  
		}
		
		System.out.println(some_value * input);
	}
}
