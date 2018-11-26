package date181126;

/**
 * 생성자
 * - 클래스가 객체로 생성될 때 기본적으로 가지고 있어야할 기본값을 
 *   설정하거나 기본적으로 수행될 코드를 정의하는 method의 일종
 *   
 * @author owner
 */
public class TestConstructor {

	/**
	 * 기본 생성자 : 클래스를 작성할 때 생성자를 하나도 정의하지 않으면
	 *              컴파일러가 매개변수 없는 Default Constructor를 생성함
	 */
	public TestConstructor() {
		System.out.println("기본 생성자");
	}
	
	/**
	 * 인자있는 생성자 : 생성자 Overload.  
	 * @param i 임의의값
	 */
	public TestConstructor(int i) {
		System.out.println("인자있는 생성자 : "+i);
	}
	
	public void test() {
		System.out.println("test method");
		temp();
		// 생성자는 메소드 호출하듯 호출할 수 없다.
		// TestConstructor(); 
	}
	
	public void temp() {
		System.out.println("----temp method");
	}
	
	public static void main(String[] args) {
		// Overloading된 생성자를 사용하여 객체화를 다양하게 할 수 있음
		TestConstructor tc = new TestConstructor(); // 기본 생성자
		System.out.println(tc);
		
		TestConstructor tc1 = new TestConstructor(2); // 인자있는 생성자
		System.out.println(tc1);
		
		tc.test();
	}
}
