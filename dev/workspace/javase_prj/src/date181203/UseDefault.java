package date181203;

/**
 * default method<br>
 * �������̽����� ����(�ڹ��ڵ�)�� ����� �� �ִ� method<br>
 * default method�� ȣ���Ϸ��� ���� Ŭ������ is-a ������ ��üȭ�� �ؾ� ��
 * @author owner
 */
public interface UseDefault {

	public void test();
	
	public default void temp() {
		System.out.println("default method - temp method");
	}
}
