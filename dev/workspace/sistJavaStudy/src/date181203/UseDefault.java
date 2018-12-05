package date181203;

/**
 * default method<br>
 * 인터페이스에서 업무(자바코드)를 기술할 수 있는 method<br>
 * default method를 호출하려면 구현 클래스로 is-a 관계의 객체화를 해야 함
 * @author owner
 */
public interface UseDefault {

	public void test();
	
	public default void temp() {
		System.out.println("default method - temp method");
	}
}
