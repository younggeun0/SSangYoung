package date181203;

/**
 * 구현 클래스(자식클래스)에서 반드시 구현해야하는 일의 목록만
 * 정의하는 interface의 사용법(구현의 강제성)
 * @author owner
 */
// interface는 부모를 여러개 가질 수 있다.
public interface SuperInterface extends InterA, InterB {
	
	// 인터페이스간 상속에는 추상method를 Override하지 않는다!

	// constant : 변수를 상수처럼 사용.
	// 변수는 작성할 수 없다.
	public static final int FLAG_VALUE = 12;
	
	// 추상 method 구성
	// 일반 메소드는 가질 수 없다. error!
	// public void test() {}
	
	// abstract 사용하지 않아도 abstract method
	public void methodA();	// abstract method
	public abstract void methodB(String i);

	
}
