package date181203;

public class UseDefaultMethod implements UseDefault {

	@Override
	public void test() {
		System.out.println("Override�� method");
	}
	
	public void test2() {
		System.out.println("test2 method");
	}

	public static void main(String[] args) {
		
		// �ڽ�Ŭ������ ��üȭ
		UseDefaultMethod udm = new UseDefaultMethod();
		udm.test();
		udm.temp();	// default method
		udm.test2();
		
		// is-a ������ ��üȭ
		UseDefault ud = new UseDefaultMethod();
		ud.test();
		ud.temp();	// default method
	}
}
