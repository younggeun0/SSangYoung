package date181203;

/**
 * ����� �������� ����� �θ�Ŭ����<br>
 * ��üȭ�� �ȵ�<br>
 * �ڽ�Ŭ������ �ݵ�� �����ؾ��� abstract method�� ������ Ŭ����.
 * 
 * @author owner
 */
public abstract class AbstractSuper {
	
	int i;
	
	public AbstractSuper() {
		// �ڽ�Ŭ������ �����ɶ��� ȣ���
		System.out.println("AbstractSuper�� ������");
	}
	
	public void method() {
		System.out.println("�θ� ���� �ϴ� �Ϲ� method");
	}
	
	// abstract method�� �ڽ��� �ݵ�� �����ؾ��� ���� ����� ����
	public abstract void absMethod(); 
	public abstract String absMethod1(int i); 
	
	/* public static void main(String[] args) {
		new AbstractSuper(); // �߻�Ŭ������ ��üȭ �� �� ����.
	} */
}
