package date181121;

/**
 * method : ������ �����Ͽ� �����ϸ�, 
 * 	        �ߺ��ڵ带 �ּ�ȭ�� �� ���
 * @author owner
 */
public class UseMethod {

	// instance method
	public void instanceMethod() {
		System.out.println("��üȭ�Ͽ� ����ϴ� "
				+ "instance method");
	}
	
	// static method
	public static void staticMethod() {
		System.out.println("��üȭ ���� ���� ȣ���Ͽ� "
				+ "����ϴ� static method");
	}
	
	public static void main(String[] args) {
		
		UseMethod um = new UseMethod();		// ��ü ����
		um.instanceMethod();				// instance method ȣ��

		// um.staticMethod();
		// static method�� Ư����ü�� �����ִ� 
		// method�� �ƴϹǷ� ��ü������ ȣ������ �ʴ´�.
		UseMethod.staticMethod();			// static method ȣ��
		
	}
}
