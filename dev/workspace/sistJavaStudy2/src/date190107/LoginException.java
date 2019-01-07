package date190107;

/**
 * 사용자 정의 예외처리 클래스<br>
 * Exception(또는 RuntimeException)을 상속받는다.
 * @author owner
 */
@SuppressWarnings("serial")
public class LoginException extends Exception {

	public LoginException() {
		this("로그인 실패");
	}
	public LoginException(String msg) {
		super(msg); // 예외처리 객체를 사용하여 예외메세지를 출력할 수 있다.
	}
}
