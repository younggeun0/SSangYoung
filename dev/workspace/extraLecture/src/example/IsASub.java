package example;

public class IsASub extends IsASuper {

	public IsASub() {
		System.out.println("�ڽ�Ŭ����");
	}
	
	public void subMethod() {
		System.out.println("�ڽ� �޼ҵ�");
	}
	
	@Override
	public void superMethod() {
		System.out.println("�ڽ� �޼ҵ�");
	}
	
	public static void main(String[] args) {
		IsASuper ias = new IsASub();
		ias.superMethod();
//		IsASub ias = new IsASuper();
		// �ڽ�Ŭ������ �θ�Ŭ�����̴�.
	}
}
