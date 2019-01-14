package example;

public class IsASub extends IsASuper {

	public IsASub() {
		System.out.println("자식클래스");
	}
	
	public void subMethod() {
		System.out.println("자식 메소드");
	}
	
	@Override
	public void superMethod() {
		System.out.println("자식 메소드");
	}
	
	public static void main(String[] args) {
		IsASuper ias = new IsASub();
		ias.superMethod();
//		IsASub ias = new IsASuper();
		// 자식클래스는 부모클래스이다.
	}
}
