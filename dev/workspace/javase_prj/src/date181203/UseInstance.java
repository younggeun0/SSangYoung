package date181203;

public class UseInstance {
	
	public TestSuper test1() {
		// is-a������ ��üȭ : �θ��� �ڿ��� �ڽ��� Override�� �޼ҵ常 ��밡��
		// �θ�Ŭ������ ��ü�� = new �ڽ�Ŭ����������();
		TestSuper ts = new TestSub();
		return ts;
	}
	public TestSuper test2() {
		// is-a������ ��üȭ : �θ��� �ڿ��� �ڽ��� Override�� �޼ҵ常 ��밡��
		// �θ�Ŭ������ ��ü�� = new �ڽ�Ŭ����������();
		TestSuper ts = new TestSub2();
		return ts;
	}

	public static void main(String[] args) {
		
		// �ڽ�Ŭ������ ��ü�� �����Ͽ� ���
		// �ڽ�Ŭ������ ��ü�� = new �ڽ��ǻ�����
		// ��ü�� ��� : �θ�Ŭ������ ����, �޼ҵ�, �ڽ�Ŭ������ ����, �޼ҵ�
		TestSub ts = new TestSub();
		ts.i = 100; 	// �θ�� ���� �̸��� ������ �ڽ��� ���� ���.
		ts.pMethod(); 	// �θ��� method ���
		ts.subMethod(); // �ڽ��� method
		ts.printI();	// �ڽ��� Override�� method�� ��� �ڽ��� method ȣ��
		
		System.out.println("-------------�θ��� �̸����� ��üȭ(��ü������)----------");
		// ��ü������ : ���� �̸��� ��ü�� �پ��ϰ� ����ϴ� ��
		// �θ� ����� �� ������ �ȴ�.
		UseInstance ui = new UseInstance();
		
		TestSuper ts1 = ui.test1();
		TestSuper ts2 = ui.test2();
		
		ts1.printI();	// Override�� method ȣ��
		ts2.printI();	
		
	}
}
