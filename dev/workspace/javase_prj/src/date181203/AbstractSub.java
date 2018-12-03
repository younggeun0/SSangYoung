package date181203;

/**
 * �߻�Ŭ������ �θ�� �ϴ� �ڽ�Ŭ����<br>
 * �ڽ�Ŭ������ �ݵ�� �θ�Ŭ������ ��� �߻� �޼ҵ带 Override �ؾ��Ѵ�.
 * @author owner
 *
 */
public class AbstractSub extends AbstractSuper{
	
	public AbstractSub() {
		System.out.println("�ڽĻ�����");
	}
	
	public void subMethod() {
		System.out.println("�ڽ� method!!");
	}

	@Override
	// Override ��Ģ: ���������ڴ� ���Ƿ� ���氡��, 
	// 				  ��ȯ��, method��, �Ű������� �����ؾ� ��.
	// �߻� method�� super�� ȣ���� �� ����.
	public void absMethod() {
		// super.absMethod();
		System.out.println("Override�� absMethod");
	}
	@Override
	public String absMethod1(int i) {
		System.out.println("Override�� absMethod1");
		return String.valueOf(i).concat("-�ڽ�");
	}
	
	public static void main(String[] args) {
	
		// �ڽ�Ŭ������ ��üȭ �Ǹ� �߻�Ŭ������ ��üȭ�� �ȴ�.
		AbstractSub as = new AbstractSub();
		
		// �ڽ�Ŭ���� ��üȭ : �θ��� ����, method, �ڽ��� ����, method ��밡��
		as.i = 12; 	    // �θ𺯼�
		as.subMethod(); // �θ� method
		
		// Override�� method �ڽĿ��� ������ ���̹Ƿ� �ڽ��� method ȣ��
		as.absMethod(); // ���� �̸��� �����Ѵٸ� �ڽ��� method ȣ��
		System.out.println(as.absMethod1(100));
		
		// is-a ������ ��üȭ - ��ü ������
		// �θ�Ŭ������ ��ü�� = new �ڽĻ�����();
		AbstractSuper as1 = new AbstractSub();
		// �θ��� �ڿ� ȣ�Ⱑ��
		
		// Override�� method�� �����Ѵٸ� �ڽ��� method�� ����� �� �ִ�.
		// �߻�method�� body�� ������ ȣ���ϰԵǸ� �ڽ��� method�� ȣ��ȴ�.
		as1.absMethod();
		System.out.println(as1.absMethod1(10));
		as1.method();
		
		// as1.subMethod(); // is-a ����� ��üȭ�ϸ� �ڽ��� ���� method�� ȣ��Ұ�
		
	}
}
