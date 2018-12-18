package date181218;

/**
 * 생성자에서 예외 날리는 경우
 * @author owner
 */
public class ConstructorThrows {

	public ConstructorThrows() throws ClassNotFoundException {
		Class.forName("java.lang.Object");
		System.out.println("객체생성");
	}
	
	public static void main(String[] args) {
		try {
			ConstructorThrows ct = new ConstructorThrows();
			System.out.println("객체화 성공 : "+ct);
		} catch (ClassNotFoundException cnfe) {
			System.err.println("객체화 중 예외발생");
			cnfe.printStackTrace();
		}
	}
}
