package date181122;

public class TestOverload02 {

	/**
	 * 구구단 메소드는 3단을 기본으로 출력
	 */
	public void gugudan() {
		
		for(int i=1; i<10; i++) {
			System.out.println("3 * "+i+" = "+(3*i));
		}
	}
	
	/**
	 * 입력받은 단의 값이 2~9 사이일 땐<br>
	 * 해당 단부터 9단까지 출력
	 * @param dan 입력받은 단의 수
	 */
	public void gugudan(int dan) {
		
		if (dan>1 && dan<10) {
			System.out.println(dan+"단을 출력합니다.");
			for(int i=dan; i<10; i++) {
				for(int j=1; j<10; j++) {
					System.out.println(i+" * "+j+" = "+(i*j));
				}
			}
		} else {
			System.out.println("2~9단 사이 단만 출력합니다.");
		}
	}
	
	public static void main(String[] args) {
		
		TestOverload02 to2 = new TestOverload02();
		
		// 구구단 3단을 출력하는 method
		// to2.gugudan();
		
		// 입력하는 단이 2~9단 사이일 때 
		// 해당 단부터 9단까지 출력 출력하는 method
		to2.gugudan(5);
		 
	}
}
