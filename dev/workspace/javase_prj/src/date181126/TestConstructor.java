package date181126;

/**
 * ������
 * - Ŭ������ ��ü�� ������ �� �⺻������ ������ �־���� �⺻���� 
 *   �����ϰų� �⺻������ ����� �ڵ带 �����ϴ� method�� ����
 *   
 * @author owner
 */
public class TestConstructor {

	/**
	 * �⺻ ������ : Ŭ������ �ۼ��� �� �����ڸ� �ϳ��� �������� ������
	 *              �����Ϸ��� �Ű����� ���� Default Constructor�� ������
	 */
	public TestConstructor() {
		System.out.println("�⺻ ������");
	}
	
	/**
	 * �����ִ� ������ : ������ Overload.  
	 * @param i �����ǰ�
	 */
	public TestConstructor(int i) {
		System.out.println("�����ִ� ������ : "+i);
	}
	
	public void test() {
		System.out.println("test method");
		temp();
		// �����ڴ� �޼ҵ� ȣ���ϵ� ȣ���� �� ����.
		// TestConstructor(); 
	}
	
	public void temp() {
		System.out.println("----temp method");
	}
	
	public static void main(String[] args) {
		// Overloading�� �����ڸ� ����Ͽ� ��üȭ�� �پ��ϰ� �� �� ����
		TestConstructor tc = new TestConstructor(); // �⺻ ������
		System.out.println(tc);
		
		TestConstructor tc1 = new TestConstructor(2); // �����ִ� ������
		System.out.println(tc1);
		
		tc.test();
	}
}
