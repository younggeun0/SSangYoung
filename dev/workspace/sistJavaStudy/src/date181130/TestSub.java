package date181130;

/**
 * TestSuper�� �ڽ� Ŭ����
 * @author owner
 */
public class TestSub extends TestSuper {

	int p_j;
	
	public TestSub() {
		System.out.println("�ڽı⺻������");
	}
	
	@Override
	public void method() {
		p_i=400;	// �ڵ��� ���뼺 ����, �θ��� ���� p_i
		p_j=500;	// ���� �̸��� ������ �����ϸ� �ڽ��� ���� ���
		
		
		System.out.println("�ڽ� �޼ҵ� p_i="+this.p_i+", p_j="+this.p_j);
		super.method();
		
		System.out.println(this);
		// System.out.println(super); // super�� ����� �� ����.
	}
	
	public static void main(String[] args) {

		TestSub ts = new TestSub();
		
		
		ts.method();
		
	}

}
