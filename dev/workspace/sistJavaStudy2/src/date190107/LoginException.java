package date190107;

/**
 * ����� ���� ����ó�� Ŭ����<br>
 * Exception(�Ǵ� RuntimeException)�� ��ӹ޴´�.
 * @author owner
 */
@SuppressWarnings("serial")
public class LoginException extends Exception {

	public LoginException() {
		this("�α��� ����");
	}
	public LoginException(String msg) {
		super(msg); // ����ó�� ��ü�� ����Ͽ� ���ܸ޼����� ����� �� �ִ�.
	}
}
