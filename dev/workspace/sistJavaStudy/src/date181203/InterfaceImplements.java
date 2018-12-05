package date181203;

/**
 * 인터페이스를 구현하는 클래스 (자식클래스, interface의 모든 추상 method를 Override하는 클래스) 구현
 * interface가 부모 interface를 가진다면 최종적인 자식클래스에서 모든 추상 method를 구현한다.
 * 
 * @author owner
 */
public class InterfaceImplements implements SuperInterface {

	@Override
	public String msgA() { // InterA
		return "오늘은 월요일";
	}

	@Override
	public String msgB() { // InterB
		return "내일은 화요일";
	}

	@Override
	public void methodA() { // SuperInterface
		System.out.println("methodA");
	}

	@Override
	public void methodB(String i) { // SuperInterface
		System.out.println("methodB i=" + i);
	}

	public void test() {
		System.out.println("test method");
	}

	public static void main(String[] args) {

		// 자식클래스로 객체화하면 모든 method 호출 가능
		InterfaceImplements ii = new InterfaceImplements();

		System.out.println("-----InterfaceImplements Instantiation-----");
		System.out.println(ii.msgA());
		System.out.println(ii.msgB());
		ii.methodA();
		ii.methodB("Hi");
		ii.test();

		// is-a 관계의 객체화
		// is-a 관계의 객체화를 하면 메소드 접근에 제한을 줄 수 있다.
		System.out.println("-----SuperInterface is-a-----");
		SuperInterface si = new InterfaceImplements();

		System.out.println(si.msgA());
		System.out.println(si.msgB());
		si.methodA();
		si.methodB("hi");

		System.out.println("-----InterA is-a-----");
		InterA ia = new InterfaceImplements();
		System.out.println(ia.msgA());

		System.out.println("-----InterB is-a-----");
		InterB ib = new InterfaceImplements();
		System.out.println(ib.msgB());
		
		// interface는 객체화되지 않는다.
		// InterA ia1 = new InterA();

	}
}
