package date181218;

/**
 * Compile Exception : byte code�� ���������� �����ϱ� ���� ��. �����ڰ� �ݵ�� ó���ؾ��ϴ� ����.
 * 
 * @author owner
 */
public class UseCompileException {

	public static void main(String[] args) {

		try {
			Object obj = Class.forName("date181217.UseRuntimeException");
			
			System.out.println("�ε��� Ŭ���� "+obj);
			
		} catch (ClassNotFoundException cnfe) {
			System.err.println("�˼��մϴ�.");
			System.err.println("���� �޽��� ��� : "+cnfe.getMessage());
			System.err.println("����ó�� ��ü�� �޽��� : "+cnfe);
			
			// printStackTrace�� ������ stack�� ��� ����Ͽ�
			// �ð��� ���� �� �ɸ�(������ ��°���� �ٸ� out�޽����� ���� �� �ִ�.)
			cnfe.printStackTrace();
			System.out.println("---");
			// println�� printStackTrace���� ���� ���
		} finally {
			System.out.println("������ּż� �����մϴ�.");
		}
	}
}
