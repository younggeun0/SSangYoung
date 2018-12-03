package date181203;

public class UseDefaultMethod implements UseDefault {

	@Override
	public void test() {
		System.out.println("Override한 method");
	}
	
	public void test2() {
		System.out.println("test2 method");
	}

	public static void main(String[] args) {
		
		// 자식클래스로 객체화
		UseDefaultMethod udm = new UseDefaultMethod();
		udm.test();
		udm.temp();	// default method
		udm.test2();
		
		// is-a 관계의 객체화
		UseDefault ud = new UseDefaultMethod();
		ud.test();
		ud.temp();	// default method
	}
}
