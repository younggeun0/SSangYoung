package date181129;

/**
 * TestSuper�� �ڽ�Ŭ���� 
 * 
 * @author owner
 */
public class TestSub extends TestSuper {
	
	int i;
	
	public TestSub() {
		System.out.println("�ڽ�Ŭ���� �⺻������");
	}
	
	public void subMethod() {
		System.out.println("�ڽ�Ŭ������ method");
	}
	
	public static void main(String[] args) {
		// ��üȭ�� �ڽ�Ŭ������ ����Ѵ�.
		TestSub ts = new TestSub();
		
		// �ڽİ� �θ� ���� ��Ű���� �����ϸ� �θ� ����
		// ������ method�� ���������ڰ� public, protected, 
		// default�� �ڿ��� ����� �� �ִ�.
		ts.public_i = 10;
		ts.protected_i = 20;
		ts.default_i = 30;
		
		System.out.println("�θ��� �ڿ� "+ts.public_i+"/"
				+ts.protected_i+"/"+ts.default_i);
		
		ts.i = 100;
		
		System.out.println("�ڽ��� �ڿ� "+ts.i);
		
		ts.superMethod();
		ts.subMethod();
	}
}
