package date181126;

/**
 * this�� ����� ������ ȣ��
 * @author owner
 */
public class ThisConstructor {

	public ThisConstructor() {
		this(26);
		System.out.println("�⺻ ������");
	}
	
	public ThisConstructor(int i) {
		// this();
		System.out.println("�����ִ� ������ i:"+i);		
		// this�� �������� ù��° �ٿ����� ��밡��
		// this(); // error!
	}
	
	public static void main(String[] args) {
		
		// ��ü�� �����ؼ� ����� ���� ���� �� �̷��� ���
		new ThisConstructor();
		
		new ThisConstructor(3);
	}
}
