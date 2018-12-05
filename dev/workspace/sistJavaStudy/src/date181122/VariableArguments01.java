package date181122;

/**
 * Variable Arguments
 * �Ű������� �ϳ��ε� �μ��� ������ ���� �� �ִ� ���<br>
 * method �������� �迭�� ó���ȴ�<br>
 * ����) "��������... �Ķ���͸�" �������� ����
 * @author owner
 */
public class VariableArguments01 {

	/**
	 * ���� ������������ �� �Է� ���� ������ ����� �� 
	 * @param param ����������
	 */
	public void test(int... param) {
		for(int val : param) {
			System.out.print(val+" ");
		}
		System.out.println("test method called");
	}
	
	public static void main(String[] args) {
		
		VariableArguments01 va = new VariableArguments01();

		va.test();
		va.test(1);
		va.test(1,2,3,4,5);
	}
}
