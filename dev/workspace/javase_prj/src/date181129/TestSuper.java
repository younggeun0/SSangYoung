package date181129;

/**
 * ��Ӱ����� �θ�Ŭ���� : ��� �ڽ��� ������ �� ���� Ư¡ ����<br>
 * �θ𿡰� ���ǵ� �ڵ�� �ڽĿ��� ����� �� �ִ�.
 * 
 * @author owner
 */
public class TestSuper {

	// ��� �ִ� �ڽ��̵� ��밡��
	public int public_i;		
	
	// ���� ��Ű���� �ڽ�, �ٸ� ��Ű���� �ڽĿ��� ��밡��
	protected int protected_i;	
	
	// �θ�Ŭ���� �ȿ����� ��밡��
	private int private_i;			
	
	// ���� ��Ű���� �ڽĿ��� ��밡��, ��Ű���� �ٸ��� ���Ұ�
	int default_i;
	
	// �θ�Ŭ������ ����� �ڽ�Ŭ������ ��üȭ�Ǹ�
	// �θ�Ŭ������ �����ڰ� ���� ȣ�� �ǰ� �ڽ�Ŭ������ �����ڰ� ȣ���
	public TestSuper() {
		System.out.println("�θ�Ŭ���� �⺻������");
	}
	
	public void superMethod() {
		System.out.println("�θ�Ŭ������ method");
	}
	
	
}
