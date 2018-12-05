package date181122;

/**
 * ������ : method Overload<br>
 * �ϳ��� Ŭ�������� ���� �̸��� method�� ������ �ۼ��ϴ� ��.<br>
 * ��Ģ) ���������� ��ȯ�� method���� ���� ����� �Ű������� �ٸ��� ����<br>
 * @author owner
 */
public class TestOverload01 {

	/**
	 * ���� �ϳ� ����ϴ� ��
	 */
	public void printStar() {
		System.out.println("��");
	}
	
	/**
	 * �ԷµǴ� ���� ���� ���� ������ ����ϴ� ��
	 * @param count ����� ���� ����
	 */
	public void printStar(int count) {
		
		for(int i=0; i<count; i++) {
			System.out.print("��");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		TestOverload01 to = new TestOverload01();
		
		to.printStar();
		to.printStar(3);
	}
}
