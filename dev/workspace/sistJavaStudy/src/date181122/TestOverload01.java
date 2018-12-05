package date181122;

/**
 * 다형성 : method Overload<br>
 * 하나의 클래스에서 같은 이름의 method를 여러개 작성하는 것.<br>
 * 규칙) 접근지정자 반환형 method명은 같게 만들고 매개변수만 다르게 생성<br>
 * @author owner
 */
public class TestOverload01 {

	/**
	 * ☆을 하나 출력하는 일
	 */
	public void printStar() {
		System.out.println("☆");
	}
	
	/**
	 * 입력되는 값에 따라 ★을 여러개 출력하는 일
	 * @param count 출력할 ★의 개수
	 */
	public void printStar(int count) {
		
		for(int i=0; i<count; i++) {
			System.out.print("★");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		TestOverload01 to = new TestOverload01();
		
		to.printStar();
		to.printStar(3);
	}
}
