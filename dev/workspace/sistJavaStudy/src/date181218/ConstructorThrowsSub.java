package date181218;

public class ConstructorThrowsSub extends ConstructorThrows {

	// 부모클래스의 생성자가 컴파일 예외를 날리면 자식클래스
	// 생성자에서도 예외를 날려야 한다.
	public ConstructorThrowsSub() throws ClassNotFoundException {
		super();
		// super는 생성자의 첫번째 줄에서만 기술할 수 있음
		// 부모클래스의 생성자가 Compile Exception을 throws로 날리면
		// 생성자를 호출하는 자식생성자에서는 반드시 처리해야하는 
		// 문법상 에러가 발생하게 된다.
		/*try {
			super();
		} catch (ClassNotFoundException cnfe) {
			
		}*/
	}

	public static void main(String[] args) {
		
	}
}
