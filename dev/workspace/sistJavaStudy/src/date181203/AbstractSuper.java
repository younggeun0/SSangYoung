package date181203;

/**
 * 상속을 목적으로 만드는 부모클래스<br>
 * 객체화가 안됨<br>
 * 자식클래스가 반드시 구현해야할 abstract method를 가지는 클래스.
 * 
 * @author owner
 */
public abstract class AbstractSuper {
	
	int i;
	
	public AbstractSuper() {
		// 자식클래스가 생성될때만 호출됨
		System.out.println("AbstractSuper의 생성자");
	}
	
	public void method() {
		System.out.println("부모 일을 하는 일반 method");
	}
	
	// abstract method는 자식이 반드시 구현해야할 일의 목록을 정의
	public abstract void absMethod(); 
	public abstract String absMethod1(int i); 
	
	/* public static void main(String[] args) {
		new AbstractSuper(); // 추상클래스는 객체화 될 수 없다.
	} */
}
