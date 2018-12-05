package date181203;

/**
 * 추상클래스를 부모로 하는 자식클래스<br>
 * 자식클래스는 반드시 부모클래스의 모든 추상 메소드를 Override 해야한다.
 * @author owner
 *
 */
public class AbstractSub extends AbstractSuper{
	
	public AbstractSub() {
		System.out.println("자식생성자");
	}
	
	public void subMethod() {
		System.out.println("자식 method!!");
	}

	@Override
	// Override 규칙: 접근지정자는 광의로 변경가능, 
	// 				  반환형, method명, 매개변수는 동일해야 함.
	// 추상 method는 super로 호출할 수 없다.
	public void absMethod() {
		// super.absMethod();
		System.out.println("Override한 absMethod");
	}
	@Override
	public String absMethod1(int i) {
		System.out.println("Override한 absMethod1");
		return String.valueOf(i).concat("-자식");
	}
	
	public static void main(String[] args) {
	
		// 자식클래스가 객체화 되면 추상클래스는 객체화가 된다.
		AbstractSub as = new AbstractSub();
		
		// 자식클래스 객체화 : 부모의 변수, method, 자식의 변수, method 사용가능
		as.i = 12; 	    // 부모변수
		as.subMethod(); // 부모 method
		
		// Override된 method 자식에서 구현한 것이므로 자식의 method 호출
		as.absMethod(); // 같은 이름이 존재한다면 자식의 method 호출
		System.out.println(as.absMethod1(100));
		
		// is-a 관계의 객체화 - 객체 다형성
		// 부모클래스명 객체명 = new 자식생성자();
		AbstractSuper as1 = new AbstractSub();
		// 부모의 자원 호출가능
		
		// Override된 method가 존재한다면 자식의 method를 사용할 수 있다.
		// 추상method는 body가 없지만 호출하게되면 자식의 method가 호출된다.
		as1.absMethod();
		System.out.println(as1.absMethod1(10));
		as1.method();
		
		// as1.subMethod(); // is-a 관계로 객체화하면 자식이 가진 method는 호출불가
		
	}
}
