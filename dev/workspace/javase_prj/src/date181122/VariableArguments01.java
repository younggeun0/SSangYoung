package date181122;

/**
 * Variable Arguments
 * 매개변수는 하나인데 인수를 여러개 넣을 수 있는 기능<br>
 * method 내에서는 배열로 처리된다<br>
 * 정의) "데이터형... 파라미터명" 형식으로 정의
 * @author owner
 */
public class VariableArguments01 {

	/**
	 * 동일 데이터형으로 된 입력 값을 여러개 사용할 때 
	 * @param param 가변인자형
	 */
	public void test(int... param) {
		for(int val : param) {
			System.out.print(val+" ");
		}
		System.out.println("test method called");
	}
	
	public static void main(String[] args) {
		
		VariableArguments01 va = new VariableArguments01();

		va.test();
		va.test(1);
		va.test(1,2,3,4,5);
	}
}
