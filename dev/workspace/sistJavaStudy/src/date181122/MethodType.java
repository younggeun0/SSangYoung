package date181122;

/**
 * method�� 4���� ����
 * @author owner
 */
public class MethodType {
	
	/**
	 * ��ȯ�� ���� �Ű����� ���� �� - ������
	 */
	public void typeA() {
		System.out.println("�ȳ��ϼ���?");
	}
	
	/**
	 * ��ȯ�� ���� �Ű����� �ִ� �� - ������
	 * @param i ����ϰ� ���� ��
	 */
	public void typeB(int i) {
		System.out.println(i+"�� �ȳ�");
	}
	
	/**
	 * ��ȯ�� �ְ�, �Ű����� ���� �� - ������
	 * ���� �޾� ����ϴ� �ڵ尡 �ʿ�.
	 * @return ��.���� �Ǽ������� ��ȯ
	 */
	public double typeC() {
		return 2018.11;
		// return ���� �Ʒ��� �ڵ尡 ���ǵ� �� ����
		// System.out.println("hello"); // Unreachable code error! 
	}
	
	/**
	 * ��ȯ�� �ְ�, �Ű����� �ִ� �� - ������
	 * @param d ������ ����� ���� �Ǽ� ��
	 * @return ������ ĳ���õ� ��
	 */
	public int typeD(double d) {
		return (int)d;
	}
	
	public static void main(String[] args) {
		
		MethodType mt = new MethodType();
		
		// 1. ������ method ȣ��
		mt.typeA();
		
		// 2. ������ method ȣ��
		mt.typeB(5);
		
		// 3. ������ method ȣ��
		// 	 - ��ȯ���� ��ġ�ϴ� ������ ����� �� ����
		double i = mt.typeC();
		System.out.println("������ : "+i);
		
		// 4. ������ method ȣ��
		//   - ��ȯ���� ��ġ�ϴ� ������ ����� �� ����
		int j = mt.typeD(2018.11);
		System.out.println(j);
		
	}
}
