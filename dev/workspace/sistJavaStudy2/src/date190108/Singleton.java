package date190108;

/**
 * ���� ���� JVM���� �ϳ��� ��ü�� ���������, �ϳ��� ��ü�� ���Ǵ� Pattern
 * @author owner
 */
public class Singleton {

	private static Singleton single;
	
	/**
	 * 1. class �ܺο��� ��üȭ�� ���� ���ϵ��� ���´�.
	 */
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		// ��ü�� �����Ǿ� ���� �ʴٸ� ��ü�� �����Ͽ� ��ȯ�ϰ�
		if (single == null) { 
			single = new Singleton();
		}
		// ��ü�� �̹� �����Ǿ� �ִٸ� ������ ��ü ��ȯ
		return single;
	}
}
