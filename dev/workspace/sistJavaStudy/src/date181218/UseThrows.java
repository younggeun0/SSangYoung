package date181218;

import java.util.Random;

/**
 * method������ �߻��� ���ܸ� method�� ȣ���� ������ ó���ϴ� throws�� ���.
 * @author owner
 */
public class UseThrows {
	
	public void test() throws ClassNotFoundException {
		// throws�� ���ܸ� ������ method�ȿ��� try~catch�� �� �ʿ䰡 ����.
		String className = "date181217.UseRuntimeException";
		
		if (new Random().nextBoolean()) {
			className = "java.long.Integer";
		}
		
		Object obj = Class.forName(className);
		System.out.println("Ŭ���� �ε� "+obj);
		
	}
	
	public static void main(String[] args) {
				
		UseThrows ut = new UseThrows();

		try {
			
			// method�� ȣ���Ͽ� �� �����ϴٺ��� ������ �߻��� ���� �ִ�.
			ut.test();
		} catch (ClassNotFoundException cnfe) {
			System.err.println("�˼��մϴ�.");
			cnfe.printStackTrace();
			System.out.println("�������");
		}
	}
}
