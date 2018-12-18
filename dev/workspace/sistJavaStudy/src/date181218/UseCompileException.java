package date181218;

/**
 * Compile Exception : byte code를 정상적으로 생성하기 위한 것. 개발자가 반드시 처리해야하는 예외.
 * 
 * @author owner
 */
public class UseCompileException {

	public static void main(String[] args) {

		try {
			Object obj = Class.forName("date181217.UseRuntimeException");
			
			System.out.println("로딩한 클래스 "+obj);
			
		} catch (ClassNotFoundException cnfe) {
			System.err.println("죄송합니다.");
			System.err.println("예외 메시지 출력 : "+cnfe.getMessage());
			System.err.println("예외처리 객체와 메시지 : "+cnfe);
			
			// printStackTrace는 정보를 stack에 담고 출력하여
			// 시간이 조금 더 걸림(때문에 출력결과가 다른 out메시지와 섞일 수 있다.)
			cnfe.printStackTrace();
			System.out.println("---");
			// println은 printStackTrace보다 먼저 출력
		} finally {
			System.out.println("사용해주셔서 감사합니다.");
		}
	}
}
