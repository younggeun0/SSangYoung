package date181129;

/**
 * 상속관계의 부모클래스 : 모든 자식이 가져야 할 공통 특징 정의<br>
 * 부모에게 정의된 코드는 자식에서 사용할 수 있다.
 * 
 * @author owner
 */
public class TestSuper {

	// 어디에 있는 자식이든 사용가능
	public int public_i;		
	
	// 같은 패키지의 자식, 다른 패키지의 자식에서 사용가능
	protected int protected_i;	
	
	// 부모클래스 안에서만 사용가능
	private int private_i;			
	
	// 같은 패키지의 자식에서 사용가능, 패키지가 다르면 사용불가
	int default_i;
	
	// 부모클래스를 상속한 자식클래스가 객체화되면
	// 부모클래스의 생성자가 먼저 호출 되고 자식클래스의 생성자가 호출됨
	public TestSuper() {
		System.out.println("부모클래스 기본생성자");
	}
	
	public void superMethod() {
		System.out.println("부모클래스의 method");
	}
	
	
}
