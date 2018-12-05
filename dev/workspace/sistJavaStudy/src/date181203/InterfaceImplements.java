package date181203;

/**
 * �������̽��� �����ϴ� Ŭ���� (�ڽ�Ŭ����, interface�� ��� �߻� method�� Override�ϴ� Ŭ����) ����
 * interface�� �θ� interface�� �����ٸ� �������� �ڽ�Ŭ�������� ��� �߻� method�� �����Ѵ�.
 * 
 * @author owner
 */
public class InterfaceImplements implements SuperInterface {

	@Override
	public String msgA() { // InterA
		return "������ ������";
	}

	@Override
	public String msgB() { // InterB
		return "������ ȭ����";
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

		// �ڽ�Ŭ������ ��üȭ�ϸ� ��� method ȣ�� ����
		InterfaceImplements ii = new InterfaceImplements();

		System.out.println("-----InterfaceImplements Instantiation-----");
		System.out.println(ii.msgA());
		System.out.println(ii.msgB());
		ii.methodA();
		ii.methodB("Hi");
		ii.test();

		// is-a ������ ��üȭ
		// is-a ������ ��üȭ�� �ϸ� �޼ҵ� ���ٿ� ������ �� �� �ִ�.
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
		
		// interface�� ��üȭ���� �ʴ´�.
		// InterA ia1 = new InterA();

	}
}
