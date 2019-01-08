package date190108;

/**
 * 실행 중인 JVM에서 하나의 객체가 만들어지고, 하나의 객체만 사용되는 Pattern
 * @author owner
 */
public class Singleton {

	private static Singleton single;
	
	/**
	 * 1. class 외부에서 객체화를 하지 못하도록 막는다.
	 */
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		// 객체가 생성되어 있지 않다면 객체를 생성하여 반환하고
		if (single == null) { 
			single = new Singleton();
		}
		// 객체가 이미 생성되어 있다면 생성된 객체 반환
		return single;
	}
}
